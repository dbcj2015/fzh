<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<style type="text/css">
body {
	background-color: #E77B18;
}

#showDiv {
	height: 400px;
	width: 300px;
	margin: auto;
	margin-top: 50px;
	text-align: center;
}

tr {
	height: 40px;
}

td {
	width: 200px;
	text-align: center;
}
</style>
<script type="text/javascript" src="js/jquery.js">	
</script>
<script type="text/javascript">
	//使用Ajax获取上级名字以及角色
	function getInfo() {
		var dt = {
			rid : ${user.rid},
			pnumber : ${user.pnumber},
			oper : "info",
		};

		$.get("user", dt, function(date) {
			//使用eval将数据转换为可执行的js代码
			eval("var data="+date);
			//获取ＨＴＭＬ元素对象
			document.getElementById("rid").innerHTML=data.rname;
			//if(${user.pnumber!=0}){
				document.getElementById("pnumber").innerHTML=data.pname;
			//}
			
		});
	}
</script>
</head>
<body onload="getInfo()">
	<div id="showDiv">
		<table border=" solid 0.5px">
			<tr>
				<td>学号:</td>
				<td>${user.unumber }</td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td>${user.uname }</td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>${user.usex }</td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td>${user.uage }</td>
			</tr>
			<tr>
				<td>地址:</td>
				<td>${user.uaddress }</td>
			</tr>
			<tr>
				<td>角色:</td>
				<td id="rid">${user.rid }</td>
			</tr>
			<!-- 班长是没有上级的，对应字段是0 -->
			<c:if test="${user.pnumber!=0 }">
			<tr>
				<td>组长:</td>
				<td id="pnumber"></td>
			</tr>
			</c:if>
		</table>
	</div>

</body>
</html>
