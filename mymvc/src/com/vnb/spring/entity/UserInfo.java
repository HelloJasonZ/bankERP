package com.vnb.spring.entity;

import java.util.Date;
import java.util.List;

public class UserInfo {
	
	private int uId;
	private String userName;
	private String password;
	private String phone;
	private String email;
	private String loginTime;
	private List<Card> cards;
	
	
	
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public UserInfo(){}
	public UserInfo(int uid,String userName,String password,String phone,String email,String time)
	{
		this.uId=uid;
		this.userName=userName;
		this.password=password;
		this.phone=phone;
		this.email=email;
		this.loginTime=time;
	}

}
