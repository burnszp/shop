<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>后台管理首页</title>
<style type="text/css">
.span3 {
	width: 220px;
}
</style>
</head>
<body flag="admin">
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${ctx}">首页</a></li>
				<li class="active">系统管理</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<div class="tile">
				<img class="tile-image big-illustration" alt=""
					src="${ctx}/resource/flat-ui/2.1.3/images/illustrations/compass.png">
				<h3 class="tile-title">
					<a href="${ctx}/admin/user">用戶管理</a>
				</h3>
				<p>用户增删改查</p>

			</div>
		</div>
		<div class="col-md-2">
			<div class="tile">
				<img class="tile-image big-illustration" alt=""
					src="${ctx}/resource/flat-ui/2.1.3/images/illustrations/colors.png">
				<h3 class="tile-title">
					<a href="${ctx}/admin/product">商品管理</a>
				</h3>
				<p>商品上架，下架</p>

			</div>
		</div>
		<div class="col-md-2">
			<div class="tile">
				<img class="tile-image big-illustration" alt=""
					src="${ctx}/resource/flat-ui/2.1.3/images/illustrations/share.png">
				<h3 class="tile-title">
					<a href="${ctx}/admin/order">订单管理</a>
				</h3>
				<p>订单处理</p>

			</div>
		</div>
		
			<div class="col-md-2">
			<div class="tile">
				<img class="tile-image big-illustration" alt=""
					src="${ctx}/resource/flat-ui/2.1.3/images/illustrations/colors.png">
				<h3 class="tile-title">
					<a href="${ctx}/admin/customer">客户管理</a>
				</h3>
				<p>客户查看</p>

			</div>
		</div>
		 
	</div>
	<script type="text/javascript">
		seajs.use('${ctx}/resource/js/admin/school')
	</script>
</body>
</html>
