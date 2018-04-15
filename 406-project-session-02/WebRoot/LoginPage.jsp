<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
  </head>
  <body>
  		<%
  			String str=(String)request.getAttribute("str");
  			if(str!=null){
  		%>
  		<h5><%=str %></h5>
  		<%		
  			}
  		%>
  		<form action="check" method="get">
		用户名:<input type="text" name="uname" value=""/><br/><br/>
		密码:<input type="password" name="pwd" value=""/><br/><br/>
		<input type="submit" value="注册"/>
	</form>
  		
	
  </body>
</html>
