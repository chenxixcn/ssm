<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
			<link rel="stylesheet" href="/css/amazeui.min.css">
		<link rel="stylesheet" href="/css/admin.css">
		<link rel="stylesheet" href="/css/app.css">
		<style>
			.admin-main{
				padding-top: 0px;
			}
		</style>
	</head>
	<body>
		
		<div class="am-cf admin-main">
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					<div class="am-g">
						<form class="am-form am-form-horizontal" action="/depart/insertDepart.do" target="right" method="post" style="padding-top: 30px;">
							<div class="am-form-group">
								<label for="dname" class="am-u-sm-3 am-form-label">
									部门名称
								</label>
								<div class="am-u-sm-9">
									<input id="dname" required="" placeholder="请输入部门名称" value="" name="dname" type="text">
									<small id="helpRole">输入部门名称。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="duty" class="am-u-sm-3 am-form-label">
									备注说明
								</label>
								<div class="am-u-sm-9">
									<textarea id="duty" rows="" cols="50" placeholder="请输入部门职责" name="duty"></textarea>
									<small>部门职责。</small>
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="addRole" class="am-btn am-btn-success" value="添加部门" type="submit">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
