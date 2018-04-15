<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/struts2/register.action" method="post">
		姓名:<input type="text" name="name"/><br>
		年龄:<input type="text" name="age"/><br>
		身份证:<input type="text" name="idno"/><br>
		生日:<input type="text" name="birthday"/><br>
		爱好:
		<input type="checkbox" name="fun" value="football"/>足球
		<input type="checkbox" name="fun" value="basketball"/>篮球
		<input type="checkbox" name="fun" value="pingpang"/>乒乓球
		<input type="checkbox" name="fun" value="glassball"/>玻璃球
		<input type="checkbox" name="fun" value="deskball"/>桌球
		<br>
		<input type="submit"/>
	</form>
</body>
</html>