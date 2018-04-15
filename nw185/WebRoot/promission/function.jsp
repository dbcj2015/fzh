<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>功能模块管理</title>
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
  		//这里写验证表单的代码
  		$.extend($.fn.validatebox.defaults.rules, {   
		    val_functionName: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写模块名称的验证规则"  
		    },
		    val_moduleId: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写功能模块的验证规则"  
		    },
		    val_url: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写URL的验证规则"  
		    },
		    val_icon: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写模块图标的验证规则"  
		    }
		    
		}); 
  		//这里是初始化表单的代码
  		function initForm(){
  			$("#frm").form("clear");
  			
  			//初始化功能模块下拉列表框,放开注释修改url/textField/valueField即可
  			$("#moduleId").combobox({
  				url : "${pageContext.request.contextPath}/module/findByProperty" , //这里写功能模块请求地址 
  				textField : "moduleName" , 
  				valueField : "moduleId" 
  			});
  			
  		}
		
		//这里是分页查询的代码
  		$(function(){
  			$("#grid").datagrid({
  				url : "${pageContext.request.contextPath}/function/list",
  				columns : [[
  					{title : "模块名称" , field: "moduleName" ,width:"10%"},
  					{title : "功能名称" , field: "functionName" ,width:"20%"},
  					{title : "URL" , field: "url" ,width:"30%"},
  					{title : "图标" , field: "icon" ,width:"10%"}
  				]],
  				toolbar : "#tb" , 
  				title : "功能模块管理",
  				pagination :true,
  				fit : true,
  				striped : true,
  				singleSelect : true
  			});
  		});
  		
  		$(function(){
  			var dialogHeight = 4 * 50 + 100;
  			//新增按钮的处理
  			$("#btnAdd").click(function(){
  				//利用combobox动态加载servlet返回的数据
  				//利用自定义属性来决定当前表单适用于新增还是用于更新
  				$("#frm").attr("opmode" , "create");
  				initForm();
  				$("#dlg").dialog({ //弹出一个宽200高300的新增员工对话框
  					title : "新增" , 
  					width : 300,
  					height : dialogHeight,
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
  				
  				//利用自定义属性来决定当前表单适用于新增还是用于更新
  				$("#frm").attr("opmode" , "update");
  				initForm();
  				$("#frm").form("load" , selectRec);//自动将selectRec JSON对象中与name同名的属性自动赋值
  				$("#dlg").dialog({ //弹出一个宽200高300的新增员工对话框
  					title : "保存" , 
  					width : 300,
  					height : dialogHeight,
  					modal : true, //设置当前对话框为模态对话框,禁止用户做其他的操作
  					buttons : "#dlgBtns"
  				});
  				
  			});
  			
  			
  			//处理保存按钮
	  		$(function(){
	  			$("#btnSave").click(function(){
	  				var opmode = $("#frm").attr("opmode");
	  				$("#frm").form("submit" , {//form是easyui提供的扩展函数,用于对表单进行处理
	  					url : "${pageContext.request.contextPath}/function/" + opmode ,//form会自动通过ajax的方式向服务器提交数据
	  					onSubmit: function(){    
	  						$("#frm").form("enableValidation")
							return $("#frm").form("validate");   
					    },
	  					success : function(text){ //服务器返回的数据
	  						var json = $.parseJSON(text);					
	  						//这里处理服务器处理成功后的行为
	  						if(json.result){
	  							$("#dlg").dialog("close");
			    	        	$.messager.alert('提示',json.message,'info' , function(){
			    	        		initForm();
			    	        		$("#grid").datagrid("reload");
			    	        	});
			    	        } else {
			    	        	$.messager.alert('错误',json.message,'warning');
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
  							url : "${pageContext.request.contextPath}/function/delete?id=" + selectRec.functionId,
  							type : "get",
  							dataType : "json" , 
  							success : function(json){
  								if(json.result){
				    	        	$.messager.alert('提示',json.message,'info' , function(){
				    	        		$("#grid").datagrid("reload");
				    	        	});
				    	        } else {
				    	        	$.messager.alert('错误',json.message,'warning');
				    	        }
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
   		<form id="frm" method="post">
   			<table style="width:100%">
   				<input type="hidden" name="functionId"/>
   				<tr>
   					<td style="width:70px">功能名称</td>
   					<td>
   						<input id="functionName" name="functionName" required="true" class="easyui-textbox" validType="val_functionName"/>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">隶属模块</td>
   					<td>
   						<select id="moduleId" name="moduleId" required="true" validType="val_moduleId" class="easyui-combobox" editable="false"></select>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">URL</td>
   					<td>
   						<input id="url" name="url" required="true" class="easyui-textbox" validType="val_url"/>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">功能图标</td>
   					<td>
   						<input id="icon" name="icon" required="true" class="easyui-textbox" validType="val_icon"/>
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
