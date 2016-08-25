package com.vnb.spring.service;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;

import com.vnb.spring.entity.Card;

public interface CardService {
	
	/**
	 * 通过用户id，获取该用户卡的信息
	 * @param uId
	 * @return
	 */
	public List<Card> getUserCard(int uId);
	
	/**
	 * 查找某张卡的信息
	 * @param card
	 * @return
	 */
	public Card getCardMessage(Card card);
	
	/**
	 * 转账功能
	 * @param putNum 转出号码
	 * @param intNum	转入号码
	 * @param money
	 * @return
	 */
	public boolean traderMoney(int uId,long putNum,long intNum,BigDecimal money);
	
	/**
	 * 通过账号查询是否存在该账号
	 * @param num
	 * @return
	 */
	public Card findCardNum(long num);
	
	/**
	 * 通过卡id获取卡信息
	 * @param id
	 * @return
	 */
	public Card getOneCard(int id);
	
	/**
	 * 修改卡的状态
	 * @param id
	 * @param num
	 */
	public void updateStatu(int id,int uId,long num);
	
	/**
	 * 取款存款方法
	 * @param cardid 卡的id
	 * @param personId 用户id
	 * @param typeId 1为取款，2为存款
	 * @param money
	 * @return
	 */
	public boolean selectMethod(int cardid,int personId,int typeId,BigDecimal money);
	
	/**
	 * 注册卡号
	 * @param card
	 * @return
	 */
	public boolean addCardNum(Card card);
	
	/**
	 * 外部通过WebService访问
	 * @param num
	 * @param ip_address
	 * @return
	 */
	@WebMethod
	public Card getWebServiceCard(long num);

	/**
	 *  获取ip地址
	 * @return
	 */
	@WebMethod
	public String getIPAd();

}
