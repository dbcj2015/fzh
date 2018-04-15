<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Contract的数据管理</title>
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
  	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/jquery.combobox.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/themes/insdep/jquery.insdep-extend.min.js"></script>
  	
  	
  	
  	<style type="text/css">
  		.easyui-combobox,.easyui-validatebox,.easyui-textbox,.easyui-datebox ,.easyui-numberbox , .easyui-filebox{
  			width:170px
  		}
 
  		
  	</style>
  	<script type="text/javascript">
  		//这里写验证表单的代码
  		$.extend($.fn.validatebox.defaults.rules, {   
		    val_contractName: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写合同编号的验证规则"  
		    },
		    val_title: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写合同名称的验证规则"  
		    },
		    val_projectId: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写采购项目的验证规则"  
		    },
		    val_contractDate: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写采购日期的验证规则"  
		    },
		    val_venderId: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写供应商的验证规则"  
		    },
		    val_contractFile: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写合同副本的验证规则"  
		    }
		    
		}); 
  		//这里是初始化表单的代码
  		function initForm(){
  			$("#frm").form("clear");
  			$("#frm").form("disableValidation");
  			$("#projectId").combobox({
  				url : "${pageContext.request.contextPath}/project/findByProperty" , 
  				textField : "fullname" , 
  				valueField : "project_id"
  			});
  		}
		
		//这里是分页查询的代码
  		$(function(){
  			$("#grid").datagrid({
  				url : "${pageContext.request.contextPath}/contract/list",
  				columns : [[
  					{title : "合同日期" , field: "contract_date" ,width:"10%"},
  					{title : "合同编号" , field: "contract_code" ,width:"10%"},
  					{title : "供应商" , field: "vender_name" ,width:"10%"},
  					{title : "采购项目" , field: "project_name" ,width:"10%"},
  					{title : "标题" , field: "title" ,width:"10%"},
  					{title : "当前状态" , field: "state" ,width:"10%"},
  					{title : "合同副本" , field: "doc_file" ,width:"10%"}
  				]],
  				toolbar : "#tb" , 
  				title : "Contract的数据列表",
  				pagination :true,
  				fit : true,
  				striped : true,
  				singleSelect : true
  			});
  		});
  		
  		$(function(){
  			//新增按钮的处理
  			$("#btnAdd").click(function(){
  				//利用combobox动态加载servlet返回的数据
  				//利用自定义属性来决定当前表单适用于新增还是用于更新
  				$("#frm").attr("opmode" , "create");
  				initForm();
  				$("#dlg").dialog({ //弹出一个宽200高300的新增员工对话框
  					title : "新增" , 
  					width : 300,
  					height : 300,
  					modal : true, //设置当前对话框为模态对话框,禁止用户做其他的操作
  					buttons : "#dlgBtns"
  				});
  			});
  			
  			
  			
  			
  			//修改按钮的处理
  			$("#btnEdit").click(function(){
  				var selectRec = $("#grid").datagrid("getSelected");
  				if(selectRec == null){
  					$.messager.alert("警告" , "请选择要修改的记录" , "warning");
  					return;
  				}
  				initForm();
  				//利用自定义属性来决定当前表单适用于新增还是用于更新
  				$("#frm").attr("opmode" , "update");
  				$("#frm").form("load" , selectRec);//自动将selectRec JSON对象中与name同名的属性自动赋值
  			});
  			
  			
  			//处理保存按钮
	  		$(function(){
	  			$("#btnSave").click(function(){
	  				var opmode = $("#frm").attr("opmode");
	  				
	  				//AJAX是不支持二进制文件上传的.
	  				/*
	  				$("#frm").form("submit" , {//form是easyui提供的扩展函数,用于对表单进行处理
	  					url : "${pageContext.request.contextPath}/contract/" + opmode ,//form会自动通过ajax的方式向服务器提交数据
	  					onSubmit: function(){    
	  						$("#frm").form("enableValidation")
							return $("#frm").form("validate");   
					    },
	  					success : function(text){ //服务器返回的数据
	  						var json = $.parseJSON(text);					
	  						//这里处理服务器处理成功后的行为
	  					}
	  				});*/
	  				
	  				$("#frm").submit();//利用原生的提交来提交表单
	  			});
	  			
	  			$("#btnCancel").click(function(){
	  				initForm();
	  				$("#dlg").dialog("close");
	  			})
	  		});
  		});
  		
  		
  		
  		//删除功能
  		$(function(){
  			$("#btnDelete").click(function(){
  				var selectRec = $("#grid").datagrid("getSelected");	
  				if(selectRec==null){
  					$.messager.alert("警告" , "请选择要删除的记录" , "warning");
  					return ;
  				}

  				$.messager.confirm("询问" , "确定要删除选中的记录吗?" , function(r){
  					if(r== true){
  						$.ajax({
  							url : "${pageContext.request.contextPath}/contract/delete?id=" + selectRec.contract_id,
  							type : "get",
  							dataType : "json" , 
  							success : function(json){
  								//这里处理删除成功后的行为
  							}
  						})
  					}
  				});
  			});
  		});
  	</script>
  </head>
  
  <body>
   	<table id="grid"></table>
   	<div id="tb">
   		<a id="btnAdd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
   		<a id="btnEdit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
   		<a id="btnDelete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
   	</div>
   	
   	<div id="dlg" style="padding:10px">
   		<form id="frm" action="${pageContext.request.contextPath}/contract/create" method="post" enctype="multipart/form-data">
   			<table style="width:100%">
   				<input type="hidden" name="contractId"/>
   				<tr>
   					<td style="width:70px">合同编号</td>
   					<td>
   						<input id="contractCode" name="contractCode" required="true" class="easyui-textbox" validType="val_contractName"/>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">合同名称</td>
   					<td>
   						<input id="title" name="title" required="true" class="easyui-textbox" validType="val_title"/>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">采购项目</td>
   					<td>
   						<select id="projectId" name="projectId" required="true" validType="val_projectId" class="easyui-combobox" editable="false">
   						</select>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">采购日期</td>
   					<td>
   						<input id="contractDate" name="contractDate" required="true" validType="val_contractDate" class="easyui-datebox" editable="false"/>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">供应商</td>
   					<td>
   						<select id="venderId" name="venderId" required="true" validType="val_venderId" class="easyui-combobox" editable="false">
   							<option value="1">惠普(中国)科技有限公司</option>
   						</select>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">合同副本</td>
   					<td>
   						<input id="contractFile" name="contractFile" required="true" class="easyui-filebox" validType="val_contractFile" buttonText="选择"/>
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
