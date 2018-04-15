<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<!-- 导入JQueryAjax包 -->
		<script type="text/javascript" src="jquery/jquery.js"></script>
		<script type="text/javascript">
			function checkUserInfo(){
				var name=document.getElementById("name").value;
				//alert(name);
				$.ajax({
					type:"get",
					url:"login",
					data:"uname="+name,
					success:function(date){
						if(eval(date)){
							//alert("用户名已经注册");
							var str="<b>*用户名已经注册<b/>";
							var span=document.getElementById("span");
							span.innerHTML=str;
						}else{
							//alert("注册成功");
							var str="<b>*注册成功<b/>";
							var span=document.getElementById("span");
							span.innerHTML=str;
						}
					}
				});
			}
		</script>
	</head>
	<body>
		请输入用户名:<input type="text" name="uname" id="name" value=""/>
		<span id="span"></span>
		<br>
		<input type="button" value="注册" onclick="checkUserInfo()"/>
	</body>
</html>
