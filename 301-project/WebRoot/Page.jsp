<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<style type="text/css">
body {
	font-size: 16px;
	background-color: #FFF;
}

ul li {
	list-style: inside;
	margin-left: 20px;
	list-style: none;
}

#content {
	position: absolute;
	left: 400px;
	top: 20px;
	width: 300px;
	height: 400px;
	border: 1px solid #cccccc;
}
</style>
<script type="text/javascript" src="jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
	/*
		解决点击标题内容隐藏以及展示，同时标题的图片随着内容的隐藏发生变化
	$(function(){
		$("#lblNews").click(function(){
			//隐藏国际新闻下的内容--其实就是隐藏div标签
			//三种方式:
		//1、全匹配
			//$("div[name=divNewsContainer]").hide();
		//2、尾匹配
			//$("div[name$='Container']").hide();
		//3、头匹配
			//$("img[name^='img']").hide();
			//$("img[src='img/item.gif']").hide();
		//4、属性选择器的语法：标签[属性名=属性值]
				//hide()方法就是将CSS的display属性设置为none
				//css 当只有一个参数的时候代表获取对象的CSS属性，两个参数则代表设置
			if($("div[name='divNewsContainer']").css("display")=="block"){
				$("#imgOnOff1").attr("src","img/close.gif");
				$("div[name='divNewsContainer']").css("display","none");
			}else if($("div[name='divNewsContainer']").css("display")=="none"){
				$("#imgOnOff1").attr("src","img/open.gif");
				$("div[name='divNewsContainer']").css("display","block");
			}
		});
		
		
		
		$("#lblProducts").click(function(){
			//隐藏产品新闻下的内容
			if($("div[name='divProductsContainer']").css("display")=="block"){
				$("#imgOnOff2").attr("src","img/close.gif");
				$("div[name='divProductsContainer']").css("display","none");
			}else if($("div[name='divProductsContainer']").css("display")=="none"){
				$("#imgOnOff2").attr("src","img/open.gif");
				$("div[name='divProductsContainer']").css("display","block");
			}
		});
	});
	*/	
	
		$(function(){
			//获取标签的五种方式:
			//$("#lblNews,#lblProducts");//组合选择器，利用逗号将多个选择器分隔，同时获取
			//‘大于号’代表子选择器，获取直接隶属于ul标记的label标签 ，子选择器只选择儿子label
			//$("ul label") 层次选择器，不区分层级，只要隶属于ul的label都会被选中
			$("ul>label").click(function(){
				if($(this).siblings("$div").css("display")=="block"){
					$(this).siblings("div").hide();//获取当前触发事件的对象$(this),当前事件对象的同级div节点
					$(this).siblings("img").attr("src" , "img/close.gif");
				}else{
					$(this).siblings("div").show();
					$(this).siblings("img").attr("src" , "img/open.gif");
				}
			})
		})
		
		$(function(){
			$("#openclose").click(function(){
				//$("div[name^=div]") 
				//$("div[name$=Container]") 
				//$("div[name=divNewsContainer],div[name=divProductsContainer]")
				//$("ul>div") $("ul div")
				//css与attr方法都是返回第一个元素的状态
				if($("div[name$=Container]").css("display") == "block"){
					//hide()方法就是将CSS的display属性设置为none
					$("div[name$=Container]").hide(500);//获取当前触发事件的对象$(this),当前事件对象的同级div节点
					$("img[name='imgOnOff']").attr("src" , "img/close.gif");
					alert($("div[name$=Container]").css("display"));
				}else{
					alert($("div[name$=Container]").css("display"));
					$("div[name$=Container]").show(500);
					$("img[name='imgOnOff']").attr("src" , "img/open.gif");
				}
			});
		});
		
		$(function(){
			$("#horder").click(function(){
				/*float属性将选中的内容以左边为起点，依次横向排列成一行，直到排满自动换行,并且随着浏览器屏幕的大小成比例变化*/
				$("ul>div>li").css("float" , "left");
			});
			$("#vorder").click(function(){
				$("ul>div>li").css("float" , "none");
			});
		});
		
</script>
</head>

<body>
	<p>
		<input type="button" name="openclose" id="openclose" value="展开/折叠" />
		<input type="button" name="horder" id="horder" value="横向排列" /> <input
			type="button" name="vorder" id="vorder" value="纵向排列" />
	</p>
	<ul>
		<img id="imgOnOff1" name="imgOnOff" src="img/open.gif" />
		<label id="lblNews">&nbsp;国际动态</label>
		<div name="divNewsContainer">
			<li><img src="img/item.gif" /><label id="lblLocal" type="local">国内新闻</label></li>
			<li><img src="img/item.gif" /><label id="lblInternational"
				type="international">国际新闻</label></li>
		</div>
	</ul>
	<br />
	<ul>
		<img id="imgOnOff2" name="imgOnOff" src="img/open.gif" />
		<label id="lblProducts">&nbsp;产品展示</label>
		<div name="divProductsContainer">
			<li><img src="img/item.gif" /><label id="lblAdidas"
				product="adidas">阿迪达斯</label></li>
			<li><img src="img/item.gif" /><label id="lblNike"
				product="nike">NIKE</label></li>
			<li><img src="img/item.gif" /><label id="lblKuangWei"
				product="kuangwei">匡威</label></li>
			<li><img src="img/item.gif" /><label id="lblAddNice"
				product="addnice">AddNice</label></li>
			<li><img src="img/item.gif" /><label id="lblLiNing"
				product="lining">李宁</label></li>
			<li><img src="img/item.gif" /><label id="lblLee" product="lee">Lee</label></li>
		</div>
	</ul>
	<div id="tips"></div>

	<div id="content"></div>
</body>
</html>
