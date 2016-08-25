package com.vnb.spring.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vnb.spring.dao.BaseDao;
import com.vnb.spring.dao.LogmsgDao;
import com.vnb.spring.entity.Logmsg;

@Component("logmsgDao")
public class LogmsgDaoImp extends BaseDao implements LogmsgDao {

	@Override
	public void addLog(int cardId, int uId, int typeId, BigDecimal money) {
		// TODO Auto-generated method stub
		
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			String sql="insert into logmsg(uId,cardId,action,creatDate,money) values(?,?,?,?,?)";
			String action="";
			Date d=new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(typeId==1)
			{
				// sql="insert into logmsg(uId,cardId,action,creatDate,money) values("+uId+","+cardId+",'取款','"+sf.format(d)+"',"+money+")";
				action="取款";
			}
			else if(typeId==2)
			{
				action="存款";
				// sql="insert into logmsg(uId,cardId,action,creatDate,money) values("+uId+","+cardId+",'存款','"+sf.format(d)+"',"+money+")";
			}
			else if(typeId==3)
			{
				//sql="insert into logmsg(uId,cardId,action,creatDate,money) values("+uId+","+cardId+",'转出','"+sf.format(d)+"',"+money+")";
				action="转出";
			}
			else if(typeId==4)
			{
				//sql="insert into logmsg(uId,cardId,action,creatDate,money) values("+uId+","+cardId+",'转入','"+sf.format(d)+"',"+money+")";
				action="转入";
			}
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, uId);
			pstm.setInt(2, cardId);
			pstm.setString(3, action);
			pstm.setString(4, sf.format(d));
			pstm.setBigDecimal(5, money);
			int i=pstm.executeUpdate();
			if(i>0)
			{
				//更新成功
				System.out.println("存入日志成功！");
			}
			else
			{
				System.out.println("存入日志失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstm, rs);
		}

	}

	@Override
	public List<Logmsg> getCheckFloat(int cardId, int personId) {
		// TODO Auto-generated method stub
		List<Logmsg> logmsgs=new ArrayList<Logmsg>();
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			//String sql="select *from logmsg where cardId="+cardId+" and uId="+personId+" order by creatDate desc";
			String sql="select *from logmsg where cardId=? and uId=? order by creatDate desc";
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, cardId);
			pstm.setInt(2, personId);
			rs=pstm.executeQuery();
			while(rs.next())
			{
				Logmsg l=new Logmsg();
				l.setLogId(rs.getInt(1));
				l.setCardId(rs.getInt(3));
				l.setuId(rs.getInt(2));
				l.setAction(rs.getString(4));
				l.setCreatDate(rs.getDate(5));
				l.setMoney(rs.getBigDecimal(6));
				logmsgs.add(l);
			}
			return logmsgs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			this.closeAll(con, pstm, rs);
		}
		return null;
	}

	@Override
	public List<Logmsg> getCheckFloat(long num, int personId) {
		// TODO Auto-generated method stub
		List<Logmsg> logmsgs=new ArrayList<Logmsg>();
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			//String sql="select *from logmsg where cardId="+cardId+" and uId="+personId+" order by creatDate desc";
			String sql="select *from logmsg where cardNum=? and uId=? order by creatDate desc";
			pstm=con.prepareStatement(sql);
			pstm.setLong(1, num);
			pstm.setInt(2, personId);
			rs=pstm.executeQuery();
			while(rs.next())
			{
				Logmsg l=new Logmsg();
				l.setLogId(rs.getInt(1));
				l.setCardId(rs.getInt(3));
				l.setuId(rs.getInt(2));
				l.setAction(rs.getString(4));
				l.setCreatDate(rs.getDate(5));
				l.setMoney(rs.getBigDecimal(6));
				logmsgs.add(l);
			}
			return logmsgs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			this.closeAll(con, pstm, rs);
		}
		return null;
	}

}
