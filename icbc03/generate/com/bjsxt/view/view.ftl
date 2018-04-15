<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>${model.class}的数据管理</title>
	<meta charset="UTF-8">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    


  	<link href="${r"${pageContext.request.contextPath}"}/resources/easyui/themes/insdep/easyui.css" type="text/css" rel="stylesheet">
  	<link href="${r"${pageContext.request.contextPath}"}/resources/easyui/themes/insdep/easyui_animation.css" type="text/css" rel="stylesheet">
  	<link href="${r"${pageContext.request.contextPath}"}/resources/easyui/themes/insdep/easyui_plus.css" type="text/css" rel="stylesheet">
  	<link href="${r"${pageContext.request.contextPath}"}/resources/easyui/themes/insdep/insdep_theme_default.css" type="text/css" rel="stylesheet">
  	<link href="${r"${pageContext.request.contextPath}"}/resources/easyui/themes/insdep/icon.css" type="text/css" rel="stylesheet">


	<script type="text/javascript" src="${r"${pageContext.request.contextPath}"}/resources/easyui/script/jquery.min.js"></script>
  	<script type="text/javascript" src="${r"${pageContext.request.contextPath}"}/resources/easyui/script/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="${r"${pageContext.request.contextPath}"}/resources/easyui/script/easyui-lang-zh_CN.js"></script>
  	<script type="text/javascript" src="${r"${pageContext.request.contextPath}"}/resources/easyui/themes/insdep/jquery.insdep-extend.min.js"></script>
  	
  	
  	
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
		    <#list view.form as p>
		    val_${p.property}: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写${p.title}的验证规则"  
		    }<#if p_has_next>,</#if>
		    </#list>
		    
		}); 
  		//这里是初始化表单的代码
  		function initForm(){
  			$("#frm").form("clear");
  			$("#frm").form("disableValidation");
  		}
		
		//这里是分页查询的代码
  		$(function(){
  			$("#grid").datagrid({
  				url : "${r"${pageContext.request.contextPath}"}${controller.namespace}/list",
  				columns : [[
  					<#list view.datagrid.columns as c>
  					{title : "${c.title}" , field: "${c.field}" <#if c.width??>,width:"${c.width}"</#if>}<#if c_has_next>,</#if>
  					</#list>
  				]],
  				toolbar : "#tb" , 
  				title : "${model.class}的数据列表",
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
  				
  				//利用自定义属性来决定当前表单适用于新增还是用于更新
  				$("#frm").attr("opmode" , "update");
  				$("#frm").form("load" , selectRec);//自动将selectRec JSON对象中与name同名的属性自动赋值
  			});
  			
  			
  			//处理保存按钮
	  		$(function(){
	  			$("#btnSave").click(function(){
	  				var opmode = $("#frm").attr("opmode");
	  				$("#frm").form("submit" , {//form是easyui提供的扩展函数,用于对表单进行处理
	  					url : "${r"${pageContext.request.contextPath}"}${controller.namespace}/" + opmode ,//form会自动通过ajax的方式向服务器提交数据
	  					onSubmit: function(){    
	  						$("#frm").form("enableValidation")
							return $("#frm").form("validate");   
					    },
	  					success : function(text){ //服务器返回的数据
	  						var json = $.parseJSON(text);					
	  						//这里处理服务器处理成功后的行为
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
  							url : "${r"${pageContext.request.contextPath}"}${controller.namespace}/delete?id=" + selectRec.${view.datagrid.keyfield},
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
   		<form id="frm" method="post">
   			<table style="width:100%">
   				<input type="hidden" name="${model.id.name}"/>
   				<#list view.form as p>
   				<tr>
   					<td style="width:70px">${p.title}</td>
   					<td>
   						<#if p.type=="text">
   						<input id="${p.property}" name="${p.property}" required="${p.required?string('true','false')}" class="easyui-textbox" validType="val_${p.property}"/>
   						</#if>
   						<#if p.type=="combobox">
   						<select id="${p.property}" name="${p.property}" required="${p.required?string('true','false')}" validType="val_${p.property}" class="easyui-combobox" editable="false">
   							<option value="-1" selected="selected">请选择</option>
   						</select>
   						</#if>
   						<#if p.type=="date">
   						<input id="${p.property}" name="${p.property}" required="${p.required?string('true','false')}" validType="val_${p.property}" class="easyui-datebox" editable="false"/>
   						</#if>
   						<#if p.type="number">
   						<input id="${p.property}" name="${p.property}" required="${p.required?string('true','false')}" validType="val_${p.property}" class="easyui-numberbox"/>
   						</#if>
   					</td>
   				</tr>
   				</#list>
   			</table>
   		</form>
   	</div>
   	<div id="dlgBtns">
   		<a id="btnSave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
   		<a id="btnCancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
   	</div>
  </body>
</html>
