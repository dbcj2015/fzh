<%@ page language="java" pageEncoding="utf-8"%>
<h3>EL表达式学习---常规java方式获取作用域中的数据</h3>


<h3>EL表达式学习---使用EL表达式获取作用域中的数据</h3>
<ol>
	<li>${param.uname}</li>
	<li>${str}</li>
	<li>${user.addr.town}</li>
	<li>${list[1]}</li>
	<li>${list[2].addr.town}</li>
	<li>${hp.a1}</li>
	<li>${hp.u.addr.town}</li>
</ol>
<!--
	EL表达式学习：
		作用：EL表达式是用来获取作用域中的数据。
		使用：
			获取用户请求数据
				${param.键名}
			获取作用域数据：
				${键名}
			作用域数据查找顺序
				pageContext---request--session---application
				从小到大依次进行查找，找到了就不找了。
			获取指定作用域中的数据
				${作用域名Scope.键名}
				${pageScope.键名}
			el表达式的逻辑运算
				在EL表达式中可以直接进行逻辑判断
				在EL表达式中可以进行算术运算
					注意：+符号仅表示算术运算，不代表字符连接符。如果运算的两边
						存在字符数据，则会将字符数据转换为数字数据再进行运算。		
		注意：
			1、EL表达式只能用来获取作用域中的数据，不能用来获取普通数据
			2、EL表达式如果没有在作用域中查找到数据，则什么都不显示
			
  -->
  <%
    String count="100";
    pageContext.setAttribute("cnt",count);
%>
count:{pageScope.cnt} 


