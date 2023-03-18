<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
			<link rel="stylesheet" href="/css/amazeui.min.css">
		<link rel="stylesheet" href="/css/admin.css">
		<link rel="stylesheet" href="/css/app.css">
		<link rel="stylesheet" href="/plugins/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/plugins/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="/plugins/datepicker/datepicker3.css">
		<style>
			.admin-main{
				padding-top: 0px;
			}
			.am-form-group{
				margin-top: 30px;
			}
		</style>
	</head>
	<body>
		
		<div class="am-cf admin-main">
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					<div class="am-g">
						<form class="am-form am-form-horizontal" action="/note/insertNote.do" target="right" method="post" style="padding-top: 30px;">
							<input value="${emp.eid}" name="eid" type="hidden">
							<div class="am-form-group">
								<label for="realname" class="am-u-sm-3 am-form-label">
									申请人
								</label>
								<div class="am-u-sm-9">
									<input id="realname" required="" placeholder="获取申请人姓名" readonly="readonly" value="${emp.realname}" name="realname" type="text">
								</div>
							</div>
							<div class="am-form-group">
								<label for="title" class="am-u-sm-3 am-form-label">
									请假标题
								</label>
								<div class="am-u-sm-9">
									<input type="text" id="title" name="title" placeholder="请输入请假标题"/>
								</div>
							</div>
							<div class="am-form-group">
								<label for="context" class="am-u-sm-3 am-form-label">
									请假原因
								</label>
								<div class="am-u-sm-9">
									<textarea rows="" id="context" cols="50" placeholder="请输入请假原因" name="context"></textarea>
								</div>
							</div>
							<div class="am-form-group">
								<label for="startdate" class="am-u-sm-3 am-form-label">
									开始时间
								</label>
								<div class="am-u-sm-9">
									<div class="data">
										<div class="input-group date">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input type="date" name="startdate" placeholder="请输入请假开始时间"  class="form-control pull-right" id="startdate">
										</div>
									</div>
								</div>
							</div>
							<div class="am-form-group">
								<label for="enddate" class="am-u-sm-3 am-form-label">
									结束时间
								</label>
								<div class="am-u-sm-9">
									<div class="data">
										<div class="input-group date">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input type="date" name="enddate" placeholder="请输入请假结束时间"  class="form-control pull-right" id="enddate">
										</div>
									</div>
								</div>
							</div>
							<div class="am-form-group">
								<label for="length" class="am-u-sm-3 am-form-label">
									请假时长
								</label>
								<div class="am-u-sm-9">
									<input type="text" id="length" name="length" placeholder="请假时长"/>
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="addRole" class="am-btn am-btn-success" value="申请请假" type="submit">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script src="js/jquery-1.11.3.min.js"></script>
		<script src="plugins/datepicker/bootstrap-datepicker.js"></script>
		<script src="plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
		<script>
			$(document).ready(function() {
				$('#startDate').datepicker({
					autoclose: true,
					language: 'zh-CN'
				});
				$('#endDate').datepicker({
					autoclose: true,
					language: 'zh-CN'
				});
			});
		</script>
	</body>
</html>
