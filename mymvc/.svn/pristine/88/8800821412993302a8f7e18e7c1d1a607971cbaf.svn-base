package com.vnb.spring.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;






import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vnb.spring.dao.BaseDao;
import com.vnb.spring.dao.UserInfoDao;
import com.vnb.spring.dao.impl.UserInfoDaoImpl;
import com.vnb.spring.entity.UserInfo;
import com.vnb.spring.service.UserInfoService;
import com.vnb.spring.service.UserService_1;
public class UserInfoServiceImpl  implements UserInfoService{

	@Resource(name="userInfoDao")
	private UserInfoDao userInfoDao;//×¢½â
			
	
	

	@Override
	public UserInfo userLogin(UserInfo userInfo, int loginType) {
		// TODO Auto-generated method stub
		UserInfo u=new UserInfo();
		u=userInfoDao.userLogin(userInfo, loginType);
		return u;
	}

	@Override
	public boolean regMessage(String content, int putType) {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag=userInfoDao.regMessage(content, putType);
		return flag;
	}

	@Override
	public boolean addUserInfo(UserInfo info) {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag=userInfoDao.addUserInfo(info);
		return flag;
	}

	@Override
	public boolean updateLoginTime(int uId, UserInfo info) {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag=userInfoDao.updateLoginTime(uId, info);
		
		return flag;
	}

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public boolean updatePassowrd(String email, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag=userInfoDao.updatePassowrd(email, password);
		
		return flag;
	}

	

}
