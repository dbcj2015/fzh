package com.bjsxt.dao;

import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {
	public void insert(){
		System.out.println("创建User成功");
	}
}
