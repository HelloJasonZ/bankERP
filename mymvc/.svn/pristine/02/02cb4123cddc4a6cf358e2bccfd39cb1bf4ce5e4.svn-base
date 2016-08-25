package com.vnb.spring.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import com.vnb.spring.dao.LogmsgDao;
import com.vnb.spring.entity.Logmsg;
import com.vnb.spring.service.LogmsgService;

public class LogmsgServiceImpl implements LogmsgService {
	
	@Resource(name="logmsgDao")
	private LogmsgDao logmsgDao;
	

	@Override
	public void addLog(int cardId, int uId, int typeId, BigDecimal money) {
		// TODO Auto-generated method stub
		logmsgDao.addLog(cardId, uId, typeId, money);

	}

	@Override
	public List<Logmsg> getCheckFloat(int cardId, int personId) {
		// TODO Auto-generated method stub
		List<Logmsg> list=logmsgDao.getCheckFloat(cardId, personId);
		return list;
	}

	@Override
	public List<Logmsg> getCheckFloat(long num, int personId) {
		// TODO Auto-generated method stub
		List<Logmsg> list=logmsgDao.getCheckFloat(num, personId);
		return list;
	}

}
