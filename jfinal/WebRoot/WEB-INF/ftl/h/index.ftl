<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- el相同都是取值的意思, 内置对象为Request, Session ,Application -->
	你好,齐毅<br/>
	${name}<br/>
	${session.pwd}
	<table style="width:100%">
		<thead>
			<th>&nbsp;</th>
			<th>姓名</th>
			<th>级别</th>
			<th>入会时间</th>
			<th>会费</th>
			<th>其他</th>
		</thead>
		<#list ms as member>
			
			<#if (member_index % 4 == 0)>
				<#assign color="lightgray"> 
			<#elseif (member_index % 4 == 1)>
				<#assign color="lightblue">
			<#elseif (member_index % 4 == 2)>
				<#assign color="lightyellow">
			<#elseif (member_index % 4 == 3)>
				<#assign color="lightgreen">
			</#if>
			
			<#if (member.level > 1)>
				<tr style="background-color:${color}">
				  	<!--
					<td>${member.name?substring(0,2)?upper_case}${member.name?substring(2)?lower_case}</td>
					-->
					
					<td>${member_index + 1}.</td>
					<td>${member.name?capitalize}</td>
					
					<td>${member.level}</td>
					<td>${member.joinTime?string("yyyy-MM-dd")}</td>
					<td>${member.price?string("$#,##0.00")}</td>
					<td>${member.others}</td>
				</tr>
			</#if>
		</#list>
		<tr>
		
		</tr>
	</table>
</body>
</html>