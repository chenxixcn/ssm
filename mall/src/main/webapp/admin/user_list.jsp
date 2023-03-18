<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>客户列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="/admin/css/bootstrap.css"/>
</head>
<body>
<div class="container">

	<jsp:include page="header.jsp"/>
	<div class="text-right"><a class="btn btn-warning" href="/users/addUser">添加客户</a></div>
		
	<br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="5%">用户</th>
		<th width="10%">姓名</th>
		<th width="10%">电话</th>
		<th width="10%">地址</th>
		<th width="15%">操作</th>
	</tr>
	<c:forEach items="${info.list}" var="user">
		<tr>
         	<td><p>${user.id}</p></td>
         	<td><p>${user.username}</p></td>
         	<td><p>${user.name}</p></td>
         	<td><p>${user.phone}</p></td>
         	<td><p>${user.address}</p></td>
			<td>
				<a class="btn btn-info" href="user_reset.jsp?id=1&username=user&password=HAMVRZRssPCADKqGjGWJtQ==">重置密码</a>
				<a class="btn btn-primary" href="/users/getUser?id=${user.id}">修改</a>
				<a class="btn btn-danger" href="/users/delUser?id=${user.id}">删除</a>
			</td>
       	</tr>
    </c:forEach>
     
     
	</table>

	<br>
	<div style='text-align:center;'>
        <a class='btn btn-info' <c:if test="${info.pageNum==1}">disabled</c:if>  href='/users/usersList?page=${info.pages}'>首页</a>
        <a class='btn btn-info' <c:if test="${info.pageNum==1}">disabled</c:if>  href='/users/usersList?page=${info.pageNum-1}'>上一页</a>
        <h2 style='display:inline;'>[${info.pageNum}/${info.pages}]</h2>
        <h2 style='display:inline;'>[${info.total}]</h2>
        <a class='btn btn-info' <c:if test="${info.pageNum==info.pages}">disabled</c:if>  href='/users/usersList?page=${info.pageNum+1}'>下一页</a>
        <a class='btn btn-info' <c:if test="${info.pageNum==info.pages}">disabled</c:if>  href='/users/usersList?page=${info.pages}'>尾页</a>
        <input type='text' id="page" class='form-control' style='display:inline;width:60px;'/>
        <a class='btn btn-info' onclick="toPage()">GO</a>
    </div>
	<br>
</div>
<script type="text/javascript" src="/admin/js/jquery.js"></script>
<script type="text/javascript">
    function toPage(){
        var page=$("#page").val();
        window.location.href="/users/usersList?page="+page;
    }
</script>
</body>
</html>