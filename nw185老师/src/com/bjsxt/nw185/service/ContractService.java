package com.bjsxt.nw185.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.nw185.dao.ContractDAO;
import com.bjsxt.nw185.entity.Contract;

@Service("contractService")
@Transactional(rollbackFor=Exception.class)
public class ContractService{
	@Resource(name="contractDAO")
	private ContractDAO contractDAO = null;
	
	//Map -> total     rows
	public Map findByProperty(Integer page , Integer rows){
		Integer startIndex = (page - 1) * rows;
		Map param = new HashMap();
		param.put("st", startIndex);
		param.put("r", rows);
		List<Map> p = contractDAO.findByProperty(param);
		Long cnt = (Long)contractDAO.countByProperty().get("cnt");
		Map result = new HashMap();
		result.put("total", cnt);
		result.put("rows", p);
		return result;
	}
	
	public List<Map> findByContractCode(String contractCode){
		Map param = new HashMap();
		param.put("contractCode", contractCode);
		return contractDAO.findByProperty(param);
	}
	
	
	public void createContract(Contract c){
		Map param = new HashMap();
		param.put("contractCode", c.getContractCode());
		if(contractDAO.findByProperty(param).size() > 0){
			throw new RuntimeException(c.getContractCode() + "合同已存在,请勿重复添加");
		}
		contractDAO.insert(c);
	}
	
	public void store(Integer[] cdIds){
		
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ContractService bean = (ContractService)ctx.getBean("contractService");
		System.out.println(bean.findByProperty(1,10));
	}
	
}
