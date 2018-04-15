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
		//以下需要在service层进行业务逻辑处理
		String securityPassword=SecurityUtils.toMD5Hex(password, "3w22");
		Map user=userName.get(0);
		if(userName.size()==0){
			throw new TestException("用户名不存在");
		}
		if(!user.get("password").equals(securityPassword)){
			throw new TestException("用户名或者密码错误");
		}
		if(user.get("status").toString().equals("0")){
			throw new TestException("账户已注销");
		}
		return user;
		
	}
	
	public List findRolesByIdService(Integer empId){
		return rbacDao.findRolesById(empId);
	}
}
