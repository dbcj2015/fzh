package com.bjsxt.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.bjsxt.servce.AccountService;

@Controller("accountController")
@RequestMapping("/bank")
@SuppressWarnings("all")
public class AccountController {

	@Resource(name="accountService")
	private AccountService service=null;
	
	@RequestMapping("/select")
	public String selectAll(WebRequest wr){
		List<Map> account = service.selectAll();
		wr.setAttribute("account", account, WebRequest.SCOPE_REQUEST);
		return "/account.jsp";
	}
	
}
