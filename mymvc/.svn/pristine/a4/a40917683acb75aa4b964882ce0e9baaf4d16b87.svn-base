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
import com.vnb.spring.dao.TransferDao;
import com.vnb.spring.entity.Transfer;

@Component("transferDao")
public class TransferDaoImp extends BaseDao implements TransferDao {

	@Override
	public void addTransferFloat(boolean tradstatu, long putNum, long intNum,
			BigDecimal money, String result) {
		// TODO Auto-generated method stub
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		Date d=new Date();
		 SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		 SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String sql="insert into transfer"
					+ "(floatNum,putNum,intNum,money,tradeTime,tradeStatu,result) values(?,?,?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			pstm.setString(1, df.format(d));
			pstm.setLong(2, putNum);
			pstm.setLong(3, intNum);
			pstm.setBigDecimal(4, money);
			pstm.setString(5, from.format(d));
			pstm.setBoolean(6, tradstatu);
			pstm.setString(7, result);
			int n=pstm.executeUpdate();
			if(n>0)
			{
				System.out.println("存入流水");
			}
			else{
				System.out.println("流水失败");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			this.closeAll(con, pstm, rs);
		}

	}

	@Override
	public List<Transfer> getAllTransfer(long cardNum) {
		// TODO Auto-generated method stub
		List<Transfer> list=new ArrayList<>();
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			String sql="select *from transfer where putNum=? Order By tradeTime Desc";
			pstm=con.prepareStatement(sql);
			pstm.setLong(1, cardNum);
			rs=pstm.executeQuery();
			while(rs.next())
			{
				Transfer transfer=new Transfer();
				transfer.setTrId(rs.getInt("trId"));
				transfer.setFloatNum(rs.getString("floatNum"));
				transfer.setPutNum(rs.getLong("putNum"));
				transfer.setIntNum(rs.getLong("intNum"));
				transfer.setMoney(rs.getBigDecimal("money"));
				transfer.setCreateTime(rs.getDate("tradeTime"));
				transfer.setTradeStau(rs.getBoolean("tradeStatu"));
				transfer.setResult(rs.getString("result"));
				list.add(transfer);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstm, rs);
		}
		return null;
	}

}
