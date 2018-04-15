<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'content.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style type="text/css">
  	td{
  		width:200px;
  	}
  	th{
  		width:200px;
  	}
  </style>
  <script type="text/javascript">
  		
  </script>
  <body>
  	<b>我要发帖</b>
  	<br>
  	<br>
  	<table>
    	<tr>
    		<th>标题</th>&nbsp;&nbsp;&nbsp;&nbsp;
    		<th>发帖人</th>&nbsp;&nbsp;&nbsp;&nbsp;
    		<th>发帖时间</th>&nbsp;&nbsp;&nbsp;&nbsp;
    		<th>浏览量</th>
    	</tr>
    	<form id="frm" action="/fzh/reply/" method="get">
	    	<c:forEach items="${contentList}" var="c">
		    	<tr>
		    		<td id="title"><a href="http://localhost:8080/fzh/reply?topicId=${c.topic_id}">${c.title }</td>
		    		<td>${c.author }</td>
		    		<td>${c.create_date }</td>
		    		<td>${c.click_amount }</td>
		    	</tr>
	    	</c:forEach>
    	</form>
    </table>
  </body>
</html>
