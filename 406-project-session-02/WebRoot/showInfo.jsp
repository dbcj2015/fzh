<%@ page language="java" import="java.util.*,com.bjsxt.vo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <head>
  </head>
  	<%
  		User user=(User)request.getAttribute("user");
  	%>
  <body>
  <table border="solid 1px">
  	<tr>
			<th>id</th>
			<th>姓名</th>
			<th>爱好</th>
			<th>地址</th>
		</tr>
		<tr>
			<td><%=user.getId() %></td>
			<td><%=user.getName() %></td>
			<td><%=user.getFav() %></td>
			<td><%=user.getAddr() %></td>
		</tr>
  </table>
		
  </body>
</html>
