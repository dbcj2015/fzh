<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
  	table{
  		border: solid 1px;
  		border-collapse: collapse;
  	}
  	td{
  		border: solid 1px;
  		
  	}
  </style>
  <script type="text/javascript">
  	function validPwd(){
  		var pwd=document.getElementById("pwd").value;
  		var newPwd=document.getElementById("newPwd").value;
  		if(pwd!=newPwd){
  			var span=document.getElementById("spanPwd");
  			span.innerHTML="密码不一致";
  		}
  	}
  	
  	function validAge(){
  		var age=document.getElementById("age").value;
  		if(isNaN(age)){
  			var span=document.getElementById("spanAge");
  			span.innerHTML="请输入数字";
  		}
  	}
  </script>
  <body>
   		<table>
   			<tr>
   				<td>姓名:</td>
   				<td> <input type="text" name="uname" value=""> </td>
   				<td style="width:100px"></td>
   			</tr>
   			<tr>
   				<td>密码:</td>
   				<td> <input id="pwd" type="password" name="pwd" value=""> </td>
   				<td></td>
   			</tr>
   			<tr>
   				<td>重复密码:</td>
   				<td> <input id="newPwd" type="password" name=pwd value="" onblur="validPwd()"> </td>
   				<td>
   					<span id="spanPwd"></span>
   				</td>
   			</tr>
   			<tr>
   				<td>年龄:</td>
   				<td> <input id="age" type="text" name="age" value="" onblur="validAge()"> </td>
   				<td>
   					<span id="spanAge"></span>
   				</td>
   			</tr>
   			<tr>
   				<td>性别:</td>
   				<td> 
   					男:<input type="radio" name="uname" value="1"> 
   					女:<input type="radio" name="uname" value="2">
   				</td>
   			</tr>
   			<tr>
   				<td>爱好:</td>
   				<td> 
   					足球:<input type="checkbox" name="uname" value="1"> 
   					篮球:<input type="checkbox" name="uname" value="2">
   					排球:<input type="checkbox" name="uname" value="3">
   				</td>
   			</tr>
   			<tr>
   				<td>班级:</td>
   				<td>
   					<select>
   						<option value="1">一班</option>
   						<option value="2">二班</option>
   						<option value="3">三班</option>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td><input type="button" value="重置"></td>
   				<td align="center"> <input type="button" value="提交"> </td>
   			</tr>
   			
   		</table>
  </body>
</html>
