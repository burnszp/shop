<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>顾客查看-${obj.username}</title>
</head>
<body flag="admin">
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="/${ctx}">首页</a></li>
				<li><a href="${ctx}/admin">系统管理</a></li>
				<li><a href="${ctx}/admin/customer">顾客管理</a></li>
				<li class="active">顾客查看</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div style="display: inline;">顾客管理</div>
				</div>

				<div class="panel-body">
					<form class="form-horizontal" role="form" method="post" action="${ctx}/admin/customer?method=save">
						<input type="hidden" name="id" value="${obj.id}"/>
						<div class="form-group">
							<label class="col-lg-2 control-label">顾客账号</label>
							<div class="col-lg-10">
								<input type="text" name="username" class="form-control"
									value="${obj.username}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 control-label">密码</label>
							<div class="col-lg-10">
								<input type="text" name="password" class="form-control"
									value="${obj.password}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 control-label">联系电话</label>

							<div class="col-lg-10">
								<input type="text" name="phone" class="form-control"
									value="${obj.phone}">
							</div>
						</div>
							<div class="form-group">
							<label class="col-lg-2 control-label">地址</label>

							<div class="col-lg-10">
								<input type="text" name="addr" class="form-control"
									value="${obj.addr}">
							</div>
						</div>
							<div class="form-group">
							<label class="col-lg-2 control-label">积分</label>

							<div class="col-lg-10">
								<input type="text" name="score" class="form-control"
									value="${obj.score}" disabled>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<a href="${ctx }/admin/customer" class="btn btn-primary">返回</a>
								<button type="submit" class='btn btn-info'>${obj.id!=null?"修改":"新增"}</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
