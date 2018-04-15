package com.bjsxt.nw185.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.bjsxt.nw185.dao.AssetDAO;
import com.bjsxt.nw185.dao.ContractDetailDAO;
import com.bjsxt.nw185.entity.*;
import com.bjsxt.nw185.service.exception.AssetException;

@Service("contractDetailService")
@Transactional(rollbackFor=Exception.class)
public class ContractDetailService{
	@Resource(name="contractDetailDAO")
	private ContractDetailDAO contractDetailDAO = null;
	@Resource(name="assetDAO")
	private AssetDAO assetDAO;
	public void test(){
		System.out.println(contractDetailDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(ContractDetail entity){
		contractDetailDAO.insert(entity);
	}
	
	public void update(ContractDetail entity){
		contractDetailDAO.update(entity);
	}
	
	public void delete(Integer cdId){
		contractDetailDAO.delete(cdId);
	}
	
	public ContractDetail findById(Integer cdId){
		return contractDetailDAO.findById(cdId);
	}
	
	public List<Map> findByProperty(Map params){
		return contractDetailDAO.findByProperty(params);
	}
	
	public Long countByProperty(Map params){
		return contractDetailDAO.countByProperty(params);
	}
	public void store(Integer[] cdIds) throws AssetException{
		for(int j=0;j<cdIds.length;j++){
			//将设备存入到数据库中需要将明细表中state值改变
			ContractDetail cd = contractDetailDAO.findById(cdIds[j]);
			System.out.println(cd.getState());
			if(cd==null){
				throw new AssetException("合同编号为"+cd.getCdId()+"的设备不存在");
			}
			if(cd.getState() !=1){
				throw new AssetException("合同编号为"+cd.getCdId()+"的设备禁止入库");
			}
			//合同明细中的设备状态
			cd.setState(2);
			contractDetailDAO.update(cd);//将明细状态变更为"在库"
			for(int i=1;i<=cd.getNum();i++){
				Asset asset=new Asset();
				asset.setBranchId(1);//隶属于省行
				asset.setCheckSeq(cd.getCheckFrequency());
				asset.setCreateEmp(cd.getCreateUser());
				asset.setCreateTime(new Date());
				asset.setGuarateeTerm(cd.getGuaranteeTerm());
				asset.setPrice(cd.getPrice());
				asset.setProductId(cd.getProductId());
				asset.setState(2);
				assetDAO.insert(asset);
			}
		}
	}
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ContractDetailService bean = (ContractDetailService)ctx.getBean("contractDetailService");
		bean.test();
	}
	
}
