package com.bjsxt.serviceimp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.entity.News;
import com.bjsxt.service.NewsService;

public class NewsServiceImp implements NewsService{

	@Override
	public List<News> getNews() {
		List newsList = new ArrayList();
		newsList.add(new News("北京空气质量全球最好" ,  "北京空气质量全球最好" , "洋葱新闻" , new Date()));
		newsList.add(new News("中国男足勇夺世界杯冠军" ,  "中国男足勇夺世界杯冠军" , "洋葱新闻" , new Date()));
		newsList.add(new News("中国官员清正廉洁" ,  "中国官员清正廉洁" , "洋葱新闻" , new Date()));
		newsList.add(new News("北京房价持续下跌" ,  "北京房价持续下跌" , "洋葱新闻" , new Date()));
		return newsList;
	}
	
}
