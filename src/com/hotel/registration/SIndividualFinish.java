package com.hotel.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.bean.CustomerBean;
import com.hotel.bean.RoomBean;
import com.hotel.dao.CustomerManage;
import com.hotel.dao.RoomManage;
import com.hotel.dao.VipcardManage;


@WebServlet(name="SIndividualFinish",urlPatterns={"/SIndividualFinish"})
public class SIndividualFinish extends HttpServlet{

		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doPost(request,response);
		}

		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			//1.获取html页面中的input
			String name = req.getParameter("name");

			String sex = req.getParameter("sex");
			String VIPIDCard = req.getParameter("vipidcard");
			String IDCard = req.getParameter("VIPId");
			int ok = VipcardManage.selectVIPLevel(IDCard);
			int roomnum = Integer.parseInt(req.getParameter("roomnum"));
			String phone = req.getParameter("phone");
			int OrderNum = 0;
			if(ok ==1 ||ok==2){
				
				ArrayList list = (ArrayList)CustomerManage.selectByRoomId(roomnum);
				if(list.size()==0){
					OrderNum = CreateRan.CreateOrderNum();
					System.out.println(OrderNum);
				}else{
					CustomerBean customer = (CustomerBean) list.get(0);
					OrderNum = customer.getOrderNum();
				}
				String StartTime = CreateRan.CreateDate();
				RoomBean room = (RoomBean)RoomManage.selectByRoomId(roomnum);
				int IsEmp = room.getIsEmp();
				if(IsEmp>0){
					//插入住户信息
					CustomerManage.insert(OrderNum, name, sex, VIPIDCard, roomnum, phone, 1, StartTime);
					//设置IsEmp-1
					RoomManage.updateIsEmp(roomnum,0);
				}else{
					resp.sendRedirect("/HotelManagement/errors/error.html");
					return ;
				}
				
				int dep=0;
				ArrayList list3 = (ArrayList)CustomerManage.selectRoom(OrderNum);
				Iterator it = list3.iterator();
				while(it.hasNext()){
					int Room =(Integer) it.next();
					
					
					dep += RoomManage.selectByRoomId(Room).getDeposit();
				}
				out.print("<h3>您一共需要缴纳"+dep+"元押金！！</h3>");
			}else{
				System.out.println("IDCard为空！！！！！！！！！！！！！！！！！！");
				resp.sendRedirect("/HotelManagement/errors/errorVIP.html");
			}
			
		}

	}
 
