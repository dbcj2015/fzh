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

#tips{
	background-color: green;
	/*文本内容字体颜色*/
	color:red;
	font-size: 9px;
	font-family: 黑体;
	padding:10px;
	position: absolute;/*按坐标进行绝对定位*/
	left: 100px;
	top:100px;
	z-index: 10;
	display :none;

}
</style>
<script type="text/javascript" src="jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
	
	$(function(){
		$("#lblNews").click(function(){
			
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

	
		$(function(){
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

				if($("div[name$=Container]").css("display") == "block"){
					//hide()方法就是将CSS的display属性设置为none
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
				/*float属性将选中的内容以左边为起点，依次横向排列成一行，直到排满自动换行,并且随着浏览器屏幕的大小成比例变化*/
				$("ul>div>li").css("float" , "left");
			});
			$("#vorder").click(function(){
				$("ul>div>li").css("float" , "none");
			});
		});
		
		//增加css属性
		$(function(){
			$("div[name$='Container']>li>label").mouseover(function(event){
				//在事件function中默认存在一个event参数，这个参数包含了鼠标、键盘等产生的信息
				$("#tips").fadeIn(200);
				var data=$(this).text();
				$("#tips").css({"left":event.pageX+10,"top":event.pageY+10});
				$("#tips").html("<b>"+data+"</b>");
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
			}); //属性选择器如果不写值，则代表只要有这个属性就会被选中
			$("label[stype],label[product]").mouseout(function(){
				$(this).removeClass("highlight");//移除一个CSS类，如果不写参数则代表删除所有的CSS类
			}); //属性选择器如果不写值，则代表只要有这个属性就会被选中
		});
		
		$(function(){
			
			$("label[stype]").click(function(){
				var st = $(this).attr("stype");
				$.ajax({
					url : "/301/news" , //请求地址
					type : "get" , 
					data : {"ch" : st} , //将选中的栏目作为参数向Servlet发送请求
					dataType : "json" , //ajax会自动将返回的字符串转换为JavaScipt内置的JSON对象
					success : function(data){ //ajax将服务器返回的结果转换为JSOn后放在data对象中
						console.info(data);
						var newslist = data.result.data;
						//console.info(newslist);
						$("#content").html("");
						for(var i = 0 ; i < newslist.length ; i++){
							var news = newslist[i];
							$("#content").append("<li class='newsitem'>" +news.date+":"+ news.title + "&nbsp;" + news.title + "</li>");//追加指定的内容
						}
					}
				});
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
			  <li><img src="img/item.gif" /><label id = "lblLocal" stype = "tiyu">体育</label></li>
              <li><img src="img/item.gif" /><label id = "lblInternational" stype = "caijing">财经</label></li>
              <li><img src="img/item.gif" /><label id = "lblInternational" stype = "junshi">军事</label></li>
              <li><img src="img/item.gif" /><label id = "lblInternational" stype = "keji">科技</label></li>
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

	<div id="content">内容</div>
</body>
</html>

