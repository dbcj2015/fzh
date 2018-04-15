<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 局部脚本声明
	注意:局部脚本声明域中不可以再次声明一个方法
	注意:注释为html注释，不是jsp注释
 -->

<%
	String str="我是局部脚本声明";
	System.out.println(str);
%>

<!-- 全局脚本声明
 -->
 
<%!
	//java注释
	public void test(){
	System.out.println("我是全局脚本声明");
}
%>

<!-- 脚本段 -->

<%	
	/**
		java注释
	*/
	String name="张三";
%>

<html>
	<body>
		<h4>欢迎<%=name %>来到401峡谷</h4>
		<h4>欢迎<%out.write(name); %>来到401峡谷</h4>
	</body>
</html>

<%--我是jsp注释，不会被转译，更不会被浏览器解析 --%>





