<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function selectRole(){
		var date={
				oper:"role"
		};
		$.get("admin",date,function(data){
			var sel=$("#sel");
			alert("list="+data);
			for(var i=0;i<list.;i++){
				
			}
		});
	}
</script>
</head>
<body onload="selectRole()">
	<div>
		<form action="#" method="get">
		<table>
			<tr>
				<td>学号:</td>
				<td> 
					<input type="text" name="unumber" value="">
				</td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td> 
					<input type="text" name="uname" value="">
				</td>
			</tr>
			<tr>
				<td>性别:</td>
				<td> 
					男:<input type="radio" name="usex" value="男" checked="checked">
					女:<input type="radio" name="usex" value="">
				</td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td> 
					<input type="text" name="uage" value="">
				</td>
			</tr>
			<tr>
				<td>籍贯:</td>
				<td> 
					<input type="text" name="uaddress" value="">
				</td>
			</tr>
			<tr>
				<td>角色:</td>
				<td> 
					<select name="rid" id="sel"></select>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
