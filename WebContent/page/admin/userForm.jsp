<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户查看-${obj.username}</title>
</head>
<body flag="admin">
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${ctx}">首页</a></li>
				<li><a href="${ctx}/admin">系统管理</a></li>
				<li><a href="${ctx}/admin/user">用戶管理</a></li>
				<li class="active">用戶查看</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div style="display: inline;">用户管理</div>
				</div>

				<div class="panel-body">
					<form class="form-horizontal" role="form" method="post" action="${ctx}/admin/user?method=save">
						<input type="hidden" name="id" value="${obj.id}"/>
						<div class="form-group">
							<label class="col-lg-2 control-label">用户名</label>
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
							<label class="col-lg-2 control-label">用户类型</label>

							<div class="col-lg-10">
								<label class="radio-inline"> <input type="radio" ${obj.usertype==1?"checked":""} 
									name="usertype" value="1" ${obj.usertype==null?"checked":""}> 管理员
								</label> <label class="radio-inline"> <input type="radio"  ${obj.usertype==2?"checked":""}
									name="usertype" value="2"> 收款员
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<a href="${ctx }/admin/user" class="btn btn-primary">返回</a>
								<button type="submit" class='btn btn-info'>${obj.id!=null?"修改":"新增"}</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$('#back').click(function() {

			window.location.href = ctx + "/admin/user";
		});
		//seajs.use('${ctx}/resource/js/admin/user')
	</script>
</body>
</html>
