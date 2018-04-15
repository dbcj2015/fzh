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
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		String uid=req.getParameter("uid");
		DownLoadService ds=new DownLoadImp();
		User u=ds.selectUserInfoService(uid);
		System.out.println(u);
		//��Ӧ������
		//����Ҫ���ص�ͼƬ·��	
			String path=this.getServletContext().getRealPath("/upload")+"\\"+u.getPhotoName();
			System.out.println(path);
			File f=new File(path);
		//������Ӧͷ
			String type=u.getType();	
			resp.setContentType(type);//�����������Ӧ����һ��ͼƬ
			resp.setContentLength((int)f.length());//����������ļ���С
			// ����,����
			//resp.setHeader("Content-Disposition","");--����������������ݵĴ򿪷�ʽ
			//attachment����ȷ�����������ʱ�����Ϊ��ʽ���ļ�;filenameĬ�������ļ����ļ���
			resp.setHeader("Content-Disposition","attachment;filename="+u.getRealName());
		//�����������ȡͼƬ����ӦͼƬ�ֽ���
			InputStream is=new FileInputStream(f);
			OutputStream out=resp.getOutputStream();
		//��Ӧ�ֽ���
			IOUtils.copy(is, out);
		//�ر�������
			is.close();
			out.close();
	}
}
