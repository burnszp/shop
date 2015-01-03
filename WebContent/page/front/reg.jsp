<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>请登录</title>

</head>
<body flag="index">
	<div class="row">
		<div class="col-md-12">

			<div class="login-screen">
				<div class="login-icon">
					<img src="${ctx}/resource/flat-ui/2.1.3/images/login/icon.png"
						alt="Welcome to 动漫商城">
					<h4>
						Welcome to <small>动漫商城</small>
					</h4>
				</div>

				<div class="login-form">
					<form class="form-horizontal" role="form" method="post"
						action="${ctx}/admin/customer?method=save">
						<input type="hidden" name="id" value="${obj.id}" />
						<div class="form-group">
							<label class="col-lg-2 control-label">账号</label>
							<div class="col-lg-10">
								<input type="text" name="username" class="form-control"
									value="${obj.username}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 control-label">密码</label>
							<div class="col-lg-10">
								<input type="password" name="password" class="form-control"
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
						<input type="hidden" name="url" value="../page/front/login.jsp"/>
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
							 
								<button type="submit" class='btn btn-info'>注&nbsp;&nbsp;册</button>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>


	<script type="text/javascript">
		
	</script>
</body>
</html>
