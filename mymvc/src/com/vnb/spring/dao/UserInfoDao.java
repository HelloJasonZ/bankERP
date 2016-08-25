package com.vnb.spring.dao;

import com.vnb.spring.entity.UserInfo;


public interface UserInfoDao {
	
	/**
	 * �û���½
	 * @param userInfo
	 * @param loginType��½���ͣ�1Ϊ�ֻ���½��2Ϊ�����½
	 * @return
	 */
	public UserInfo userLogin(UserInfo userInfo,int loginType);
	
	/**
	 * �û�ע�����Ϣ�Ƿ��Ѿ�����
	 * @param content
	 * @param putType 1Ϊ�ֻ�  2Ϊ����  3Ϊ�û�����
	 * @return
	 */
	public boolean regMessage(String content,int putType);

	
	/**
	 * ע���û���Ϣ
	 * @param info
	 * @return
	 */
	public boolean addUserInfo(UserInfo info);
	
	/**
	 *   ����ʱ��
	 * @param uId
	 * @param info
	 * @return
	 */
	public boolean updateLoginTime(int uId, UserInfo info);
	
	
	/**
	 * springMVC  ��½
	 * @param user
	 * @return
	 */
	public UserInfo userLogin(UserInfo user);
	
	/**
	 * �޸�����
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean updatePassowrd(String email,String password);
}
