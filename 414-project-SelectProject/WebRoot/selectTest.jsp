<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

	<script type="text/javascript" src="jquery/jquery.js"></script>

<html>
  <head>
  		<script type="text/javascript">
  			function test(){
  				var inp=$("#inp");
  	  			alert(inp.attr("value"));
  	  			alert(inp.val());
  			}
  			
  		</script>
  </head>
  
  <body>
   	<input type="text" name="uname" id="inp" value="张单"/>
   	<br>
   	<input type="button"  value="提交" onclick="test()"/>
  </body> 
</html>
