<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>合同明细管理</title>
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
		        	console.info(value);
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
		        	console.info(value);
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
  			var cid = $("#contractId").val();
  			$("#frm").form("clear");//清空表单
  			$("#contractId").val(cid);
  			
  			//初始化设备型号下拉列表框,放开注释修改url/textField/valueField即可
  			
  			$("#brandId").combobox({
  				url : "${pageContext.request.contextPath}/brand/findByProperty" , 
  				textField : "brandName" , 
  				valueField : "brandId" ,
  				onChange : function(newValue){
  					var gid = $("#goodstypeId").combobox("getValue");
  					$("#productId").combobox({
  		  				url : "${pageContext.request.contextPath}/product/findByProperty?goodstypeId=" + gid + "&brandId=" + newValue , //这里写设备型号请求地址 
  		  				textField : "productName" , 
  		  				valueField : "productId" 
  		  			});
  				}
  			});
  			
  			$("#goodstypeId").combobox({
  				url : "${pageContext.request.contextPath}/goodstype/findByProperty" , 
  				textField : "goodstypeName" , 
  				valueField : "goodstypeId" ,
  				onChange : function(newValue){
  					var bid = $("#brandId").combobox("getValue");
  					$("#productId").combobox({
  		  				url : "${pageContext.request.contextPath}/product/findByProperty?goodstypeId=" + newValue + "&brandId=" + bid , //这里写设备型号请求地址 
  		  				textField : "productName" , 
  		  				valueField : "productId" 
  		  			});
  				}
  			});
  		}
		
		//这里是分页查询的代码
  		$(function(){
  			$("#grid").datagrid({
  				url : "${pageContext.request.contextPath}/contractDetail/findByProperty",
  				columns : [[
					{title : "" , field: "dsvf" ,width:"10%",checkbox:true},//设置复选框
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
					}},
					{title : "总价" , field: "fdbgrfs" ,width:"10%",formatter:function(value,rows){
						return rows.price*rows.num;
					}},
				]],
  				toolbar : "#tb" , 
  				title : "合同明细管理",
  				fit : true,
  				striped : true,
  				singleSelect : false,//设置复选框可以多选
  				border:false,
  				onLoadSuccess:function(data){
  					//console.info("数据加载成功",data);
  					var cnt=0;
  					var totalPrice=0;
  					for(var i=0;i<data.rows.length;i++){
  						cnt=cnt+data.rows[i].num;
  						totalPrice=totalPrice+data.rows[i].price*data.rows[i].num;
  					}
  					$("#totalCnt").text(cnt);
  					$("#totalPrice").html(totalPrice);
  				}
  			});
  		});
  		
  		$(function(){
  			var dialogHeight = 5 * 50 + 100;
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
	  					url : "${pageContext.request.contextPath}/contractDetail/" + opmode ,//form会自动通过ajax的方式向服务器提交数据
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
  							url : "${pageContext.request.contextPath}/contractDetail/delete?id=" + selectRec.cdId,
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
  		
  		
  	//这里是分页查询的代码
  		$(function(){
  			$("#gridContract").datagrid({
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
  				fit : true,
  				striped : true,
  				singleSelect : true,
  				border:false , 
  				onClickRow : function(index , data){ //点击查询明细
  					console.info(data);
  					$("#grid").datagrid("load" , { //向datagrid一开始设置的url从新发起查询请求,并且附带额外的参数
  						contractId : data.contract_id
  					});
  					
  					$("#contractId").val(data.contract_id);//为表单的合同编号字段赋值
  					console.info($("#contractId").val());
  				}
  			});
  		});
  	
  		$(function(){
  			$("#grid").datagrid("load" , { //向datagrid一开始设置的url从新发起查询请求,并且附带额外的参数
					contractId : -1
				});
  		})
  		//设备入库
  		$(function(){
  			$("#btnStore").click(function(){
  				var sels=$("#grid").datagrid("getSelections");//获取所有选中的数据,已数组形式返回
  				if(sels.length==0){
  					$.messager.alert("警告" , "请选择要入库的合同明细" , "warning");
  					return;
  				}
  				var cdIds=new Array();
  				for(var i=0;i<sels.length;i++){//将获取的数据中合同id单独取出放在一个数组中
  					cdIds.push(sels[i].cdId);
  				}
  				console.info(cdIds);
  				$.ajax({
  					url:"${pageContext.request.contextPath}/contractDetail/store",
  					data:"ids="+cdIds.join(","),//将数组转化为为字符串
  					type:"post",
  					dataType:"json",
  					success:function(json){
  						console.info(json);
  						if(json.result){
		    	        	$.messager.alert("提示",json.message,"info" , function(){
		    	        		$("#grid").datagrid("reload");
		    	        	});
		    	        } else {
		    	        	$.messager.alert("错误",json.message,"warning");
		    	        }
  					}
  				});
  			});
  		});
  	</script>
  </head>
  
  <body class="easyui-layout">
  	<div region="north" style="height:200px" border="false">
  		<table id="gridContract"></table>
  	</div>
  	<div region="center" border="false">
	   	<table id="grid"  ></table>
	   	<div id="tb">
	   		<a id="btnAdd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
	   		<a id="btnEdit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
	   		<a id="btnDelete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
	   		<a id="btnStore" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">设备入库</a>
	   		<span>总台数:</span>
	   		<span id="totalCnt">0</span>
	   		<span>总价:</span>
	   		<span id="totalPrice">0</span>
	   	</div>
	   	
	   	<div id="dlg" style="padding:10px">
	   		<form id="frm" method="post">
	   			<table style="width:100%">
	   				
	   				<tr>
	   					<td style="width:70px">设备类型</td>
	   					<td>
	   						<input type="hidden" name="cdId"/>
	   						<input type="hidden" name="contractId" id="contractId"/>
	   						<select id="goodstypeId" name="goodstypeId" required="true"  class="easyui-combobox" editable="false"></select>
	   					</td>
	   				</tr>
	   				<tr>
	   					<td style="width:70px">设备品牌</td>
	   					<td>
	   						<select id="brandId" name="brandId" required="true"  class="easyui-combobox" editable="false"></select>
	   					</td>
	   				</tr>
	   				<tr>
	   					<td style="width:70px">设备型号</td>
	   					<td>
	   						<select id="productId" name="productId" required="true" validType="val_productId" class="easyui-combobox" editable="false"></select>
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
