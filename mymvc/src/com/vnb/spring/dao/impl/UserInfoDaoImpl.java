package com.vnb.spring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.vnb.spring.dao.BaseDao;
import com.vnb.spring.dao.UserInfoDao;
import com.vnb.spring.entity.UserInfo;

@Component("userInfoDao")
public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

	
	public UserInfo userLogin(UserInfo userInfo, int loginType) {
		// TODO Auto-generated method stub
		UserInfo u=new UserInfo();
		//��ǰ���ж�ҳ��������͵�½
		//1Ϊ�ֻ�����			2Ϊ�������
		String sql="";
		if(loginType==1)
		{
			sql="select *from userinfo where phone='"+userInfo.getPhone()+"' and password=?";
		}
		else if(loginType==2)
		{
			sql="select *from userinfo where email='"+userInfo.getEmail()+"' and password=?";
		}
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, userInfo.getPassword());
			rs=pstm.executeQuery();
			if(rs.next())
			{
				u.setuId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setLoginTime(rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			this.closeAll(con, pstm, rs);
		}
		
		
		
		return u;
	}

	@Override
	public boolean regMessage(String content, int putType) {
		// TODO Auto-generated method stub
		//�ж��û���Ϣ�Ƿ���� putType 1Ϊ�ֻ�  2Ϊ����  3Ϊ�û�����
		String sql="";
		
			if(putType==1)
			{
				sql="select *from userinfo where phone=?";
			}
			else if(putType==2)
			{
				sql="select *from userinfo where email=?";
			}
			else if(putType==3)
			{
				sql="select *from userinfo where userName=?";
			}
			Connection con=this.getConnection();
			PreparedStatement pstm=null;
			ResultSet rs=null;
			try {
				pstm=con.prepareStatement(sql);
				pstm.setString(1, content);//Ԥ����
				rs=pstm.executeQuery();
			if(rs.next())
			{
				//������Ϣ������
				
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			this.closeAll(con, pstm, rs);
		}
		return false;
	}

	@Override
	public boolean addUserInfo(UserInfo info) {
		// TODO Auto-generated method stub
		String sql="insert into userinfo(userName,password,phone,email) values(?,?,?,?)";
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, info.getUserName());
			pstm.setString(2, info.getPassword());
			pstm.setString(3, info.getPhone());
			pstm.setString(4, info.getEmail());
			int n= pstm.executeUpdate();
			if(n>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			this.closeAll(con, pstm, rs);
		}
		
		return false;
	}

	@Override
	public boolean updateLoginTime(int uId, UserInfo info) {
		// TODO Auto-generated method stub
		Date d=new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql="update userinfo set loginTime=? where uId="+uId+"";
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, sf.format(d));
			int n=pstm.executeUpdate();
			if(n>0)
			{
				System.out.println("��½�ɹ�");
				return true;
			}
			else
			{
				System.out.println("���ڴ���");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			this.closeAll(con, pstm, rs);
		}
		return false;
	}

	@Override
	public UserInfo userLogin(UserInfo user) {
		// TODO Auto-generated method stub
		UserInfo u=new UserInfo();
		//��ǰ���ж�ҳ��������͵�½
		//1Ϊ�ֻ�����			2Ϊ�������
		String sql="select *from userinfo where userName=? and password=?";
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getPassword());
			rs=pstm.executeQuery();
			if(rs.next())
			{
				u.setuId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setLoginTime(rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			this.closeAll(con, pstm, rs);
		}
		return u;
	}

	@Override
	public boolean updatePassowrd(String email, String password) {
		// TODO Auto-generated method stub
		String sql="update userinfo set password=? where email=?";
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, password);
			pstm.setString(2, email);
			int n=pstm.executeUpdate();
			if(n>0)
			{
				System.out.println("�޸ĳɹ�");
				return true;
			}
			else
			{
				System.out.println("���ڴ���");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			this.closeAll(con, pstm, rs);
		}
		return false;
	}

}
