<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.hotel.dao.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>VIP散户登记页面</title>

    <meta charset='utf-8'>
    <link rel="stylesheet" type="text/css" href="./styles/registration.css">
	
  </head>
  
  <body>
	<div id ="Header">
		<h1>VIP散户登记页面</h1>	 
	</div>
	<div id="inside" style="text-align:center;font-size:26px;color:yellow;">
		<%
			ArrayList Room2 =(ArrayList) RoomManage.selectByRoomSize(2);
			ArrayList Room3 =(ArrayList) RoomManage.selectByRoomSize(3);
			
			out.print("当前可选的双人房有： ");
			Iterator it = Room2.iterator();
			while(it.hasNext())
				out.print(it.next()+"  ");
			out.print("<br/>");
			out.print("当前可选的三人房有： ");
			Iterator it3 = Room3.iterator();
			while(it3.hasNext())
				out.print(it3.next()+"  ");
			out.println();
		%>
	</div>
	<div style="margin-top:60px;">
		<form id="form3" method="post" action ="" style="text-align:center;">
			姓&nbsp;名:<input type="text" id="name" name ="name"/><br/>
			会员号:<input type="text" id="VIPId" name ="VIPId"/><br/>
			性&nbsp;别:<input type="text" id="sex" name ="sex"/><br/>
			身份证：<input type="text" id="vipidcard" name ="vipidcard"/><br/>
			房间号:<input type="text" id="roomnum" name ="roomnum"/><br/>
			手机号:<input type="text" id="phone" name ="phone"/><br/>
			<input type="submit" id="button" value="完成并提交" onclick="selectAction(1);" />&nbsp;&nbsp;
			<input type="submit" id="button" value="添加"  onclick="selectAction(0);" />&nbsp;&nbsp;
			<input type="reset" id="button" value="重置"/>
		</form>
	</div>
	<script>
		function selectAction(v){
		//	event.preventDefault();
			if(v==0){
				document.getElementById("form3").action="SIndividualHandle";
			}else{
				document.getElementById("form3").action="SIndividualFinish";
			}
		}
	</script>
  </body>
</html>
