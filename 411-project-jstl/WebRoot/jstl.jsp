<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--在jsp页面中使用jstl标签库，必须引入jstl命令,jsp就可以根据命令解析jstl标签
	taglib:标签库;指令
	Taglib 指令是定义一个标签库以及其自定义标签的前缀
	prefix:前缀
 --%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
	jstl输出标签:数据必须是作用域中的数据
		<c:out value="${str }"></c:out>
	作用域存储标签：
		<c:set var="键名" value="值" scope="作用域名"></c:set>
	作用域数据删除标签:
			<c:remove var="要删除的作用域数据的键" scope="作用域名"></c:remove>
			删除指定作用域中的指定的数据，如果不指定作用域则将四个作用域中的同键数据全部删除
--%>

<%
	String str="哈哈";
	//EL表达式获取的数据必须是作用域中的表达式
	request.setAttribute("str", str);
%>

<%=str%>--${str}
<br />
<c:out value="${str }"></c:out>
<br />
<c:out value="我是普通数据"></c:out>
<br />
"我是普通数据"
<br />
<c:out value="${a }" default="value中没有值，可以输出默认值"></c:out>
<hr />
	<c:set var="ss" value="今天下雨了"></c:set>
	${ss }
	<br />
	<c:out value="${ss}"></c:out>
<hr />
	<c:set var="ss" value="默认作用域是pageContext,指定作用域:今天下雨了" scope="request"></c:set>
	${requestScope.ss }
	<br />
	<c:out value="${ss}"></c:out>















