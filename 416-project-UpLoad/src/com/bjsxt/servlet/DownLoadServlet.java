package com.bjsxt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.bjsxt.entry.User;
import com.bjsxt.uploadService.DownLoadService;

import com.bjsxt.uploadserviceimp.DownLoadImp;

public class DownLoadServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		String uid=req.getParameter("uid");
		DownLoadService ds=new DownLoadImp();
		User u=ds.selectUserInfoService(uid);
		System.out.println(u);
		//响应处理结果
		//创建要下载的图片路径	
			String path=this.getServletContext().getRealPath("/upload")+"\\"+u.getPhotoName();
			System.out.println(path);
			File f=new File(path);
		//设置响应头
			String type=u.getType();	
			resp.setContentType(type);//告诉浏览器响应的是一张图片
			resp.setContentLength((int)f.length());//告诉浏览器文件大小
			// 安排,配置
			//resp.setHeader("Content-Disposition","");--告诉浏览器下载内容的打开方式
			//attachment参数确保浏览器下载时以另存为方式打开文件;filename默认下载文件的文件名
			resp.setHeader("Content-Disposition","attachment;filename="+u.getRealName());
		//创建流对象获取图片和响应图片字节码
			InputStream is=new FileInputStream(f);
			OutputStream out=resp.getOutputStream();
		//响应字节码
			IOUtils.copy(is, out);
		//关闭流对象
			is.close();
			out.close();
	}
}
