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
				<div class="panel-heading">Log in</div>
				<div class="panel-body">
					<form role="form" method="post" action="LoginCheck">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Name" name="Name" type="text" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="password" type="password" value="">
							</div>
							<div class="checkbox">
							<!--  
								<label>
									<input name="remember" type="checkbox" value="Remember Me">Remember Me
								</label>
							-->
							<br>	
							</div>
							<div class="form-group">
								<input class="form-control btn btn-primary"  type="submit" value="Sign in" style="width:50%;margin-left:25%;">
							</div>
							<!--  
							<div>
								<button  type="button" class="btn btn-primary" style="margin-left:140px;margin-right:70px;" onclick="window.location.href='./login.jsp'">Sign up</button> 
								<button  type="submit" class="btn btn-primary">Sign in</button> 
							</div>
							-->
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
  
   	
  </body>
</html>
