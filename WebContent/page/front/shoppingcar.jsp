<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>购物车</title>
</head>
<body flag="shoppingcar">
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${ctx}">首页</a></li>
				<li class="active">购物车</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div style="display: inline;">剁手清单</div>
				</div>

				<div class="panel-body">

					<table class="table table-hover table-condensed table-bordered ">
						<thead>
							<th>商品名称</th>
							<th>单价</th>
							<th>数量</th>
						</thead>

						<tbody>
								<c:set var="totalPrice" value="0"></c:set>
							<c:forEach var="rec" items="${items}">
								<tr>
									<td><a href="${ctx}/product?id=${rec.productId}">${rec.productName}</a></td>
									<td>${rec.price}</td>
									<td>${rec.amount}</td>
									<c:set var="totalPrice" value="${totalPrice+(rec.amount*rec.price)}"></c:set>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		//seajs.use('${ctx}/resource/js/admin/orderForm')
	</script>
</body>
</html>
