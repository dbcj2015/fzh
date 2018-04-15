package com.bjsxt.struts2.annotation.action;

import org.apache.struts2.convention.annotation.Action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-default") //package extends="struts-default"
@Namespace("/emp") //namespace
@Results({ //定义跳转的页面
	@Result(name="create" , type="redirect" , location="/create.html"),
	@Result(name="list" , location = "/list.html")
})
public class StrutsAnnotationAction extends ActionSupport{
	@Action("create")
	public String create(){
		return "create";
	}
	@Action("search")
	public String search(){
		return "list";
	}
}
