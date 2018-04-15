<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>合同明细列表</title>
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
		    val_productId: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写设备型号的验证规则"  
		    },
		    val_num: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写采购数量的验证规则"  
		    },
		    val_price: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写单价的验证规则"  
		    },
		    val_guaranteeTerm: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写保修期(月)的验证规则"  
		    },
		    val_checkFrequency: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写巡检阀值的验证规则"  
		    }
		    
		}); 
  		//这里是初始化表单的代码
  		function initForm(){
  			$("#frm").form("clear");
  			$("#frm").form("disableValidation");
  		}
		
		//这里是分页查询的代码
  		$(function(){
  			$("#grid").datagrid({
  				url : "${pageContext.request.contextPath}/contractDetail/list",
  				columns : [[
					{title : "" , field: "" ,checkbox:"true" ,width:"10%"},
					{title : "设备类型" , field: "goodstypeName" ,width:"10%"},
					{title : "设备品牌" , field: "brandName" ,width:"10%"},
  					{title : "设备型号" , field: "productId" ,width:"10%"},
  					{title : "采购数量" , field: "num" ,width:"10%"},
  					{title : "单价" , field: "price" ,width:"10%"},
  					{title : "保修期(月)" , field: "guaranteeTerm" ,width:"10%"},
  					{title : "巡检阀值" , field: "checkFrequency" ,width:"10%"},
  					//formatter函数主要是限制单元格的值
  					{title : "设备状态" , field: "state" ,width:"10%" ,formatter:function(value,rows){
  						if(value==1){
  							return "配送中";
  						}else if(value==2){
  							return "设备在库";
  						}else{
  							return "未知状态";
  						}
  					}}
  				]],
  				toolbar : "#tb" , 
  				title : "ContractDetail的数据列表",
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
	  					url : "${pageContext.request.contextPath}/contractDetail/" + opmode ,//form会自动通过ajax的方式向服务器提交数据
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
  							url : "${pageContext.request.contextPath}/contractDetail/delete?id=" + selectRec.cdId,
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
  		$(function(){
  			$("#contract").datagrid({
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
  				singleSelect : true,
  				border:false,
  				onClickRow:function(index,data){
  					console.info(data);
  				}
  			});
  		});
  	</script>
  </head>
  
  <body class="easyui-layout">
  	<div region="north"  style="height:300px" border="false"><table id="contract"></table></div>
  	<div region="center" border="false"  style="height:100px">
  	<table id="grid">
   	<div id="tb">
   		<a id="btnAdd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
   		<a id="btnEdit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
   		<a id="btnDelete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
   		<a id="btnSave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">设备入库</a>
   	</div>
   	
   	<div id="dlg" style="padding:10px">
   		<form id="frm" method="post">
   			<table style="width:100%">
   				<input type="hidden" name="cdId"/>
   				<tr>
   					<td style="width:70px">设备型号</td>
   					<td>
   						<select id="productId" name="productId" required="true" validType="val_productId" class="easyui-combobox" editable="false">
   							<option value="-1" selected="selected">请选择</option>
   						</select>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">采购数量</td>
   					<td>
   						<input id="num" name="num" required="true" validType="val_num" class="easyui-numberbox"/>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">单价</td>
   					<td>
   						<input id="price" name="price" required="true" validType="val_price" class="easyui-numberbox"/>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">保修期(月)</td>
   					<td>
   						<input id="guaranteeTerm" name="guaranteeTerm" required="true" validType="val_guaranteeTerm" class="easyui-numberbox"/>
   					</td>
   				</tr>
   				<tr>
   					<td style="width:70px">巡检阀值</td>
   					<td>
   						<input id="checkFrequency" name="checkFrequency" required="true" validType="val_checkFrequency" class="easyui-numberbox"/>
   					</td>
   				</tr>
   			</table>
   		</form>
   	</div>
   
   	<div id="dlgBtns">
   		<a id="btnSave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
   		<a id="btnCancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
   	</div>
   		</div>
  </body>
</html>
