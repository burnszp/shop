<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我的订单</title>
</head>
<body flag="index">


	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${ctx}">首页</a></li>
				<li class="active">我的订单</li>

			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div style="display: inline;">订单管理</div>
					<div style="display: inline; float: right; margin-top: -5px;">
						<div class="btn-group">
							<button data-toggle="dropdown"
								class="btn btn-primary dropdown-toggle" type="button">
								&nbsp;&nbsp;&nbsp;&nbsp;过滤 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
									class="caret"></span>
							</button>
							<ul role="menu" class="dropdown-menu">
								<li><a href="${ctx}/order?ostatus=2"  >已处理订单
								</a></li>
								<li><a href="${ctx}/order?ostatus=1" >未处理订单 </a></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="panel-body">
					<table class="table table-hover table-condensed table-bordered ">
						<thead>
							<th><label class="checkbox" for="checkboxall"> <input
									type="checkbox" id="checkboxall" data-toggle="checkbox"
									class="custom-checkbox"><span class="icons"><span
										class="icon-unchecked"></span><span class="icon-checked"></span></span>

							</label></th>
							<th>订单编号</th>
							<th>创建日期</th>
							<th>总金额</th>
							<th>订单积分</th>
							<th>订单状态</th>
						</thead>

						<tbody>
							<c:forEach items="${pager.list}" var="rec" varStatus="status">
								<tr>
									<td><label class="checkbox" for="checkbox${status.index}">
											<input type="checkbox" value="${rec.id}"
											id="checkbox${status.index}" data-toggle="checkbox"
											class="custom-checkbox"><span class="icons"><span
												class="icon-unchecked"></span><span class="icon-checked"></span></span>

									</label></td>

									<td><a href="${ctx}/order?method=view&id=${rec.id}">${rec.orderId}</a></td>
									<td>${rec.createDate}</td>
									<td>${rec.totalPrice}</td>
									<td>${rec.score}</td>

									<td>${rec.ostatus==1?"未处理":"已处理"}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="pagination" id="page" url="${ctx}/order"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<h6 class="modal-title" id="myModalLabel">确认执行该操作？</h6>
						</div>
						<div class="modal-body">
							<button type="button" class="btn btn-default"
								data-dismiss="modal" style="margin-left: 67px;">取消</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-primary" id="modalOk">确定</button>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var pageSize = '${pager.pageSize}';
		var pageNumber = '${pager.pageNumber}';
		var pageCount = '${pager.pageCount}';
		seajs.use('${ctx}/resource/js/front/order')
	</script>
</body>
</html>
