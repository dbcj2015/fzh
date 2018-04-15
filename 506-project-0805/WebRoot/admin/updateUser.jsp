<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <!-- 声明css进行页面的修饰 -->
    <style type="text/css">
    	select{
    		width:300px;
    		height: 30px;
    	}
    	input[type=text]{
    		width:300px;
    		height:30px;
    	}
    	tr{
    		height: 50px;
    	}
    </style>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
    	
    	//创建函数获取角色信息
    		function getRoleInfo(rname){
    			//创建ajax获取角色信息
    			$.get("admin",{oper:"roleInfo"},function(data){
    				//使用eval将数据转换为可执行的js代码
    				eval("var rs="+data);
    				//获取下拉框对象
    				var sel=$("#role");
    				//清空原有数据
    				sel.empty();
    				//遍历将数据填充到下拉框中
    				for(var i=0;i<rs.length;i++){
    					if(rs[i].rid!=4){
    						if(rs[i].rname==rname){
    							sel.append("<option value="+rs[i].rid+" selected='selected'>"+rs[i].rname+"</option>");
    						}else{
    							sel.append("<option value="+rs[i].rid+">"+rs[i].rname+"</option>");
    						}
    						
    					}
    				}
    				getLeaderInfo();
    			})
    		}
    	//获取上级信息
    	function getLeaderInfo(){
    		//获取选择的角色id
    		var rid=$("#role").val();
    		//创建请求数据
    		var pid=Number(rid=="3"?"2":rid)+1;
    		var dt={
    			pid:pid,
    			oper:"leaderInfo"
    		}
    		//发送请求
    		$.get("admin",dt,function(data){
    			//使用eval将数据转换为可执行的js代码
    			eval("var ls="+data);
    			//获取下拉框对象
    			var sel=$("#leader");
    			//请空下拉框
    			  sel.empty();
    			//遍历将数据填充到下拉框
    			for(var i=0;i<ls.length;i++){
    				sel.append("<option value="+ls[i].unumber+">"+ls[i].rname+"---"+ls[i].uname+"</option>")
    			}
    		})
    	}
    </script>
  </head>
  
  <body onload="getRoleInfo('${param.rname}')">
    	<div id="showdiv">
    	<form action="admin" method="get">
    	<input type="hidden" name="oper" value="updateUser" />
    		<table>
    			<tr>
    				<td>学号：</td>
    				<td>
    					<input type="text" name="unumber" value="${param.unumber}" readonly="readonly"/>
    				</td>
    			</tr>
    			<tr>
    				<td>用户名：</td>
    				<td>
    					<input type="text" value="${param.uname}"  disabled="disabled"/>
    				</td>
    			</tr>
    			<tr>
    				<td>角色:</td>
    				<td>
    					<select name="rid" id="role" onchange="getLeaderInfo()"></select>
    				</td>
    			</tr>
    			<tr>
    				<td>上级:</td>
    				<td>
    					<select name="pnumber" id="leader">
    						<option value=""></option>
    						<option value=""></option>
    						<option value=""></option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center">
    					<input type="submit" value="确认修改"/>
    				</td>
    			</tr>
    		</table>
    		</form>
    	</div>
  </body>
</html>
