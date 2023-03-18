<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<link rel="stylesheet" type="text/css" href="/index/css/common.css"/>
<link rel="stylesheet" type="text/css" href="/index/css/search.css"/>
<link rel="stylesheet" type="text/css" href="/index/css/index.css"/>
<link rel="stylesheet" type="text/css" href="/index/css/font.css" />
</head>
<body>

<div id="searchss">
	<div class="search">
		<div class="logo">
			<a href="/index/index"><img src="/index/img/logo.jpg"/></a>
		</div>
		<div class="sear_input">
			<form action="/index/todayHotNew?" method="get">
				<input type="text" name="name" value="${name}">
                <input type="hidden" name="url" value="search">
				<button><i class="iconfont icon-icon--"></i></button>
			</form>
		</div>
		<div class="sera_cart">
			<a href="cart"><p><i class="iconfont icon-gouwuche5"></i>我的购物车</p></a>
			
		</div>
		
		 <div class="sear_fir">
		 	
				<div class="sinup">
					<a href="/index/login.jsp">登录</a>
					<a>/</a>
					<a href="/index/register.jsp">注册</a>
				</div>
				<div class="sinup">
					<a target="_blank" href="/admin/login.jsp">后台管理</a>
				</div>
		 </div>
	</div>
</div>

<!--导航nav-->
<div id="navall">
	<div id="nav">
		<!--产品分类-->
		<div class="proclass">
			<p>产品分类</p>
			
			<div class="prolist" style="display:none;">
                <c:forEach items="${allTypes}" var="type">
					<div class="list">
						<dl>
							<a href="/index/todayHotNew?id=${type.id}&url=type"><dt>${type.name}</dt></a>
						</dl>
					</div>
                </c:forEach>
					
				
				
			</div>
		</div>
					
		<!--导航-->
		<ul id="inav">
			<li <c:if test="${url=='index'}">class="active"</c:if> ><a href="/index/index">商城首页</a></li>
			<li <c:if test="${url=='today'}">class="active"</c:if> ><a href="/index/todayHotNew?url=today">今日推荐</a></li>
			<li <c:if test="${url=='hot'}">class="active"</c:if> ><a href="/index/todayHotNew?url=hot">热销排行</a></li>
			<li <c:if test="${url=='new'}">class="active"</c:if> ><a href="/index/todayHotNew?url=new">新品上市</a></li>
		</ul>
	</div>
</div>


<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
//显示隐藏分类
$(".proclass").on("mouseenter", function() {
	$(".prolist").css("display", "block");
});
$(".proclass").on("mouseleave", function() {
	$(".prolist").css("display", "none");
});
// 显示隐藏个人中心
$(".my").on("mouseenter",function(){
	$(".uls").show();
})
$(".my").on("mouseleave",function(){
	$(".uls").hide();
})
$(".uls li a").on("mouseenter",function(){
	$(this).css('color','#ff712b');
})
$(".uls li a").on("mouseleave",function(){
	$(this).css('color','#919191');
})
	
// 加入购物车
$(document).on("click", ".addcart", function(){
	var goodId = $(this).attr("data-id");
	var index = layer.load();
	$.post("cartBuy", {good_id:goodId}, function(data){
		layer.close(index);
		if(data==true){
			layer.msg("加入成功", {
                icon: 1,   // 成功图标
                time: 1200 //1.2秒关闭（如果不配置，默认是3秒）
            });
			updateCartnum(1); // 更新数量
		}else if(data==false){
            layer.msg("操作失败，请检查是否登录或网络问题", {
                icon: 2,   // 失败图标
                time: 2000 //2秒关闭（如果不配置，默认是3秒）
            });
        }else{ // 重新渲染页面
        	document.write(data);
        }
	});
});

// 更新购物车显示数量
function updateCartnum(num){
	if($(".cartnum").length > 0){
		$(".cartnum").text(parseInt($(".cartnum").text()) + num);
	}else{ // 第一个
		$(".sera_cart").append('<span class="cartnum">1</span>');
	}
}
</script>
</body>
</html>