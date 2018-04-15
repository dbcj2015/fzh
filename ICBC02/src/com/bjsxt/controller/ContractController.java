package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.entity.Contract;
import com.bjsxt.service.ContractService;
import com.google.gson.Gson;

@Controller("contractController")
@RequestMapping("/contract")
public class ContractController {
	@Resource(name="contractService")
	private ContractService service = null;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(Integer page , Integer rows){
		Map result = service.findByProperty(page, rows);
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/create")
	//�����ϴ����ļ�,Ҫ������ΪMultipartFile,�����ϴ����ļ�.
	//Ҫ���������ǰ���ϴ������name����һ��
	public String create(Contract c , String contractCode , MultipartFile contractFile , WebRequest wr) throws IllegalStateException, IOException{
		String sourceName = contractFile.getOriginalFilename();//��ȡԭʼ�ļ��� ����.zip ����.rar ����.7z
		String suffix = sourceName.substring(sourceName.lastIndexOf("."));//��չ��
		
		if(!(suffix.endsWith(".zip") || suffix.endsWith(".rar") || suffix.endsWith(".7z"))){
			throw new IllegalStateException("���ϴ���Ч��ѹ�����ļ�");
		}
		String basePath  = "d:/nw185document/contract/" + contractCode; //�����ļ���Ŀ¼
		new File(basePath).mkdirs();//�����µ�Ŀ¼
		
		String newFileName = contractCode + suffix;//���ļ���
		contractFile.transferTo(new File(basePath + "/" + newFileName));
		
		//���ö������
		Map user = (Map)wr.getAttribute("loginuser", WebRequest.SCOPE_SESSION);
		c.setCreateTime(new Date());
		c.setCreateUser((Integer)user.get("user_id"));
		c.setDocFile(basePath + "/" + newFileName);
		c.setState(1);
		service.createContract(c);//�����ͬ��Ϣ
		return "/contract.jsp";
	}
	
}
