package com.bjsxt.fileuploadsize.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class UploadSize {
	private String name;
	private String idno;
	
	private File idphoto; //利用文件接收上传信息,后台是使用默认拦截器FileUpload实现
	private String idphotoFileName ; //在file框name属性后面增加FileName,则代表原始文件名
	private String idphotoContentType ; //增加ContentType,代表文件的MIME类型
	public String upload() throws IOException{
		String suffix=idphotoFileName.substring(idphotoFileName.lastIndexOf("."));
		String newFileName=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		FileUtils.copyFile(idphoto, new File("c:/"+newFileName+suffix));
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public File getIdphoto() {
		return idphoto;
	}
	public void setIdphoto(File idphoto) {
		this.idphoto = idphoto;
	}
	public String getIdphotoFileName() {
		return idphotoFileName;
	}
	public void setIdphotoFileName(String idphotoFileName) {
		this.idphotoFileName = idphotoFileName;
	}
	public String getIdphotoContentType() {
		return idphotoContentType;
	}
	public void setIdphotoContentType(String idphotoContentType) {
		this.idphotoContentType = idphotoContentType;
	}
	
}
