<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<style type="text/css">
body{
	font-size:16px;
	background-color: #FFF;
}

ul li{
	list-style:inside;
	margin-left:20px;
	list-style:none;
}

#content {
  position: absolute;
  left: 400px;
  top: 20px;
  width : 500px;
  height : 400px;
  border : 1px solid #cccccc;
}

#tips{
	background-color: green;
	color:white;
	font-size: 9px;
	font-family: 黑体;
	padding:10px;
	position: absolute;/*按坐标进行绝对定位*/
	left: 100px;
	top:100px;
	z-index: 10;
	display :none;
}

#tips2{
	background-color: red;
	color:white;
	font-size: 9px;
	font-family: 黑体;
	padding:10px;
	position: absolute;/*按坐标进行绝对定位*/
	left: 150px;
	top:120px;
	z-index: 12;
}
/*定义了一个CSS类*/
.highlight{
	color:red;
	font-weight: bold;
	text-decoration: underline;
	cursor: pointer;
}

.newsitem{
	font-size:9px;
	border-bottom: 1px dashed #ccc;
	padding:10px;
}
</style>
	<title>JQUERY树状菜单</title>
		<script type="text/javascript" src="script/jquery-3.2.1.js"></script>
	<script type="text/javascript">
		/* 上午代码
		$(function(){ //$(document).ready(function(){..})等价，页面就绪函数，页面加载完在会执行里面的JS代码
			//jquery选择器中 ， #id的方式被称为id选择器
			//.click(function(){则代表单击事件
			//jQuery或者JS无外乎就是在哪些组件上做什么事儿，结果是什么
			$("#lblNews").click(function(){
				//属性选择器的语法：标签[属性名=属性值]
				//hide()方法就是将CSS的display属性设置为none
				//css 当只有一个参数的时候代表获取对象的CSS属性，两个参数则代表设置
				if($("div[name='divNewsContainer']").css("display") == "block"){
					$("#imgOnOff1").attr("src" , "img/close.gif");//设置属性值
					$("div[name='divNewsContainer']").css("display" , "none");//精确匹配 .  style="display:none"
				}else if($("div[name='divNewsContainer']").css("display") == "none"){
					$("#imgOnOff1").attr("src" , "img/open.gif");//设置属性值
					$("div[name='divNewsContainer']").css("display" , "block");
				}
				//$("div[name$='Container']").hide();//尾匹配
				//$("img[name^='img']").hide();//头匹配
				//$("img[src='img/item.gif']").hide();
			});
			
			
			$("#lblProducts").click(function(){
				var productContainer = $("div[name='divProductsContainer']");
				var onOff2 = $("#imgOnOff2");
				
				if(productContainer.css("display") == "block"){
					onOff2.attr("src" , "img/close.gif");//设置属性值
					productContainer.css("display" , "none");//精确匹配 .  style="display:none"
				}else if(productContainer.css("display") == "none"){
					onOff2.attr("src" , "img/open.gif");//设置属性值
					productContainer.css("display" , "block");
				}
			});			
		});
		// window.onload 是指当页面资源加载完毕后才执行代码， 
		//页面就绪函数则是代表DOM标签被解析后就立即执行，大多属性框架POM效率比onload来的要高
		*/
		
		
		$(function(){
			//$("#lblNews,#lblProducts");//组合选择器，利用逗号将多个选择器分隔，同时获取
			//大于号代表子选择器，获取直接隶属于ul标记的label标签 ，子选择器只选择儿子
			//$("ul label") 层次选择器，不区分层级，只要隶属于ul的label都会被选中
			$("ul>label").click(function(){
				if($(this).siblings("div").css("display") == "block"){
					$(this).siblings("div").hide();//获取当前触发事件的对象$(this),当前事件对象的同级div节点
					$(this).siblings("img").attr("src" , "img/close.gif");
				}else{
					$(this).siblings("div").show();
					$(this).siblings("img").attr("src" , "img/open.gif");
				}
			});
		});
		
		$(function(){
			$("#openclose").click(function(){
				//$("div[name^=div]") 
				//$("div[name$=Container]") 
				//$("div[name=divNewsContainer],div[name=divProductsContainer]")
				//$("ul>div") $("ul div")
				//css与attr方法都是返回第一个元素的状态
				if($("div[name$=Container]").css("display") == "block"){
					$("div[name$=Container]").hide(500);//获取当前触发事件的对象$(this),当前事件对象的同级div节点
					$("img[name='imgOnOff']").attr("src" , "img/close.gif");
				}else{
					$("div[name$=Container]").show(500);
					$("img[name='imgOnOff']").attr("src" , "img/open.gif");
				}
			});
		});
		
		$(function(){
			$("#horder").click(function(){
				$("ul>div>li").css("float" , "left");
			});
			$("#vorder").click(function(){
				$("ul>div>li").css("float" , "none");
			});
		})
		
		$(function(){
			$("div[name$='Container']>li>label").mouseover(function(event){
				//在事件function中默认存在一个event参数，这个参数包含了鼠标、键盘等产生的信息
				$("#tips").fadeIn(200); //渐现
				var t = $(this).text();
				//$("#tips").css("left" , event.pageX + 10);
				//$("#tips").css("top" , event.pageY+10);
				$("#tips").css({"left" : event.pageX + 10 , "top" : event.pageY+10});
				$("#tips").html("<b>点击查看关于" + t + "的新闻</b>"); //text()方法用于获取或设置组件的内部文本
			});
			//mouseover mouseout mousemove 与鼠标移动相关的
			$("div[name$='Container']>li>label").mouseout(function(){
				$("#tips").text("");
				$("#tips").fadeOut();//渐隐
			});
		});
		
		$(function(){
			$("label[stype],label[product]").mouseover(function(){
				$(this).addClass("highlight");//增加一个CSS类
			}) //属性选择器如果不写值，则代表只要有这个属性就会被选中
			$("label[stype],label[product]").mouseout(function(){
				$(this).removeClass("highlight");//移除一个CSS类，如果不写参数则代表删除所有的CSS类
			}) //属性选择器如果不写值，则代表只要有这个属性就会被选中
		});
		
		$(function(){
			
			$("label[stype]").click(function(){
				var st = $(this).attr("stype");
				$.ajax({
					url : "/jquery/news" , //请求地址
					type : "get" , 
					data : {"ch" : st} , //将选中的栏目作为参数向Servlet发送请求
					dataType : "json" , //ajax会自动将返回的字符串转换为JavaScipt内置的JSON对象
					success : function(data){ //ajax将服务器返回的结果转换为JSOn后放在data对象中
						console.info(data);
						var newslist = data.result.list;
						$("#content").html("");
						for(var i = 0 ; i < newslist.length ; i++){
							var news = newslist[i];
							$("#content").append("<li class='newsitem'>" + news.time + "&nbsp;" + news.title + "</li>");//追加指定的内容
						}
					}
				});
			});
			
		});
	</script>
