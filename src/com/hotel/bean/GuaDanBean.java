package com.hotel.bean;

import java.sql.Timestamp;

public class GuaDanBean {

	private int OrderNum;
	private float price;
	private Timestamp LeaveTime;
	public Timestamp getLeaveTime() {
		return LeaveTime;
	}
	public void setLeaveTime(Timestamp timestamp) {
		LeaveTime = timestamp;
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
