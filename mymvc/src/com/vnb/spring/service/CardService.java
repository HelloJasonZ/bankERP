package com.vnb.spring.service;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;

import com.vnb.spring.entity.Card;

public interface CardService {
	
	/**
	 * ͨ���û�id����ȡ���û�������Ϣ
	 * @param uId
	 * @return
	 */
	public List<Card> getUserCard(int uId);
	
	/**
	 * ����ĳ�ſ�����Ϣ
	 * @param card
	 * @return
	 */
	public Card getCardMessage(Card card);
	
	/**
	 * ת�˹���
	 * @param putNum ת������
	 * @param intNum	ת�����
	 * @param money
	 * @return
	 */
	public boolean traderMoney(int uId,long putNum,long intNum,BigDecimal money);
	
	/**
	 * ͨ���˺Ų�ѯ�Ƿ���ڸ��˺�
	 * @param num
	 * @return
	 */
	public Card findCardNum(long num);
	
	/**
	 * ͨ����id��ȡ����Ϣ
	 * @param id
	 * @return
	 */
	public Card getOneCard(int id);
	
	/**
	 * �޸Ŀ���״̬
	 * @param id
	 * @param num
	 */
	public void updateStatu(int id,int uId,long num);
	
	/**
	 * ȡ�����
	 * @param cardid ����id
	 * @param personId �û�id
	 * @param typeId 1Ϊȡ�2Ϊ���
	 * @param money
	 * @return
	 */
	public boolean selectMethod(int cardid,int personId,int typeId,BigDecimal money);
	
	/**
	 * ע�Ῠ��
	 * @param card
	 * @return
	 */
	public boolean addCardNum(Card card);
	
	/**
	 * �ⲿͨ��WebService����
	 * @param num
	 * @param ip_address
	 * @return
	 */
	@WebMethod
	public Card getWebServiceCard(long num);

	/**
	 *  ��ȡip��ַ
	 * @return
	 */
	@WebMethod
	public String getIPAd();

}
