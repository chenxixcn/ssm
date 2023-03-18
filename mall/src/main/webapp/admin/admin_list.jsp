
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>管理员列表</title>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="/admin/css/bootstrap.css"/>
</head>
<body>
<div class="container">

	<jsp:include page="header.jsp"/>
	<div class="text-right"><a class="btn btn-warning" href="/admin/addAdmin">添加管理员</a></div>
		
	<br>
	
	<table class="table table-bordered table-hover">

		<tr>
			<th width="5%">ID</th>
			<th width="10%">用户名</th>
			<th width="10%">操作</th>
		</tr>
		
		<C:forEach items="${info.list}" var="admin">
			 <tr>
				<td><p>${admin.id}</p></td>
				<td><p>${admin.username}</p></td>
				<td>
					<p>
                        <C:if test="${admin.username=='admin'}">
                        系统保护用户
                        </C:if>
                        <C:if test="${admin.username!='admin'}">
                            <a class="btn btn-info" href="admin_reset.jsp?id=2&username=777">重置密码</a>
                            <a class="btn btn-danger" href="/admin/delAdmin?id=${admin.id}">删除</a>
                        </C:if>
                    </p>
					
				</td>
			</tr>
        </C:forEach>

		 
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
</body>
</html>

