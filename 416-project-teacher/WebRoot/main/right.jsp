<%@ page language="java" import="java.util.*,com.bjsxt.entry.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<!--声明css代码域  -->
	<style type="text/css">
		body{
			background-color: #E77B18;
		}
		/* 设置显示时间的div的样式 */
		#divTime{
			border:solid 1px gray;
			width:500px;
			height:150px;
			margin:auto;
			margin-top:50px;
			border-radius:10px;
			text-align: center;
		}
		/* 设置timeSpan中的时间样式 */
			#timeSpan{
				font-size: 70px;
			}
		/* 设置dateSpan中的日期样式 */
			#dateSpan{
				font-size:20px;
			}
		/* 设置签到签退的div的位置 */
		#sign{
			margin:auto;
			margin-top:80px;
			text-align: center;
		
		}
	   /* 设置签到签退按钮的样式 */
	   		input[type=button]{
	   			width: 300px;
	   			height: 100px;
	   			font-size: 40px;
	   			border-radius:10px;
	   		}
	   		#bin{
	   			margin-right:150px;
	   		}
	   		#bout{
	   			margin-left:150px;
	   		}
	</style>
	<!-- 声明js代码域 -->
	<script type="text/javascript">
		//声明函数显示当前时间
			function getTimeInfo(){
				//获取当前时间
					var d=new Date();
					var h=d.getHours();
					var m=d.getMinutes();
					var s=d.getSeconds();
					var currentTime=h+":"+m+":"+s;
				//获取span对象
					 var timeSpan=document.getElementById("timeSpan");
				//将时间填充进span中
					timeSpan.innerHTML=currentTime;
				//实现时间的动态显示
					window.setTimeout(getTimeInfo,1000);
			}
		//声明函数显示当前日期
			function getDateInfo(){
				//获取当前日期
					var date=new Date();
					var y=date.getFullYear();
					var m=date.getMonth()+1;
					var d=date.getDate();
					var currentDate=y+"-"+m+"-"+d;
				//获取span对象
					var span=document.getElementById("dateSpan");
				//将日期填充到span中
					dateSpan.innerHTML=currentDate;	
			}
		/* 
			签到签退功能思路:
					签到：
						1、在当前页面内显示签到的结果，所以使用ajax技术进行签到
						2、请求发送功能servlet进行处理，UserServlet
						3、签到人，签到时间，签到日期，签到状态。
							在获取数据的时候判断签到的状态，9点之前算正常用0表示，9点之后算迟到用1表示。
						4、点击签到按钮的时候执行ajax函数进行签到
					
		
		*/
		//签到功能实现
			function signInAjax(){
				//判断签到状态
				var h=new Date().getHours();
				var inStatus;
				if(h<9){
					inStatus=0;
				}else{
					inStatus=1;
				}
				//获取签到数据
					var unumber=${u.unumber};
					var inTime=$("#timeSpan").html();
					var indate=$("#dateSpan").html();
				//创建请求数据
					var dt={
						unumber:unumber,
						inTime:inTime,
						indate:indate,	
						inStatus:inStatus,
						oper:"in"
					}
				//使用ajax进行签到
					$.get("user",dt,function(data){
						//使用eval将响应数据转换为可执行的js代码
						if("a"==data){
							alert("已经签到，不能重复签到");
						}else if("0"==data){
							alert("签到成功:正常");
						}else if("1"==data){
							alert("签到成功:迟到");
						}else{
							alert("签到失败");
						}
					});
			}
			/*
				思路：
					1、在当前页面内显示签退的结果，所以使用ajax技术进行签到
					2、请求发送功能servlet进行处理，UserServlet
					3、签退人，签退时间，签退日期，签退状态。
						在获取数据的时候判断，18点之前算早退，18点之后算正常。
					4、点击签到按钮的时候执行ajax函数进行签到
			
			*/
			//签退功能实现
				function signOutAjax(){
				//判断签退状态
					var h=new Date().getHours();
				    var outStatus;
				    if(h<18){
				    	outStatus=1;
				    }else{
				    	outStatus=0;
				    }
				//获取签退信息
					var unumber=${u.unumber};
					var outTime=$("#timeSpan").html();
					var outdate=$("#dateSpan").html();
				//创建签退请求数据
					var dt={
						unumber:unumber,
						outTime:outTime,
						outdate:outdate,
						outStatus:outStatus,
						oper:"sout"
					}
				//使用ajax进行签退
					$.get("user",dt,function(data){
						//使用eval将响应结果转换为可执行的js代码
						 if("a"==data){
							 alert("请先签到");
						 }else if("0"==data){
							 alert("签退成功:正常");
						 }else if("1"==data){
							 alert("签退成功:早退");
						 }else{
							 alert("签退失败");
						 }
					});	
			}
	</script>
</head>

<body onload="getTimeInfo();getDateInfo()">
	<!-- 显示当前时间 -->
	<div id="divTime">
		<span id="timeSpan"></span><br />
		<span id="dateSpan"></span>
	</div>
	<div id="sign">
		<input type="button" value="签到" id="bin" onclick="signInAjax();"/>
		<input type="button" value="签退" id="bout" onclick="signOutAjax()"/>
	</div>
</body>

</html>

