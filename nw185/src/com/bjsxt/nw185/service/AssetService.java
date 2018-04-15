package com.bjsxt.nw185.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.nw185.dao.AssetDAO;
import com.bjsxt.nw185.dao.BranchDAO;
import com.bjsxt.nw185.entity.Asset;
import com.bjsxt.nw185.entity.Branch;
import com.bjsxt.nw185.service.exception.AssetException;
@SuppressWarnings("all")
@Service("assetService")
@Transactional(rollbackFor=Exception.class)
public class AssetService{
	@Resource(name="assetDAO")
	private AssetDAO assetDAO = null;
	
	public List<Map> groupStoreAsset(){
		return assetDAO.groupStoreAsset();
	}
	
	public void distribution(Integer productId,Integer branchId,Integer num) throws AssetException{
		System.out.println("productId:"+productId+"branchId"+branchId+num);
		Map map=new HashMap();
		Asset asset=new Asset();
		map.put("state" , 2);
		map.put("branchId", 1); 
		map.put("st", 0);
		map.put("r", num);
		map.put("productId", productId);
		List<Map> list = assetDAO.findByProperty(map);
		//保证资产表中的数据达到划拨的数量
		if(list.size()<num){
			throw new AssetException("设备划拨失败");
		}
		
		//将所有查询出的所有数据重新设置state值以及branchId
		for(Map s:list){
			Integer assetId=(Integer)s.get("assetId");
			Asset ass = assetDAO.findById(assetId); //获取对应的实体类
			ass.setBranchId(branchId);
			ass.setState(3);
			assetDAO.update(ass);
		}
		
	}
}
