<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'firstAjax.jsp' starting page</title>
    <style type="text/css">
    	#showdiv{
    		border: solid 1px;
    		width:300px;
    		height:300px;
    	}
    </style>
	<script type="text/javascript">
		//创建第一个ajax函数
		function testAjax(){
			//这对不同的浏览器，创建ajax对象不同
				var ajax;
				if(window.XMLHttpRequest){//火狐方式
					ajax=new XMLHttpRequest();
				}else if(window.ActiveXObject){//IE方式
					ajax=new ActiveXObject("Msxm12.XMLHTTP");
				}
			//复写Onreadstatechange函数
				ajax.onreadystatechange=function(){
				//获取响应信息
					var data=ajax.responseText;
				//将数据放入div
					document.getElementById("showdiv").innerHTML=data;
			}
			//创建请求
				ajax.open("get","ajax");
			//发送请求
				ajax.send(null);
		}
	</script>
	
  </head>
  
  <body> 	
  	<input type="button" value="测试第一个Ajax程序" onclick="testAjax()">
    <div id="showdiv"></div>
  </body>
</html>
