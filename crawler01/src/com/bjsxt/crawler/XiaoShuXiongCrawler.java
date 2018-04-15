package com.bjsxt.crawler;


import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class XiaoShuXiongCrawler extends BreadthCrawler{

	public XiaoShuXiongCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Page page, CrawlDatums next) {
		System.out.println("==================" + page.getUrl() + "=======================");
		System.out.println("==========================");
		if(page.getUrl().indexOf("xiaoshuxiong")>0){
			System.out.println("*********");
			String imgs = page.select(".g-content .recommend-list clearfix mb-25 .mod-item img").attr("src");
			System.out.println(imgs);
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		MeiTunCrawler crawler = new MeiTunCrawler("xiaoshuxiong", true);
		crawler.setThreads(10);// 设置并发线程数量
		crawler.setResumable(false);// 断点续爬,WebCollector内置了数据库Berkerly
		crawler.addSeed("https://www.xiaoshuxiong.com/"); // 设置爬虫的入口
		crawler.addRegex("-.*#.*");// -代表不抓取的意思,.*#.*代表只要地址中包含#就排除在外
		crawler.addRegex(".*xiaoshuxiong.*");
		// crawler.addRegex(".*"); //确定哪些超链接会被获取,这里写正则表达式 .*代表遍历所有的网页
		crawler.start(99);// 开始抓爬, 99代表抓99层结构
	}
}
