<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品详情-${obj.pname}</title>

</head>
<body flag="index">
	<div class="row">
		<div class="col-md-3">

			<img class="tile-image big-illustration" alt=""
				style="width: 200px; height: 200px;"
				src="${ctx}/resource/upload/images/product/${obj.img}">
		</div>
		<div class="col-md-9">


			<form class="form-horizontal" role="form">
				<input type="hidden"   id="productId" value="${obj.id}" />
				<div class="form-group">
					<label class="col-lg-2 control-label"> </label>
					<div class="col-lg-10">${obj.pname}</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label"> </label>
					<div class="col-lg-10">${obj.descript}</div>
				</div>

				<div class="form-group">
					<label class="col-lg-2 control-label"></label>
					<div class="col-lg-10">价格：${obj.price}</div>
				</div>
				
				<div class="form-group">
					<label class="col-lg-2 control-label"></label>
					<div class="col-lg-10">数量：<input type="text" name="price" id="txtAmount" value="1" >&nbsp;&nbsp;<small>库存:${obj.stock}件</small></div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-5">
						<a class="btn btn-danger btn-large" href="${ctx}/order?method=buy">立即购买</a> <a id="btnAddcar" href="#"
							class="btn btn-info btn-large" >加入到购物车</a>
					</div>

				</div>

			</form>

			<div class="row">
				<div class="col-md-3"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		seajs.use('${ctx}/resource/js/front/productView');
	</script>
</body>
</html>
