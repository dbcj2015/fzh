<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
	<!-- 
		ajax.open(method,url,async);
    		method:提交方式 get和post
    			get提交方式的用户数据使用？隔开以键值对的形式拼接在URL后面
    			post提交方式的用户数据是单独的，需要使用send进行发送，但是也是键值对，不同的键值对使用&符号隔开
    				注意：post请求方式需要在发送请求前，单独设置请求参数的格式。
    					ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    		url:提交地址
    		async:异步同步设置 true表示异步，false表示同步，默认是true
    	
	
	
	 -->
		<script type="text/javascript">
			function packageAjax(method,url,date,deal200,deal404,deal500,async){
				//创建ajax引擎对象
					var ajax;
					if(window.XMLHttpRequest){
		    			ajax=new XMLHttpRequest();
		    		}else if(window.ActiveXObject){
		    			ajax=new ActiveXObject("Msxml2.XMLHTTP");
		    		}
				//复写onreadyStateChange函数
					ajax.onreadystatechange=function(){
					//判断ajax状态码
						if(ajax.readyState==4){
							//判断ajax响应状态码
								if(ajax.status==200){
									//获取响应数据
										var data=ajax.responseText;
									//处理响应数据
										deal200(data)
								}else if(ajax.status==404){
									//响应状态码404如果发生了，在没有进行传参的方式下是不会展示错误效果的
									//如果传参的时候没有deal404,则deal404的默认值为undefine,对应的布尔值类型为false
									if(deal404){
										deal404();
									}
								}else if(ajax.status==500){
									if(deal500){
										deal500();
									}
								}else{
									alert("未知的错误");
								}
						} 
				}
			if("get"==method.toLowerCase()){
				//创建请求
				ajax.open(method, url+(data==null ? "" :"?"+data));
			//发送请求
				ajax.send(null);
			}else{
				//post方式创建请求
				ajax.open(method,url);
     			ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				//发送请求
				ajax.send(data);
			}		
		}
			
			//packageAjax(method,url,data,function(date){
				//处理响应数据:根据业务需求编写具体的业务处理方式
			//});
		</script>
	</head>
	<body>
		
	</body>
</html>
