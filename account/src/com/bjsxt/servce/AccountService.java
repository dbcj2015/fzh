package com.bjsxt.servce;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.AccountDao;

@Transactional(rollbackFor=Exception.class)
@Service("accountService")
public class AccountService {
	
	@Resource(name="accountDao")
	private AccountDao dao=null;
	
	public List<Map> selectAll(){
		return dao.selectAll();
	}
}
