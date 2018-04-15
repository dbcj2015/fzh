<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<h4>后台实现下拉框</h4>
		<script type="text/javascript">
			function checkSelect(){
			//创建ajax引擎对象
				var ajax;
				if(window.XMLHttpRequest){
					ajax=new XMLHttpRequest();
				}else if(window.ActiveXObject){
					ajax=new ActiveXObject("Msxml12.XMLHTTP");
				}
			//复写onreadyStateChange函数
				ajax.onreadystatechange=function(){
				//判断ajax状态码
					if(ajax.readyState==4){
						if(ajax.status==200){
							//获取响应数据
								var data=ajax.responseText;
								alert(data);
							//处理响应数据	
								//使用eval函数将数据转换为可执行的js代码
									eval("var c="+data);
								//获取要填充数据的HTML对象
								var sel=document.getElementById("sel");
								//将数据填充到对象中
									for (var i = 0; i < c.length; i++) {
										sel.innerHTML=sel.innerHTML+"<option value='"+c[i].cno+"'>"+c[i].cname+"<option />";
								}
						}
					}
				}
			//创建请求
				ajax.open("get", "select");
			//发送请求
				ajax.send(null);
			}
	//使用封装函数实现下拉框内容填充
		alert("我是通过封装的方式实现下拉框内容的填充");
		packageAjax("get","select",null,function(date){
			//处理响应数据
				eval("list="+date);
				var sel=document.getElementById("sel");
				for (var i = 0;i <list.length; i++) {
				sel.innerHTML=sel.innerHTML+"<option value='"+c[i].cno+"'>"+c[i].cname+"<option />";	
				}
		})
		</script>
	</head>
	<body onload="checkSelect()">
		请选择班级信息: <select name="" id="sel">
		<!-- 下拉框选项中:value是提交的值
		<option value=""></option>
		 -->
		</select>
	</body>
</html>