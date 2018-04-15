package com.bjsxt.nw185.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.nw185.entity.Contract;
import com.bjsxt.nw185.service.ContractService;
import com.bjsxt.nw185.service.exception.deleteException;
import com.google.gson.Gson;
@SuppressWarnings("all")
@Controller("contractController")
@RequestMapping("/contract")
public class ContractController {
	@Resource(name="contractService")
	private ContractService service = null;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(Integer page , Integer rows){
		if(page == null || rows == null){
			page = 1;
			rows = 999999999;
		}
		Map result = service.findByProperty(page, rows);
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/create")
	//对于上传的文件,要求类型为MultipartFile,代表上传的文件.
	//要求参数名与前端上传组件的name保持一致
	public String create(Contract c , String contractCode , MultipartFile contractFile , WebRequest wr) throws IllegalStateException, IOException{
		String sourceName = contractFile.getOriginalFilename();//获取原始文件名 张三.zip 李四.rar 王五.7z
		String suffix = sourceName.substring(sourceName.lastIndexOf("."));//扩展名
		
		if(!(suffix.endsWith(".zip") || suffix.endsWith(".rar") || suffix.endsWith(".7z"))){
			throw new IllegalStateException("请上传有效的压缩包文件");
		}
		String basePath  = "d:/nw185document/contract/" + contractCode; //保存文件的目录
		new File(basePath).mkdirs();//创建新的目录
		
		String newFileName = contractCode + suffix;//新文件名
		contractFile.transferTo(new File(basePath + "/" + newFileName));
		
		//设置额外参数
		Map user = (Map)wr.getAttribute("loginuser", WebRequest.SCOPE_SESSION);
		c.setCreateTime(new Date());
		c.setCreateUser((Integer)user.get("user_id"));
		c.setDocFile(basePath + "/" + newFileName);
		c.setState(1);
		service.createContract(c);//保存合同信息
		return "/contract.jsp";
	}
	
	
	@RequestMapping("/update")
	public String update(Contract c,Integer contract_id,MultipartFile contractFile) throws IllegalStateException, IOException{
		
		c.setContractId(contract_id);
		Map selectById = service.selectById(contract_id);
		c.setState((Integer)selectById.get("state"));
		c.setCreateUser((Integer)selectById.get("create_user"));
		c.setCreateTime((Date)selectById.get("create_time"));
		c.setUpdateTime(new Date());
		String fileName = contractFile.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		if(!(suffix.endsWith(".zip") || suffix.endsWith(".rar") || suffix.endsWith(".7z"))){
			throw new IllegalStateException("请上传有效的文件");
		}
		String basePath  = "d:/nw185document/contract/" + c.getContractCode(); //保存文件的目录
		new File(basePath).mkdirs();
		String newFileName = c.getContractCode() + suffix;//新文件名
		contractFile.transferTo(new File(basePath + "/" + newFileName));
		c.setDocFile(newFileName);
		service.update(c);
		return "/contract.jsp";
	}
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer id){
		Map map=new LinkedHashMap();
		try {
			service.delete(id);
			map.put("result", true);
			map.put("message", "删除成功");
		} catch (deleteException e) {
			e.printStackTrace();
			map.put("result", false);
			map.put("message", e.getMessage().toString());
		}
		return new Gson().toJson(map);
	}
	
	@RequestMapping("findByContractCode")
	@ResponseBody
	public String findByContractCode(String contractCode){
		Map map=new HashMap();
		map.put("contractCode", contractCode);
		return new Gson().toJson(service.findByContractCode(map));
	}
}
