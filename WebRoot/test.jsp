<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>宾馆管理信息系统</title>

    <meta charset='utf-8'>
    <meta http-equiv="expires" content="0"> 
       <link rel="stylesheet" type="text/css" href="./styles/home.css"> 
   
		<link rel="stylesheet" type="text/css" href="./bootstrap/bootstrap.min.css">
	
  </head>
  
  <body>
	<div id ="homeHeader">
		<h1>宾馆管理信息系统</h1>	 
	</div>
	
    <div id="homeContent">
		<div class="putong">
		<form class="form-inline" role="form">
			<div class="form-group">
				<input  class="form-control col-md-6" type="button" onclick="window.location.href='./Individual.jsp'" value="普通散户"  />
				<input  class="form-control col-md-6" type="button" onclick="window.location.href='./Group.jsp'" value="普通团体"  />
			</div>
		</form>
		</div>
		<div class="super">
			<input  type="button" onclick="window.location.href='./SuperIndividual.jsp'" value="VIP散户"  />
			<input  type="button" onclick="window.location.href='./SuperGroup.jsp'" value="VIP团体"  />
		</div>
	</div>
	
	<div id="homeFooter">
		<a href="">办理VIP</a>
	</div>
  </body>
</html>
