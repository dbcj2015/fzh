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
 * 上传学习：将客户端资源发送到服务器端
 * 		思路：
 * 			1、在客户端选需要上传的图片资源
 * 			2、在服务器端接收图片的二进制资源
 * 			3、将图片资源写入到服务器端的指定硬盘位置。
 *		实现:
 *			1、请求方式必须是post
 *			2、设置form表单的数据提交格式，设置为字节码提交模式  enctype="multipart/form-data"
 *				浏览器默认解析的数据类型:
 *					enctype="application/x-www-form-urlencoded"
 *						注意:浏览器默认的解析的数据类型是字符型的键值对
 *						get方式:提交数据量比较小的数据
 *			3、使用了form表单上传数据提交模式后，服务器不能在使用getParameter(String name)方法来获取
 *			      请求数据了，需要使用指定的方式来获取数据。
 *			4、导入jar包创建类获取上传数据
 *			5、解析好的数据返回的是List<FileItem>,一个表单项数据(name,pwd对应两个fileItem对象)对应一个FileItem对象
 *			6、遍历List中的FileItem获取数据
 *				判断是普通表单项还是上传表单项
 *							isFormField();--普通表单项返回true
 *					获取数据
 *						普通表单项数据
 *							getFiledName()//获取键的值
 *							getString("utf-8")//获取键值对的值
 *						上传表单项数据
 *							getFiledName()//获取键的值
 *							getString()//获取的是上传的文件内容
 *							getName()//获取上传的文件名
 *							getContentType()//获取上传的文件类型
 *					文件类型			type
 *		问题：
 *			1、文件的路径虽然可以写在服务器硬盘的任意位置，但是最好写到项目根目录中
 *				动态获取服务器项目根目录：
 *					this.getContext().getRealPath("/自定义子文件名");
 *				注意:服务器端也存在硬盘;
 *					将请求文件写到项目根目录下，方便服务器再次重新获取请求文件
 *					
 *			2、文件类型必须为jpg png gif结尾的图片
 *			3、文件的大小
 *				getSize()
 *				upload.setSizeMax(1024*20);
 *			4、文件的写出的文件名
 *				使用UUID.randomUUID();随机创建文件名，保证每个文件的名字是唯一的，解决同名文件覆盖的风险。
 *				
 *	注意：
 *		File对象在创建io流写出路径的时候
 *			如果路径存在但是文件不存在，会自动的创建文件，并将数据写入到文件中
 *			如果路径不存在，不会自动创建路径，会报错，系统找不到指定路径，需要手动创建路径，然后再拼接成绝对路径进行写出操作
 */
public class upLoadServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//1、创建FileItemFactory对象--该对象将FileItem对象存储在服务器的硬盘里
			FileItemFactory factory=new DiskFileItemFactory();
		//2、由FileItemFactory对象创建出ServletFileUpload对象--只能用ServletFileUpload对象中的parseRequest方法解析FileItem对象数据
			ServletFileUpload upload=new ServletFileUpload(factory);
			//创建文件大小--如果文件大小大于设定值，将报错
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
			
			//4、遍历数据:
			for(int i=0;i<list.size();i++){
				FileItem f=list.get(i);
				System.out.println(f.isFormField()+":"+f.getFieldName()+":"+f.getName()+":"+f.getContentType()+":"+f.getString("utf-8"));
				if(!f.isFormField()){
					//file中的参数是绝对路径:从根目录到具体的一个文件;路径也就是目录
//					该方式报错的原因是:
//						首先没有该目录(路径img/)所以找不到改文件,文件没有可以自动创建，但是路径不可以
//					File file=new File("D:/img/a.jpg");
//					if(!file.exists()){
//						//这个是创建一个路径
//						file.mkdirs();
//					}
				//创建目录
//					File file=new File("C:/img/");
//					if(!file.exists()){
//						file.mkdirs();
//					}
//					//将目录和文件拼接到一块:File file2=new File("C:/img/a.jpg");
//					//将文件存储在硬盘中
//					File file2=new File(file, "a.jpg");
				//获取文件类型
					type=f.getContentType();
				//获取文件名
					realName=f.getName();
				//获取文件的后缀名
					String afterName=realName.substring(realName.lastIndexOf(".")+1);
				//检验文件类型
					if(!("jpg".equals(afterName)||"png".equals(afterName)||"gif".equals(afterName))){
						resp.getWriter().write("上传的文件类型不正确");
						return;
					}
				//给图片动态赋予图片名
					UUID uuid = UUID.randomUUID();
				//创建文件存储的名
					photoName=uuid.toString()+"."+afterName;
//				//将文件存储到服务器项目的根目录下
//					File file=new File("E:/tomcat/apache-tomcat-7.0.62/webapps/upload");
				//动态获取服务器的根目录
					String path=this.getServletContext().getRealPath("/upload/");
					System.out.println("动态获取当前项目路径:"+path);
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
				//获取普通请求的文件名
					if("uname".equals(f.getFieldName())){
						name=f.getString("utf-8");
					}
					if("pwd".equals(f.getFieldName())){
						pwd=f.getString();
					}
					
				}
			}
			
		//将登录提交的信息存储到数据库中
			String[] objs={name,pwd,realName,photoName,type};
			UploadService us=new UploadServiceImp();
			int i=us.insertUserLoadInfoService(objs);
			System.out.println(i);
	}
}
