package com.hotel.bean;

import java.sql.Timestamp;

public class HasPayedBean {

	private int OrderNum;
	private float price;
	private Timestamp PayedTime;
	public Timestamp getLeaveTime() {
		return PayedTime;
	}
	public void setLeaveTime(Timestamp payedTime) {
		PayedTime = payedTime;
	}
	public int getOrderNum() {
		return OrderNum;
	}
	public void setOrderNum(int orderNum) {
		OrderNum = orderNum;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
