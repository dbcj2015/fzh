package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import com.bjsxt.entity.Reply;

public interface ContentDao {
	public List<Map> SelectContent();

	public void insert(Reply r);
	public Reply selectReply(String name);
	public List<Map> selectReply(Integer topicId);

	public void updateClick(Integer topicId);
}
