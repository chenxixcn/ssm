<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="/css/amazeui.min.css">
		<link rel="stylesheet" href="/css/admin.css">
		<style>
			.admin-main{
				padding-top: 0px;
			}
		</style>
	</head>
	<body>
		<div class="am-cf admin-main">
			<div class="admin-content">
				<div class="admin-content-body">
					<div class="am-g">
						<form class="am-form am-form-horizontal" method="post" style="padding-top:30px;" data-am-validator>
							<div class="am-form-group">
								<label for="doc-vld-pwd-1" class="am-u-sm-3 am-form-label">
									新密码 </label>
								<div class="am-u-sm-9">
									<input type="password" id="doc-vld-pwd-1" required placeholder="请输入新密码" name="password"> <small>输入新密码。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="doc-vld-pwd-2" class="am-u-sm-3 am-form-label">
									重复密码</label>
								<div class="am-u-sm-9">
									<input type="password" id="doc-vld-pwd-2" required placeholder="请输入重复密码" name="pwd" data-equal-to="#doc-vld-pwd-1"
									 required> <small>输入重复密码。</small>
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input type="button" id="btns" onclick="btnclose(${emp.epass})" class="am-btn am-btn-success" value="修改密码" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="/js/jquery-1.11.3.min.js">
		</script>
		<script type="text/javascript" src="/myplugs/js/plugs.js">
		</script>
		<script>
			function btnclose(epass) {
				var pwd1=document.getElementById("doc-vld-pwd-1").value;
				var pwd2=document.getElementById("doc-vld-pwd-2").value;
				if(pwd1!=pwd2){
                    alert("两次密码不一致");
                    return false;
                }
				if(pwd1==epass){
					alert("密码不能与原密码相同");
					return false;
				}
				$.ajax({
					url:"/employee/updatePass.do",
					type:"get",
					data:{
						epass:pwd1
					},
					success: function (result) {
						if(result==1){
							alert("密码修改成功，即将跳转登录页面!");
							top.window.location.href="/login.jsp";
						}
					}
				})
			}
		</script>
	</body>
</html>
