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
<script type="text/javascript">
	//设置点击最后一页时
		function checkLastPage(){
		var lp=${pageCount};
		var p=${page};
		if(p<lp){
			return true;
		}else{
			alert("已经是最后一页了");
			return false;
		}

	}
		//设置点击首页
		function checkFirstPage(){
		var p=${page};
		if(p>1){
			return true;
		}else{
			alert("已经是第一页");
			return false;
		}
	}
		//当前页码背景色
		function addBgc(){
		//获取元素对象
			var li=document.getElementById('${page}');
		//给li对象添加背景色
			li.style.backgroundColor="gray";
		}
</script>
</head>
<body onload="addBgc()">

	<div class="place">
		<span></span>
		<ul class="placeul">
			<li><a href="#"></a></li>
			<li><a href="#"></a></li>
			<li><a href="#"></a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<table class="tablelist">
			<thead>
				<tr>
					<th>学号 <i class="sort"><img src="images/px.gif" /></i></th>
					<th>姓名</th>
					<th>签到时间</th>
					<th>签到状态</th>
					<th>签退时间</th>
					<th>签退状态</th>
					<th>日期</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${newList}" var="ns">
					<tr>
						<td>${ns.unumber }</td>
						<td>${uname }</td>
						<td>${ns.sintime }</td>
						<td>${ns.sinstatus==0 ? "正常" : "迟到"}</td>
						<td>${ns.souttime }</td>
						<td>${ns.soutstatus==0 ? "正常" :"早退" }</td>
						<td>${ns.sdate }</td>

						<td><a href="#" class="tablelink"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 以上是实现签退签到功；以下是实现分页功能 -->
		<div class="pagin">
			<div class="message">
				共<i class="blue">${pageAllCount }</i>条记录，当前显示第&nbsp;<i class="blue">${page }&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem" ><a href="group?oper=showSign&unumber=${newList[0].unumber}&uname=${requestScope.uname}&page=${page-1}" onclick="return checkFirstPage()"><span
						class="pagepre"></span></a></li>
				<c:forEach begin="1" end="${pageCount}" var="p">
				<li class="paginItem" id="${p}"><a href="group?oper=showSign&unumber=${newList[0].unumber}&uname=${requestScope.uname}&page=${p}">${p }</a></li>
				</c:forEach>
				<li class="paginItem"><a href="group?oper=showSign&unumber=${newList[0].unumber}&uname=${requestScope.uname}&page=${page+1}" onclick="return checkLastPage()"><span
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
				<input name="" type="button" class="sure" value="确定" />&nbsp; 
				<input name="" type="button" class="cancel" value="取消" />
			</div>

		</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>

</html>
