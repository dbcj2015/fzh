package com.bjsxt.servlet;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bjsxt.uploadService.UploadService;
import com.bjsxt.uploadserviceimp.UploadServiceImp;

/**
 * @author wollo
 * �ϴ�ѧϰ�����ͻ�����Դ���͵���������
 * 		˼·��
 * 			1���ڿͻ���ѡ��Ҫ�ϴ���ͼƬ��Դ
 * 			2���ڷ������˽���ͼƬ�Ķ�������Դ
 * 			3����ͼƬ��Դд�뵽�������˵�ָ��Ӳ��λ�á�
 *		ʵ��:
 *			1������ʽ������post
 *			2������form���������ύ��ʽ������Ϊ�ֽ����ύģʽ  enctype="multipart/form-data"
 *				�����Ĭ�Ͻ�������������:
 *					enctype="application/x-www-form-urlencoded"
 *						ע��:�����Ĭ�ϵĽ����������������ַ��͵ļ�ֵ��
 *						get��ʽ:�ύ�������Ƚ�С������
 *			3��ʹ����form���ϴ������ύģʽ�󣬷�����������ʹ��getParameter(String name)��������ȡ
 *			      ���������ˣ���Ҫʹ��ָ���ķ�ʽ����ȡ���ݡ�
 *			4������jar���������ȡ�ϴ�����
 *			5�������õ����ݷ��ص���List<FileItem>,һ����������(name,pwd��Ӧ����fileItem����)��Ӧһ��FileItem����
 *			6������List�е�FileItem��ȡ����
 *				�ж�����ͨ������ϴ�����
 *							isFormField();--��ͨ�����true
 *					��ȡ����
 *						��ͨ��������
 *							getFiledName()//��ȡ����ֵ
 *							getString("utf-8")//��ȡ��ֵ�Ե�ֵ
 *						�ϴ���������
 *							getFiledName()//��ȡ����ֵ
 *							getString()//��ȡ�����ϴ����ļ�����
 *							getName()//��ȡ�ϴ����ļ���
 *							getContentType()//��ȡ�ϴ����ļ�����
 *					�ļ�����			type
 *		���⣺
 *			1���ļ���·����Ȼ����д�ڷ�����Ӳ�̵�����λ�ã��������д����Ŀ��Ŀ¼��
 *				��̬��ȡ��������Ŀ��Ŀ¼��
 *					this.getContext().getRealPath("/�Զ������ļ���");
 *				ע��:��������Ҳ����Ӳ��;
 *					�������ļ�д����Ŀ��Ŀ¼�£�����������ٴ����»�ȡ�����ļ�
 *					
 *			2���ļ����ͱ���Ϊjpg png gif��β��ͼƬ
 *			3���ļ��Ĵ�С
 *				getSize()
 *				upload.setSizeMax(1024*20);
 *			4���ļ���д�����ļ���
 *				ʹ��UUID.randomUUID();��������ļ�������֤ÿ���ļ���������Ψһ�ģ����ͬ���ļ����ǵķ��ա�
 *				
 *	ע�⣺
 *		File�����ڴ���io��д��·����ʱ��
 *			���·�����ڵ����ļ������ڣ����Զ��Ĵ����ļ�����������д�뵽�ļ���
 *			���·�������ڣ������Զ�����·�����ᱨ��ϵͳ�Ҳ���ָ��·������Ҫ�ֶ�����·����Ȼ����ƴ�ӳɾ���·������д������
 */
public class upLoadServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//1������FileItemFactory����--�ö���FileItem����洢�ڷ�������Ӳ����
			FileItemFactory factory=new DiskFileItemFactory();
		//2����FileItemFactory���󴴽���ServletFileUpload����--ֻ����ServletFileUpload�����е�parseRequest��������FileItem��������
			ServletFileUpload upload=new ServletFileUpload(factory);
			//�����ļ���С--����ļ���С�����趨ֵ��������
				upload.setSizeMax(1024*2014);
		String name=null;
		String pwd=null;
		String realName=null;
		String type=null;
		String photoName=null;
			List<FileItem> list=null;
			try {
				list = upload.parseRequest(req);	
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			//4����������:
			for(int i=0;i<list.size();i++){
				FileItem f=list.get(i);
				System.out.println(f.isFormField()+":"+f.getFieldName()+":"+f.getName()+":"+f.getContentType()+":"+f.getString("utf-8"));
				if(!f.isFormField()){
					//file�еĲ����Ǿ���·��:�Ӹ�Ŀ¼�������һ���ļ�;·��Ҳ����Ŀ¼
//					�÷�ʽ�����ԭ����:
//						����û�и�Ŀ¼(·��img/)�����Ҳ������ļ�,�ļ�û�п����Զ�����������·��������
//					File file=new File("D:/img/a.jpg");
//					if(!file.exists()){
//						//����Ǵ���һ��·��
//						file.mkdirs();
//					}
				//����Ŀ¼
//					File file=new File("C:/img/");
//					if(!file.exists()){
//						file.mkdirs();
//					}
//					//��Ŀ¼���ļ�ƴ�ӵ�һ��:File file2=new File("C:/img/a.jpg");
//					//���ļ��洢��Ӳ����
//					File file2=new File(file, "a.jpg");
				//��ȡ�ļ�����
					type=f.getContentType();
				//��ȡ�ļ���
					realName=f.getName();
				//��ȡ�ļ��ĺ�׺��
					String afterName=realName.substring(realName.lastIndexOf(".")+1);
				//�����ļ�����
					if(!("jpg".equals(afterName)||"png".equals(afterName)||"gif".equals(afterName))){
						resp.getWriter().write("�ϴ����ļ����Ͳ���ȷ");
						return;
					}
				//��ͼƬ��̬����ͼƬ��
					UUID uuid = UUID.randomUUID();
				//�����ļ��洢����
					photoName=uuid.toString()+"."+afterName;
//				//���ļ��洢����������Ŀ�ĸ�Ŀ¼��
//					File file=new File("E:/tomcat/apache-tomcat-7.0.62/webapps/upload");
				//��̬��ȡ�������ĸ�Ŀ¼
					String path=this.getServletContext().getRealPath("/upload/");
					System.out.println("��̬��ȡ��ǰ��Ŀ·��:"+path);
				//E:\\tomcat\\apache-tomcat-7.0.62\\webapps\\416\\upload
					File file=new File(path);
					if(!file.exists()){
						file.mkdirs();
					}
					File file2=new File(file, photoName);
					try {
						f.write(file2);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
				//��ȡ��ͨ������ļ���
					if("uname".equals(f.getFieldName())){
						name=f.getString("utf-8");
					}
					if("pwd".equals(f.getFieldName())){
						pwd=f.getString();
					}
					
				}
			}
			
		//����¼�ύ����Ϣ�洢�����ݿ���
			String[] objs={name,pwd,realName,photoName,type};
			UploadService us=new UploadServiceImp();
			int i=us.insertUserLoadInfoService(objs);
			System.out.println(i);
	}
}
