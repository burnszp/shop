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
			<button id="btnPrint" class="btn btn-primary">确认打印</button>
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
						<td colspan="5">请将欠款、商品当面点清。如有质量问题，七<br>日内凭交易记录退货，生鲜食品8小时内退货</td>
					</tr>
				</table>
			</div>
		</div>
	</div>



	<script type="text/javascript">
	 
		 seajs.use('${ctx}/resource/js/admin/orderPrint.js')
	</script>
</body>
</html>
