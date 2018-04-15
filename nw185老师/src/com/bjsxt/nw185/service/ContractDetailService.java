package com.bjsxt.nw185.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.nw185.dao.AssetDAO;
import com.bjsxt.nw185.dao.ContractDetailDAO;
import com.bjsxt.nw185.entity.Asset;
import com.bjsxt.nw185.entity.ContractDetail;
import com.bjsxt.nw185.service.exception.BussinessException;

@Service("contractDetailService")
@Transactional(rollbackFor=Exception.class)
public class ContractDetailService{
	@Resource(name="contractDetailDAO")
	private ContractDetailDAO contractDetailDAO = null;
	@Resource(name="assetDAO")
	private AssetDAO assetDAO = null;
	public void test(){
		System.out.println(contractDetailDAO.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public void create(ContractDetail entity){
		//新增逻辑,如果遇到重复的合同明细添加,则修改指定的数据
		//if(contractDetailDAO.findByPropety({contractId:xx , productId:xx})){
		//说明该合同已录入过该类型设备明细
		// contractDetail s = contractDetailDAO.findById(ddId);
		//s.setNum(s.getNum + entity.getNum());
		//}else{//新增
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
	
	//设备入库
	public void store(Integer[] cdIds) throws BussinessException{
		
		for(Integer cdId : cdIds){
			//for(Integer cdId : cdIds){
			ContractDetail cd = contractDetailDAO.findById(cdId);//获取指定的合同明细
			
			if(cd == null){ //合同明细不存在
				throw new BussinessException(cdId + "编号合同明细不存在");
			}
			
			if(cd.getState() != 1){//必须是配送中的状态才允许办理入库
				throw new BussinessException(cdId + "编号合同明细禁止重复入库");
			}
			
			cd.setState(2);
			contractDetailDAO.update(cd);//将明细状态变更为"在库"
			//}
			
			for(int i = 1 ; i <= cd.getNum() ; i++){//采购了多少 数据就在asset表中新增多少条记录
				Asset ass = new Asset();
				ass.setBranchId(1);//隶属于省行
				ass.setCheckSeq(cd.getCheckFrequency());
				ass.setCreateEmp(cd.getCreateUser());
				ass.setCreateTime(new Date());
				ass.setGuarateeTerm(cd.getGuaranteeTerm());
				ass.setPrice(cd.getPrice());
				ass.setProductId(cd.getProductId());
				ass.setState(2);
				ass.setRunState(6);
				assetDAO.insert(ass);
			}
		}
	}
	
	public static void main(String[] args) throws BussinessException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ContractDetailService bean = (ContractDetailService)ctx.getBean("contractDetailService");
		//bean.test();
		Integer[] ids = new Integer[]{1,2,3,4,5};
		bean.store(ids);
	}
	
}
