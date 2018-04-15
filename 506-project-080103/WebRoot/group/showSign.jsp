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
<script type="text/javascript">
	//验证是否是最有一页
		function checkPage(){
			var page=${page};
			var pageCount=${pageCount};
			if(page<pageCount){
				return true;
				
			}else{
				alert("已经是最后一页");
				return false;
			}
		}
	//验证是否是第一页
		function checkFirstPage(){
		 	var page=${page};
		 	if(page>1){
		 		return true;
		 	}else{
		 		alert("已经是第一页");
		 		return false;	
		 	}
		}
	//当前页码背景色
		function addBgc(){
		//获取元素对象
			var li=document.getElementById('${page}');
		//给li对象添加背景色
			li.style.backgroundColor="gray";
		}
</script>
</head>
<body onload="addBgc();">
	<div class="place">
    <span></span>
    <ul class="placeul">
    <li><a href="#"></a></li>
    <li><a href="#"></a></li>
    <li><a href="#"></a></li>
    </ul>
    </div>   
    <div class="rightinfo">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>学号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>姓名</th>
        <th>签到时间</th>
        <th>签到状态</th>
        <th>签退时间</th>
        <th>签退状态</th>
        <th>日期</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="s">
	        <tr>
		        <td>${s.unumber}</td>
		        <td>${requestScope.uname}</td>
		        <td>${s.sintime}</td>
		        <td>${s.sinstatus==1?"迟到":"正常"}</td>
		        <td>${s.souttime}</td>
		        <td>${s.soutstatus==1?"早退":"正常"}</td>
		        <td>${s.sdate}</td>
	        </tr> 
        </c:forEach>                
        </tbody>
    </table>
    <div class="pagin">
    	<div class="message">共<i class="blue">${count}</i>条记录，当前显示第&nbsp;<i class="blue">${page}&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="group?oper=showSign&page=${page-1}&unumber=${list[0].unumber}&uname=${requestScope.uname}" onclick="return checkFirstPage()"><span class="pagepre"></span></a></li>
        <c:forEach begin="1" end="${pageCount}" var="i">
        	 <li class="paginItem" id="${i}"><a href="group?oper=showSign&page=${i}&unumber=${list[0].unumber}&uname=${requestScope.uname}">${i}</a></li>
        </c:forEach>
       
        <li class="paginItem"><a href="group?oper=showSign&page=${page+1}&unumber=${list[0].unumber}&uname=${requestScope.uname}" onclick="return checkPage()"><span class="pagenxt"></span></a></li>
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

