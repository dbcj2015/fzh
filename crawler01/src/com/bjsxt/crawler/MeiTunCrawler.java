package com.bjsxt.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

//BreadthCrawler 按层次爬取指定的网站
@SuppressWarnings("all")
public class MeiTunCrawler extends BreadthCrawler {
	// 这里固定写死的构造器
	// 两个参数:
	// crawlPath 代表爬虫任务的名字
	// autoParse 代表抓取的网页是否自动解析 ,一般情况下默认为true
	public MeiTunCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO Auto-generated constructor stub
	}

	@Override
	// 处理当前页面的方法
	/** visit方法是在每获取一张有效的网页时就会触发
	 * page 当期页面的HTMl
	 * next 代表下一个抓取的页面,这个参数一般我们不用
	 */
	public void visit(Page page, CrawlDatums next) {

//		// TODO Auto-generated method stub
//		if (page.getUrl().indexOf("itemDetail") > 0) {
//			// 获取照片地址
//			String img = page.select(".preimg .idTabs img").attr("src");
//			String title = page.select(".title .sname").text();
//			String describe = page.select(".title .describe").text();
//			String span = page.select(".price span").text();
//			String price = page.select(".price #meitun_pirce").text();
//			// System.out.println(title);
//			// System.out.println(describe);
//			// System.out.println(span+":"+price);
//			String jpg = page.select("dl img").attr("src");
//			String text = page.select(
//					".rightside .related .related-con .botm .pdtlable a")
//					.text();
//			// System.out.println(text);
//			// System.out.println("当前的URL:" + page.getUrl());//把抓取的网页URL打印
//
//			// 如果通过查看源代码的方式没有响应的数据是因为数据是通过ajax方式动态加载，通过ajax方式获取
//
//			/*
//			 * 在JAVA中如何发起一个GET或者POST请求呢? 通常我们有两种办法: 1. 使用Java自带的URLConnection
//			 * 对象发起GET/POST请求 , 不好用
//			 * http://blog.csdn.net/woxueliuyun/article/details/43267365
//			 * 优点:JAVA原生 缺点:需要各种的重构和封装才能好用 2.
//			 * 传统的解决方案,在上古世纪的时候如果要发起Http请求,我们通常会采用 Apache HttpClient组件实现
//			 * http://hc.apache.org/
//			 * http://blog.csdn.net/wangpeng047/article/details/19624529/
//			 * 优点:功能强大,你能想到的,HttpClient都能做到 缺点:门槛高,API复杂,且需要掌握大量Http底层知识才能熟练使用
//			 * 
//			 * 3. OKHttp http://square.github.io/okhttp/
//			 */
//			String listSkus = page.select("#listSkus").text();
//			// 将字符串转化为json格式
//			Gson gson = new Gson();
//			List<Map> textList = gson.fromJson(listSkus,
//					new TypeToken<List<Map>>() {
//					}.getType());
//			Integer detailId = null;
//			try {
//				// textList.get(0).get("detailId")返回值类型是double
//				detailId = ((Double) textList.get(0).get("detailId")).intValue();
//				if (detailId != null) {
//					OkHttpClient client = new OkHttpClient();// 创建HttpClient对象
//					Request request = new Request.Builder().url(
//							"http://item.meitun.com/getItemAttr?detailId="
//									+ detailId).build();
//					Response response = client.newCall(request).execute();
//					String detailText = response.body().string();
//					detailText = detailText.substring(1,
//							detailText.length() - 1).replace("\\", "");
//					List<Map> detailGson = new Gson().fromJson(detailText,
//							new TypeToken<List<Map>>() {
//							}.getType());
//
//					// System.out.println(detailText);
//					// 数组为null值和数据为空数组是有区别的,空数组是一个真正的对象，运行时不会报空指针异常
//					// 一个为null的数组不是一个对象,不会分配空间,运行时会报空指针异常,所以返回一个数组时需要判断是不是一个null数组
//					// 如果是为了避免报异常就需要处理，空数组不需要处理
//					if (detailGson == null) {
//						detailGson = new ArrayList<>();
//					}
//					for (Map map : detailGson) {
//						// System.out.println("http://item.meitun.com/getItemAttr?detailId="+detailId);
//						// System.out.println(map.get("title")+":"+map.get("value"));
//					}
//
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}

//		if (page.getUrl().indexOf("getActivityRelations") > 0) {
//			System.out.println(page.getUrl());
//		}
		//System.out.println(page.getUrl());

	}

	public static void main(String[] args) throws Exception {
		// http://item.meitun.com/itemDetail/1822522-0-13020201360101.htm?topicId=121926
		// WebCollector会自动过滤掉已分析过的页面
		MeiTunCrawler crawler = new MeiTunCrawler("meitun", true);
		crawler.setThreads(10);// 设置并发线程数量
		crawler.setResumable(false);// 断点续爬,WebCollector内置了数据库Berkerly
		crawler.addSeed("http://www.meitun.com/"); // 设置爬虫的入口
		crawler.addRegex("-.*#.*");// -代表不抓取的意思,.*#.*代表只要地址中包含#就排除在外
		crawler.addRegex(".*meitun.*");
		// crawler.addRegex(".*"); //确定哪些超链接会被获取,这里写正则表达式 .*代表遍历所有的网页
		crawler.start(99);// 开始抓爬, 99代表抓99层结构
	}
}
