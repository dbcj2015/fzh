<%@page contentType="text/html;charset=utf-8"%>
<!doctype html>
<html>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <link rel="stylesheet" href="css/amazeui.min.css">
  <link rel="stylesheet" href="css/wap.css">
   
  <title>内容页列表页</title>
 	 <script src="js/jquery.min.js"></script>
    <script src="js/amazeui.min.js"></script>
</head>
<script type="text/javascript">
	var channelId=${param.channel};
	var page=1;
	var rows=10;
	//alert(channelId);//获取用户请求数据，区别与request域中的数据
	//通过Ajax发送用户请求数据
	function loadNews(){//这种方式的函数必须通过调用来执行
		$.ajax({
			url:"list",
			data:{"channelId":channelId,"page":page,"rows":rows},
			dataType:"json",
			type:"get",
			success:function(data){
				//得到的是一个数组
				if(data.length==0){
					$("#btnMore").hide();
				}
				var obtainHtml=$("#obtainHtml").html();
				var appendHtml=$("#appendHtml");
				for (var i = 0; i < data.length; i++) {
					var news=data[i];
					var newHtml=obtainHtml.replace("{src}",news.src)
					.replace("{title}",news.title)
					.replace("{content}",news.content)
					.replace("{pic}",news.pic)
					.replace("{news_id}",news.news_id);
					appendHtml.append(newHtml);
				}
			}
		});
	};
	$(function(){//这种方式的函数在页面加载的时候就自动执行
		loadNews();
	$("#btnMore").click(function(){
		page=page+1;
		loadNews();
	});
	});
	
</script>
<!-- 这是一种特殊处理模式:将以下内容通过处理重新填充到body标签中 -->
<script type="text/html" id="obtainHtml">
	<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block">
	<a href="content?newsId={news_id}">
        <div class="pet_list_one_info">
            <div class="pet_list_one_info_l >
                <div class="pet_list_one_info_ico"><img src="img/a1.png" alt=""></div>
                <div class="pet_list_one_info_name">{src} </div>
            </div>
        </div>
        <div class=" am-u-sm-8 am-list-main pet_list_one_nr">
            <h3 class="am-list-item-hd pet_list_one_bt">{title}</h3>
            <div class="am-list-item-text pet_list_one_text">{content}</div>

        </div>
          <div class="am-u-sm-4 am-list-thumb">
              <img src="{pic}" class="pet_list_one_img" alt=""/>
          </div>
	</a>
      </li>
</script>
<body style="background:#ececec">
  <div class="pet_mian" >
    <div class="pet_head">
      <header data-am-widget="header"
          class="am-header am-header-default pet_head_block">
        <div class="am-header-left am-header-nav ">
          <a href="index" class="iconfont pet_head_jt_ico">&#xe601;</a>
        </div>

        <div class="am-header-right am-header-nav">
          <a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
        </div>
      </header>
    </div>
    <div class="pet_content pet_content_list">
      <div class="pet_article_like">
        <div class="pet_content_main pet_article_like_delete">
          <div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
            <div class="am-list-news-bd">
              <ul class="am-list" id="appendHtml">
              		<!-- 通过填充的方式将对应的新闻列表填充在此处 -->
              </ul>
              <div id="btn" style=""text-align:center"">
              	<button id="btnMore" type="button" class="am-btn am-btn-default" style="width:80%">点击加载更多...</button>
              </div>
             
               </div>
            </div>
          </div>
        </div>
        <div class="pet_article_footer_info">Copyright(c)2015 PetShow All Rights Reserved</div>
      </div>
    </div>
<script>
	$(function(){
	    // 动态计算新闻列表文字样式
	    auto_resize();
	    $(window).resize(function() {
	        auto_resize();
	    });
	    $('.am-list-thumb img').load(function(){
	        auto_resize();
	    });
	    $('.pet_article_like li:last-child').css('border','none');
	        function auto_resize(){
	        $('.pet_list_one_nr').height($('.pet_list_one_img').height());
	                // alert($('.pet_list_one_nr').height());
	    }
	        $('.pet_article_user').on('click',function(){
	            if($('.pet_article_user_info_tab').hasClass('pet_article_user_info_tab_show')){
	                $('.pet_article_user_info_tab').removeClass('pet_article_user_info_tab_show').addClass('pet_article_user_info_tab_cloes');
	            }else{
	                $('.pet_article_user_info_tab').removeClass('pet_article_user_info_tab_cloes').addClass('pet_article_user_info_tab_show');
	            }
	        });
	
	        $('.pet_head_gd_ico').on('click',function(){
	            $('.pet_more_list').addClass('pet_more_list_show');
	       });
	        $('.pet_more_close').on('click',function(){
	            $('.pet_more_list').removeClass('pet_more_list_show');
	        });
	});
</script>
</body>
  </html>