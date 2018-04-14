package crawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
//BreadthCrawler 按层次爬取指定的网站
public class ZhaopinCrawler extends BreadthCrawler{
	//这里固定写死的构造器
	//两个参数:
	//crawlPath 代表爬虫任务的名字
	//autoParse 代表抓取的网页是否自动解析 ,一般情况下默认为true
	public ZhaopinCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		C3p0Plugin c3p0 = new C3p0Plugin("jdbc:mysql://localhost:3306/zhaopin?useUnicode=true&characterEncoding=UTF-8", "root", "");
		//ActiveRecordPlugin就是JFINAL操作数据库的核心类,它以Plugin(插件)的形式出现
		ActiveRecordPlugin arp= new ActiveRecordPlugin(c3p0);
		arp.addMapping("source_info", SourceInfo.class);
		c3p0.start();
		arp.start();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	//处理当前页面的方法
	/** visit方法是在每获取一张有效的网页时就会触发
	 * page 当期页面的HTMl
	 * next 代表下一个抓取的页面,这个参数一般我们不用
	 */
	public void visit(Page page, CrawlDatums next) {
		// TODO Auto-generated method stub
		SourceInfo si = new SourceInfo();
		try{
			Elements links = page.select("a[data-link]");
			for(Element link : links){
				String l = link.attr("data-link");
				next.add("https://m.zhaopin.com" + l);
			}
			if(page.getUrl().indexOf("/job/") > 0){
				System.out.println(page.getUrl());
				
				si.set("title", page.select(".job-name").get(0).text())
					.set("company", page.select(".r_jobdetails .comp-name").text())
					.set("city", page.select(".r_jobdetails .job-detail .ads").text())
					.set("date", page.select(".r_jobdetails .job-detail .time").text())
					.set("description", page.select(".about-main").html())
					.set("trade", page.select(".jobP-info p").get(0).text())
					.set("edu", page.select(".job-detail .box1>span").get(2).text())
					.set("emp_num", page.select(".jobP-info p").get(1).select("span").get(0).text())
					.set("company_type", page.select(".jobP-info p").get(1).select("span").get(1).text())
					.set("url", page.getUrl());
				
				
				//String minSal = this.getRegexResult("(.{1,})()-", 	salText);
				//String maxSal = this.getRegexResult("-(.{1,})[千万]", 	salText);
				
				String salText = page.select(".job-sal").get(0).text();
				Pattern salPattern = Pattern.compile("(.*)([万千])-(.*)([万千])");//编译正则
				Matcher salMatcher = salPattern.matcher(salText);
				while(salMatcher.find()){//对匹配的结果进行查找
					if(salMatcher.group(2).equals("千")){
						si.set("min_sal", new Float(Float.parseFloat(salMatcher.group(1)) * 1000).intValue());
					}else if(salMatcher.group(2).equals("万")){
						si.set("min_sal", new Float(Float.parseFloat(salMatcher.group(1)) * 10000).intValue());
					}
					
					
					if(salMatcher.group(4).equals("千")){
						si.set("max_sal", new Float(Float.parseFloat(salMatcher.group(3)) * 1000).intValue());
					}else if(salMatcher.group(4).equals("万")){
						si.set("max_sal", new Float(Float.parseFloat(salMatcher.group(3)) * 10000).intValue());
					}
				}
				
				String expText = page.select(".exp").get(0).text();
				Pattern expPattern = Pattern.compile("([0-9]{1,2})-([0-9]{1,2})年");//编译正则
				Matcher expMatcher = expPattern.matcher(expText);
				while(expMatcher.find()){//对匹配的结果进行查找
					si.set("min_exp", Integer.parseInt(expMatcher.group(1)));
					si.set("max_exp", Integer.parseInt(expMatcher.group(2)));
				}

				si.save();
			}
		}catch(Exception e){
			System.out.println(si);
			e.printStackTrace();
		}
	}
	
	private String getRegexResult(String regex , String source) {
		String result = null;
		Pattern pattern = Pattern.compile(regex);//编译正则
		Matcher matcher = pattern.matcher(source);
		while(matcher.find()){//对匹配的结果进行查找
			result =  matcher.group(1); //获取原字符串中符合第一个分组即(\\d)的数据
		}
		return result;
	}
	
	
	public static void main(String[] args)  {
		//http://item.meitun.com/itemDetail/1822522-0-13020201360101.htm?topicId=121926
		//WebCollector会自动过滤掉已分析过的页面
		ZhaopinCrawler crawler = new ZhaopinCrawler("zhaopin-all" , true);
		crawler.setThreads(10);//设置并发线程数量
		crawler.setResumable(true);//断点续爬,WebCollector内置了数据库Berkerly
		crawler.addSeed("https://m.zhaopin.com/beijing-530/?keyword=java&order=0&maprange=3&ishome=0"); //设置爬虫的入口
		for(int i = 2 ; i <= 1250 ; i++){
			crawler.addSeed("https://m.zhaopin.com/beijing-530/?keyword=java&pageindex=" + i + "&maprange=3&islocation=0"); //设置爬虫的入口
		}
		//crawler.addSeed("https://m.zhaopin.com/job/cc120103904j90256946000/");
		crawler.addRegex("-.*#.*");//-代表不抓取的意思,.*#.*代表只要地址中包含#就排除在外
		crawler.addRegex(".*m.zhaopin.com/job/.*");
		//crawler.addRegex(".*"); //确定哪些超链接会被获取,这里写正则表达式 .*代表遍历所有的网页
		try {
			crawler.start(10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//开始抓爬, 99代表抓99层结构
	}

}
