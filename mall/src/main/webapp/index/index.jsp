<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>首页</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/index/css/public.css">
	<link rel="stylesheet" type="text/css" href="/index/css/index.css">
	<link rel="stylesheet" type="text/css" href="/index/css/swiper.css">
</head>
<body>
    <c:if test="${userInfo==null}">
        <jsp:include page="header.jsp"/>
    </c:if>
    <c:if test="${userInfo!=null}">
        <jsp:include page="header-login.jsp"/>
    </c:if>
	<div class="main">
		<!--今日推荐-->
		<div class="m_content m_today_box">
			<div id="m_today">
				<div class="m-hot-tit clearfix">
					<div class="m-hot-tit-left"><span>今日推荐</span></div>
					<a href="/index/todayHotNew?url=today"><div class="m-hot-tit-right"><span>更多推荐 ></span></div></a>
				</div>
				<div class="mdd_today_box clearfix">
					<div class="m_today_center clearfix">
						<c:forEach items="${topGoods}" var="goods">
							<div class="goods-box2 ">
								<div class="goods clearfix">
									<a href="detail?id=${goods.id}">
										<div class="img-box">
											<img src="${goods.cover}">
										</div>
									</a>
									<div class="goods-right">
										<a href="detail?id=${goods.id}">
											<p class="goodsname">${goods.name}</p>
										</a>
										<p class="goods-descript">${goods.intro}</p>
										<p class="goods-spec">${goods.spec}</p>
										<p class="goodsprices"><span class="yj">&yen;<span class="yjcont">${goods.price}</span></span></p>
										<p class="addcart" data-id="${goods.id}"><i class="iconfont icon-gouwuche3"></i>加入购物车</p>
									</div>
								</div>
							</div>
                        </c:forEach>
					</div>
				</div>
			</div>
		</div>
		
	
		<!--热销排行-->
		<!-- 排名前三个热销商品 -->
		<div class="m_content mdd-top">
			<div id="m_hot">
				<div class="m-hot-tit clearfix">
					<div class="m-hot-tit-left"><span>热销排行</span></div>
					<a href="/index/todayHotNew?url=hot"><div class="m-hot-tit-right"><span>更多热销 ></span></div></a>
				</div>
				<div class="m_hot_one clearfix">
				
					<c:forEach items="${goodsBySaleTree}" var="goods">
						<div class="goods-box1 ">
							<div class="goods clearfix">
								<div class="m-pm" style="background-image: url(img/m_top_1.png)"></div>
								<a href="detail?id=${goods.id}">
									<div class="img-box">
										<img src="${goods.cover}">
									</div>
								</a>
								<div class="goods-right">
									<a href="detail?id=${goods.id}">
										<p class="goodsname">${goods.name}</p>
									</a>
									<p class="goods-descript">${goods.intro}</p>
									<p class="goods-spec">${goods.spec}</p>
									<p class="goodsprices"><span class="yj">&yen;<span class="yjcont">${goods.price}</span></span></p>
									<p class="addcart" data-id="${goods.id}"><i class="iconfont icon-gouwuche3"></i>加入购物车</p>
								</div>
							</div>
						</div>
                    </c:forEach>
					
				</div>
				<!-- 排名第四-八的热销商品 -->
				<div class="m_hot_two clearfix">
                    <c:forEach items="${goodsBySaleFive}" var="goods">
						<div class="goods-box ">
							<div class="goods clearfix">
								<div class="m-pm"><span>4</span></div>
								<a href="detail?id=${goods.id}">
									<div class="img-box">
										<img src="${goods.cover}">
									</div>
								</a>
								<div class="goods-right">
									<a href="detail?id=${goods.id}">
										<p class="goodsname">${goods.name}</p>
									</a>
									<p class="goods-descript">${goods.intro}</p>
									<p class="goods-spec">${goods.spec}</p>
									<p class="goodsprices"><span class="yj">&yen;<span class="yjcont">${goods.price}</span></span></p>
									<p class="addcart" data-id="${goods.id}"><i class="iconfont icon-gouwuche3"></i>加入购物车</p>
								</div>
							</div>
						</div>
                    </c:forEach>
				</div>
			</div>
		</div>	
		
		<!--产品分类-->
		<c:forEach items="${allTypes}" var="type">
			<div class="main Louti vegetable">
				<div class="m-hot-tit clearfix">
					<div class="m-hot-tit-left"><span>${type.name}</span></div>
					<a href="/index/todayHotNew?url=type&&id=${type.id}"><div class="m-hot-tit-right">查看更多 ></div></a>
				</div>
				<div class="main-box">
					<div class="m-swiper-container">
						<div class="swiper-wrapper">
                            <div class="swiper-slide">
								<c:forEach items="${goodsMap.get(type.name)}" var="goods" varStatus="stauts">
									<div class="goods-box ">
										<div class="goods">
											<a href="detail?id=${goods.id}">
												<div class="img-box">
													<img src="${goods.cover}">
												</div>
											</a>
											<a href="detail?id=${goods.id}">
												<p class="goodsname">${goods.name}</p>
											</a>
											<p class="goods-descript">${goods.intro}</p>
											<p class="goods-spec">${goods.spec}</p>
                                            <p class="goodsprices"><span class="yj">&yen;<span class="yjcont">${goods.price}</span></span></p>
											<p class="addcart" data-id="${goods.id}"><i class="iconfont icon-gouwuche3"></i>加入购物车</p>
										</div>
									</div>
                                    <c:if test="${stauts.count%5==0}">
                                            </div><div class="swiper-slide">
                                    </c:if>
                                </c:forEach>
                            </div>
							</div>
                        <div class="swiper-pagination"></div>
						</div>
					</div>
				</div>
			</div>
	</c:forEach>

<jsp:include page="footer.jsp"/>
</body>

<script src="/index/js/jquery.min.js" type="text/javascript"></script>
<script src="/index/js/jquery.fly.min.js" type="text/javascript"></script>
<script src="/index/js/jquery.flexslider.min.js" type="text/javascript"></script>
<script src="/index/js/swiper.min.js" type="text/javascript"></script>
<script type="text/javascript">
// 商品轮播
new Swiper('.m-swiper-container', {
	pagination: {
		el: '.swiper-pagination',
		clickable: true,
	},
});

// 显示购物车按钮
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
$(".goods-box1").on("mouseenter", function() {
	$(this).addClass("active")
});
$(".goods-box1").on("mouseleave", function() {
	$(this).removeClass("active")
});
$(".goods-box2").on("mouseenter", function() {
	$(this).addClass("active")
	$(this).find(".addcart").show()
	$(this).find(".reserve").show()
	$(this).find(".goodsprices").hide()
});
$(".goods-box2").on("mouseleave", function() {
	$(this).removeClass("active")
	$(this).find(".addcart").hide()
	$(this).find(".reserve").hide()
	$(this).find(".goodsprices").show()
});

</script>

</html>