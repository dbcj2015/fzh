<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
  <head>
  </head>
  <body>
  	<%-- <%
  		String str=(String)request.getAttribute("str");
  	if(str!=null){
  	%>
  		<h4><%=str%></h4>
  	<%
  		}
  	%> --%>
  	
  	
  	<%--
  	
  	<% String str=(String)request.getAttribute("str");%>
  	<%=str==null ? "" : str %>
  	
  	 --%>
  	<% String str=(String)request.getAttribute("str");%>
  	${str }
  <form action="check" method="get">
	用户名:<input type="text" name="uname" value=""/><br><br>
	密    码:<input type="password" name="pwd" value=""/><br><br>
	<input type="submit"  value="提交"/>
	</form>	
   
  </body>
</html>
