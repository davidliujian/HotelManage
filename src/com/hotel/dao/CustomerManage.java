package com.hotel.dao;
import com.hotel.bean.RoomBean;
import com.hotel.bean.CustomerBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
/*
 * private int OrderNum;
	private String CName;
	private String CSex;
	private int CIDCard;
	private int RoomId;
	private int CPhone;
	private int IsVip;
	private String StartTime;
 */
public class CustomerManage {
	
	public static boolean insert(int OrderNum, String CName,String CSex, 
				String CIDCard,int RoomId,String CPhone,int IsVip,String StartTime){
		boolean issuc=false;
		Connection con =  Connect.getCon();
		Statement stat =null;
		try{
			stat = con.createStatement();	
			int count=stat.executeUpdate("insert into customer values("+OrderNum
					+",'"+CName+"','"+CSex+"','"+CIDCard+"',"+RoomId+",'"+CPhone+"',"+IsVip+",'"+StartTime+"')");
			if(count>0)
				issuc=true;
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("添加顾客错误！！！");
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
			int count=stat.executeUpdate("delete from customer where OrderNum = "+OrderNum);
			if(count>0)
				issuc = true;
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("根据订单号删除顾客数据错误！！！");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("数据库成功获取！！");
			Connect.close2(con, stat);
		}
	
		return issuc;
	}
	
	public static boolean update(String CName,String CSex,String CIDCard ,int RoomId,String CPhone){
		boolean issuc = false;
		Connection con =  Connect.getCon();
		Statement stat =null;
	
		try{
			stat = con.createStatement();	
			int count=stat.executeUpdate("update customer set CName='"
					+CName+"',CSex='"+CSex+"',RoomId="+RoomId+",CPhone='"+CPhone
					+"' where CIDCard='"+CIDCard+"'");
			if(count>0)
				issuc = true;
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("换房更新数据出错！！！");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("数据库成功获取！！");
			Connect.close2(con, stat);
		}
	
		return issuc;
	}
	
	public static Collection selectCustomer(){
		Collection list = new ArrayList();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from customer ORDER BY OrderNum";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				CustomerBean customer = new CustomerBean();
				customer.setOrderNum(rs.getInt("OrderNum"));
				customer.setCName(rs.getString("CName"));
				customer.setCSex(rs.getString("CSex"));
				customer.setCIDCard(rs.getString("CIDCard"));
				customer.setRoomId(rs.getInt("RoomId"));
				customer.setCPhone(rs.getString("CPhone"));
				customer.setIsVip(rs.getInt("IsVip"));
				customer.setStartTime(rs.getString("StartTime"));
				list.add(customer);
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
	
	public static Collection selectByRoomId(int RoomId){
		Collection list = new ArrayList();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from customer where RoomId = "+RoomId;
			rs = stat.executeQuery(sql);
			while(rs.next()){
				CustomerBean customer = new CustomerBean();
				customer.setOrderNum(rs.getInt("OrderNum"));
				customer.setCName(rs.getString("CName"));
				customer.setCSex(rs.getString("CSex"));
				customer.setCIDCard(rs.getString("CIDCard"));
				customer.setRoomId(rs.getInt("RoomId"));
				customer.setCPhone(rs.getString("CPhone"));
				customer.setIsVip(rs.getInt("IsVip"));
				customer.setStartTime(rs.getString("StartTime"));
				list.add(customer);
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
	
	public static CustomerBean selectByCIDCard(String CIDCard){
		CustomerBean customer = new CustomerBean();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from customer where CIDCard = '"+CIDCard+"'";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				
				customer.setOrderNum(rs.getInt("OrderNum"));
				customer.setCName(rs.getString("CName"));
				customer.setCSex(rs.getString("CSex"));
				customer.setCIDCard(rs.getString("CIDCard"));
				customer.setRoomId(rs.getInt("RoomId"));
				customer.setCPhone(rs.getString("CPhone"));
				customer.setIsVip(rs.getInt("IsVip"));
				customer.setStartTime(rs.getString("StartTime"));
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
		return customer;
	}
	
	public static int selectIsVIP(int OrderNum){
		int IsVIP =0;
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select distinct IsVIP from customer where OrderNum = "+OrderNum;
			rs = stat.executeQuery(sql);
			while(rs.next()){
				IsVIP = rs.getInt("IsVIP");
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
		return IsVIP;
	}
	
	public static Collection selectRoom(int OrderNum){
		Collection list = new ArrayList();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select distinct RoomId from customer where OrderNum = "+OrderNum;
			rs = stat.executeQuery(sql);
			while(rs.next()){
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
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        