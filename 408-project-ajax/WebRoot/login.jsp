<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<script type="text/javascript">
			function testAjax(){
				//获取前台用户信息
					var uname=document.getElementById("uname").value;
				//创建ajax引擎对象
					var ajax;
					if(window.XMLHttpRequest){
						ajax=new XMLHttpRequest();
					}else if(window.ActiveXObject){
						ajax=new ActiveXObject("Msxm12.XMLHTTP");
					}
				//复写onreadystatechange函数
					ajax.onreadystatechange=function(){
						//判断ajax状态码
							if(ajax.readyState==4){
								//判断状态响应码
									if(ajax.status==200){
										//获取响应数据
											var data=ajax.responseText;
										//处理响应数据
											if(eval(data)){
												alert("用户名已经注册");
											}else{
												alert("恭喜您注册成功");
											}
									}
							}
				}
				
				//创建请求
					ajax.open("get", "login?uname="+uname);
				//发送请求
					ajax.send(null);
			}
		</script>
</head>
	<body>
		用户名:<input type="text" name="uname" id="uname" value="" onblur="testAjax()"/>
	</body>
</html>
