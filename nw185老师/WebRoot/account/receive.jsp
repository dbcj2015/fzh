<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>设备接收</title>
	<meta charset="UTF-8">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    


  	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/easyui.css" type="text/css" rel="stylesheet">
  	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/easyui_animation.css" type="text/css" rel="stylesheet">
  	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/easyui_plus.css" type="text/css" rel="stylesheet">
  	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/insdep_theme_default.css" type="text/css" rel="stylesheet">
  	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/icon.css" type="text/css" rel="stylesheet">


	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/jquery.min.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/easyui-lang-zh_CN.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/themes/insdep/jquery.insdep-extend.min.js"></script>
  	
  	
  	
  	<style type="text/css">
  		.easyui-validatebox,.easyui-textbox,.easyui-datebox ,.easyui-numberbox{
  			width:170px
  		}
  		.easyui-combobox{
  			width:170px
  		}
  		
  	</style>
  	<script type="text/javascript">
  	$(function(){
			$("#grdDist").datagrid({
				url : "${pageContext.request.contextPath}/distribution/findByProperty?toBranchId=${loginuser.branch_id}&state=3",
				columns : [[
					{title : "序号" , field: "seq" ,width:"10%" , formatter:function(v,r,i){return i+1;}},
					{title : "划拨时间" , field: "distTime" ,width:"60%"}
				]],
				toolbar : "#tb" , 
				title : "省行设备划拨单",
				fit : true,
				border:false,
				striped : true,
				singleSelect : true , 
				onClickRow : function(i,row){
					var distId = row.distId;
	  	  			$("#grid").datagrid({
	  	  				url : "${pageContext.request.contextPath}/distribution/groupDetailByDistId?distId=" + distId,
	  	  				columns : [[
	  	  					{title : "设备类型" , field: "goodstype_name" ,width:"20%"},
	  	  					{title : "设备品牌" , field: "brand_name" ,width:"20%"},
	  	  					{title : "设备型号" , field: "product_name" ,width:"20%"},
	  	  					{title : "划拨数量" , field: "num" ,width:"10%"}
	  	  				]],
	  	  				title : "省行设备划拨单明细",
	  	  				fit : true,
	  	  				border:false,
	  	  				striped : true,
	  	  				singleSelect : true
	  	  			});
				}
			});
		});
		
		//这里是分页查询的代码
  		$(function(){
  			$("#btnReceive").click(function(){
  				var sel = $("#grdDist").datagrid("getSelected");
  	  			if(sel == null){
  	  				$.messager.alert("警告" , "请选择要接收的设备" , "warning");
  	  				return;
  	  			}
  	  			
  	  			$.ajax({
					url : "${pageContext.request.contextPath}/asset/receive" ,
					data : {"distId" : sel.distId},
					type : "post" ,
					dataType : "json" , 
					success : function(json){
						if(json.result){
	    	        	$.messager.alert('提示',json.message,'info' , function(){
	    	        		$("#grdDist").datagrid("reload");
	    	        		$("#grid").datagrid("loadData", { total: 0, rows: [] });
	    	        	});
	    	        } else {
	    	        	$.messager.alert('错误',json.message,'warning');
	    	        }
					}
					
				});
  	  			
  			});
  		});
  	</script>
  </head>
  
  <body class="easyui-layout">
  	<div region="north" style="height:250px" >
  		<table id="grdDist"></table>
  		<div id="tb">
	   		<a id="btnReceive" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">确认接收</a>
	   	</div>
  	</div>
  	<div region="center" >
  		<table id="grid"></table>
	   	
  	</div>
   	
  </body>
</html>
