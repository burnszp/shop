<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>订单处理-${obj.orderId}</title>
</head>
<body flag="admin">
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${ctx}">首页</a></li>
				<li><a href="${ctx}/admin">系统管理</a></li>
				<li><a href="${ctx}/admin/order">订单管理</a></li>
				<li class="active">订单处理</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div style="display: inline;">订单：${obj.orderId}&nbsp;&nbsp;[${obj.ostatus==1?"未处理":"已处理"
						}]</div>
				</div>

				<div class="panel-body">
					<form class="form-horizontal" role="form"  >
						<input type="hidden" name="id" value="${obj.id}" />
						<div class="form-group">
							<label class="col-lg-5 control-label">订单编号：
								${obj.orderId} </label> <label class="col-lg-5  control-label">
								交易日期：${obj.createDate}</label>
						</div>

						<div class="form-group">
							<label class="col-lg-5 control-label">客户账号：
								${obj.customer.username} </label> <label class="col-lg-5  control-label">
								收款员：<c:if test="${obj.ostatus==1}">未处理</c:if> <c:if
									test="${obj.ostatus==2}">${obj.admin.username}</c:if>
							</label>
						</div>



						<div class="form-group">
							<label class="col-lg-5 control-label">本次积分： ${obj.score}
							</label> <label class="col-lg-5  control-label">
								总交易金额：${obj.totalPrice}</label>
						</div>

						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<a href="${ctx}/admin/order" class="btn btn-primary">返回</a>
								<c:if test="${obj.ostatus==1}">
									<a href="${ctx}/admin/order?method=handle&id=${obj.id}"
										class='btn btn-info'>处理订单</a>
								</c:if>
								<button id="btnPrint" class='btn btn-danger'>打印预览</button>
							</div>
						</div>
					</form>

					<div class="panel panel-info">
						<div class="panel-heading">
							<div style="display: inline;">订单明细</div>
						</div>

						<div class="panel-body">
							<table class="table table-hover table-condensed table-bordered ">
								<thead>
									<th>商品名称</th>
									<th>单价</th>
									<th>数量</th>
								</thead>

								<tbody>

									<c:forEach var="rec" items="${items}">
										<tr>
											<td><a href="${ctx}/product?id=${rec.productId}">${rec.productName}</a></td>
											<td>${rec.price}</td>
											<td>${rec.amount}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="divPrint" style="visibility: hidden;">
		<table style="margin-left: auto; margin-right: auto;">
			<tr>
				<td colspan="5" align="center">欢&nbsp;&nbsp;&nbsp;&nbsp;迎&nbsp;&nbsp;&nbsp;&nbsp;光&nbsp;&nbsp;&nbsp;&nbsp;临</td>
			</tr>
			<tr>
				<td colspan="5" align="center">天&nbsp;&nbsp;客&nbsp;&nbsp;隆&nbsp;&nbsp;师&nbsp;&nbsp;大&nbsp;&nbsp;店<br></td>
			</tr>
			<tr>
				<td colspan="3">日期：${obj.createDate}</td>
				<td colspan="2">收款员:${obj.admin.username}<br></td>
			</tr>
			<tr>
				<td>商品名称&nbsp;&nbsp;</td>
				<td>商品编码&nbsp;&nbsp;</td>
				<td>数量&nbsp;&nbsp;</td>
				<td>单价&nbsp;&nbsp;</td>
				<td>金额&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="5">---------------------------------------------------</td>
			</tr>
			<c:set var="sum" value="0"></c:set>
			<c:forEach var="rec" items="${items}">
				<c:set var="sum" value="${sum+rec.amount}"></c:set>
				<tr>
					<td>${rec.productName}</td>
					<td>${rec.productId}</td>
					<td>${rec.amount}</td>
					<td>${rec.price}</td>
					<td>${rec.amount*rec.price}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="center">----------总计----------</td>
			</tr>
			<tr>
				<td colspan="3">条目：${fn:length(items)}</td>
				<td colspan="2">数量:${sum}</td>
			</tr>

			<tr>
				<td colspan="3">金额：${obj.totalPrice}</td>
				<td colspan="2"><br></td>
			</tr>

			<tr>
				<td colspan="5" align="center">-------付款方式-------</td>
			</tr>
			<tr>
				<td colspan="3">支付：刷卡：${obj.totalPrice}</td>
				<td colspan="2"></td>
			</tr>

			<tr>
				<td colspan="3">总金额：${obj.totalPrice}</td>
				<td colspan="2">找零：0.00<br></td>
			</tr>
			<tr>
				<td colspan="5">---------------------------------------------------</td>
			</tr>
			<tr>
				<td colspan="5">请将欠款、商品当面点清。如有质量问题，七<br>日内凭交易记录退货，生鲜食品8小时内退货
				</td>
			</tr>
		</table>
	</div>


	<script type="text/javascript">
		seajs.use('${ctx}/resource/js/admin/orderForm')
	</script>
</body>
</html>
