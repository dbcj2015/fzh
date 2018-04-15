<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'contentList.jsp' starting page</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript">
		function submitReply(){
			var name=document.getElementById("textId").value;
			var area=document.getElementById("textArea").value;
			var dt={
					uname:name,
					textArea:area
			};
			$.get("list",dt,function(data){
				eval("data="+data);
				console.info(data);
				var name=document.getElementById("spanAme");
				name.innerHTML=data.author;
				var area=document.getElementById("spanText");
				area.innerHTML=data.contnt;
			});
		}
		
		function addTime(){
			var date=new Date();
			var y=date.getFullYear();
			var m=date.getMonth()+1;
			var d=date.getDay();
			var h=date.getHours();
			var mm=date.getMinutes();
			var s=date.getSeconds();
			var currentTime=y+":"+m+":"+d+":"+h+":"+mm+":"+s;
			var spanTime=document.getElementById("timeSpan");
			spanTime.innerHTML=currentTime;
		}
	</script>
  </head>
  <style type="text/css">
  	
  </style>
  <body>
    	<table align="center">
    		<tr>
    			<td><b>${topic.title }</b></td> &nbsp;
    			<td><b>${topic.author }</b></td> &nbsp;
    			<td><b>${topic.createDate }</b></td> &nbsp;
    			<td><b>共被浏览过${topic.clickAmount}次</b></td>
    		</tr>
    		<tr>
    			<td><b>正文:${ topic.content}</b></td>
    		</tr>
    	</table>
    	<hr>
    <div align="center">
    	昵称:<span id="spanAme"></span>
    	&nbsp;&nbsp;
    	时间:<span id="timeSpan"></span>
    	<br>
		正文:<span id="spanText"></span>
		<br>
		<b>=======================================</b>
    </div>
    <hr>
    <div id="textDiv" align="center">
    		昵称: <input type="text" name="uname" value="" id="textId"><br><br>
    		评论: <textarea rows="" cols="" id="textArea" name="textArea" > </textarea>
    		<input type="button" value="发表评论" onclick="submitReply();addTime()">
    </div>
    <table>
 	 <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>   	
    </table>
  </body>
</html>
