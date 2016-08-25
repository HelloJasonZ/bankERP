package com.vnb.spring.service.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;







import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vnb.spring.dao.BaseDao;
import com.vnb.spring.dao.CardDao;
import com.vnb.spring.dao.UserInfoDao;
import com.vnb.spring.dao.impl.UserInfoDaoImpl;
import com.vnb.spring.entity.Card;
import com.vnb.spring.entity.UserInfo;
import com.vnb.spring.service.CardService;
import com.vnb.spring.service.UserInfoService;
import com.vnb.spring.service.UserService_1;
public class CardServiceImpl  implements CardService{

	@Resource(name="cardDao")
	private CardDao cardDao;//×¢½â

	@Override
	public List<Card> getUserCard(int uId) {
		// TODO Auto-generated method stub
		List<Card> list=cardDao.getUserCard(uId);
		if(list.size()>0)
		{
			return list;
		}
		
		return null;
	}

	@Override
	public Card getCardMessage(Card card) {
		// TODO Auto-generated method stub
		
		Card c=cardDao.getCardMessage(card);
		if(c!=null)
		{
			return c;
		}
		return null;
	}

	@Override
	public boolean traderMoney(int uId, long putNum, long intNum,
			BigDecimal money) {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag=cardDao.traderMoney(uId, putNum, intNum, money);
		return flag;
	}

	@Override
	public Card findCardNum(long num) {
		// TODO Auto-generated method stub
		Card c=cardDao.findCardNum(num);
		if(c!=null)
		{
			return c;
		}
		return null;
	}

	@Override
	public Card getOneCard(int id) {
		// TODO Auto-generated method stub
		Card c=cardDao.getOneCard(id);
		if(c!=null)
		{
			return c;
		}
		return null;
	}

	@Override
	public void updateStatu(int id, int uId, long num) {
		// TODO Auto-generated method stub
		cardDao.updateStatu(id, uId, num);
		
	}

	@Override
	public boolean selectMethod(int cardid, int personId, int typeId,
			BigDecimal money) {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag=cardDao.selectMethod(cardid, personId, typeId, money);
		return flag;
	}

	@Override
	public boolean addCardNum(Card card) {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag=cardDao.addCardNum(card);
		return flag;
	}

	@Override
	public Card getWebServiceCard(long num) {
		// TODO Auto-generated method stub
		Card c=cardDao.getWebServiceCard(num);
		if(c!=null)
		{
			return c;
		}
		return null;
	}

	@Override
	public String getIPAd() {
		// TODO Auto-generated method stub
		return null;
	}
			

}
