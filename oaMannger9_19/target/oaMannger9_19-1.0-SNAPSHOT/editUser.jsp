<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
			<link rel="stylesheet" href="css/amazeui.min.css">
		<link rel="stylesheet" href="css/admin.css">
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
						<form class="am-form am-form-horizontal" action="/employee/updateEmployee.do?" method="post" target="right" style="padding-top: 30px;">
							<input type="hidden"  name="eid" value="${employees.eid}"/>
							<input type="hidden"  name="estatus" value="${employees.estatus}"/>
                            <input type="hidden"  name="page" value="${page}"/>
							<div class="am-form-group">
								<label for="realname" class="am-u-sm-3 am-form-label">
									员工姓名
								</label>
								<div class="am-u-sm-9">
									<input id="realname" required="" placeholder="请输入员工姓名" value="${employees.realname}" name="realname" type="text">
									<small id="helpRole">输入员工姓名。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="ename" class="am-u-sm-3 am-form-label">
									用户名
								</label>
								<div class="am-u-sm-9">
									<input id="ename" type="text" name="ename" value="${employees.ename}" placeholder="请输入用户用户名"  />
									<small>输入用户名。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="epass" class="am-u-sm-3 am-form-label">
									密码
								</label>
								<div class="am-u-sm-9">
									<input id="epass" type="password" name="epass" value="${employees.epass}" placeholder="请输入用户密码"  />
									<small>输入密码。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="esex" class="am-u-sm-3 am-form-label">
									性别
								</label>
								<div class="am-u-sm-9" id="esex">

									<input type="radio" name="esex" value="0" <c:if test="${employees.esex==0}" >checked="checked"</c:if>/> 男
									<input type="radio" name="esex" value="1" <c:if test="${employees.esex==1}" >checked="checked"</c:if>  style="margin-left: 30px;"/> 女<br>
									<small>选择性别。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="did" class="am-u-sm-3 am-form-label">
									所在部门
								</label>
								<div class="am-u-sm-9">
									<select placeholder="请选择所在部门" id="did" name="did">
										<c:forEach items="${departs}" var="depart">
											<c:if test="${employees.did==depart.did}">
												<option value="${depart.did}" selected>${depart.dname}</option>
											</c:if>
											<c:if test="${employees.did!=depart.did}">
												<option value="${depart.did}">${depart.dname}</option>
											</c:if>
										</c:forEach>
									</select>

									<small>选择所在部门。</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="position" class="am-u-sm-3 am-form-label">
									用户角色
								</label>
								<div class="am-u-sm-9">
									<select placeholder="请选择用户角色" id="position" name="position">
										<option value="2" <c:if test="${employees.position==2}">selected</c:if>>普通员工</option>
										<option value="1" <c:if test="${employees.position==1}">selected</c:if>>部门主管</option>
									</select>
									<small>请选择用户角色。</small>
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="addRole" class="am-btn am-btn-success" value="编辑员工" type="submit">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
