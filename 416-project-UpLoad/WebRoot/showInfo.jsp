<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<style type="text/css">
	tr{
		height:50px;
	}
</style>
</head>
<body>
	<div>
		<table border="1px">
			<tr>
				<td width="100px">用户id</td>
				<td width="100px">用户名</td>
				<td width="100px">头像</td>
				<td width="100px">下载</td>
			</tr>
			<c:forEach items="${list }" var="l">
				<tr>
					<td>${l.uid }</td>
					<td>${l.name }</td>
					<td>
						<img src="upload/${l.photoName }" alt="" width="80px  "/>
					</td>
					<td>
						<a href="down?uid=${l.uid }">下载</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
