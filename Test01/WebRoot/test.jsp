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
	<script type="text/javascript">
		function changeColor(id,colo){
			document.getElementById(id).style.background=colo;	
		}
	</script>
  </head>
  	<!-- 2）字体大小12px，表格宽300px，按钮行占两列并水平居中 -->
  <style type="text/css">
  table{
  	border:solid 1px blue;
  	width:400px;
  	border-collapse: collapse;
  }
  	td{
  		border:solid 1px blue;
  		width:300px;
  		height:30px;
  		 
  	}
  </style>
  <body>
    	<table>
    		<tr>
    			<td align="left" id="red" onmouseover="changeColor('red','red')" onmouseout="changeColor('red','#ffffff')">红色</td>
    			<td align="left" id="green" onmouseover="changeColor('green','green')" onmouseout="changeColor('green','#ffffff')">绿色</td>
    			<td align="left" id="yellow" onmouseover="changeColor('yellow','yellow')" onmouseout="changeColor('yellow','#ffffff')">黄色</td>
    		</tr>
    	</table>
  </body>
</html>
