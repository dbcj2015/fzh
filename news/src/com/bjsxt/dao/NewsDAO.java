package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NewsDAO {
	public List<Map> isShowBanner();
	public List<Map> obtainLatestNews();
	public Map obtainNewsId(Integer newsId);
	public void updateThumbsUp(Integer newsId);
	public Map findThumbsNum(Integer newsId);
	public List obtainNewsListByChannel(@Param(value="page") Integer page,@Param("rows") Integer rows,@Param("channelId")Integer channelId);
}
