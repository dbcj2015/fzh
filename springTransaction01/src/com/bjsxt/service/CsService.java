package com.bjsxt.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.bjsxt.dao.BasicInfoDAO;
import com.bjsxt.dao.JobInfoDAO;
@Service
public class CsService {
	@Resource(name="basic")
	private BasicInfoDAO bidao=null;
	@Resource(name="job")
	private JobInfoDAO jifao=null;
	public void register(String id,String name,String company){
		
		bidao.Insert(id, name);
		jifao.Insert(id, company);
	}
	
	public static void main(String[] args) {
		ApplicationContext acx=new ClassPathXmlApplicationContext("classpath:applicateContent.xml");
		CsService cs = (CsService)acx.getBean("cs");
		cs.register("141125199102203365", "∆Ê“Ï", "±±æ©…–—ßÃ√");
		
		
	}

	public BasicInfoDAO getBidao() {
		return bidao;
	}

	public void setBidao(BasicInfoDAO bidao) {
		this.bidao = bidao;
	}

	public JobInfoDAO getJifao() {
		return jifao;
	}

	public void setJifao(JobInfoDAO jifao) {
		this.jifao = jifao;
	}

	
}

