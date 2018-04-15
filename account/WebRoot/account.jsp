<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
   
    <title>My JSP 'account1.jsp' starting page</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body class="container">
  <div class="col-xm-8" style="border: solid 1px; margin-top: 100px">
  	<table class="table table-bordered">
  		<tr>
  			<td></td>
  			<td colspan="6" style="text-align: center">灵通卡在ATM的交易情况</td>
  			<td colspan="2" style="text-align: center">POS的交易情况</td>
  		</tr>
  		<th>卡种</th>
  		<th>存款笔数</th>
  		<th>存款金额</th>
  		<th>取款笔数</th>
  		<th>取款金额</th>
  		<th>转账笔数</th>
  		<th>转账金额</th>
  		<th>POS消费笔数</th>
  		<th>POS消费金额</th>
  		<c:forEach items="${account}" var="a">
	  		<tr>
	  			<td>${a.card_type }</td>
	  			<td>${a.c_amount }</td>
	  			<td>${a.c_money }</td>
	  			<td>${a.q_amount }</td>
	  			<td>${a.q_money }</td>
	  			<td>${a.z_amount }</td>
	  			<td>${a.z_money }</td>
	  			<td>${a.pos_amount}</td>
	  			<td>${a.pos_consume}</td>
	  		</tr>
  		</c:forEach>
  		
  	</table>
  </div>
  
    	
  </body>
</html>
