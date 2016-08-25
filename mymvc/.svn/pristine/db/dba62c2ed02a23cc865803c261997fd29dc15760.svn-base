package com.vnb.spring.dao;

import com.vnb.spring.entity.UserInfo;


public interface UserInfoDao {
	
	/**
	 * 用户登陆
	 * @param userInfo
	 * @param loginType登陆类型，1为手机登陆，2为邮箱登陆
	 * @return
	 */
	public UserInfo userLogin(UserInfo userInfo,int loginType);
	
	/**
	 * 用户注册的信息是否已经存在
	 * @param content
	 * @param putType 1为手机  2为邮箱  3为用户名称
	 * @return
	 */
	public boolean regMessage(String content,int putType);

	
	/**
	 * 注册用户信息
	 * @param info
	 * @return
	 */
	public boolean addUserInfo(UserInfo info);
	
	/**
	 *   更新时间
	 * @param uId
	 * @param info
	 * @return
	 */
	public boolean updateLoginTime(int uId, UserInfo info);
	
	
	/**
	 * springMVC  登陆
	 * @param user
	 * @return
	 */
	public UserInfo userLogin(UserInfo user);
	
	/**
	 * 修改密码
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean updatePassowrd(String email,String password);
}
