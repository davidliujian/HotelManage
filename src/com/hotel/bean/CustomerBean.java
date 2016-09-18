package com.hotel.bean;

public class CustomerBean {

	private int OrderNum;
	private String CName;
	private String CSex;
	private String CIDCard;
	private int RoomId;
	private String CPhone;
	private int IsVip;
	private String StartTime;
	public CustomerBean(){}
	public int getOrderNum() {
		return OrderNum;
	}
	public void setOrderNum(int orderNum) {
		OrderNum = orderNum;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getCSex() {
		return CSex;
	}
	public void setCSex(String cSex) {
		CSex = cSex;
	}
	public String getCIDCard() {
		return CIDCard;
	}
	public void setCIDCard(String cIDCard) {
		CIDCard = cIDCard;
	}
	public int getRoomId() {
		return RoomId;
	}
	public void setRoomId(int roomId) {
		RoomId = roomId;
	}
	public String getCPhone() {
		return CPhone;
	}
	public void setCPhone(String cPhone) {
		CPhone = cPhone;
	}
	public int getIsVip() {
		return IsVip;
	}
	public void setIsVip(int isVip) {
		IsVip = isVip;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
}
