<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>

		<title>热销排行</title>

		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/public.css">
		<link rel="stylesheet" type="text/css" href="css/reclassify.css">
	</head>
	<body>

        <c:if test="${userInfo==null}">
            <jsp:include page="header.jsp"/>
        </c:if>
        <c:if test="${userInfo!=null}">
            <jsp:include page="header-login.jsp"/>
    </c:if>
		<div id="main" class="main">

			<!-- 该页面用来展示商品列表。  1.查询后需要展示多个商品。  2.点击商品类型需要展示多个商品 -->

			<!-- 如果控制器没有传递type和name过来，就不用管这段代码。 -->


			<div class="goodscont clearfix">

            <c:forEach items="${info.list}" var="goods">
				<div class="goods-box animated wobble">
					<div class="goods">
						<a target="_blank" href="detail?id=${goods.id}">
							<div class="img-box">
								<img src="${goods.cover}">
							</div>
						</a>
						<a target="_blank" href="detail?id=${goods.id}">
							<p class="goodsname">${goods.name}</p>
						</a>
						<p class="goods-descript">${goods.intro}</p>
						<p class="goods-spec">${goods.spec}</p>
						<p class="goodsprices" style="display:block;">
							<span class="yj">￥<span class="yjcont">${goods.price}</span></span>
						</p>
						<p class="addcart" data-id="${goods.id}" style="display:none;">
							<i class="iconfont icon-gouwuche3"></i>加入购物车
						</p>
					</div>
				</div>
            </c:forEach>

			</div>

            <div class='holder'>

                <a href='todayHotNew?page=1&url=${url}'>首页</a>
                <a <c:if test="${info.pageNum!=1}">href='todayHotNew?page=${info.pageNum-1}&url=${url}'</c:if> >上页</a>
                                <c:forEach begin="1" var="i" step="1" end="${info.pages}">
                                    <a <c:if test="${info.pageNum==i}">class='jp-current'</c:if> href='todayHotNew?page=${i}&url=${url}'>${i}</a>
                                </c:forEach>
                <a <c:if test="${info.pageNum!=info.pages}">href='todayHotNew?page=${info.pageNum+1}&url=${url}'</c:if> >下页</a>
                <a href='todayHotNew?page=${info.pages}&url=${url}'>尾页</a>
            </div>

		</div>

	</body>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		// 显示隐藏购物车
		$(".goods-box").on("mouseenter", function() {
			$(this).addClass("active")
			$(this).find(".addcart").show()
			$(this).find(".reserve").show()
			$(this).find(".m_stop").show()
			$(this).find(".goodsprices").hide()
		});
		$(".goods-box").on("mouseleave", function() {
			$(this).removeClass("active")
			$(this).find(".addcart").hide()
			$(this).find(".reserve").hide()
			$(this).find(".m_stop").hide()
			$(this).find(".goodsprices").show()
		});
	</script>
</html>
