package com.hotel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.hotel.bean.GuaDanBean;
import com.hotel.bean.HasPayedBean;

public class GuaDanManage {


	
	public static boolean insert(int OrderNum, float price){
		boolean issuc=false;
		Connection con =  Connect.getCon();
		Statement stat =null;
		try{
			stat = con.createStatement();	
			int count=stat.executeUpdate("insert into leavewithoutpay values("+OrderNum
					+","+price+",null )");
			if(count>0)
				issuc=true;
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("添加数据错误！！！");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("数据库成功获取！！");
			Connect.close2(con, stat);
		}
		
		return issuc;
	}
	
	public static boolean delete(int OrderNum){
		boolean issuc = false;
		Connection con =  Connect.getCon();
		Statement stat =null;
		try{
			stat = con.createStatement();	
			int count=stat.executeUpdate("delete from leavewithoutpay where OrderNum="+OrderNum);
			if(count>0)
				issuc = true;
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("删除数据错误！！！");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("数据库成功获取！！");
			Connect.close2(con, stat);
		}
	
		return issuc;
	}
	
	
	public static Collection select(){
		Collection list = new ArrayList();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from leavewithoutpay";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				GuaDanBean room = new GuaDanBean();
				room.setOrderNum(rs.getInt("OrderNum"));
				room.setPrice(rs.getFloat("Price"));
				room.setLeaveTime(rs.getTimestamp("LeaveTime"));
				list.add(room);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("查询信息出错！！！");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("数据库成功获取！！");
			Connect.close3(rs, con, stat);
		}
		return list;
	}
	
	public static GuaDanBean selectByOrderNum(int OrderNum){
		GuaDanBean haspayed = new GuaDanBean();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from leavewithoutpay where OrderNum = "+OrderNum;
			rs = stat.executeQuery(sql);
			while(rs.next()){
				haspayed.setOrderNum(rs.getInt("OrderNum"));
				haspayed.setPrice(rs.getFloat("Price"));
				haspayed.setLeaveTime(rs.getTimestamp("LeaveTime"));
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("查询信息出错！！！");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("数据库成功获取！！");
			Connect.close3(rs, con, stat);
		}
		return haspayed;
	}
	
	

}
