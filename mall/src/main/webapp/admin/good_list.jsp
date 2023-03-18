<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>商品列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="/admin/css/bootstrap.css"/>
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
	<div class="text-right"><a class="btn btn-warning" href="/goods/getAllType">添加商品</a></div>
	
	<br>
		
	<ul role="tablist" class="nav nav-tabs">

        <li <C:if test="${type!=1}">class="active"</C:if> role="presentation"><a href="/goods/goodsList">全部商品</a></li>
        <li <C:if test="${type==1}">class="active"</C:if> role="presentation"><a href="/goods/goodsList?type=1">今日推荐</a></li>
    </ul>
    
   
	
	<br>

	<table class="table table-bordered table-hover">

	<tr>
		<th width="3%">ID</th>
		<th width="5%">图片</th>
		<th width="10%">名称</th>
		<th width="10%">介绍</th>
		<th width="5%">规格</th>
		<th width="3%">价格</th>
		<th width="5%">类目</th>
		<th width="3%">库存</th>
		<th width="3%">销量</th>
		<th width="5%">操作</th>
	</tr>
	
	<C:forEach items="${info.list}" var="goods">
        <tr>
            <td><p>${goods.id}</p></td>
            <td><p><a href="../index/detail?id=1" target="_blank"><img src="${goods.cover}" width="100px"></a></p></td>
            <td><p><a href="../index/detail?id=1" target="_blank">${goods.name}</a></p></td>
            <td><p>${goods.intro}</p></td>
            <td><p>${goods.spec}</p></td>
            <td><p>${goods.price}</p></td>
            <td><p>${goods.typeName}</p></td>
            <td><p>${goods.stock}</p></td>
            <td><p>${goods.sales}</p></td>
            <td>
                <p>
                    <C:if test="${goods.type!=1}">
                        <a class="btn btn-success topDelete" href="/tops/addTop?good_id=${goods.id}" type="2" goodId="1" text="加入今日推荐">加入今日推荐</a>
                    </C:if>
                    <C:if test="${goods.type==1}">
                        <a class="btn bg-primary topDelete" href="/tops/delTop?good_id=${goods.id}" type="1" goodId="1" text="移出今日推荐">移出今日推荐</a>
                    </C:if>                </p>
                <a class="btn btn-info" href="/goods/getGoodsInfo?id=${goods.id}&page=${info.pageNum}">修改</a>
                <a class="btn btn-danger" href="/goods/delGoods?id=${goods.id}&page=${info.pageNum}">删除</a>
            </td>
        </tr>
    </C:forEach>
	</table>

	<br>
	<div style='text-align:center;'>

		<a class='btn btn-info' <c:if test="${info.pageNum==1}">disabled</c:if>  href='/goods/goodsList?page=${info.pages}&type=${type}'>首页</a>
		<a class='btn btn-info' <c:if test="${info.pageNum==1}">disabled</c:if>  href='/goods/goodsList?page=${info.pageNum-1}&type=${type}'>上一页</a>
		<h2 style='display:inline;'>[${info.pageNum}/${info.pages}]</h2>
		<h2 style='display:inline;'>[${info.total}]</h2>
		<a class='btn btn-info' <c:if test="${info.pageNum==info.pages}">disabled</c:if>  href='/goods/goodsList?page=${info.pageNum+1}&type=${type}'>下一页</a>
		<a class='btn btn-info' <c:if test="${info.pageNum==info.pages}">disabled</c:if>  href='/goods/goodsList?page=${info.pages}&type=${type}'>尾页</a>
		<input type='text' id="page" class='form-control' style='display:inline;width:60px;'/>
		<a class='btn btn-info' onclick="toPage()">GO</a>
	</div>
	<br>
</div>


<script type="text/javascript" src="/admin/js/jquery.js"></script>
<script type="text/javascript">
    function toPage(){
        var page=$("#page").val();
        window.location.href="/goods/goodsList?page="+page+"&type="+${type};
    }
$(function(){
	$(document).on("click", ".topSave", function(){
		var type = $(this).attr("type");
		var goodId = $(this).attr("goodId");
		var text = $(this).attr("text");
		var old = $(this).text();
		var obj = this;
		$.post("topSave", {"goodId": goodId, "type": type}, function(data){
			if(data=="ok"){
				$(obj).text(text).attr("class", "btn btn-success topDelete").attr("text", old);
			}else{
				alert("操作失败!");
			}
		}, "text");
	});
	$(document).on("click", ".topDelete", function(){
		var type = $(this).attr("type");
		var goodId = $(this).attr("goodId");
		var text = $(this).attr("text");
		var old = $(this).text();
		var obj = this;
		$.post("topDelete", {"goodId": goodId, "type": type}, function(data){
			if(data=="ok"){
				$(obj).text(text).attr("class", "btn btn-primary topSave").attr("text", old);
			}else{
				alert("操作失败!");
			}
		}, "text");
	});
});
</script>
</body>
</html>