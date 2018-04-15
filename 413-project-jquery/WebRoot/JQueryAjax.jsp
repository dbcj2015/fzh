<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<!-- 先导入jquery包 -->
		<script type="text/javascript" src="jquery/jquery.js"></script>
		
		<!--以下是JQueryAjax中get方法  -->
			<!-- 
				<script type="text/javascript">
				function testJQueryAjax(){
					$.get("jquery",{name:"张三"},function(date){
						alert(date);
					});
				}
			</script>
			 -->
		<!--以下是JQueryAjax中post方法  -->
		<!-- 
			<script type="text/javascript">
				function testJQueryAjax(){
					$.post("jquery",{name:"张三"},function(date){
						alert(date);
					});
				}
			</script>
		 -->
		 <!--以下是JQueryAjax中全能方法:option  -->
			<script type="text/javascript">
				function testJQueryAjax(){
					$.ajax({
						type:"get",
						url:"jquery",
						date:"name=张三",
						success:function(date){
							alert(date);
						}
					});
				}
			</script>
	</head>
	<body>
		<input type="button" value="测试JqueryAjax" onclick="testJQueryAjax()"/>
	</body>
</html>
