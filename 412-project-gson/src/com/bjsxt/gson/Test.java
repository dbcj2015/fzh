package com.bjsxt.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gson.Gson;

public class Test{
	public static void main(String[] args) {
		Gson gson = new Gson();  
		Tiger tiger = new Tiger();  
		tiger.id = 1;  
		tiger.nickName = "乔晓松";  
		tiger.age = 22;
	    String json = gson.toJson(tiger);
	    System.out.println(json);
	    HashMap map=new HashMap<>();
	    map.put("name", "张三");
	    map.put("age", 56);
	    System.out.println("map="+map);
	    String json2 = gson.toJson(map);
	    System.out.println(json2);
	    LinkedHashMap lhm=new LinkedHashMap<>();
	    lhm.put("name", "张三");
	    lhm.put("age", 56);
	    System.out.println(lhm);
	    
	}
}

