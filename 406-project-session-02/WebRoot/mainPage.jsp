<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    

  </head>
  <%
		String name=(String)request.getAttribute("uname"); 
  %>
  <body>
   		<h4>欢迎<%=name %>来到401峡谷</h4>
   		<hr />
   		<form action="showInfo" method="get">
   			<input type="submit" value="查看个人信息"/>
   		</form>
   		
   		
  </body>
</html>
