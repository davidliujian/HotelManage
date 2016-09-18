package com.hotel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.hotel.bean.HasPayedBean;

public class HasPayedManage {

	
	public static boolean insert(int OrderNum, float price){
		boolean issuc=false;
		Connection con =  Connect.getCon();
		Statement stat =null;
		try{
			stat = con.createStatement();	
			int count=stat.executeUpdate("insert into haspayed values("+OrderNum
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
			int count=stat.executeUpdate("delete from haspayed where OrderNum="+OrderNum);
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
			String sql = "SELECT * FROM haspayed";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				HasPayedBean room = new HasPayedBean();
				room.setOrderNum(rs.getInt("OrderNum"));
				room.setPrice(rs.getFloat("Price"));
				room.setLeaveTime(rs.getTimestamp("PayedTime"));
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
	
	public static HasPayedBean selectByOrderNum(int OrderNum){
		HasPayedBean haspayed = new HasPayedBean();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from haspayed where OrderNum = "+OrderNum;
			rs = stat.executeQuery(sql);
			while(rs.next()){
				haspayed.setOrderNum(rs.getInt("OrderNum"));
				haspayed.setPrice(rs.getFloat("Price"));
				haspayed.setPrice(rs.getFloat("PayedTime"));
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
