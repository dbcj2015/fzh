<%@ page language="java" import="java.util.*,com.bjsxt.loginDao.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>所有用户的详细信息</title>
  </head>
  
  <body>
   <table border="1px">
   		<tr>
   			<td>用户id</td>
   			<td>用户name</td>
   			<td>用户fav</td>
   			<td>用户addr</td>
   		</tr>
<!-- 通过jstl标签库实现遍历 -->
	<%
   		ArrayList<User> list=(ArrayList<User>)request.getAttribute("list");
   	%>	
	<c:forEach items="${list }" var="user">
		<tr>
			<td>${user.id}</td>	
			<td>${user.name}</td>
			<td>${user.fav}</td>
			<td>${user.addr}</td>		   		
		</tr>
	</c:forEach>
   	<%-- 
		   	<%
		   		ArrayList<User> list=(ArrayList<User>)request.getAttribute("list");
		   		for(int i=0;i<list.size();i++){
		   	%>	
		   		<tr>
			   		<td><%=list.get(i).getId() %></td>
			   		<td><%=list.get(i).getName() %></td>
			   		<td><%=list.get(i).getFav() %></td>
			   		<td><%=list.get(i).getAddr() %></td>
		   		</tr>
		   	<%
		   		}
		   	%>
   	 --%>
   
   </table>
  </body>
</html>
