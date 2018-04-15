package com.bjsxt.icbc.contract.service;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.bjsxt.icbc.contract.dao.ContractDAO;

@Service("contractService")
@Transactional(rollbackFor=Exception.class)
public class ContractService{
	@Resource(name="contractDAO")
	private ContractDAO contractDAO = null;
	
	public void test(){
		System.out.println(contractDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ContractService bean = (ContractService)ctx.getBean("contractService");
		bean.test();
	}
	
}
