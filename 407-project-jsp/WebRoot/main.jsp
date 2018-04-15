<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>欢迎来到401峡谷</title>

  </head>
  
  <body>
    <form action="show" method="get">
		<input type="submit"  value="查询所有个人信息"/>
	</form>	
  </body>
</html>
