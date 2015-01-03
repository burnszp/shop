<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品查看-${obj.pname}</title>
</head>
<body flag="admin">
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${ctx}">首页</a></li>
				<li><a href="${ctx}/admin">系统管理</a></li>
				<li><a href="${ctx}/admin/product">商品管理</a></li>
				<li class="active">商品查看</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div style="display: inline;">商品管理</div>
				</div>

				<div class="panel-body">
					<form class="form-horizontal" action="${ctx}/admin/product?method=save" method="post"  role="form">
						<input type="hidden" name="id" value="${obj.id}"/>
						<input type="hidden" name="img" value="${obj.img}"/>
						<div class="form-group">
							<label class="col-lg-2 control-label">商品名</label>
							<div class="col-lg-10">
								<input type="text" name="pname" class="form-control" value="${obj.pname}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 control-label">商品描述</label>
							<div class="col-lg-10">
								<input type="text" name="descript" class="form-control" value="${obj.descript}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 control-label">库存</label>
							<div class="col-lg-10">
								<input type="text" name="stock" class="form-control" value="${obj.stock}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 control-label">单价</label>
							<div class="col-lg-10">
								<input type="text" name="price" class="form-control" value="${obj.price}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 control-label">是否上架</label>
							<div class="col-lg-10">
								<div class="bootstrap-switch-square">
									<input type="checkbox" ${obj.pstatus==1?"checked":"" } data-toggle="switch"
										name="pstatus"    data-on-text="上架" data-off-text="下架"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-5">
								<a href="${ctx }/admin/product" class="btn btn-primary">返回</a>
								<button type="submit" class='btn btn-info'>${obj.id!=null?"修改":"新增"}</button>
							
							</div>
							 
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		if ($('[data-toggle="switch"]').length) {
			$('[data-toggle="switch"]').bootstrapSwitch();
		}
		$('#back').click(function() {

			window.location.href = ctx + "/admin/product";
		});
	</script>
</body>
</html>
