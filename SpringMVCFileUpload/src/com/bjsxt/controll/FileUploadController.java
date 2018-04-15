package com.bjsxt.controll;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.spi.http.HttpHandler;

import org.aspectj.util.FileUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/t")
public class FileUploadController {
	
	@RequestMapping("/upload")
	//@ResponseBody//不需要进行请求派发
	public String upload(String uname,String uID,MultipartFile photo,WebRequest wr) throws IllegalStateException, IOException{
		System.out.println(uname+":"+uID+":"+photo.getOriginalFilename());
		String filePath="C:/";
		String fileName=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		//得到后缀名
		String suffix=photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
		photo.transferTo(new File(filePath+fileName+suffix));
		
		
		//存储数据
		List ds=(List)wr.getAttribute("datasource", WebRequest.SCOPE_GLOBAL_SESSION);
		Map map=new LinkedHashMap<>();
		map.put("name", uname);
		map.put("uID", uID);
		map.put("filename", fileName+suffix);
		if(ds==null){//第一次访问访问时作用域中没有存储数据，需要创建一个数组存储数据
			ds=new ArrayList<>();
		}
		ds.add(map);//第二次得到数据请求后，将数据继续保存在数组中
		//将得到的数据保存在作用域中
		wr.setAttribute("datasource", ds, WebRequest.SCOPE_GLOBAL_SESSION);
		return "/list";
	}
	
	@RequestMapping("/download")
	//下载要求方法返回的是ResponseEntity<byte[]>,代表向客户端返回字节数组
	public ResponseEntity<byte[]> download(String fileName) throws IOException{
		byte[] datasource = FileUtil.readAsByteArray(new File("c:/"+fileName));
		HttpHeaders headers=new HttpHeaders();//设置下载文件的默认文件名的地方
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); //通知浏览器强制打开下载框
		//Disposition配置,处置
		headers.setContentDispositionFormData("attachment" , new String(("照片" + fileName).getBytes("UTF-8"),"ISO-8859-1") );//设置默认下载的文件名
		return new ResponseEntity<byte[]>(datasource, headers, HttpStatus.CREATED); 
	}
}
