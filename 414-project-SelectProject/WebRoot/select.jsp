<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
	<!-- 先导入jquery包 -->
		<script type="text/javascript" src="jquery/jquery.js"></script>
		
		<script type="text/javascript">
			
			function getProvince(){
				getData("0","province",getCity);
				/*
				var dt={pid:"0"};
				$.get("login",dt,function(date){
					//alert(date);
					eval("list="+date);
					for(var i=0;i<list.length;i++){
						var sel=document.getElementById("province");
						sel.innerHTML=sel.innerHTML+"<option value='"+list[i].areaid+"'>"+list[i].areaname+"</ option>";
					}
					getCity();
				});
				*/
			}
			
			function getCity(){
				getData("province","city",getTown);
				/*
				var pid=$("#province").val();
				var dt={pid:pid};
				var sel=document.getElementById("city");
				sel.innerHTML="";
				//使用JQuery中ajax函数
				$.get("login",dt,function(date){
					//alert(date);
					eval("list="+date);
					for(var i=0;i<list.length;i++){
						sel=document.getElementById("city");
						sel.innerHTML=sel.innerHTML+"<option value='"+list[i].areaid+"'>"+list[i].areaname+"</ option>";
					}
					getTown();
				});
				*/
			}
			
			function getTown(){
				getData("city","town");
				<%--city的value值是town的parentid
					select中的value值是用于提交使用的
				--%>
				/*var pid=$("#city").val();
				var dt={pid:pid};
				var sel=document.getElementById("town");
				//每次选择会使下拉框内容出现追加的现象，在选择之前将上次下拉框内容清楚
				sel.innerHTML="";
				$.get("login",dt,function(date){
					//alert(date);
					eval("list="+date);
					for(var i=0;i<list.length;i++){
						sel=document.getElementById("town");
						sel.innerHTML=sel.innerHTML+"<option value='"+list[i].areaid+"'>"+list[i].areaname+"</ option>";
					}
				});*/
			}
			
		/*封装三级联动*/
			function getData(pid,cid,getChildInfo){
				var pid=(pid=="0"?"0":$("#"+pid).val());
				var dt={pid:pid};
				$.get("login",dt,function(date){
					//alert(date);
					var sel=$("#"+cid);
					sel.empty();
					eval("list="+date);
					for(var i=0;i<list.length;i++){
						sel.innerHTML=sel.innerHTML+"<option value='"+list[i].areaid+"'>"+list[i].areaname+"</ option>";
						//sel.append("<option value="+list[i].areaid+">"+list[i].areaname+"</ option>");
					}
					if(getChildInfo){
						getChildInfo();
					}
				});
			}
			
		</script>
	</head>
	<body onload="getProvince()">
		<div id="showdiv">
			<!-- onchange()事件就是当下拉框选值时触发的事件 -->
			<select name="" id="province" onchange="getCity()"></select>
			<select name="" id="city" onchange="getTown()"></select>
			<select name="" id="town" ></select>
		</div>
	</body>
</html>
