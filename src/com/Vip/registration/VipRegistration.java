package com.Vip.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.Connect;
import com.hotel.dao.VipcardManage;

@WebServlet(name="VipRegistration",urlPatterns={"/VipRegistration"})
public class VipRegistration extends HttpServlet{

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
			String VIPId = req.getParameter("VIPId");
			String VIPName = req.getParameter("VIPName");
			String VIPSex = req.getParameter("VIPSex");
			String VIPIDCard = req.getParameter("VIPIDCard");
			String VIPPhone = req.getParameter("VIPPhone");
			int VIPLevel = Integer.parseInt(req.getParameter("VIPLevel"));
//			System.out.println(username);
//			System.out.println(password);
			
			if(VipcardManage.insert(VIPId, VIPName, VIPSex, VIPIDCard, VIPPhone, VIPLevel) == true){
				resp.sendRedirect("/HotelManagement/VIPInfo.jsp");
			}else{
				out.print("sorry ！ Your VIP registration is not successful!");
			}

			
		}

	}


