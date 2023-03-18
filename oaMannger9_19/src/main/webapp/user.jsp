<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="/css/amazeui.min.css" />
		<link rel="stylesheet" href="/css/admin.css" />
	</head>

	<body>
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理</strong><small></small></div>
			</div>
			<hr>
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default btnAdd"><span class="am-icon-plus"></span> 新增</button>
							<button type="button" style="margin-left: 20px;" class="am-btn am-btn-default btnIn">
								<span class="am-icon-child"></span> 在职员工
							</button>
							<button type="button"  style="margin-left: 20px;" class="am-btn am-btn-default btnOut">
								<span class="am-icon-child"></span> 离职员工
							</button>
						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">
				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<form action="/employee/selectEmployeeByRealName.do" method="post">
						<div class="am-input-group am-input-group-sm" style="margin-right: 30px;">
							<input type="hidden" name="estatus" value="${estatus}" class="am-form-field">
							<input type="text" name="realname" value="${realname}" class="am-form-field" placeholder="请输入用户姓名">
							<span class="am-input-group-btn">
							<button class="am-btn am-btn-default" type="submit">搜索</button>
						</span>
						</div>
					</form>
				</div>
			</div>
			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr>
									<th class="table-check"><input type="checkbox" id="chkAll"></th>
									<th class="table-id" style="width:100px;">ID</th>
									<th class="table-title">姓名</th>
									<th class="table-type">用户名</th>
									<th class="table-author am-hide-sm-only">性别</th>
									<th class="table-dname">所在部门</th>
									<th class="table-role">用户角色</th>
									<th class="table-set">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${info.list}" var="employee">
								<tr>
									<td><input type="checkbox" name="chk"></td>
									<td>${employee.eid}</td>
									<td>
										<a href="#">${employee.realname}</a>
									</td>
									<td>${employee.ename}</td>
									<td class="am-hide-sm-only">${employee.esex==0?"<span class='am-badge  am-badge-primary '>男</span>":"<span class='am-badge am-badge-danger'>女</span>"}</td>
									<td>${employee.depart.dname}</td>
									<td>${employee.position==0?"boss":employee.position==1?"经理":"普通员工"}</td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<button type="button" onclick="updateEmployee(${employee.eid},${info.pageNum})" id="depart_22" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit"><span class="am-icon-pencil-square-o"></span> 编辑</button>
												<c:if test="${employee.estatus==0}">
												<button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="updateStatus(${employee.eid},${employee.estatus})"><span class="am-icon-trash-o"></span> 删除</button></div>
												</c:if>
											<c:if test="${employee.estatus==1}">
											<button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="updateStatus(${employee.eid},${employee.estatus})"><span class="am-icon-trash-o"></span> 恢复</button></div>
										</c:if>
										</div>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>
					<div class="am-cf" style="margin-right: 30px;">
						共 ${info.total} 条记录
						<div class="am-fr">
							<ul class="am-pagination">
								<c:if test="${info.pageNum!=1}">
									<li class="am-active">
										<a href="/employee/selectEmployeeByStatus.do?estatus=${estatus}&page=${info.pageNum-1}"> << </a>
									</li>
								</c:if>
								<c:forEach begin="1" end="${info.pages}" step="1" var="i">
									<li>
										<a href="/employee/selectEmployeeByStatus.do?estatus=${estatus}&page=${i}">${i}</a>
									</li>
								</c:forEach>
								<c:if test="${info.pageNum!=info.pages}">
									<li class="am-active">
										<a href="/employee/selectEmployeeByStatus.do?estatus=${estatus}&page=${info.pageNum+1}"> >> </a>
									</li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="/js/jquery-1.11.3.min.js" ></script>
		<script type="text/javascript" src="/myplugs/js/plugs.js" ></script>
		<script>
			$(function() {
				$(".btnAdd").click(function() {
					$.jq_Panel({
						title: "添加员工",
						iframeWidth: 600,
						iframeHeight: 560,
						url: "/employee/selectDepart.do?dstatus=0"
					});
				});

			});
			$(".btnOut").click(function () {
				window.location.href="/employee/selectEmployeeByStatus.do?estatus=1";
			});
			$(".btnIn").click(function () {
				window.location.href="/employee/selectEmployeeByStatus.do?estatus=0";
			});
			function updateStatus(eid,estatus) {
				window.location.href="/employee/updateEmployee.do?estatus="+estatus+"&eid="+eid;
			}
			function updateEmployee(eid,pageNum){
				$.jq_Panel({
					title: "编辑员工",
					iframeWidth: 600,
					iframeHeight: 560,
					url: "/employee/selectEmployeeByEid.do?eid="+eid+"&page="+pageNum
				});
			}
		</script>
	</body>

</html>