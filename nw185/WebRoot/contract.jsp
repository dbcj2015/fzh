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
  	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/themes/insdep/jquery.insdep-extend.min.js"></script>  	
  	<style type="text/css">
  		.easyui-combobox,.easyui-validatebox,.easyui-textbox,.easyui-datebox ,.easyui-numberbox , .easyui-filebox{
  			width:170px
  		}
  	</style>
  	<script type="text/javascript">
  		//这里写验证表单的代码
	  		//合同编号在输入后立即通过AJAX进行校验唯一性，而不是现有的提交后再校验
	  		//注意:之前的校验是通过正则表达式进行校验的，在输入的同时进行校验,但是合同的唯一性必须在后台数据库查询之后再进行唯一性校验
	  		//这种情况下,可以通过AJax在输入后直接进行校验，不需要之前的提交后在后端进行校验
  		$.extend($.fn.validatebox.defaults.rules, {
		    val_contractCode: {
		        validator: function(value,param){ //该函数返回的是布尔值类型，只有返回值为false的时候才会执行message语句	
		        	console.info(value);
		        	
		        if(value.length!=14){
	        		return false;//这个return跳出的是validator函数，不是 val_contractCode函数
	        	}else{
	        		var flag=false;
	        		$.ajax({
	        			url:"${pageContext.request.contextPath}/contract/findByContractCode",
	        			data:{"contractCode":value},
	        			type:"post",
	        			async : false, //true代表异步,false代表同步
	        			dataType:"json",
	        			success:function(json){
	        				console.info("AJAX返回了数据");
	        				if(json.length !=0){
	        					//return true;//这个作用域是success函数，不是validator，所以validator返回值类型还是false
	        					flag=true;
	        				}else{
	        					flag=false;
	        				}
	        			}
	        		});
	        		//return true;
	        		return flag;
	        		console.info("我是验证代码");
	        	}
	        },   
		        message: "合同编号书写不规范" //该句只有 validator函数返回值是false的时候才会执行
		    },
		    /* if(value.length!=14){
    		return false;//这个return跳出的是validator函数，不是 val_contractCode函数
    	}else{
    		$.ajax({//默认情况下ajax是异步的,所谓异步就是ajax将数据发送给服务器后，不需要等待success返回结果直接往下执行,所以console.info("我是验证代码");
    		//永远出现在console.info("AJAX返回了数据");之前，此时返回值如果没有返回值，默认情况下返回值类型是false，所以message信息始终可以执行到
    			url:"${pageContext.request.contextPath}/contract/findByContractCode",
    			data:{"contractCode":value},
    			type:"post",
    			dataType:"json",
    			success:function(json){
    				
    				console.info("AJAX返回了数据");
    			}
    		});
    		//return true;
    		console.info("我是验证代码");
    	}
    },    */
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
  			//$("#frm").form("disableValidation");
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
  				$("#frm").attr("opmode","create");
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
  				//通过点击获取数据，该数据包括数据列表填充时所有的数据信息，不仅仅是列表中展示的数据
  				var selectRec = $("#grid").datagrid("getSelected");
  				console.info(selectRec);
  				if(selectRec == null){
  					$.messager.alert("警告" , "请选择要修改的记录" , "warning");
  					return;
  				}
  				initForm();
  				//利用自定义属性来决定当前表单适用于新增还是用于更新
  				$("#frm").attr("opmode" , "update");
  				$("#frm").form("load" , selectRec);//自动将selectRec JSON对象中与name同名的属性自动赋值
  				$("#dlg").dialog({
  					title:"更改数据",
  					width:"300px",
  					height:"300px",
  					modal:true,
  					buttons:"#dlgBtns"
  				});
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
			  				
	  				var url=$("#frm").attr("action");
	  				$("#frm").attr("action",url+opmode);
	  				
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
  								if(json.result==true){
  									$.messager.alert("提示",json.message,"info",function(){
  										$("#grid").datagrid("reload");
  									});
  								}else{
  									$.messager.alert('错误',json.message,'warning');
  								}
  							}
  						});
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
   		<form id="frm" action="${pageContext.request.contextPath}/contract/" method="post" enctype="multipart/form-data">
   			<table style="width:100%">
   				<!-- <input type="hidden" name="contract_id"/> -->
   				<tr>
   					<td style="width:70px">合同编号</td>
   					<td>
   						<input id="contractCode" name="contractCode" required="true"  validType="val_contractCode" class="easyui-textbox"/>
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
