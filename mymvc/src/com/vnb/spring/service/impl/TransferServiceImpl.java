package com.vnb.spring.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import com.vnb.spring.dao.TransferDao;
import com.vnb.spring.entity.Transfer;
import com.vnb.spring.service.TransferService;

public class TransferServiceImpl implements TransferService {

	
	@Resource(name="transferDao")
	private TransferDao transferDao;
	@Override
	public void addTransferFloat(boolean tradstatu, long putNum, long intNum,
			BigDecimal money, String result) {
		// TODO Auto-generated method stub
		transferDao.addTransferFloat(tradstatu, putNum, intNum, money, result);

	}

	@Override
	public List<Transfer> getAllTransfer(long cardNum) {
		// TODO Auto-generated method stub
		List<Transfer> list=transferDao.getAllTransfer(cardNum);
		return list;
	}

}
