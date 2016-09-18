package com.hotel.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.hotel.bean.VipcardBean;

public class VipcardManage {

	@SuppressWarnings("null")
	public static boolean insert(String VIPId, String VIPName,String VIPSex,String VIPIDCard,String VIPPhone,int VIPLevel){
		boolean issuc=false;
		Connection con = Connect.getCon();
		Statement stat =null;
		int count=0;
		try{
			stat = con.createStatement();	
			
			String sql="insert into vipcard values('"+VIPId
					+"','"+VIPName+"','"+VIPSex+"','"+VIPIDCard+"','"+VIPPhone+"',"+VIPLevel+", null "+")";
			count=stat.executeUpdate(sql);
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
	
	public static Collection select(){
		Collection list = new ArrayList();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from vipcard";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				VipcardBean vipcard = new VipcardBean();
				vipcard.setVIPId(rs.getString("VIPId"));
				vipcard.setVIPName(rs.getString("VIPName"));
				vipcard.setVIPSex(rs.getString("VIPSex"));
				vipcard.setVIPIDCard(rs.getString("VIPIDCard"));
				vipcard.setVIPPhone(rs.getString("VIPPhone"));
				vipcard.setVIPLevel(rs.getInt("VIPLevel"));
				vipcard.setHandTime(rs.getTimestamp("HandTime"));
				list.add(vipcard);
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
	
	public static VipcardBean selectByVIPId(int VIPId){
		VipcardBean vipcard = new VipcardBean();
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select * from vipcard where VIPId= '"+VIPId+"'";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				vipcard.setVIPId(rs.getString("VIPId"));
				vipcard.setVIPName(rs.getString("VIPName"));
				vipcard.setVIPSex(rs.getString("VIPSex"));
				vipcard.setVIPIDCard(rs.getString("VIPIDCard"));
				vipcard.setVIPPhone(rs.getString("VIPPhone"));
				vipcard.setVIPLevel(rs.getInt("VIPLevel"));
				vipcard.setHandTime(rs.getTimestamp("HandTime"));
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
		return vipcard;
	}
	
	public static int selectVIPLevel(String VIPId){
		int VIPLevel = 0;
		Connection con =  Connect.getCon();
		Statement stat =null;
		ResultSet rs = null;
		try{
			stat = con.createStatement();	
			String sql = "select VIPLevel from vipcard where VIPId = "+VIPId;
			rs = stat.executeQuery(sql);
			while(rs.next()){
				VIPLevel = rs.getInt("VIPLevel"); 
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
		return VIPLevel;
	}
	
	
	public static boolean delete(int VIPId){
		boolean issuc = false;
		Connection con =  Connect.getCon();
		Statement stat =null;
		int count=0;
		try{
			stat = con.createStatement();	
			count=stat.executeUpdate("delete from vipcard where VIPId ='"+VIPId+"'");
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
	
	public static boolean update(String VIPName,String VIPSex,String VIPIDCard,String VIPPhone,int VIPLevel,String VIPId){
		boolean issuc = false;
		Connection con =  Connect.getCon();
		Statement stat =null;
		int count=0;
		try{
			stat = con.createStatement();	
			count=stat.executeUpdate("update vipcard set VIPName='"
					+VIPName+"',VIPSex='"+VIPSex+"',VIPIDCard='"+VIPIDCard+"',VIPPhone='"+VIPPhone+"',VIPLevel="+VIPLevel+" where VIPId ='"+VIPId+"'");
			System.out.println(count);
			if(count>0)
				issuc = true;
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("数据库修改失败！！！");
		}catch(Exception e){
			System.out.println("数据库修改失败！！！");
			e.printStackTrace();
		}
		finally{
			Connect.close2(con, stat);
		}
	
		return issuc;
	}
}
