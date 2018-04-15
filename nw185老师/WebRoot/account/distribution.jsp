<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>设备划拨</title>
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
		    val_brandName: { 
		        validator: function(value,param){ 
		            return true;
		        },   
		        message: "这里填写设备名称的验证规则"  
		    }
		    
		}); 
  		//这里是初始化表单的代码
  		function initForm(){
  			$("#frm").form("clear");
  			
  			
  		}
		
		//这里是分页查询的代码
  		$(function(){
  			$("#grid").datagrid({
  				url : "${pageContext.request.contextPath}/asset/groupStoreAsset",
  				columns : [[
  					{title : "设备类型" , field: "goodstype_name" ,width:"20%"},
  					{title : "设备品牌" , field: "brand_name" ,width:"20%"},
  					{title : "设备型号" , field: "product_name" ,width:"20%"},
  					{title : "库存数量" , field: "cnt" ,width:"10%"}
  				]],
  				toolbar : "#tb" , 
  				title : "在库设备清单",
  				fit : true,
  				striped : true,
  				singleSelect : true
  			});
  		});
  		
  		$(function(){
  			var dialogHeight = 300;
  			//设备划拨
  			$("#btnAdd").click(function(){
  				var sel = $("#grid").datagrid("getSelected");
  				if(sel == null){
  					$.messager.alert("警告" , "请选择要派发的设备" , "warning");
  					return;
  				}
  				
  				$("#txtProductName").text(sel.goodstype_name + "-" + sel.brand_name + "-" + sel.product_name);
  				$("#txtStoreCnt").text(sel.cnt);
  				//利用combobox动态加载servlet返回的数据
  				//利用自定义属性来决定当前表单适用于新增还是用于更新
  				$("#frm").attr("opmode" , "create");
  				initForm();
  				$("#productId").val(sel.product_id);
  				$("#dlg").dialog({ //弹出一个宽200高300的新增员工对话框
  					title : "新增" , 
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
	  					url : "${pageContext.request.contextPath}/asset/distribution" ,//form会自动通过ajax的方式向服务器提交数据
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
  		
  		
  		$(function(){
  			$("#cmbBranch").combobox({
  				url : "${pageContext.request.contextPath}/branch/findByProperty?branchLevel=2" ,
  				textField : "branchName" ,
  				valueField : "branchId",
  				mode : "remote" //远程加载
  			});
  			
  		})
  	</script>
  </head>
  
  <body>
   	<table id="grid"></table>
   	<div id="tb">
   		<a id="btnAdd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">设备划拨</a>
   	</div>
   	
   	<div id="dlg" style="padding:10px">
   		<form id="frm" method="post">
   			<table style="width:100%">
				<tr>
   					<td style="height:30px;width:70px">设备型号</td>
   					<td>
   						<input type="hidden" name="productId" id="productId" />
   						<span id="txtProductName">xxxxxx</span>
   					</td>
   				</tr>
   				<tr>
   					<td style="height:30px;width:70px">库存数量</td>
   					<td>
   						<span id="txtStoreCnt">100</span>
   					</td>
   				</tr>
   				
   				<tr>
   					<td style="width:70px">二级分行</td>
   					<td>
   						<select id="cmbBranch" name="branchId" class="easyui-combobox">
   							
   						</select>
   					</td>
   				</tr>
   				
   				<tr>
   					<td style="width:70px">派发数量</td>
   					<td>
   						<input name="num" class="easyui-numberbox" >
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
