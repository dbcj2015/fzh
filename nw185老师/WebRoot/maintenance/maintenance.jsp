<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>设备维修</title>
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
  				
  			//初始化设备类型下拉列表框,放开注释修改url/textField/valueField即可
  			$("#venderId").combobox({
  				url : "${pageContext.request.contextPath}/vender/findByProperty" , //这里写设备类型请求地址 
  				textField : "venderName" , 
  				valueField : "venderId" 
  			});
  			
  		}
  		
  		
		//这里是分页查询的代码
  		$(function(){
  			$("#grid").datagrid({
  				url : "${pageContext.request.contextPath}/fault/findByProperty?branchId=${loginuser.branch_id}&faultState=9",
  				columns : [[
					{title : "机构" , field: "branchName" ,width:"10%"},
					{title : "设备编号" , field: "sn" ,width:"10%"},
  					{title : "设备类型" , field: "goodstypeName" ,width:"10%"},
  					{title : "设备品牌" , field: "brandName" ,width:"10%"},
  					{title : "设备型号" , field: "productName" ,width:"10%"},
  					{title : "当前用户" , field: "empName" ,width:"10%"},
  					{title : "设备状态" , field: "runStateText" ,width:"10%"},
  					{title : "健康状况" , field: "faultStateText" ,width:"10%"}
  					
  				]],
  				toolbar : "#tb" , 
  				title : "在用设备清单",
  				fit : true,
  				striped : true,
  				singleSelect : true
  			});
  		});
  		
  		$(function(){
  			var dialogHeight = 400;
  			$("#btnAdd").click(function(){
  				var sel = $("#grid").datagrid("getSelected");
  				if(sel == null){
  					$.messager.alert("警告" , "请选择要维修的设备" , "warning");
  					return;
  				}
  				
  				$("#txtProductName").text(sel.goodstype_name + "-" + sel.brand_name + "-" + sel.product_name);
  				initForm();
  				$("#productId").val(sel.product_id);
  				$("#frm").form("load" , sel);
  				$("#faultState").combobox("setValue" , "10");
  				$("#dlg").dialog({ //弹出一个宽200高300的新增员工对话框
  					title : "设备维修登记" , 
  					width : 300,
  					height : dialogHeight,
  					modal : true, //设置当前对话框为模态对话框,禁止用户做其他的操作
  					buttons : "#dlgBtns"
  				});
  			});
  			

  			//处理保存按钮
	  		$(function(){
	  			$("#btnSave").click(function(){
	  				$("#frm").form("submit" , {
	  					url : "${pageContext.request.contextPath}/asset/maintenance" ,
	  					success : function(text){ 
	  						var json = $.parseJSON(text);					
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
   		<a id="btnAdd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">维修登记</a>
   	</div>
   	
   	<div id="dlg" style="padding:10px">
   		<form id="frm" method="post">
   			<table style="width:100%">
				<tr>
   					<td style="height:30px;width:70px">设备型号</td>
   					<td>
   						<input type="hidden" name="faultId" />
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
   					<td style="width:70px">故障现象</td>
   					<td>
   						<input name="faultDescription" class="easyui-textbox" editable="false" editable="true" >
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">维修商</td>
   					<td>
   						<select id="venderId" name="venderId" required="true" class="easyui-combobox" editable="false"></select>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">维修时间</td>
   					<td>
   						<input name="maintenanceTime" class="easyui-datebox" editable="false" required=true>
   					</td>
   				</tr>
   				
   				<tr>
   					<td style="width:70px">维修内容</td>
   					<td>
   						<input name="maintenanceDetail" class="easyui-textbox" data-options="multiline:true" style="height:70px" editable="true"  required=true>
   					</td>
   				</tr>
   				
   				<tr>
   					<td style="width:70px">维修结果</td>
   					<td>
   						<select id="faultState" name="faultState" required="true" class="easyui-combobox" editable="false">
   							<option value=10>维修完毕,恢复正常</option>
   							<option value=11>取消维修,设备报废</option>
   						</select>
   					</td>
   				</tr>
   				
   				<tr>
   					<td style="width:70px">费用</td>
   					<td>
   						<input name="cost" class="easyui-numberbox" editable="true" required=true default="0">
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
