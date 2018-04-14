package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//BreadthCrawler 按层次爬取指定的网站
public class MeiTunCrawler extends BreadthCrawler{
	//这里固定写死的构造器
	//两个参数:
	//crawlPath 代表爬虫任务的名字
	//autoParse 代表抓取的网页是否自动解析 ,一般情况下默认为true
	public MeiTunCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
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
		if(page.getUrl().indexOf("itemDetail") > 0 ){
			if(page.select(".sale-over").size() > 0){
				System.out.println("嘿嘿~下架鸟!!");
				return;
			}
			
			
			String title = page.select(".sname").text();
			String desc = page.select(".title .describe").text();
			String currentPrice = page.select("#meitun_pirce").text();
			String originalPrice = page.select("#basic_price").text();
			Elements dimgs = page.select("#detail dl img");
			System.out.println("当前的URL:" + page.getUrl());//把抓取的网页URL打印
			for(int i = 0 ; i < dimgs.size() ; i++){
				Element dimg = dimgs.get(i);
				String dimgurl = dimg.attr("src");
				System.out.println(dimgurl);
			}
			
			
			/*在JAVA中如何发起一个GET或者POST请求呢?
			 * 通常我们有两种办法:
			 * 1. 使用Java自带的URLConnection 对象发起GET/POST请求 , 不好用
			 * 	http://blog.csdn.net/woxueliuyun/article/details/43267365
			 * 优点:JAVA原生
			 * 缺点:需要各种的重构和封装才能好用
			 * 2. 传统的解决方案,在上古世纪的时候如果要发起Http请求,我们通常会采用 Apache HttpClient组件实现
			 * 	http://hc.apache.org/
			 *  http://blog.csdn.net/wangpeng047/article/details/19624529/
			 *  优点:功能强大,你能想到的,HttpClient都能做到
			 *  缺点:门槛高,API复杂,且需要掌握大量Http底层知识才能熟练使用
			 *  
			 * 3. OKHttp
			 * http://square.github.io/okhttp/
			 * 
			 * 
			 * */
			
			String sourceText =  page.select("#listSkus").text();
			Gson gson = new Gson();
			//fromJSON将JSON转换为List<Map>
			List<Map> sourceList =  gson.fromJson(sourceText, new TypeToken<List<Map>>(){}.getType());
			Integer detailId = null;//获取查询编号
			try{
				detailId = ((Double)sourceList.get(0).get("detailId")).intValue();
			}catch(Exception e){
				e.printStackTrace();
			}
			OkHttpClient client = new OkHttpClient();//创建HttpClient对象
			//创建Request请求
			Request request = new Request.Builder().url("http://item.meitun.com/getItemAttr?detailId=" + detailId).build();
			try {
				Response response = client.newCall(request).execute();//获取响应对象
				String json = response.body().string();//获取响应体中的数据
				json = json.substring(1,json.length()-1).replace("\\", "");

				List<Map> resultList =  gson.fromJson(json, new TypeToken<List<Map>>(){}.getType());
				if(resultList == null){
					resultList = new ArrayList();
				}
				for(Map param : resultList){
					System.out.println(param.get("title") + ":" + param.get("value"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//发送请求获取响应
			
			
			System.out.println("===============我是可爱的分隔符=======O(∩_∩)O哈哈~ ===");
		}
	}
	
	public static void main(String[] args) throws Exception {
		//http://item.meitun.com/itemDetail/1822522-0-13020201360101.htm?topicId=121926
		//WebCollector会自动过滤掉已分析过的页面
		MeiTunCrawler crawler = new MeiTunCrawler("meitun" , true);
		crawler.setThreads(10);//设置并发线程数量
		crawler.setResumable(false);//断点续爬,WebCollector内置了数据库Berkerly
		//crawler.addSeed("http://www.meitun.com/"); //设置爬虫的入口
		crawler.addSeed("http://item.meitun.com/itemDetail/121926-0-29011202450101.htm?topicId=121926");
		crawler.addRegex("-.*#.*");//-代表不抓取的意思,.*#.*代表只要地址中包含#就排除在外
		crawler.addRegex(".*meitun.*");
		//crawler.addRegex(".*"); //确定哪些超链接会被获取,这里写正则表达式 .*代表遍历所有的网页
		crawler.start(99);//开始抓爬, 99代表抓99层结构
	}

}
