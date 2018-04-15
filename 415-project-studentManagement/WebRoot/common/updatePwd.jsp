<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
 <style type="text/css">
   		/*设置背景颜色  */
    	body{
			background-color: #E77B18;
		}
    	/*设置table的样式  */
    		table{
    			margin:auto;
    		}
    		td{
    			font-size: 20px;
    			font-family: 宋体;
    		}
    		
    		tr{
    			height:80px;
    		}
    		input{
    			width:200px;
    			height: 40px;
    			
    		}
    	/*设置div的样式  */
    	#showdiv{
    		border:solid 1px;
    		width:500px;
    		margin:auto;
    		margin-top:100px;
    		border-radius:10px;
    	}
    	#div01{
    		margin-top:50px;
    		text-align: center;
    	
    	}
    </style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	var flag = false;
	function checkOldPwd() {
		var oldPwd = $("#oldPwd").val();
		var dt = {
			oldPwd : oldPwd,
			oper : "pwd",
		};
		$.get("user", dt, function(date) {
			//使用eval将数据转换为可执行的js代码
			if (eval(date)) {
				//提示语样式
				$("#oldSpan").css("color", "green");
				//提示语
				$("#oldSpan").html("密码正确");
				flag=true;
			} else {
				//提示语样式
				$("#oldSpan").css("color", "darkred");
				//提示语
				$("#oldSpan").html("密码错误");
				flag=false;
			}
		});
	}
	//修改密码
	function updatePwd() {
		//判断--只有原始密码正确的前提下才可以修改密码
		if (flag) {
			//获取表单对象
			var fm = document.getElementById("fm");
			fm.submit();
		} else {
			document.getElementById("oldSpan").style.color = "darkred";
			document.getElementById("oldSpan").innerHTML = "原始密码错误";
		}
	}
	
</script>
</head>
<body>
	<form action="user" method="get" id="fm" target="_top">
		<input type="hidden" name="oper" value="newPwd"/>
		<div id="showdiv">
			<table>
				<tr>
					<td width="150px">原始密码:</td>
					<td width="350px">
					<input type="password" id="oldPwd" placeholder="请输入原始密码" onblur="checkOldPwd()" />
					<span id="oldSpan"></span>
					</td>
					
				</tr>
				<tr>
					<td>新密码:</td>
					<td><input type="password" name="newPwd" id="newPwd"
						placeholder="请输入新密码" /></td>
				</tr>
			</table>
		</div>
		<div id="div01">
			<input type="button" value="确认修改" onclick="updatePwd()"/>
		</div>
	</form>
</body>
</html>
