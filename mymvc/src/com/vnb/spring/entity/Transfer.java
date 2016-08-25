package com.vnb.spring.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Transfer {

	private int trId;
	private String floatNum;
	private long putNum;
	private long intNum;
	private BigDecimal money;
	private Date createTime;
	private boolean tradeStau;
	private String result;
	
	
	public int getTrId() {
		return trId;
	}
	public void setTrId(int trId) {
		this.trId = trId;
	}
	public String getFloatNum() {
		return floatNum;
	}
	public void setFloatNum(String floatNum) {
		this.floatNum = floatNum;
	}
	public long getPutNum() {
		return putNum;
	}
	public void setPutNum(long putNum) {
		this.putNum = putNum;
	}
	public long getIntNum() {
		return intNum;
	}
	public void setIntNum(long intNum) {
		this.intNum = intNum;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public boolean isTradeStau() {
		return tradeStau;
	}
	public void setTradeStau(boolean tradeStau) {
		this.tradeStau = tradeStau;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public Transfer(){}
	
	public Transfer(int id,long putNun,long inNum,BigDecimal money,Date createTime,boolean trads,String result)
	{
		this.trId=id;
		this.putNum=putNun;
		this.intNum=inNum;
		this.money=money;
		this.createTime=createTime;
		this.tradeStau=trads;
		this.result=result;
	}
}
