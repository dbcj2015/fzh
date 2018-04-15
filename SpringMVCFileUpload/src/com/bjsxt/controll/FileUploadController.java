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
	//@ResponseBody//����Ҫ���������ɷ�
	public String upload(String uname,String uID,MultipartFile photo,WebRequest wr) throws IllegalStateException, IOException{
		System.out.println(uname+":"+uID+":"+photo.getOriginalFilename());
		String filePath="C:/";
		String fileName=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		//�õ���׺��
		String suffix=photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
		photo.transferTo(new File(filePath+fileName+suffix));
		
		
		//�洢����
		List ds=(List)wr.getAttribute("datasource", WebRequest.SCOPE_GLOBAL_SESSION);
		Map map=new LinkedHashMap<>();
		map.put("name", uname);
		map.put("uID", uID);
		map.put("filename", fileName+suffix);
		if(ds==null){//��һ�η��ʷ���ʱ��������û�д洢���ݣ���Ҫ����һ������洢����
			ds=new ArrayList<>();
		}
		ds.add(map);//�ڶ��εõ���������󣬽����ݼ���������������
		//���õ������ݱ�������������
		wr.setAttribute("datasource", ds, WebRequest.SCOPE_GLOBAL_SESSION);
		return "/list";
	}
	
	@RequestMapping("/download")
	//����Ҫ�󷽷����ص���ResponseEntity<byte[]>,������ͻ��˷����ֽ�����
	public ResponseEntity<byte[]> download(String fileName) throws IOException{
		byte[] datasource = FileUtil.readAsByteArray(new File("c:/"+fileName));
		HttpHeaders headers=new HttpHeaders();//���������ļ���Ĭ���ļ����ĵط�
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); //֪ͨ�����ǿ�ƴ����ؿ�
		//Disposition����,����
		headers.setContentDispositionFormData("attachment" , new String(("��Ƭ" + fileName).getBytes("UTF-8"),"ISO-8859-1") );//����Ĭ�����ص��ļ���
		return new ResponseEntity<byte[]>(datasource, headers, HttpStatus.CREATED); 
	}
}
