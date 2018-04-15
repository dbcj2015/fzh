<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 主题文件 -->
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/easyui_animation.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/easyui_plus.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/insdep_theme_default.css" rel="stylesheet" type="text/css">
	
	<!-- 图标CSS -->
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/icon.css" rel="stylesheet" type="text/css">
	
	<!-- 引入两个JS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/jquery.easyui.min.js"></script>
	<!-- 引入汉化包 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/themes/insdep/jquery.insdep-extend.min.js"></script>
	<!-- 用于校验的规则包 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/smp.validation.js"></script>
	
	<style type="text/css">
		#dlgEmp table tr td:first-child{
			text-align: right;
			padding-right: 10px;
		}
		
		#dlgEmp table tr{
			height : 40px;
		}
		
	</style>
	<!-- 
		正则 
		^\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d[0-9X]$ -> 13010219840530091X
		^[ABDEFGHIJKLMNOQRSTUVXYZ]{0,10}$   {0,10}代表前面的字符可以不出现，但最多只能出现10个
		^1(33|34|78|31|88|89|32|35|30|59|87|39)\d{8}$ 手机分组
		区号 ^\d{3,4}-\d{7,8}$  ^(\d{3}|\d{4})-(\d{7}|\d{8})$
	 -->
	<script type="text/javascript">
		var opMode = "create";//代表当前表单的操作状态
		//清空表单
		function initForm(){
			$("#frmEmp").form("clear");
			$("#cmbDept").combobox("setValue" , -1);//设置默认值
			$("#cmbJob").combobox("setValue" , -1);
		}
		//用来描述岗位的信息，jobFormatter在数据加载的时候会根据条件将return 的结果填充到单元格
		function jobFormatter(value , row , index){
			if(row.job == 1){
				return "市场经理";
			}else if(row.job == 2){
				return "咨询师";
			}else if(row.job == 3){
				return "实训师";
			}
		}
		//rowStyler则是根据指定的条件，来美化对应的行
		function highlightD1(index,row ){
			if(row.dept_id == 1){
				return "color:red;font-weight:bold";
			}else if(row.dept_id==2){
				return "background-color:lightgreen";
			}else if(row.dept_id==3){
				return "text-decoration:underline";
			}
		}
		
		$(function(){
			$("#btnAdd").click(function(){
				initForm();
				opMode="create";//设置表单为新增模式
				$("#dlgEmp").dialog({
					title : "员工信息表单" ,
					width : 300,
					height:300,
					buttons : "#digBtns",
					modal : true //模态对话框，只允许操作对话框中的内容，后台不允许交互，非模态框，则允许后台交互
					//JS中实现模态对话框的原理就是利用DIV做一个“遮罩层”
				});
			});
			
			//加载部门数据
			$("#cmbDept").combobox({
				url : "/ssm/dept/list",
				valueField : "dept_id" ,
				textField :"dname",
				value : -1 //代表默认选中value=-1的选项
			})
		})
		
		$(function(){
			$("#btnSave").click(function(){
				$("#frmEmp").form("submit" , {
					url : "/ssm/emp/" + opMode,
					success : function(text){
						console.info(text);
						var json = $.parseJSON(text);//将服务器返回的字符串转为JSON对象
						console.info(json);
						if(json.result == true){
							$.messager.alert("通知" , json.message ,"warning", function(){
								$("#dlgEmp").dialog("close");//关闭对话框
								
								$("#gridEmp").datagrid("reload");
							}) //EASYUI为我们提供的alert（）警告框的替代者
						}else{
							$.messager.alert("错误" , json.message ,"error");
						}
					}
				});
			});
		});
		
		$(function(){
			$("#btnEdit").click(function(){
				var recs = $("#gridEmp").datagrid("getSelections");
				if(recs.length == 0 || recs.length >1){
					$.messager.alert("警告" , "请选择一条要修改的记录" , "warning");
					return;
				}
				console.info(recs);
				initForm();
				opMode="update";//设置表单为修改模式
				$("#dlgEmp").dialog({
					title : "员工信息表单" ,
					width : 300,
					height:300,
					buttons : "#digBtns",
					modal : true //模态对话框，只允许操作对话框中的内容，后台不允许交互，非模态框，则允许后台交互
					//JS中实现模态对话框的原理就是利用DIV做一个“遮罩层”
				});
				
				//$("#cmbDept").combobox("setValue" , recs[0].dept_id);
				//load方法会将数据中的属性与输入项的name相同的自动填充
				$("#frmEmp").form("load" , recs[0]);
			});
		});
		
		
		$(function(){
			$("#btnDelete").click(function(){
				//删除必须选择记录
				var recs = $("#gridEmp").datagrid("getSelections");
				if(recs.length == 0 ){
					$.messager.alert("警告" , "请至少选择一条要删除的记录" , "warning");
					return;
				}
				//拼接发送的请求字符串
				var ids = "";
				for(var i = 0 ; i < recs.length ; i++){
					ids = ids + "&" + "id=" + recs[i].emp_id;
				}
				
				//确认对话框
				$.messager.confirm("确认" , "确定要删除您选中的" + recs.length + "位员工资料吗？" ,function(r){
					if(r==true){//点击了确定按钮
						//利用ajax向服务器发送请求
						$.ajax({
							url : "/ssm/emp/delete?1=1" + ids,
							type : "post" , 
							dataType : "json" , 
							success : function(json){
								//服务器处理成功，表格刷新
								if(json.result == true){ //EASYUI为我们提供的alert（）警告框的替代者
									$.messager.alert("通知" , json.message ,"info", function(){
										$("#gridEmp").datagrid("reload");
									});
								}else{
									$.messager.alert("错误" , json.message ,"error");
								}
							}
						});
					}else{
						//点击了取消按钮
					}
				})
				
			});
		});
	</script>
