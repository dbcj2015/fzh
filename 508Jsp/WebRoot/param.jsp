<%@page language="java" %>
<%@page contentType="text/html; charset=utf-8" %>
<%@page pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page session="true"%>
<%@page errorPage="error.jsp"%>
<%@page isErrorPage="true" %>


<!-- 
	1、jsp的原理：
		浏览器访问jsp会被tomcat服务器所拦截，执行JspServlet将对应的jsp文件转译成servlet文件，并由服务器调用执行。
	2、jsp学习：
		jsp的指令：
			page
			include指令
				 静态指令:
			 		%@include file="引入文件的相对路径"%
			 		特点：
			 			会将引入的文件和原文件转译成一个java文件。
			 			静态引入的文件和原文件之间不可以存在同名变量，否则转译会报错。耦合性高，效率高
				 动态指令：
				 	jsp:include page="引入文件的相对路径"
				 		会各自进行转译，但是为在浏览器中显示在同一个页面内
				 		动态引人和原文件之间可以存在同名变量，耦合性低，效率低	
			forward指令：请求内容转发
				注意：转发双标签之间除了指定的参数标签以外不可以在其中书写其他任何内容。		
							jsp:param value="hehie" name="name"/
			java bean:自学了解
					jsp:useBean id="" /jsp:useBean		 	
		jsp的脚本段：
			%局部代码块%
			
			%!全局代码块%
		jsp的表达式：
			%=变量名/方法名()%
			注意不要加分号	
		jsp的注释：
			%--注释内容--%   				jsp不转译不执行
			!--注释内容--     				HTML注释，转译并发送给浏览器
			%//注释内容%                  java注释   会被转译但不会被执行
		jsp的九大内置对象
			四个作用域：
				pageContext:当前页面
				request:一次请求
				session:浏览器不关闭，后台不失效，项目的任意位置
				application:项目范围内
			两个输出：
				out:
				response:
			三个打酱油：
				page:
				config:
				exception:
			
 -->
<html>
	<head>
		<style	type="text/css">
			b{
				/* color: red; */
			}
		</style>
	</head>
	<body>
			<%--
				我是jsp注释
			
			 --%>
			<%
				int a=3;
				String s="126";
				//我是java注释
				if(a==3){
			%>
				<b>this is my jsp <%=s%></b>
				<!-- 我是HTML注释 -->
			<%
				}else{
			%>
					<%//下面这句代码代表了大家的心情 %>
					<b>哈哈</b>	
			<%
				}
			%>
	<!-- 全局脚本代码 -->
			<%!
				public void test(){
				
					int a=3;
				}
			
			%>
		<!-- 静态引入 -->
		<%@include file="include01.jsp" %>			
		<!--动态引入  -->	
		<jsp:include page="include02.jsp"></jsp:include>	
		<!--请求转发 -->
		<%-- <jsp:forward page="first.jsp">
			<jsp:param value="hehie" name="name"/>
		</jsp:forward> --%>
		<!-- jsp的九大内置对象 -->
		<br />
		<%=request.getParameter("name")%>
		<br />
		<%response.getWriter().write("哈哈");%>
		<br />
		<%application.setAttribute("name","我是全局变量作用域"); %>
		<%application.setAttribute("name","我是全局变量作用域1"); %>
		<%=application.getAttribute("name") %>
		<br />
		<ol>	
			<h3>四个作用域</h3>
				<li>pageContext对象：页面上下文对象，封装了当前jsp文件运行的信息，作用域为当前页面</li>
				<li>request对象：请求对象，封住的是当前请求信息</li>
				<li>session对象：会话对象，经常用</li>
				<li>application对象:项目对象，一个项目只有一个</li>
			<h3>两个输出</h3>
				<li>response对象：响应对象，用于响应内容到客户端</li>
				<li>out对象：响应对象，带有缓冲区的响应对象</li>
			<h3>三个打酱油</h3>
				<li>config对象:servlet初始化对象，一个servlet有一个</li>
				<li>page对象：失效了</li>
				<li>exception对象：异常对象，记录当前页面异常信息</li>			
		</ol>
		
		<!-- 局部脚本声明 -->
		<%! String name; %>
	</body>
</html>

















