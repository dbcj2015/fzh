<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<<script type="text/javascript" src="jquery/jquery.js">
<!--

//-->
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mail.jsp' starting page</title>
    <meta charset="utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  	function checkemail() {
		$.ajax({
			type : "GET",			
			url : "checkmail",
			dataType : "json",		
			data : "userName=" + $("#email").val(),
			success : function(msg) {
				//此处获取的json返回数据是字符串,需要进行解析
				//var data=eval(msg);
				//alert("data="+data.msg);
				alert(msg.msg);
				$("#message").html(msg.msg);
				//$("#message").text(msg.msg);
				$("#message").css("color", "red");
			}
		});
	}
  	/* function checkemail() {
		$.ajax({
			type : "GET",			url : "checkemail",
			dataType : "html",		data : "userName=" + $("#email").val(),
			success : function(msg) {
				$("#showResult").html(msg);
				$("#showResult").css("color", "red");
			}
		});
	} */

  </script>
  <body>
    	邮件注册:
	<input type="text" id="email" onblur="checkemail()">@163.com
	<span id="message">验证</span>
  </body>
</html>
