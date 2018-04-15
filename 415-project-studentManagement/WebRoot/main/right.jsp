<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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




<style type="text/css">
body {
	background-color: #E77B18;
}

#showDiv {
	border: solid 1px gray;
	width: 500px;
	height: 150px;
	margin: auto;
	margin-top: 50px;
	text-align: center;
}

/* 设置timeSpan中的时间样式 */
#spanTime {
	font-size: 70px;
}
/*设置日期样式*/
#spanDate {
	font-size: 30px;
}

#sinDiv {
	margin: auto;
	margin-top: 100px;
	text-align: center;
}
/*设置签到签退标签的属性*/
#sin {
	margin-right: 150px;
}

#sout {
	margin-left: 150px;
}

input[type="button"] {
	width: 200px;
	height: 80px;
	font-size: 20px;
	border-radius: 10px;
}
</style>
<script type="text/javascript">
	function getTimeInfo() {
		var date = new Date();
		var h = date.getHours();
		var m = date.getMinutes();
		var s = date.getSeconds();
		var currentTime = h + ":" + m + ":" + s;
		var spanTime = document.getElementById("spanTime");
		spanTime.innerHTML = currentTime;
		//实现时间的动态显示
		window.setTimeout(getTimeInfo, 1000);
	}

	function getDateInfo() {
		var date = new Date();
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDay();
		var currentDate = y + ":" + m + ":" + d;
		//获取日期span
		var spanDate = document.getElementById("spanDate");
		spanDate.innerHTML = currentDate;
	}
	//将签到信息插入到数据库中
	function getInDate() {
		var unumber = ${user.unumber};
		//alert(unumber);
		//获取签到日期
		var inTime = $("#spanTime").html();
		var inDate = $("#spanDate").html();
		//获取签到状态信息
		var inStatus;
		var h = new Date().getHours();
		//不能等于9，原因:getHours()函数对于区间[9-10]的结果都是9
		if (h < 9) {
			inStatus = "0";
		} else {
			inStatus = "1";
		}
		var dt = {
			unumber : unumber,
			inTime : inTime,
			inDate : inDate,
			inStatus : inStatus,
			oper : "in",
		}
		$.get("user", dt, function(date) {
			if ("a" == date) {
				alert("你已经签到成功");
			} else if ("0" == date) {
				alert("签到成功:正常");
			} else if ("1" == date) {
				alert("签到成功:迟到");
			} else {
				alert("签到失败");
			}

		});
	}
	//获取签退信息
	function getOutDate() {
		var h=new Date().getHours();
		var outStatus;
		if(h<18){
			outStatus="1";
		}else{
			outStatus="0";
		}
		var unumber = ${user.unumber};
		var inTime = $("#spanTime").html();
		var inDate = $("#spanDate").html();
		var dt = {
			unumber : unumber,
			inTime : inTime,
			inDate : inDate,
			outStatus:outStatus,
			oper : "sout",
		}

		$.get("user", dt, function(date) {
			if ("0"==date) {
				alert("签退成功:正常");
			} else if("1"==date){
				alert("签退成功:早退");
			}else{
				alert("签到失败");
			}
		});
	}
</script>

</head>
<body onload="getTimeInfo(),getDateInfo()">
	<div id="showDiv">
		<span id="spanTime"></span> <span id="spanDate"></span>
	</div>
	<div id="sinDiv">
		<input type="button" name="uname" id="sin" value="签到"
			onclick="getInDate()" /> <input type="button" name="uname" id="sout"
			value="签退" onclick="getOutDate()" />
	</div>
</body>

</html>

