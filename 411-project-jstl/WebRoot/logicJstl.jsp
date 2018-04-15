<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl逻辑标签以及循环标签中:
	逻辑标签中的逻辑表达式,以及循环标签中属性标签都是结合EL表达式使用的，所以所有的数据都是作用域中的
 -->
<%--
	逻辑标签：
			单分支逻辑判断
				<c:if test="${逻辑表达式}">
					执行体(html代码)
				</c:if>
				逻辑表达式中的变量一定是存在于作用域中。
			多分支逻辑判断
				<c:choose>
					<c:when test="${逻辑表达式}">执行体(html代码)</c:when>
					<c:when test="${逻辑表达式}">执行体(html代码)</c:when>
					……
					<c:otherwise>执行体(html代码)</c:otherwise>	
				</c:choose>
				逻辑表达式中的变量一定是存在于作用域中。
		循环标签：
			<c:foreach 设置循环属性>
				循环体
			</c:foreach>
			常用的属性：
				begin:循环开始位置。
				end:循环结束位置。
				step:循环步长
				varStatus:获取循环状态,变量名
					注意：声明的变量是默认存储到作用域中
					${变量名.index}--当次循环的角标
					${变量名.count}--当次循环的次数
					${变量名.first}--是否是第一次循环
					${变量名.last}---是否是最后一次循环
				items:要循环对象
				var:记录每次循环的结果
					注意：获取结果需要使用EL表达式来进行获取
--%>
<c:set var="score" value="89"></c:set>
	<c:if test="${score>80}">
		<b>这次考试进步了80分，真棒</b>
	</c:if>

<!-- 多分支逻辑判断 -->
<hr />
	<c:choose>
		<c:when test="${score>90}">
			<b>优秀</b>
		</c:when>
		<c:when test="${score>80&&score<=90}">
			<b>一般</b>
		</c:when>
		<c:when test="${score>70&&score<=80}">
			<b>良好</b>
		</c:when>
		<c:otherwise>
			<b>男女混合双打</b>
		</c:otherwise>
	</c:choose>

<%--
	循环标签：
			<c:foreach 设置循环属性>
				循环体
			</c:foreach>
			常用的属性：
				begin:循环开始位置。
				end:循环结束位置。
				step:循环步长
				varStatus:获取循环状态,变量名--是写在作用域中
					注意：声明的变量是默认存储到作用域中
					${变量名.index}--当次循环的角标
					${变量名.count}--当次循环的次数
					${变量名.first}--是否是第一次循环
					${变量名.last}---是否是最后一次循环
				items:要循环对象--是作用域中的对象
				var:记录每次循环的结果--变量默认写在作用域中
					注意：获取结果需要使用EL表达式来进行获取
			
 --%>

<hr />
<c:forEach begin="1" end="5" step="2">
	1111<br />
</c:forEach>

<hr />
<c:forEach begin="1" end="5" step="2" varStatus="q">
	1111--${q.index}--${q.count}--${q.first}--${q.last }<br />
</c:forEach>

<hr />
<c:forEach begin="1" end="9" step="2" varStatus="q">
	<c:if test="${q.count==5}">
		1111--${q.index}--${q.count}--${q.first}--${q.last }<br />
	</c:if>
</c:forEach>

<hr />
<!-- 遍历list对象 -->
	<%
		ArrayList<String> list=new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		request.setAttribute("list",list);
	%>
<c:forEach items="${list }">
	list遍历<br />
</c:forEach>

<hr />
<c:forEach items="${list }" varStatus="p">
	<c:if test="${p.index==3 }">
		list遍历第三次<br />
	</c:if>
</c:forEach>

<hr />
<c:forEach items="${list }" varStatus="p" var="s">
	<c:if test="${p.index==3 }">
		list遍历第三次--${s}<br />
	</c:if>
</c:forEach>












