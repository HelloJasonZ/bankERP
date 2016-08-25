package com.vnb.spring.service;

import java.math.BigDecimal;
import java.util.List;

import com.vnb.spring.entity.Logmsg;

public interface LogmsgService {
	
	/**
	 * 日志写入
	 * @param cardId
	 * @param uId 
	 * @param typeId 1取款   2存款		3转出	4转入
	 * @param money
	 */
	public void addLog(int cardId,int uId,int typeId,BigDecimal money);
	
	/**
	 * 查看某张卡流水记录
	 */
	public List<Logmsg> getCheckFloat (int cardId,int personId);
	
	/**
	 * 查看某张卡流水记录
	 */
	public List<Logmsg> getCheckFloat (long num,int personId);

}
