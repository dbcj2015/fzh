package com.bjsxt.icbc.contract.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.icbc.contract.entity.Contract;
import com.bjsxt.icbc.contract.service.ContractService;

@Controller("contractController")
@RequestMapping("/contract")
public class ContractController {
	@Resource(name="contractService")
	private ContractService service = null;
	
}
