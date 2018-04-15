<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
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
				alert("哈哈");
			}
			//创建请求
				ajax.open("get","ajax");
			//发送请求
				ajax.send(null);
			alert("嘿嘿");
			//最终的结果是“哈哈”,“嘿嘿”,“哈哈”,“哈哈”,“哈哈”
			//主线程执行open方法，readystate值从0变为1，调用ajax.onreadystatechange函数，此时主线程
			//继续执行，当执行完“嘿嘿”后，readystate值还没有变为2
		}
	</script>
	
  </head>
  
  <body> 	
  	<input type="button" value="测试第一个Ajax程序" onclick="testAjax()">
    <div id="showdiv"></div>
  </body>
</html>
