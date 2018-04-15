<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'info.jsp' starting page</title>
  </head>
  <body>
     <form action="up" method="post" enctype="multipart/form-data">
    	<table border="1px">
    		<tr>
    			<td>用户名：</td>
    			<td>
    				<input type="text" name="uname" value=""/>
    			</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td>
    				<input type="password" name="pwd" value="" />
    			</td>
    		</tr>
    		<tr>
    			<td>头像：</td>
    			<td>
    				<input type="file" name="photo" value="" />
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
	    			<input type="submit" value="注册" />
	    		</td>
    		</tr>

    	</table>
    </form>
  </body>
</html>
