package com.bjsxt.serviceImp;

import java.util.List;
import java.util.Map;

import com.bjsxt.dao.ContentDao;
import com.bjsxt.daoImp.ContentDaoImp;
import com.bjsxt.entity.Reply;
import com.bjsxt.service.ContentService;

public class ContentServiceImp implements ContentService{
	
	ContentDao dao=new ContentDaoImp();
	public List<Map> selectContent(){
		List<Map> contentServiceImp = dao.SelectContent();
		return contentServiceImp;
	}
	@Override
	public void Insert(Reply r) {
		dao.insert(r);
		
	}
	@Override
	public Reply selectReply(String name) {
		return dao.selectReply(name);
		
	}
	
	public List<Map> selectReply(Integer topicId){
		return dao.selectReply(topicId);
	}
	@Override
	public void updateClick(Integer topicId) {
		dao.updateClick(topicId);
		
	}
}
