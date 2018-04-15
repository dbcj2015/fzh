<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>
<style type="text/css">
	#sel{
		font-size:15px;
	}
	#role{
		width:100px;
		height:20px;
		margin-top: 8px;
		font-size:15px;
	}
</style>
<script type="text/javascript">
	function getRoleRid(){
		var rid=$("#role").val();
		//通过下拉框触发change事件发送请求数据--发送请求数据相当于拼接数据刷新页面发送请求数据
			window.location.href="clazz?oper=clazzInfo&rid="+rid;
	}
	
	//角色判断--因为每次触发事件发送请求数据，都会加载页面导致下拉框中的角色始终默认是第一个
	function getRole(){
		var os=document.getElementById("role").options;
		for(var i=0;i<os.length;i++){
			if(os[i].value==${rid==null?"1":rid}){
				os[i].selected=true;
			}
		}
	}
</script>
</head>
<body onload="getRole()">

	<div class="place" id="sel">
	<span id="roleSpan">请选择查看的角色信息</span>&nbsp;&nbsp;&nbsp;&nbsp;
	<select name="" id="role" onchange="getRoleRid()">
		
			<option value="1" >学生</option>
    		<option value="2" >组长</option>
    		<option value="3" >班长</option>
		</select>
	</div>

	<div class="rightinfo">
		<table class="tablelist">
			<thead>
				<tr>
					<th>学号 <i class="sort"><img src="images/px.gif" /></i></th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>地址</th>
					<th>角色</th>
					<th>上级姓名</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list }" var="s">
					<tr>
						<td>${s.unumber }</td>
						<td>${s.uname }</td>
						<td>${s.usex }</td>
						<td>${s.uage }</td>
						<td>${s.uaddress }</td>
						<td>${s.rname }</td>
						<td>${s.pname }</td>
						<!-- 通过用户学号,姓名获取签到签退信息 -->
						<td><a href="group?oper=showSign&unumber=${s.unumber }&uname=${s.uname}&page=1" class="tablelink"></a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="pagin">
			<div class="message">
				共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:;"><span
						class="pagepre"></span></a></li>
				<li class="paginItem"><a href="javascript:;">1</a></li>
				<li class="paginItem current"><a href="javascript:;">2</a></li>
				<li class="paginItem"><a href="javascript:;">3</a></li>
				<li class="paginItem"><a href="javascript:;">4</a></li>
				<li class="paginItem"><a href="javascript:;">5</a></li>
				<li class="paginItem more"><a href="javascript:;">...</a></li>
				<li class="paginItem"><a href="javascript:;">10</a></li>
				<li class="paginItem"><a href="javascript:;"><span
						class="pagenxt"></span></a></li>
			</ul>
		</div>
		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>


