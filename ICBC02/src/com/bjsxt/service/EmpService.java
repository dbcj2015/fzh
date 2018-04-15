package com.bjsxt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.EmpDao;
import com.bjsxt.dao.RbacDao;
import com.bjsxt.exception.TestException;
import com.bjsxt.utils.SecurityUtils;

@Service("empService")
@Transactional(rollbackFor=Exception.class)
public class EmpService {
	@Resource(name="empDao")
	private EmpDao empDao=null;
	@Resource(name="rbacDao")
	private RbacDao rbacDao=null;
	public Map findService(String username,String password) throws TestException{
		List<Map> userName = empDao.find(username);
		//������Ҫ��service�����ҵ���߼�����
		String securityPassword=SecurityUtils.toMD5Hex(password, "3w22");
		Map user=userName.get(0);
		if(userName.size()==0){
			throw new TestException("�û���������");
		}
		if(!user.get("password").equals(securityPassword)){
			throw new TestException("�û��������������");
		}
		if(user.get("status").toString().equals("0")){
			throw new TestException("�˻���ע��");
		}
		return user;
		
	}
	
	public List findRolesByIdService(Integer empId){
		return rbacDao.findRolesById(empId);
	}
}
