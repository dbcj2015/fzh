package com.bjsxt.fileupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class UploadAction {
	private String name;
	private String idno;
	
	/**
	 * fileUpload拦截器会自动将文件上传到临时目录中,扩展名已.tmp进行保存.我们在Action方法中对其临时文件进行操作.Action方法结束该文件自动被删除.不带走一片云彩
	 */
	private File idphoto; //利用文件接收上传信息,后台是使用默认拦截器FileUpload实现
	private String idphotoFileName ; //在file框name属性后面增加FileName,则代表原始文件名
	private String idphotoContentType ; //增加ContentType,代表文件的MIME类型
	public String upload() throws IOException{
		String suffix=idphotoFileName.substring(idphotoFileName.lastIndexOf("."));
		String newFileName=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		FileUtils.copyFile(idphoto, new File("c:/"+newFileName+suffix));
		return "success";
	}
	
	public String fileUpload(){
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try {
			bis=new BufferedInputStream(new FileInputStream(idphoto));
			bos=new BufferedOutputStream(new FileOutputStream("c:/"+idphotoFileName));
			//定义一个缓冲区，一次性最多可以写入1k字节的数据
			byte[] buffer=new byte[1024];
			//将数据写进缓冲区，返回的是写入的字节数
			int len=bis.read(buffer);
			while(len>0){
				//将缓冲区的数据写出到本地文件中,len代表的是缓冲区有多少字节则写出对应字节数的数据
				bos.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return "success";
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
	
}