</head>
<body>
	<table id="gridEmp" title="员工管理" url="/ssm/emp/list" rowStyler="highlightD1" border=false class="easyui-datagrid" toolbar="#tb" pagination="true" fit=true>
		<thead>
			<tr>
				<th width="100" checkbox="true" field="xx"></th>
				<th width="100" field="emp_id">员工编号</th>
				<th width="100" field="name">姓名</th>
				<th width="100" field="dname">部门</th>
				<th width="100" field="mobile">手机号</th>
				<th width="100" field="job" formatter="jobFormatter">岗位</th>
				<th width="200" field="email">邮箱</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<a href="#" class="easyui-linkbutton" id="btnAdd" plain=true iconCls="icon-add">新增</a>
		<a href="#" class="easyui-linkbutton" id="btnEdit" plain=true iconCls="icon-edit">修改</a>
		<a href="#" class="easyui-linkbutton" id="btnDelete" plain=true iconCls="icon-remove">删除</a>
	</div>
	<div id="dlgEmp">
		<form id="frmEmp" method="post">
			<table style="width:100%">
				<tr>
					<td style="width:75px">姓名</td>
					<td>
					<input name="empId" type="text" />
					<input name="name" type="text" class="easyui-textbox" style="width:200px" required=true validType="validName"></td>
				</tr>
				<tr>
					<td style="width:75px">部门</td>
					<td>
						<select name="deptId" id="cmbDept" validType="validDefaultOption" class="easyui-combobox" style="width:200px" editable=false>
						</select>
					</td>
				</tr>
				<tr>
					<td style="width:75px">手机号</td>
					<td><input name="mobile" validType="validMobile" type="text" class="easyui-textbox" style="width:200px"  required=true></td>
				</tr>
				
				<tr>
					<td style="width:75px">岗位</td>
					<td>
						<select id="cmbJob" validType="validDefaultOption" name="job" class="easyui-combobox" style="width:200px" editable=false>
							<option value="-1">请选择</option>
							<option value="1">市场经理</option>
							<option value="2">咨询师</option>
							<option value="3">实训师</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td style="width:75px">电子邮箱</td>
					<td><input name="email" type="text" class="easyui-textbox" style="width:200px"  required=true validType="email"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="digBtns">
		<a id="btnSave" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
	</div>
</body>
</html>