package com.vnb.spring.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Card {

	private int cardId;
	private int uId;
	private long cardNum;
	private String cardType;
	private BigDecimal money;
	private String address;
	private Date createTime;
	private int cardStatu;
	private String password;
	
	private UserInfo userInfo;

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public long getCardNum() {
		return cardNum;
	}

	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCardStatu() {
		return cardStatu;
	}

	public void setCardStatu(int cardStatu) {
		this.cardStatu = cardStatu;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public Card(){}

	public Card(int cid,int uid,long num,String type,BigDecimal money,String address,Date time,int statu,UserInfo u)
	{
		this.cardId=cid;
		this.uId=uid;
		this.cardNum=num;
		this.cardType=type;
		this.money=money;
		this.address=address;
		this.createTime=time;
		this.cardStatu=statu;
		this.userInfo=u;
	}
	
	@Override
	public String toString() {
		return "Card [getCardId()=" + getCardId() + ", getuId()=" + getuId()
				+ ", getCardNum()=" + getCardNum() + ", getCardType()="
				+ getCardType() + ", getMoney()=" + getMoney()
				+ ", getAddress()=" + getAddress() + ", getCreateTime()="
				+ getCreateTime() + ", getCardStatu()=" + getCardStatu()
				+ ", getUserInfo()=" + getUserInfo() + "]";
	}
	
	
}
