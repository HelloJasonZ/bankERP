package com.vnb.spring.service;

import java.math.BigDecimal;
import java.util.List;

import com.vnb.spring.entity.Transfer;

public interface TransferService {
	
	/**
	 * 转账流水
	 * @param tradstatu
	 * @param putNum
	 * @param intNum
	 * @param result
	 */
	public void addTransferFloat(boolean tradstatu,long putNum,long intNum,BigDecimal money,String result);
	
	/**
	 * 更具卡号查得到转账流水
	 * @param cardNum
	 * @return
	 */
	public List<Transfer> getAllTransfer(long cardNum);

}
