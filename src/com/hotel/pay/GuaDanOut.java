package com.hotel.pay;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.CustomerManage;
import com.hotel.dao.GuaDanManage;

@WebServlet(name="GuaDanOut",urlPatterns={"/GuaDanOut"})
public class GuaDanOut extends HttpServlet{

		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doPost(request,response);
		}

		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			
			String p =req.getParameter("price");
			System.out.println(p);
			int OrderNum = Integer.parseInt(req.getParameter("OrderNum"));
			float price = Float.parseFloat(p);
			//从customer中删除此订单
			CustomerManage.delete(OrderNum);
			//在leavewithoutpay中添加此订单
			GuaDanManage.insert(OrderNum, price);
			
			resp.sendRedirect("/HotelManagement/CustomerInfo.jsp");
		}

	}



