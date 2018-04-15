package com.bjsxt.nw185.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UsersDAO {
	public List<Map> find(@Param("username") String username);
}
