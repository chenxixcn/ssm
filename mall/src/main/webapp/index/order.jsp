<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>我的订单</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/public.css">
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/reclassify.css">
	<link rel="stylesheet" type="text/css" href="css/order.css">
</head>
<body>
<jsp:include page="header-login.jsp"/>
	<div id="main">
	
		<div class="east" style="width: 1200px;margin: 0 auto;">
			<div style="">
				<table border="0" cellspacing="" cellpadding="" class="list">
					<thead>
						<tr>
							<th class="li1"></th>
							<th class="li2"><span>商品</span></th>
							<th class="li3"><span>单价</span></th>
							<th class="li4"><span>数量</span></th>
							<th class="li5"><span></span></th>
							<th class="li6"><span>实付款</span></th>
							<th class="li7"><span>交易状态</span></th>
							<th class="li8"><span>交易操作</span></th>
						</tr>
					</thead>
				</table>
			</div>
				
			<div style="width:100%;height:auto !important;height:468px;background: #f6f6f6;">
				<div id="itemContainer" style="background: #f6f6f6;">
                    <c:if test="${orderList.list!=null and orderList.list.size()!=0}">
					<c:forEach items="${orderList.list}" var="order">
						<table border="0" cellspacing="" cellpadding="" class="list animated wobble">
							<tbody>
								<tr class="order-info">
							 		<td colspan="8">
										<span style="margin-left: 20px;">订单编号&nbsp;:&nbsp;</span><i class="order-num">${order.id}</i>
										<span style="margin-left: 40px;">下单时间&nbsp;:&nbsp;</span><i class="order-num">${order.systimeStr}</i>
									</td>
								</tr>
                                <c:set var="total" value="0"/>
                                <c:if test="${order.items!=null and order.items.size()!=0}">
                                <c:forEach items="${order.items}" var="items"  varStatus="status">
								<tr class="order" style="margin-bottom: 10px;">
                                    <c:set var="total" value="${items.amount*items.goods.price+total}"/>
										<td class="li1" style="text-align: left;" colspan="4">
											<a href="detail?id=${items.goods.id}"><img src="${items.goods.cover}"></a>
											<div class="m-good-descript">
												<a href="detail?id=${items.goods.id}"><p class="goods-descript">${items.goods.name}</p></a>
											</div>
											<div class="li3"><span>${items.goods.price}</span></div>
											<div class="li4"><span>${items.amount}</span></div>
											<div class="li5"></div>
										</td>

                                    <c:if test="${status.index==0}">
                                        <td class="li6" rowspan="0">
                                            <div>
                                                <p class="total-money">
                                                        ${order.total}
                                                </p>
                                            </div>
                                        </td>
                                        <td class="li7" rowspan="0">
                                            <div>
                                                    <span>${order.statusStr}<c:if test="${order.paytypeStr!=null}">(${order.paytypeStr})</c:if></span>
                                            </div>
                                        </td>
                                        <td class="li8" rowspan="0">
                                            <div>
                                                <p>
                                                    <c:if test="${order.status==1}">
                                                        <a href="/index/orderStatus?id=${order.id}&&status=1"><button>去付款</button></a>
                                                    </c:if>
                                                    <c:if test="${order.status==3}">
                                                        <a href="/index/orderStatus?id=${order.id}&&status=4"><button>确认收货</button></a>
                                                    </c:if>
                                                </p>
                                            </div>
                                        </td>
                                    </c:if>
								</tr>
                                </c:forEach>
                                </c:if>
							</tbody>
						</table>
                    </c:forEach>
                    </c:if>
				</div>
			</div>
			
			<div class='holder'>

                <c:forEach begin="1" var="i" step="1" end="${orderList.pages}">
				<a <c:if test="${orderList.pageNum==i}">class='jp-current'</c:if> title='第${i}页' href='order?page=${i}'>${i}</a>
                </c:forEach>
				<a <c:if test="${orderList.pageNum < orderList.pages}">href='order?page=${orderList.pageNum+1}'</c:if>>下页</a>
				<a href='order?page=${orderList.pages}'>尾页</a>
			</div>
		</div>
		
	</div>
<jsp:include page="footer.jsp"/>
</body>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

</script>
</html>