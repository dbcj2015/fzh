package com.bjsxt.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller{
	//JFinalĬ�Ͻ���ҳ����Ǵ�index.htmlҳ��������Ա�����ʾ�ض���
	//Ĭ��ִ�еķ��� ��Ĭ�Ͼͷ���/index
	public void index(){
		this.redirect("/index.html");
	}
}
