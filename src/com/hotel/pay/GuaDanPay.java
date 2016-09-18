package com.hotel.pay;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.GuaDanManage;
import com.hotel.dao.HasPayedManage;

@WebServlet(name="GuaDanPay",urlPatterns={"/GuaDanPay"})
public class GuaDanPay extends HttpServlet{

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
			//从leavewithoutpay中删除此账单
			GuaDanManage.delete(OrderNum);
			//在haspayed中添加此账单
			HasPayedManage.insert(OrderNum,price);
			
			
			resp.sendRedirect("/HotelManagement/GuaDanPay.jsp");
		}

	}



