package com.vnb.spring.dao.impl;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vnb.spring.dao.BaseDao;
import com.vnb.spring.dao.CardDao;
import com.vnb.spring.entity.Card;
import com.vnb.spring.service.LogmsgService;
import com.vnb.spring.service.TransferService;
import com.vnb.spring.service.UserInfoService;


@Component("cardDao")
public class CardDaoImp extends BaseDao implements CardDao {
	
	
	@Autowired
	private LogmsgService logmsgService;
	
	@Autowired
	private TransferService transferService;
	

	/**
	 * ͨ���û�id��ȡ���û��¿�����Ϣ
	 */
	@Override
	public List<Card> getUserCard(int uId) {
		// TODO Auto-generated method stub
		List<Card> list=new ArrayList<>();
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			String sql="select *from card where uId=?";
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, uId);
			rs=pstm.executeQuery();
			while(rs.next())
			{
				Card card=new Card();
				card.setCardId(rs.getInt("cardId"));
				card.setuId(rs.getInt("uId"));
				card.setCardNum(rs.getLong("cardNum"));
				card.setCardType(rs.getString("cardType"));
				card.setMoney(rs.getBigDecimal("money"));
				card.setAddress(rs.getString("address"));
				card.setCreateTime(rs.getDate("createTime"));
				card.setCardStatu(rs.getInt("cardStatu"));
				list.add(card);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			this.closeAll(con, pstm, rs);
		}
		return null;
	}

	@Override
	public Card getCardMessage(Card card) {
		// TODO Auto-generated method stub
		Card c=new Card();
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			String sql="select *from card where uId=? and cardNum=?";
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, card.getuId());
			pstm.setLong(2, card.getCardNum());
			rs=pstm.executeQuery();
			if(rs.next())
			{
				c.setCardId(rs.getInt("cardId"));
				c.setuId(rs.getInt("uId"));
				c.setCardNum(rs.getLong("cardNum"));
				c.setCardType(rs.getString("cardType"));
				c.setMoney(rs.getBigDecimal("money"));
				c.setAddress(rs.getString("address"));
				c.setCreateTime(rs.getDate("createTime"));
				c.setCardStatu(rs.getInt("cardStatu"));
				c.setPassword(rs.getString("password"));
				return c;
			}
			else
			{
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			this.closeAll(con, pstm, rs);
		}
		return null;
	}

	@Override
	public boolean traderMoney(int uId, long putNum, long intNum,BigDecimal money) {
		// TODO Auto-generated method stub
		boolean f=false;
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		Card flag=findCardNum(intNum);
		//��ȡת��������Ϣ
				Card cd=new Card();
				cd.setuId(uId);
				cd.setCardNum(putNum);
				
				Card cc=getCardMessage(cd);
				BigDecimal re=cc.getMoney().subtract(money);
				if(putNum==intNum)
				{
					//ת��ʧ�ܣ��˺Ų���Ϊ�Լ�
					transferService.addTransferFloat(false, putNum, intNum, money, "Ŀ���˺Ų���Ϊ�Լ����޷�ת��");
					f= false;
				}
				
				if(re.doubleValue()<0)
				{
					//ת��ʧ�ܣ��˺Ž���
					//ת��ʧ�ܣ��˺Ų���Ϊ�Լ�
					transferService.addTransferFloat(false, putNum, intNum, money, "ת�˽��㣬�޷�ת��");
					f= false;
				}
				if(flag==null)
				{
					//ת��ʧ�ܣ��˺Ų�����
					transferService.addTransferFloat(false, putNum, intNum, money, "Ŀ���˺Ų����ڣ��޷�ת��");
					f= false;
				}
				else if(flag.getCardStatu()==0||flag.getCardStatu()==2||flag.getCardStatu()==3)
				{
					//�˺��쳣
					transferService.addTransferFloat(false, putNum, intNum, money, "Ŀ���˻�״̬������״̬");
					f= false;
				}
				else
				{
					//ת��ȥ��
					try {
						con.setAutoCommit(false);
						String reduSql="update card set money=? where cardId=?";
						pstm=con.prepareStatement(reduSql);
						pstm.setBigDecimal(1, re);
						pstm.setInt(2, cc.getCardId());
						int n=pstm.executeUpdate();
						
						//��ñ�ת���Ľ��
						Card tr_card=findCardNum(intNum);
						
						BigDecimal tr_reult=tr_card.getMoney().add(money);
						String addSql="update card set money=? where cardId=?";
						pstm=con.prepareStatement(addSql);
						pstm.setBigDecimal(1, tr_reult);
						pstm.setInt(2, tr_card.getCardId());
						int m=pstm.executeUpdate();
						if(n>0&&m>0)
						{
							con.commit();//�ύ����
							logmsgService.addLog(cc.getCardId(), cc.getuId(), 3, money);//ת����־
							logmsgService.addLog(tr_card.getCardId(), tr_card.getuId(), 4, money);//ת����־
							
							//���³ɹ��Ҹ�����־
							System.out.println("����ת��......");
							Thread.sleep(1000);
							System.out.println("ת�˳ɹ���");
							
					transferService.addTransferFloat(true, putNum, intNum, money, "");
							f= true;
						}
						else
						{
							con.rollback();
							transferService.addTransferFloat(false, putNum, intNum, money, "�쳣");
							f= false;
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						try {
							con.rollback();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}finally{
						this.closeAll(con, pstm, rs);
					}
				}
				return f;
	}

	/**
	 * ���ҿ��Ƿ����
	 */
	@Override
	public Card findCardNum(long num) {
		// TODO Auto-generated method stub
		Card c=new Card();
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			String sql="select *from card where cardNum=?";
			pstm=con.prepareStatement(sql);
			pstm.setLong(1, num);
			rs=pstm.executeQuery();
			if(rs.next())
			{
				//���ڸÿ�
				c.setCardId(rs.getInt("cardId"));
				c.setuId(rs.getInt("uId"));
				c.setCardNum(rs.getLong("cardNum"));
				c.setCardType(rs.getString("cardType"));
				c.setMoney(rs.getBigDecimal("money"));
				c.setAddress(rs.getString("address"));
				c.setCreateTime(rs.getDate("createTime"));
				c.setCardStatu(rs.getInt("cardStatu"));
				c.setPassword(rs.getString("password"));
				return c;
			}
			else{
				return null;
			}
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
	public Card getOneCard(int id) {
		// TODO Auto-generated method stub
		Card c=new Card();
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			String sql="select *from card where cardId=?";
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next())
			{
				//���ڸÿ�
				c.setCardId(rs.getInt("cardId"));
				c.setuId(rs.getInt("uId"));
				c.setCardNum(rs.getLong("cardNum"));
				c.setCardType(rs.getString("cardType"));
				c.setMoney(rs.getBigDecimal("money"));
				c.setAddress(rs.getString("address"));
				c.setCreateTime(rs.getDate("createTime"));
				c.setCardStatu(rs.getInt("cardStatu"));
				c.setPassword(rs.getString("password"));
				return c;
			}
			else{
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstm, rs);
		}
		return null;
	}

	@Override
	public void updateStatu(int id, int uId,long num) {
		// TODO Auto-generated method stub
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			String sql="update card set cardStatu=? where cardId=? and cardNum=? and uId=?";
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, 2);
			pstm.setInt(2, id);
			pstm.setLong(3, num);
			pstm.setInt(4, uId);
			int n=pstm.executeUpdate();
			if(n>0)
			{
				System.out.println("���¿�״̬");
			}
			else
			{
				System.out.println("����ʧЧ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstm, rs);
		}
	}

	@Override
	public boolean selectMethod(int cardid, int personId, int typeId,
			BigDecimal money) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		//�����ж�ѡ���
				try {
					
				 
					Card c=getOneCard(cardid);//��ȡĳ�ſ���Ϣ
				if(typeId==1)
				{
					//ȡ���жϽ���Ƿ�������
					BigDecimal result=c.getMoney().subtract(money);
					if(result.doubleValue()>=0)
					{
						//�ۿ�����
						String reduSql="update card set money=? where cardId=?";
						pstm=con.prepareStatement(reduSql);
						pstm.setBigDecimal(1, result);
						pstm.setInt(2, cardid);
						int rd=pstm.executeUpdate();
						if(rd>0)
						{
							//���³ɹ�
							System.out.println("�ۿ�ɹ�");
							//������־
							
							logmsgService.addLog(cardid, personId, typeId, money);
							flag= true;
						}
						else
						{
							System.out.println("����ʧ��");
							flag= false;
						}
					}
					else
					{
						//�ۿ�ʧ�ܣ����������
						System.out.println("�ۿ�ʧ�ܣ����С��ȡ�����");
						flag= false;
					}
				}
				else if(typeId==2)
				{
					//���
					BigDecimal add=c.getMoney().add(money);
					String addSql="update card set money=? where cardId=?";
					pstm=con.prepareStatement(addSql);
					pstm.setBigDecimal(1, add);
					pstm.setInt(2, cardid);
					int r=pstm.executeUpdate();
					if(r>0)
					{
						//���³ɹ�
						System.out.println("���ɹ�");
						//������־
						logmsgService.addLog(cardid, personId, typeId, money);
						flag= true;
					}
					else
					{
						System.out.println("����ʧ��");
						flag= false;
					}
				}
				else
				{
					//��ѡ����ȷ
					System.out.println("ѡ������");
					flag= false;
				}
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				finally{
					this.closeAll(con, pstm, rs);
				}
				
				return flag;
		
		
	}

	@Override
	public boolean addCardNum(Card card) {
		// TODO Auto-generated method stub
		//ע�Ῠ��
		boolean flag=false;
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			Date d=new Date();
			 SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
			String sql="insert into card(uId,cardNum,cardType,money,address,createTime,cardStatu,password)"
					+ " values(?,?,?,?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, card.getuId());
			pstm.setLong(2, card.getCardNum());
			pstm.setString(3, card.getCardType());
			pstm.setBigDecimal(4, card.getMoney());
			pstm.setString(5, card.getAddress());
			pstm.setString(6, from.format(d));
			pstm.setInt(7, card.getCardStatu());
			pstm.setString(8, card.getPassword());
			int n=pstm.executeUpdate();
			if(n>0)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			this.closeAll(con, pstm, rs);
		}
		return flag;
	}

	@WebMethod
	@Override
	public Card getWebServiceCard(long num) {
		// TODO Auto-generated method stub
		Card c=new Card();
		Connection con=this.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		try {
			String sql="select *from card where cardNum=?";
			pstm=con.prepareStatement(sql);
			pstm.setLong(1, num);
			rs=pstm.executeQuery();
			if(rs.next())
			{
				//���ڸÿ�
				c.setCardId(rs.getInt("cardId"));
				c.setuId(rs.getInt("uId"));
				c.setCardNum(rs.getLong("cardNum"));
				c.setCardType(rs.getString("cardType"));
				c.setMoney(rs.getBigDecimal("money"));
				c.setAddress(rs.getString("address"));
				c.setCreateTime(rs.getDate("createTime"));
				c.setCardStatu(rs.getInt("cardStatu"));
				c.setPassword(rs.getString("password"));
				
				//
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("�����ⲿWebService���ʣ���IPΪ��"+getIPAd());
				return c;
			}
			else{
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			this.closeAll(con, pstm, rs);
		}
		return null;
	}

	@WebMethod
	@Override
	public String getIPAd() {
		// TODO Auto-generated method stub
		String add_str="";
		try
		{ 
			add_str= "������IP="+InetAddress.getLocalHost();
		} catch (UnknownHostException e)
		{ 
		e.printStackTrace();
		}
		return add_str;
		}

}
