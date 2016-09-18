package com.hotel.registration;



	import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.CustomerManage;
import com.hotel.dao.RoomManage;

	@WebServlet(name="ChangeRoom",urlPatterns={"/ChangeRoom"})
	public class ChangeRoom extends HttpServlet{

			public void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				doPost(request,response);
			}

			public void doPost(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				req.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				
				//1.获取html页面中的input
				String CName = req.getParameter("CName");
//				System.out.println(VIPId);

				String CSex = req.getParameter("CSex");
				String CIDCard = req.getParameter("CIDCard");
				int RoomId = Integer.parseInt(req.getParameter("RoomId"));
				int nRoomId = Integer.parseInt(req.getParameter("nRoomId"));
				String CPhone = req.getParameter("CPhone");

				
				if(CustomerManage.update(CName, CSex, CIDCard, nRoomId,CPhone) == true){
					ArrayList list = (ArrayList)CustomerManage.selectByRoomId(RoomId);
					if(list.size()==0){
						RoomManage.updateIsEmp(RoomId, RoomManage.selectByRoomId(RoomId).getRoomSize());
					}
					RoomManage.updateIsEmp(nRoomId, 0);
					resp.sendRedirect("/HotelManagement/CustomerInfo.jsp");
				}else{
					out.print("sorry ！ Your VIP update is not successful!");
				}

				
			}

		}

