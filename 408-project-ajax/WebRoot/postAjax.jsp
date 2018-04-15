<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<script type="text/javascript">
		//创建第一个ajax函数
		function testPostAjax(){
			var name=document.getElementById("inp").value;
			//这对不同的浏览器，创建ajax对象不同
				var ajax;
				if(window.XMLHttpRequest){//火狐方式
					ajax=new XMLHttpRequest();
				}else if(window.ActiveXObject){//IE方式
					ajax=new ActiveXObject("Msxm12.XMLHTTP");
				}
			//复写Onreadstatechange函数
				ajax.onreadystatechange=function(){
				if(ajax.readyState==4){
					if(ajax.status==200){
						var date=ajax.responseText;
						alert(date);
					}
				}
			}
			//创建请求
				ajax.open("post","post");
				ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			//发送请求
				ajax.send("uname="+name);
		}
		</script>
	</head>
	<body>
		请输入用户名: <input type="text" name="uname" id="inp" value="" />
		<br />
		<input type="button" value="测试post方式" onclick="testPostAjax()"/>
	</body>
</html>