<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>登录</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/index/css/public.css">
	<link rel="stylesheet" type="text/css" href="/index/css/common.css">
	<link rel="stylesheet" type="text/css" href="/index/css/logon.css">
	<link rel="stylesheet" type="text/css" href="/index/css/font.css">
</head>
<body>
	
	
	<div id="main" class="logincoent">
	
		<div class="rebackgroundimg">
			<div class="registruer">
				<div class="regrnamepwd">
					<p class="iteljk">登录<span><a href="/index/register.jsp">未注册请先注册</a></span></p>
					<form action="/index/login" method="post">
					   <ul class="ul_form">
							<li class="user">
								<i class="iconfont icon-yonghu"></i>
								<input type="text" class="username" name="username" placeholder="请输入用户名" value="user">
							</li>
							<li class="pwdmia">
								<i class="iconfont icon-mima"></i>
								<input type="password" class="pwd" name="password" placeholder="请再次输入密码" value="123456">
							</li>
						</ul>
						<input type="submit" value="立即登录" class="sub">
						<div style="color: red;font-size: 16px;text-align: center;margin-top: 20px;">${msg}</div>
					</form>
				</div>
			</div>
		</div>
		
	</div>


</body>
<script src="/index/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

</script>
</html>