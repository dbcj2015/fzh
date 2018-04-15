<!DOCTYPE html>
<html>
  <head>
    <title>index.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
  	<b>我是FreeMarker输出方式</b>
    	${name}
    	${session.age}
    	<br/>
    	<table style="width:100%">
    		<thead>
				<th>&nbsp;</th>
				<th>行号</th>
				<th>姓名</th>
				<th>级别</th>
				<th>入会时间</th>
				<th>会费</th>
				<th>其他</th>
    		</thead>
    		<#list member as m>
    			<!-- 设置彩虹线 -->
	    		<#if (m_index % 4 == 0)>
					<#assign color="lightgray"> 
				<#elseif (m_index % 4 == 1)>
					<#assign color="lightblue">
				<#elseif (m_index % 4 == 2)>
					<#assign color="lightyellow">
				<#elseif (m_index % 4 == 3)>
					<#assign color="lightgreen">
				</#if>
    			<!-- 设置斑马线:隔行颜色不同 -->
    			<tr style="background-color:${color}">
    				<td>${m_index+1}.</td> <!-- 获取行号 -->
					<td>${m.name?capitalize}</td>
					<td>${m.level}</td>
					<td>${m.joinTime?string("yyyy-MM-dd")}</td>
						<!-- ?string.currency输出货币形式
							?string("$#,##0.00")自定义货币的输出方式
						 -->
					<td>${m.price?string("$#,##0.00")}</td>
					<td>${m.others}</td>
				</tr>
    		</#list>
    	</table>
  </body>
</html>
