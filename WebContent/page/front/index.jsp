<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>weilcome</title>
</head>
<body flag="index">

	<div class="row">
		<c:forEach items="${pager.list}" var="rec" varStatus="status">
			<c:if test="${status.index+1<=4}">
				<div class="col-md-3">
					<div class="tile">
						<a href="product?id=${rec.id}"><img
							class="tile-image big-illustration" alt=""
							src="${ctx}/resource/upload/images/product/${rec.img}"></a>
						<h3 class="tile-title">
							<a href="product?id=${rec.id}">${rec.pname}</a>
						</h3>
						<p>${rec.descript}</p>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>

	<div class="row">
		<c:forEach items="${pager.list}" var="rec" varStatus="status">
			<c:if test="${status.index+1>4&&status.index+1<=8}">
				<div class="col-md-3">
					<div class="tile">
						<a href="product?id=${rec.id}"><img
							class="tile-image big-illustration" alt=""
							src="${ctx}/resource/upload/images/product/${rec.img}"></a>
						<h3 class="tile-title">
							<a href="product?id=${rec.id}">${rec.pname}</a>
						</h3>
						<p>${rec.descript}</p>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>
	<div class="pagination" id="page" url="${ctx}/index"></div>
	<script type="text/javascript">
		var pageSize = '${pager.pageSize}';
		var pageNumber = '${pager.pageNumber}';
		var pageCount = '${pager.pageCount}';
		seajs.use('${ctx}/resource/js/front/index')
	</script>
</body>
</html>
