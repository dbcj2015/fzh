package com.bjsxt.dao;

import java.util.ArrayList;

import com.bjsxt.entry.User;

public interface ClazzDao {

	ArrayList<User> getClazzInfo(String rid);

}
