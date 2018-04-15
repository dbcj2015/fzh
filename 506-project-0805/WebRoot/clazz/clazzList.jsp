<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.js"></script>


<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
<style type="text/css">
	#role{
		width:150px;
		height: 30px;
		margin-top: 4px;
		font-size: 15px;
	}
	#roleSpan{
		font-size: 17px;
		color: black;
	}
</style>
<script type="text/javascript">
	//实现角色选择后的请求发送
	function getRoleUserInfo(){
		//角色id
		var rid=$("#role").val();
		//发送请求到ClazzServlet
		window.location.href="clazz?oper=clazzInfo&rid="+rid;
	}
	//角色判断
	function selectRole(){
			//获取option对象集和
			var os=document.getElementById("role").options;
			//遍历
			for(var i=0;i<os.length;i++){
				if(os[i].value==${rid==null?"1":rid}){
					os[i].selected=true;
				}
			}
		
		}
</script>
</head>


<body onload="selectRole();">

	<div class="place" id="showdiv">
    	<span id="roleSpan">请选择查看的角色信息</span>&nbsp;&nbsp;&nbsp;&nbsp;
    	<select name="role" id="role" onchange="getRoleUserInfo();" >
    		<option value="1">学生</option>
    		<option value="2">组长</option>
    		<option value="3">班长</option>
    	</select>
    </div>
    
    <div class="rightinfo">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>学号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>用户名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>籍贯</th>
        <th>角色</th>
        <th>上级姓名</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="user">
	        <tr>
	        <td>${user.unumber}</td>
	        <td>${user.uname}</td>
	        <td>${user.usex}</td>
	        <td>${user.uage}</td>
	        <td>${user.uaddress}</td>
	        <td>${user.rname}</td>
	        <td>${user.pname}</td>
	        <td><a href="group?oper=showSign&unumber=${user.unumber}&uname=${user.uname}&page=1" class="tablelink">查看签到签退信息</a></td>
	        </tr> 
        </c:forEach>                
        </tbody>
    </table>
    
   
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
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>

