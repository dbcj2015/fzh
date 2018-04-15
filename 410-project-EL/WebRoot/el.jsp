<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%
 	
 	pageContext.setAttribute("hello","hello pageContext");
 	request.setAttribute("hello","hello request");
 	//对于session对象，数据请求结束，session对象还是存在的，只要JESESSION存在，session就可以根据id提供数据信息
 	session.setAttribute("hello", "hello session");
 	application.setAttribute("hello", "hello application");
 	//对于普通数据
 		String str="非作用域数据";
 	//必须将其放在作用域中
 		request.setAttribute("str", str);
 %>
<hr />
${hello}
${pageScope.hello}
${requestScope.hello }
${sessionScope.hello }
${applicationScope.hello }
${requestScope.str}
${a }
<br /><br />
<!--EL表达式的逻辑运算
	${1+"a"}-报错:作为运算时，必须是数字或者是数字字符串
-->
${1+3}--${1==1}--${a=="a"}--${1+"1" }--





