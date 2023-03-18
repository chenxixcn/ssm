<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>订单列表</title>
<link rel="stylesheet" href="/admin/css/bootstrap.css"/>
</head>
<body>
<div class="container">
	<jsp:include page="header.jsp"/>
	<br>
		<ul role="tablist" class="nav nav-tabs">
        <li <c:if test="${status==0}">class="active"</c:if> role="presentation" ><a href="/orders/orderList">全部订单</a></li>
        <li <c:if test="${status==1}">class="active"</c:if> role="presentation"><a href="/orders/orderList?status=1">未付款</a></li>
        <li <c:if test="${status==2}">class="active"</c:if> role="presentation"><a href="/orders/orderList?status=2">已付款</a></li>
        <li <c:if test="${status==3}">class="active"</c:if> role="presentation"><a href="/orders/orderList?status=3">配送中</a></li>
        <li <c:if test="${status==4}">class="active"</c:if> role="presentation"><a href="/orders/orderList?status=4">已完成</a></li>
    </ul>
    
    <br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="5%">总价</th>
		<th width="15%">商品详情</th>
		<th width="20%">收货信息</th>
		<th width="10%">订单状态</th>
		<th width="10%">支付方式</th>
		<th width="10%">下单用户</th>
		<th width="10%">下单时间</th>
		<th width="10%">操作</th>
	</tr>
        <c:forEach items="${info.list}" var="order">
         <tr>
         	<td><p>${order.id}</p></td>
         	<td><p>${order.total}</p></td>
         	<td>
                <c:forEach items="${order.items}" var="items">
		         	<a target="_blank" href="../index/detail?id=32"><p>${items.goods.name}</p></a>
		         	<p>¥${items.price} x ${items.amount}</p>
                </c:forEach>
         	</td>
         	<td>
         		<p>${order.name}</p>
         		<p>${order.address}</p>
         		<p>${order.phone}</p>
         	</td>
			<td>
				<p>
					${order.statusStr}
				</p>
			</td>
			<td>
				<p>
                    ${order.paytypeStr}
				</p>
			</td>
			<td><p>${order.users.name}</p></td>
			<td><p>${order.systimeStr}</p></td>
			<td>
                <c:if test="${order.status==1 || order.status==4 }">
                    <a class="btn btn-danger" href="/orders/delOrders?id=${order.id}">删除</a>
                </c:if>

                <c:if test="${order.status==2}">
                    <a class="btn btn-success" href="/orders/editOrders?id=${order.id}&status=3">发货</a>
                </c:if>

                <c:if test="${order.status==3}">
                    <a class="btn btn-primary" href="/orders/editOrders?id=${order.id}&status=4">完成</a>
                </c:if>
			</td>
       	</tr>
        </c:forEach>
     
	</table>

	<br>
	<div style='text-align:center;'>
        <a class='btn btn-info' <c:if test="${info.pageNum==1}">disabled</c:if>  href='/orders/orderList?page=1&status=${status}'>首页</a>
		<a class='btn btn-info' <c:if test="${info.pageNum==1}">disabled</c:if>  href='orderList?page=${info.pageNum-1}&status=${status}'>上一页</a>
		<h2 style='display:inline;'>[${info.pageNum}/${info.pages}]</h2>
		<h2 style='display:inline;'>[${info.total}]</h2>
		<a class='btn btn-info' <c:if test="${info.pageNum==info.pages}">disabled</c:if> href='orderList?page=${info.pageNum+1}&status=${status}'>下一页</a>
		<a class='btn btn-info' <c:if test="${info.pageNum==info.pages}">disabled</c:if> href='orderList?page=${info.pages}&status=${status}'>尾页</a>
		<input type='text' id="page" class='form-control'/>
		<a class='btn btn-info' onclick="toPage()">GO</a>
	</div>
	<br>
</div>
<script src="/admin/js/jquery.js"></script>
<script>
    function  toPage() {
        var page=$("#page").val();
        window.location.href="/orders/orderList?page="+page+"&status=${status}";
    }
</script>
</body>
</html>