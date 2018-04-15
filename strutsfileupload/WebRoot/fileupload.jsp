<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- struts2为我们提供了一系列自定义标签来显示数据, -->
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">这是Html 4版本 -->
<!DOCTYPE HTML><!-- 这是html 5的版本 -->
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fileupload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		
  		<s:actionerror/>
   		<s:fielderror></s:fielderror>
    	<form action="/strutsfileupload/maxSize" method="post" enctype="multipart/form-data">
    		<input type="text" name="name" placeholder="请输入您的姓名">
    		<input type="text" name="idno" placeholder="请输入您的身份证号">
    		<input type="file" name="idphoto" placeholder="请输入您身份证照片">
    		<input type="submit" value="提交">
    	</form>
  </body>
</html>
