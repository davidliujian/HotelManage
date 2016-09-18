<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css">

  </head>
  
  <body style="background-image:url('./image/bg1.png');">
 	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default"  style="margin-top:200px;">
				<div class="panel-heading">Sign up</div>
				<div class="panel-body">
					<form role="form" method="post" action="VipRegistration">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="会员号" name="VIPId" type="text" >
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="姓名" name="VIPName" type="text" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="性别" name="VIPSex" type="text" value="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="身份证" name="VIPIDCard" type="text" value="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="手机号" name="VIPPhone" type="text" value="">
							</div>
							
							<div class="form-group">
								<input class="form-control" placeholder="会员等级" name="VIPLevel" type="text" value="">
							</div>
							<div class="form-group">
								<input class="form-control btn btn-primary"  type="submit" value="Sign up" style="width:50%;margin-left:25%;">
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
  
   	
  </body>
</html>
