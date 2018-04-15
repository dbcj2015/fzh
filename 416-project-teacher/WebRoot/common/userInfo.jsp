<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentInfo.jsp' starting page</title>
	<!-- 声明css代码域 -->
	<style type="text/css">
		/* 添加背景颜色 */
		 body{
			background-color: #E77B18;
			font-family: 黑体;
		}
		/* 设置table样式 */
		td{
			border:solid 1px;
			font-size: 20px;
		}
		tr{
			height:50px;
		}
		/* 设置div的位置 */
		#showdiv{
			width:450px;
			margin:auto;
		}
	</style>
	<!--引入jQuery文件  -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		//使用ajax技术获取用户的角色以及上级姓名
			function getUserInfo(){
				//创建请求数据
					var dt={
						rid:${u.rid},	
						pnumber:${u.pnumber},
						oper:"info"
					}
				//使用ajax获取信息
					$.get("user",dt,function(data){
						//使用eval将数据转换为可执行的js代码
						eval("var data="+data);
						//获取ＨＴＭＬ元素对象
						document.getElementById("rid").innerHTML=data.rname;
						if(${u.pnumber}!=0){
							document.getElementById("pnumber").innerHTML=data.pname;
						}	
					});
			}
	</script>
  </head>
  
  <body onload="getUserInfo()">
  	<div id="showdiv">
	   	<table>
	   		<tr>
	   			<td width="100px">学号:</td>
	   			<td width="300px">${u.unumber}</td>
	   		</tr>
	   		<tr>
	   			<td>姓名:</td>
	   			<td>${u.uname}</td>
	   		</tr>
	   		<tr>
	   			<td>性别:</td>
	   			<td>${u.usex}</td>
	   		</tr>
	   		<tr>
	   			<td>年龄:</td>
	   			<td>${u.uage}</td>
	   		</tr>
	   		<tr>
	   			<td>籍贯:</td>
	   			<td>${u.uaddress}</td>
	   		</tr>
	   		<tr>
	   			<td>角色:</td>
	   			<td id="rid">${u.rid}</td>
	   		</tr>
	   		<c:if test="${u.pnumber!=0}">
		   		<tr>
		   			<td>上级:</td>
		   			<td id="pnumber"></td>
		   		</tr>
	   		</c:if>
	   	</table>
   	</div>
  </body>
</html>
