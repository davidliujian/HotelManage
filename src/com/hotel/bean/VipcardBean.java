package com.hotel.bean;

import java.sql.Timestamp;

public class VipcardBean {

	private String VIPId;
	private String VIPName;
	private String VIPSex;
	private String VIPIDCard;
	private String VIPPhone;
	private int VIPLevel;
	private Timestamp HandTime;
	public Timestamp getHandTime() {
		return HandTime;
	}
	public void setHandTime(Timestamp handTime) {
		HandTime = handTime;
	}
	public String getVIPId() {
		return VIPId;
	}
	public void setVIPId(String vIPId) {
		VIPId = vIPId;
	}
	public String getVIPName() {
		return VIPName;
	}
	public void setVIPName(String vIPName) {
		VIPName = vIPName;
	}
	public String getVIPSex() {
		return VIPSex;
	}
	public void setVIPSex(String vIPSex) {
		VIPSex = vIPSex;
	}
	public String getVIPIDCard() {
		return VIPIDCard;
	}
	public void setVIPIDCard(String vIPIDCard) {
		VIPIDCard = vIPIDCard;
	}
	public String getVIPPhone() {
		return VIPPhone;
	}
	public void setVIPPhone(String vIPPhone) {
		VIPPhone = vIPPhone;
	}
	public int getVIPLevel() {
		return VIPLevel;
	}
	public void setVIPLevel(int vIPLevel) {
		VIPLevel = vIPLevel;
	}
}
