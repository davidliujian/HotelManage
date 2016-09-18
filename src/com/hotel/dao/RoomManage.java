package com.hotel.dao;
import com.hotel.bean.RoomBean;
import com.hotel.bean.VipcardBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class RoomManage {
	
	public static boolean insert(int RoomId, int RoomSize,float RoomPrice,int IsEmp,int Deposit){
		boolean issuc=false;
		Connection con =  Connect.getCon();
		Statement stat =null;
		try{
			stat = con.createStatement();	
			int count=stat.executeUpdate("insert into room values("+RoomId
					+","+RoomSize+","+RoomPrice+","+IsEmp+","+Deposit+")");
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
	
	public static boolean delete(int RoomId){
		boolean issuc = false;
		Connection con =  Connect.getCon();
		Statement stat =null;
		try{
			stat = con.createStatement();	
			int count=stat.executeUpdate("delete from room where id="+RoomId);
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
	
	public static boolean update(int RoomId, int RoomSize,float RoomPrice,int IsEmp,int Deposit){
		boolean issuc = false;
//		Collection list = new ArrayList();
		Connection con =  Connect.getCon();
		Statement stat =null;
	
		try{
			stat = con.createStatement();	
			int count=stat.executeUpdate("update room set RoomSize="
					+RoomSize+",RoomPrice="+RoomPrice+",IsEmp="+IsEmp+",Deposit="+Deposit+" where RoomId="+RoomId);
			if(count>0)
				issuc = true;
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("更新数据出错！！！");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("数据库成功获取！！");
			Connect.close2(con, stat);
		}
	
		return issuc;
	}
	
	public static boolean updateIsEmp(int RoomId,int IsEmp){
		boolean issuc = false;
//		Collection list = new ArrayList();
		Connection con =  Connect.getCon();
		Statement stat =null;
	
		try{
			stat = con.createStatement();	
			int count=stat.executeUpdate("update room set IsEmp = "+ IsEmp+" where RoomId="+RoomId);
			if(count>0)
				issuc = true;
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("更新数据出错！！！");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("数据库成功获取！！");
			Connect.close2(con, stat);
		}
	
		return issuc;
	}
	
	public static Collection selectRoom(){
		Collection list = new ArrayList();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from room";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				RoomBean room = new RoomBean();
				room.setRoomId(rs.getInt("RoomId"));
				room.setRoomSize(rs.getInt("RoomSize"));
				room.setRoomPrice(rs.getInt("RoomPrice"));
				room.setIsEmp(rs.getInt("IsEmp"));
				room.setDeposit(rs.getInt("Deposit"));
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
	
	public static Collection selectByRoomSize(int RoomSize){
		Collection list = new ArrayList();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from room where RoomSize = "+RoomSize+" and IsEmp != 0";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				
//				RoomBean room = new RoomBean();
//				room.setRoomId(rs.getInt("RoomId"));
//				room.setRoomSize(rs.getInt("RoomSize"));
//				room.setRoomPrice(rs.getInt("RoomPrice"));
//				room.setIsEmp(rs.getInt("IsEmp"));
//				room.setDeposit(rs.getInt("Deposit"));
				list.add(rs.getInt("RoomId"));
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
	
	public static RoomBean selectByRoomId(int RoomId){
		RoomBean room = new RoomBean();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from room where RoomId = "+RoomId;
			rs = stat.executeQuery(sql);
			while(rs.next()){			
				
				room.setRoomId(rs.getInt("RoomId"));
				room.setRoomSize(rs.getInt("RoomSize"));
				room.setRoomPrice(rs.getInt("RoomPrice"));
				room.setIsEmp(rs.getInt("IsEmp"));
				room.setDeposit(rs.getInt("Deposit"));				
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
		return room;
	}
}
