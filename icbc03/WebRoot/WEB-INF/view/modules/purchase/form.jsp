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
	<style type="text/css">
		.s{
			height:500px;
			width:600px;
			left:50%;
			position: absolute;
			margin-left: -300px;
			top: 30px;
		}
		.contact_info_title{
			width:100px;
			text-align: right;
		}
		.contact_info_input{
			width:200px;
		}
		.contact_info_title , .contact_info_input{
			padding: 5px;
		}
		.contract_info .easyui-textbox  , .contract_info .easyui-combobox , .contract_info .easyui-filebox{
			width:190px;
		}
	</style>
</head>
<body>
	<div class="easyui-panel" height="300" title = "合同采购"  cls="s">
		<div class="easyui-layout"  fit=true>
			<div region="north" style="height:200px">
				<table  class="contract_info" style="width:100%">
					<tr>
						<td class="contact_info_title" >项目</td>
						<td class="contact_info_input" ><select class="easyui-combobox"></select></td>
						<td class="contact_info_title" >合同编号</td>
						<td class="contact_info_input"><input class="easyui-textbox"></td>
					</tr>
					<tr>
						<td class="contact_info_title" >合同名称</td>
						<td class="contact_info_input" ><input class="easyui-textbox"></td>
						<td class="contact_info_title" >供应商</td>
						<td class="contact_info_input"><select class="easyui-combobox"></select></td>
					</tr>
					<tr>
						<td class="contact_info_title" >合同影印件</td>
						<td class="contact_info_input" ><input class="easyui-filebox" accept="application/msword"></td>
						<td class="contact_info_title" >&nbsp;</td>
						<td class="contact_info_input">&nbsp;</td>
					</tr>
				</table>
			</div>
			<div region="center" >222</div>
		</div>
	</div>
</body>
</html>