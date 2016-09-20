<%@ page language="java" import="java.util.*,com.hotel.dao.*,com.hotel.bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>历史账单</title>

<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css">
<link href="./bootstrap/css/styles.css" rel="stylesheet">


</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Hotel</span>Admin</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
		<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 用户管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="Manage.html">
							<span class="glyphicon glyphicon-share-alt"></span> 用户登记
						</a>
					</li>
					<li>
						<a class="" href="ChangeRoom.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> 修改用户信息
						</a>
					</li>
					<li>
						<a class="" href="CustomerInfo.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> 当前住宿信息
						</a>
					</li>
				</ul>
			</li>
			<!--
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					用户管理 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">用户登记</a></li>
					<li><a href="#">换房</a></li>
					<li class="divider"></li>
					<li><a href="#">当前住宿信息</a></li>					
				</ul>
			</li>
			-->
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 账目管理 <span data-toggle="collapse" href="#sub-item-2" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li>
						<a class="" href="CheckOut.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> 结账退房
						</a>
					</li>
					<li>
						<a class="" href="GuaDanOut.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> 挂账退房
						</a>
					</li>
					<li>
						<a class="" href="GuaDanPay.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> 挂单补齐
						</a>
					</li>
						<li>
						<a class="" href="HistoryPay.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> 历史账单
						</a>
					</li>
				</ul>
			</li>
			
				<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 贵宾卡管理 <span data-toggle="collapse" href="#sub-item-3" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-3">
					<li>
						<a class="" href="./VIPRegistration.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> 办理VIP
						</a>
					</li>
					<li>
						<a class="" href="VIPCancle.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> VIP注销
						</a>
					</li>
					<li>
						<a class="" href="VIPInfo.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> VIP信息显示
						</a>
					</li>
					<li>
						<a class="" href="ChangeVIP.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> VIP信息修改
						</a>
					</li>
				</ul>
			</li>
			
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 房间管理 <span data-toggle="collapse" href="#sub-item-4" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-4">
					<li>
						<a class="" href="RoomAdd.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> 添加房间
						</a>
					</li>
					<li>
						<a class="" href="RoomChange.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> 房间信息修改
						</a>
					</li>
					<li>
						<a class="" href="RoomInfo.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> 房间信息显示
						</a>
					</li>
				</ul>
			</li>

			<li role="presentation" class="divider"></li>
			<li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span>Login Page</a></li>
		</ul>
		<div class="attribution">Created by <a href="http://www.medialoot.com/item/lumino-admin-bootstrap-template/">Jian  Liu</a></div>
	</div><!--/.sidebar-->
		
	
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">历史账单显示</li>
			</ol>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				<%
					ArrayList list = (ArrayList)HasPayedManage.select();
				%>
				<table class="table table-striped">
  					<caption>历史账单情况</caption>
					  <thead>
					    <tr>
					      <th>订单号</th>				
					      <th>价格</th>
					      <th>结账时间</th>
					    </tr>
					  </thead>
					  <tbody>
				 <% 
					Iterator it = list.iterator();
					while(it.hasNext()){
						HasPayedBean vipcard = (HasPayedBean)it.next();	
					
				%>
				
					    <tr>
					      <td><%=vipcard.getOrderNum() %></td>
					      <td><%=vipcard.getPrice() %></td>
					      <td><%=vipcard.getLeaveTime().toString() %></td>
					    </tr>
					    
					    
				<%
				
					}
				
				%>	    
					  </tbody>
				</table>			
			</div>
		</div>
	</div>
	
	<script src="./bootstrap/js/jquery-3.1.0.min.js"></script>
	<script src="./bootstrap/js/bootstrap.min.js"></script>
	
	<script>
		!function ($) {     
 		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);
	</script>

</body>

</html>