</head>
<body>

<p>
<input type="button" name="openclose" id="openclose" value="展开/折叠"/>
<input type="button" name="horder" id="horder" value="横向排列"/>
<input type="button" name="vorder" id="vorder" value="纵向排列"/>
<div id="tips">我是Tips1</div>
<!-- 
<div id="tips2">我是Tips2</div>
 -->
</p>
	<ul>
		<img id = "imgOnOff1" name="imgOnOff"  src="img/open.gif"/>
		<label id = "lblNews">&nbsp;国际动态</label>
    	<div name="divNewsContainer">
              <li><img src="img/item.gif" /><label id = "lblLocal" stype = "NBA">NBA</label></li>
              <li><img src="img/item.gif" /><label id = "lblInternational" stype = "女性">女性</label></li>
              <li><img src="img/item.gif" /><label id = "lblInternational" stype = "军事">军事</label></li>
              <li><img src="img/item.gif" /><label id = "lblInternational" stype = "科技	">科技</label></li>
		</div>
   	</ul>
   	<br/>
	<ul>
		<img id = "imgOnOff2" name="imgOnOff" src="img/open.gif"/>
		<label id="lblProducts">&nbsp;产品展示</label>
		<div name="divProductsContainer" >
	        <li><img src="img/item.gif" /><label id = "lblAdidas" product = "adidas">阿迪达斯</label></li>
  			<li><img src="img/item.gif" /><label id = "lblNike" product = "nike">NIKE</label></li>
        	<li><img src="img/item.gif" /><label id = "lblKuangWei" product = "kuangwei">匡威</label></li>
            <li><img src="img/item.gif" /><label id = "lblAddNice" product = "addnice">AddNice</label></li>
            <li><img src="img/item.gif" /><label id = "lblLiNing" product = "lining">李宁</label></li>            
            <li><img src="img/item.gif" /><label id = "lblLee" product = "lee">Lee</label></li>
        </div>
	</ul>
	
	
	<div id = "content">
	
	</div>
	

</body>
</html>

