<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head> 
     <script type="text/javascript">
     	//创建ajax函数
     	function testAjax(){
     		//获取前台用户数据
     		var un=document.getElementById("un").value;
     		//创建ajax对象
	     		var ajax;
	     		if(window.XMLHttpRequest){//火狐
	     			ajax=new XMLHttpRequest();
	     		}else if(window.ActiveXObject){//ie
	     			ajax=new ActiveXObject("Msxml2.XMLHTTP");
	     		}
	     	//复写onreadystatechange函数
		     	ajax.onreadystatechange=function(){
	     				//判断ajax状态码
	     				if(ajax.readyState==4){
	     					//判断响应状态码
	     					if(ajax.status==200){
	     						//获取响应数据
		     						var data=ajax.responseText;
		     					//处理响应数据
		     						document.getElementById("showdiv").innerHTML=data;
	     					}else if(ajax.status==404){
	     						document.getElementById("showdiv").innerHTML="资源未找到";
	     					}else if(ajax.status==500){
	     						document.getElementById("showdiv").innerHTML="服务器繁忙";
	     					}	
	     				}		
		     	}
     		//创建请求--此处是js获取标签信息，区别于form表单提交数据
     		//un是js获取input标签中的值,uname是js发送数据请求后服务器获取对应数据信息的键值名
     			ajax.open("get","ajax?uname="+un);
     		
     		//发送请求
     			ajax.send(null);
     	}
     </script>
    <style type="text/css">
    	#showdiv{
    		border:solid 1px;
    		width:300px;
    		height:300px;
    	} 
    </style>
  </head> 
  <body>
	<h3>ajax基本语法学习</h3>
	用户名: <input type="text" name="un" id="un" value="" />
	<input type="button" value="测试ajax"  onclick="testAjax()"/>
	<hr />
	<div id="showdiv"></div>
  </body>
</html>