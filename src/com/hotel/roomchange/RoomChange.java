package com.hotel.roomchange;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.RoomManage;

@WebServlet(name="RoomChange",urlPatterns={"/RoomChange"})
public class RoomChange extends HttpServlet{

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
			int RoomId = Integer.parseInt(req.getParameter("RoomId"));
//			System.out.println(VIPId);
			int RoomSize = Integer.parseInt(req.getParameter("RoomSize"));
//			System.out.println(VIPName);
			String RoomPrices = req.getParameter("RoomPrice");
			float RoomPrice = Float.parseFloat(RoomPrices);
			int IsEmp = Integer.parseInt(req.getParameter("IsEmp"));
			int Deposit = Integer.parseInt(req.getParameter("Deposit"));
//			System.out.println(username);
//			System.out.println(password);
			
			if(RoomManage.update(RoomId, RoomSize, RoomPrice, IsEmp, Deposit) == true){
				resp.sendRedirect("/HotelManagement/RoomInfo.jsp");
			}else{
				out.print("sorry ！ Your Room update is not successful!");
			}

			
		}

	}


