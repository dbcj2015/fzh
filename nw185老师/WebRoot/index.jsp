<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SMP系统管理平台</title>
	<!-- 主题文件 -->
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/easyui_animation.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/easyui_plus.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/insdep_theme_default.css" rel="stylesheet" type="text/css">
	<!-- 图标CSS -->
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/easyui/themes/insdep/iconfont/iconfont.css" rel="stylesheet" type="text/css">
	<!-- 引入两个JS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/script/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/themes/insdep/jquery.insdep-extend.min.js"></script>
	<style>
		.header-nav li{
			float: left;
		}
		.panel-title{
			font-size:18px;
		}
		.function-list{
			padding:10px;
		}
		.function-list li{
			height: 25px;
			font-size:16px;
			cursor: pointer;
			padding: 5px;
		}
		.function-list li:hover{
			background-color: lightblue;
		}
		.function-list li>i{
			margin-right: 10px;
			font-size: 20px;
		}
		
		.function-li-selected{
			border-bottom: 3px solid orange;
		}
		
		.nav-li-selected > a{
			border-top:3px solid orange!important;
		}
		
	</style>
	<script type="text/javascript">
		//点击模块按钮的时候,切换功能菜单
		$(function(){
			$(".header-nav li[flshow]").click(function(){
				var flshow = $(this).attr("flshow");//获取要显示的功能列表
				$(".function-list").hide();
				$(flshow).fadeIn(200);
				$(".nav-li-selected").removeClass("nav-li-selected");
				$(this).addClass("nav-li-selected");
				
				//修改标题
				//CSS可以当ID用
				var title = $(this).find(".module-text").text();
				$("#functions").panel("setTitle" , title);
			});
			
		});
		//默认显示第一个模块的功能
		$(function(){
			//:first选择器代表选择第一个元素
			//eq选择指定索引的元素,下标从0开始
			$(".function-list:eq(0)").show();
		});
		//点击功能的时候,实现切换
		$(function(){
			//子选择器,选中直接隶属于.function-list cSS类的选择器
			$(".function-list>li").click(function(){
				var url = $(this).attr("url"); //利用attr函数获取自定义属性url
				var text = $(this).find(".function-text").text();//在当前自己的html中查询符合条件的
				var isExist = $("#tabsMain").tabs("exists" , text);//判断指定的标签是否存在 
				
				if(isExist == false){//标签不存在的时候,创建
					$("#tabsMain").tabs("add" , {
						title : text ,
						closable : true ,
						content : "<iframe src='" + url + "' style='width:100%;height:97%;border:0px'/>" 
					});
				}else{ //有则激活
					$("#tabsMain").tabs("select" , text)
				}
				$(".function-li-selected").removeClass("function-li-selected");
				$(this).addClass("function-li-selected");
			});
			
		})
		
		$(function(){
			$("#divExit").click(function(){
				window.location = "${pageContext.request.contextPath}/users/logout";
			})
		})
		
		
	    $(function () {
	    	 //右键菜单click
	        $("#tabMenu").menu({
	        	
	            onClick: function (item) {
	            	var tab = $("#tabsMain").tabs("getSelected");
	            	var tabOption = tab.panel('options'); 
	            	var title = tabOption.title;
	            	if(item.id == "tabRefresh"){
		            	tab.find("iframe").get(0).contentWindow.location.reload();	
	            	}
	            	if(item.id=="tabExit"){
	            		
	            		$("#tabsMain").tabs("close" , title);
	            	}
	            }
	        });
	    	 
	        //监听右键事件，创建右键菜单
	        $('#tabsMain').tabs({
	            onContextMenu: function (e, title, index) {
	                e.preventDefault();
	                if (index > 0) {
	                	$("#tabsMain").tabs("select" , title);
	                	
	                    $('#tabMenu').menu('show', {
	                        left: e.pageX,
	                        top: e.pageY
	                    }).data("tabTitle", title);
	                }
	            }
	        });
	       
	    });
	</script>
</head>
<!-- Easyui中采用class=“easyui-....”的方式描述组件 -->
<body class="easyui-layout">
	<!-- Easyui中采用自定义属性的方式来设置选项 -->
	<div region="north" style="height:50px;overflow: hidden;">
		<ul class="header-nav">
			<li style="margin-right:100px"><img src="${pageContext.request.contextPath}/resources/images/logo.png" style="height:48px;margin-left:25px"></li>
			 <!-- 显示模块 -->
			 <c:forEach items="${modules}" var="m">
			 	<li flshow="#M${m.module_id}"><a class="easyui-linkbutton" style="border:0px;height:48px;font-size: 18px;font-weight: bold"><i class="icon iconfont ${m.icon }" style="font-size:20px"></i>&nbsp;<span class="module-text">${m.module_name}</span></a></li>
			 </c:forEach>
			 
			 
			<li style="float:right">
					<a href="javascript:void(0)" id="mb" class="easyui-menubutton" style="height:48px;margin-right: 25px" data-options="menu:'#mm'">
					    <i class="icon iconfont icon-accountfilling" style="font-size:20px"></i>
					 ${loginuser.name}</a>
					<div id="mm" style="width:100px;">
					    <div data-options="iconCls:'icon-man'">用户信息</div>
					    <div data-options="iconCls:'icon-lock'">修改密码</div>
					    <div class="menu-sep"></div>
					    <div id="divExit" data-options="iconCls:'icon-undo'">退出系统</div>
					</div>		
					<div id="tabMenu" style="width:100px;">
					    <div id="tabRefresh" data-options="iconCls:'icon-reload'">刷新</div>
					    <div class="menu-sep"></div>
					    <div id="tabExit" data-options="iconCls:'icon-exit'">关闭</div>
					</div>	
			</li>
		</ul>
	</div>
	<div id="functions" region="west" title ="综合台账" split="true" style="width:200px">
		 
		 <c:forEach items="${functions}" var="fs">
		 	<ul class="function-list" style="display:none" id="${fs.key}">
		 		<c:forEach items="${fs.value}" var="f">
		 			<li url="${f.url}"><i class="icon iconfont ${f.icon }" ></i><span class="function-text">${f.function_name }</span></li>
		 		</c:forEach>
		 	</ul>
		 </c:forEach>
	</div>
	<div region="center">
		<div id="tabsMain" class="easyui-tabs" fit=true border=false>
			<div title="工作台" style="padding:10px 0px 0px 10px;">
				<iframe  src='${pageContext.request.contextPath}/workbench.jsp' style='border:0px;width:100%;height:95%'/>			
			</div>
		</div>
	</div>
	
	
</body>
</html>