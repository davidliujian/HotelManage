package com.hotel.registration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CreateRan {

	/** 
	 * 生成随机订单号：当前年月日时分秒+五位随机数 
	 *  
	 * @return 
	 */  
	public static int CreateOrderNum(){
		
	        SimpleDateFormat simpleDateFormat;  
	  
	        simpleDateFormat = new SimpleDateFormat("MMdd");  
	  
	        Date date = new Date();  
	  
	        String str = simpleDateFormat.format(date);  
	  
	        Random random = new Random();  
	  
	        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数  
	  
	        return Integer.parseInt(rannum + str);// 当前时间  
		
	}
	
	public  static String CreateDate(){
		SimpleDateFormat simpleDateFormat;  
		 
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
  
        Date date = new Date();  
        
        String str = simpleDateFormat.format(date);  
        return str;
	}
	
}
