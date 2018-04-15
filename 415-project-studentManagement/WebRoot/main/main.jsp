<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息管理系统界面</title>
</head>
<!-- 
	main主页是用来切割一个html主页的：rows="88,*,31":表示一共切割了三行
							:cols="187,*":在第二行切割了两列
							第一列引用的地址是main/left.jsp;通过target以及name属性，保证left.jsp中页面的跳转到达main页面中name="rightFrame"
 -->
<frameset rows="88,*,31" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="main/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
    <frame src="main/left.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="main/right.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
  </frameset>
  <frame src="main/footer.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" title="bottomFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>

