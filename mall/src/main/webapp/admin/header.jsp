<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
</head>
<body>

	<nav class="navbar navbar-default" role="navigation" style="background-color:#fbf8ef;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/admin/index.jsp">后台首页</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li <c:if test="${flag==1}">class="active"</c:if> ><a href="/types/typeList">类目管理</a></li>
                    <li <c:if test="${flag==2}">class="active"</c:if> ><a href="/goods/goodsList">商品管理</a></li>
                    <li <c:if test="${flag==3}">class="active"</c:if> ><a href="/orders/orderList">订单管理</a></li>
                    <li <c:if test="${flag==4}">class="active"</c:if> ><a href="/users/usersList">客户管理</a></li>
                    <li <c:if test="${flag==5}">class="active"</c:if> ><a href="/admin/selectAll">管理员</a></li>
                    <li ><a href="/admin/logOut">退出</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>