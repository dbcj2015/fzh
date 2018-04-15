package com.bjsxt.service;

import java.util.List;
import java.util.Map;

import com.bjsxt.dao.ContentDao;
import com.bjsxt.daoImp.ContentDaoImp;
import com.bjsxt.entity.Reply;

public interface ContentService {
	
	public List<Map> selectContent();
	public void Insert(Reply r);
	public Reply selectReply(String name);
	public List<Map> selectReply(Integer topicId);
	public void updateClick(Integer topicId);
}
