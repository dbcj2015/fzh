<%@page contentType = "text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>uimaker信息管理系统</title> 
    <!-- 一定要使用绝对路径访问 /工程名/资源路径 -->
    <link href="/icbc02/resources/css/base.css" rel="stylesheet">
    <link href="/icbc02/resources/css/login.css" rel="stylesheet">

</head> 
<body class="white">
	
	<div class="login-bd">
		<div class="bd-inner">
			<div class="inner-wrap">
				<div class="lg-zone">
					<div class="lg-box">
						
						<div class="lg-label">
						
						<h4 ><img alt="" src="/icbc02/resources/images/logo.png" style="width:150px;margin-right: 50px">用户登录</h4></div>
						<c:if test="${message != null}">
						<div class="alert alert-error clearfix">
			              <i class="iconfont">&#xe62e;</i>
			              <span>${message }</span>
			            </div>
			            </c:if>
						<form id="frmLogin" action="/icbc02/icbc/register" method="post">
							<div class="lg-username input-item clearfix">
								<i class="iconfont">&#xe60d;</i>
								<input type="text" name="username" placeholder="账号/邮箱">
							</div>
							<div class="lg-password input-item clearfix">
								<i class="iconfont">&#xe634;</i>
								<input type="password" name="password" placeholder="请输入密码">
							</div>
							<div class="enter">
								<a href="javascript:document.getElementById('frmLogin').submit();" class="purchaser" style="width:300px">登&nbsp;&nbsp;录</a>
								
							</div>
						</form>
						<div class="line line-y"></div>
						<div class="line line-g"></div>
					</div>
				</div>
				<div class="lg-poster"></div>
			</div>
		</div>
	</div>
	<div class="login-ft">
		<div class="ft-inner">
			<div class="about-us">
				<a href="javascript:;">关于我们</a>
				<a href="javascript:;">法律声明</a>
				<a href="javascript:;">服务条款</a>
				<a href="javascript:;">联系方式</a>
			</div>
			<div class="address">地址：北京市海淀区西三旗建材城西路85号神州科技园B座&nbsp;邮编：100000&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2016&nbsp;-&nbsp;2017&nbsp;版权所有</div>
			<div class="other-info">建议使用IE8及以上版本浏览器&nbsp;京ICP备&nbsp;09003078号&nbsp;E-mail：qiyi@sxt.com</div>
		</div>
	</div>
</body> 
</html>
    
<script type="text/javascript">

</script>
