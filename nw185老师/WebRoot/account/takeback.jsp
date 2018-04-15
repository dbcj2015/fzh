<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>设备回收</title>
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
  		 
  		//这里是初始化表单的代码
  		function initForm(){
  			$("#frm").form("clear");
  			
  			
  		}
  		
  		$(function(){
  			$("#cmbUserId").combobox({
  				url : "${pageContext.request.contextPath}/emp/findByProperty?branchId=${loginuser.branch_id}" ,
  				textField : "name" ,
  				valueField : "empId",
  				mode : "remote" //远程加载
  			});
  			
  		})
  		
		//这里是分页查询的代码
  		$(function(){
  			$("#grid").datagrid({
  				url : "${pageContext.request.contextPath}/asset/findByProperty?branchId=${loginuser.branch_id}&state=5&orderby=t.sn%20desc",
  				columns : [[
					{title : "机构" , field: "branch_name" ,width:"10%"},
					{title : "设备编号" , field: "sn" ,width:"10%"},
  					{title : "设备类型" , field: "goodstypeName" ,width:"10%"},
  					{title : "设备品牌" , field: "brandName" ,width:"10%"},
  					{title : "设备型号" , field: "productName" ,width:"10%"},
  					{title : "当前用户" , field: "empName" ,width:"10%"}
  					
  				]],
  				toolbar : "#tb" , 
  				title : "在用设备清单",
  				fit : true,
  				striped : true,
  				singleSelect : true
  			});
  		});
  		
  		$(function(){
  			var dialogHeight = 300;
  			$("#btnAdd").click(function(){
  				var sel = $("#grid").datagrid("getSelected");
  				if(sel == null){
  					$.messager.alert("警告" , "请选择要回收的设备" , "warning");
  					return;
  				}
  				
  				$("#txtProductName").text(sel.goodstype_name + "-" + sel.brand_name + "-" + sel.product_name);
  				//利用combobox动态加载servlet返回的数据
  				//利用自定义属性来决定当前表单适用于新增还是用于更新
  				$("#frm").attr("opmode" , "create");
  				initForm();
  				$("#productId").val(sel.product_id);
  				$("#frm").form("load" , sel);
  				$("#dlg").dialog({ //弹出一个宽200高300的新增员工对话框
  					title : "设备回收登记" , 
  					width : 300,
  					height : dialogHeight,
  					modal : true, //设置当前对话框为模态对话框,禁止用户做其他的操作
  					buttons : "#dlgBtns"
  				});
  			});
  			
  			
  			
  			
  			
  			
  			//处理保存按钮
	  		$(function(){
	  			$("#btnSave").click(function(){
	  				$("#frm").form("submit" , {//form是easyui提供的扩展函数,用于对表单进行处理
	  					url : "${pageContext.request.contextPath}/asset/takeback" ,//form会自动通过ajax的方式向服务器提交数据
	  					success : function(text){ //服务器返回的数据
	  						var json = $.parseJSON(text);					
	  						//这里处理服务器处理成功后的行为
	  						if(json.result){
	  							$("#dlg").dialog("close");
			    	        	$.messager.alert("提示",json.message,'info' , function(){
			    	        		initForm();
			    	        		$("#grid").datagrid("reload");
			    	        	});
			    	        } else {
			    	        	$.messager.alert("错误",json.message,"warning");
			    	        }
	  					}
	  				});
	  			});
	  			
	  			$("#btnCancel").click(function(){
	  				initForm();
	  				$("#dlg").dialog("close");
	  			})
	  		});
  		});
  		
  		
  		
  	</script>
  </head>
  
  <body>
   	<table id="grid"></table>
   	<div id="tb">
   		<a id="btnAdd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">回收登记</a>
   	</div>
   	
   	<div id="dlg" style="padding:10px">
   		<form id="frm" method="post">
   			<table style="width:100%">
				<tr>
   					<td style="height:30px;width:70px">设备型号</td>
   					<td>
   						<input type="hidden" name="assetId" />
   						<span id="txtProductName"></span>
   					</td>
   				</tr>
   				<tr>
   					<td style="height:30px;width:70px">SN</td>
   					<td>
   						<input name="sn" class="easyui-textbox" editable="false">
   					</td>
   				</tr>
   				
   				<tr>
   					<td style="height:30px;width:70px">当前用户</td>
   					<td>
   						<input name="empName" class="easyui-textbox" editable="false" >
   						<input type="hidden" name="empId"/>
   					</td>
   				</tr>
   				
   				<tr>
   					<td style="width:70px">回收时间</td>
   					<td>
   						<input name="takebackTime" class="easyui-datebox" editable="false" required=true>
   					</td>
   				</tr>
   			</table>
   		</form>
   	</div>
   	<div id="dlgBtns">
   		<a id="btnSave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
   		<a id="btnCancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
   	</div>
  </body>
</html>
