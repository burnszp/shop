<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理员登录</title>
 
</head>
<body flag="index">
	<div class="row">
		<div class="col-md-12">
			 
        <div class="login-screen">
          <div class="login-icon">
            <img src="${ctx}/resource/flat-ui/2.1.3/images/login/icon.png" alt="欢迎光临后台管理">
            <h4>欢迎光临 <small>后台管理</h4>
          </div>

          <div class="login-form">
           <form class="form-horizontal" role="form" method="post" action="${ctx}/admin?method=login">
					 
						<div class="form-group">
							<label class="col-lg-2 control-label">用户名</label>
							<div class="col-lg-10">
								<input type="text" name="username" class="form-control" >
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 control-label">密码</label>
							<div class="col-lg-10">
								<input type="password" name="password" class="form-control" >
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<button type="submit" class='btn btn-info'>登&nbsp;&nbsp;录</button>
							</div>
						</div>
					</form>
          </div>
        </div>
      
		</div>
	</div>


	<script type="text/javascript">
		 var msg = "${msg}";
		seajs.use('${ctx}/resource/js/admin/login');
	</script>
</body>
</html>
