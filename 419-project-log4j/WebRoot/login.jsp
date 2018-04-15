<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录签到系统</title>
</head>

<body>
	<div>
		<form action="login" method="get">
			学号:<input type="text" name="unumber" value="" /> <br />
			<br /> 姓名:<input type="text" name="uname" value="" /> <br />
			<br /> <input type="submit" value="注册" />
		</form>
	</div>
</body>

</html>

