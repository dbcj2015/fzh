package com.bjsxt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.entity.Member;
import com.bjsxt.entity.Person;
import com.jfinal.core.Controller;

public class JFController extends Controller{
	
	public void reg(){
		Person person=this.getBean(Person.class,"p");
			//在request作用域放置数据
		this.setAttr("p", person);
		this.renderFreeMarker("/WEB-INF/ftl/index.ftl");
	}
	
	public void FreeMarker(){
		this.setAttr("name", "冯志红");//view视图中的获取方式:${name}
		this.setSessionAttr("age", "我是session对象中的年龄:78");
		//对实体类进行初始化
		List<Member> list = new ArrayList();
		for(int i = 1 ; i <= 10 ; i++){
			Member m = new Member();
			m.setJoinTime(new Date());
			m.setLevel(i%5);
			m.setName("michael jackson " + i);
			m.getOthers().put("ot1", "xxx");
			m.getOthers().put("ot2", "yyy");
			m.setPrice((i % 5) * 1000f);
			list.add(m);
		}
		this.setAttr("member", list);
		this.renderFreeMarker("index.ftl");
	}
}
