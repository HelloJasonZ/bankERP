package com.vnb.spring.control;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vnb.spring.entity.Card;
import com.vnb.spring.entity.UserInfo;
import com.vnb.spring.service.CardService;
import com.vnb.spring.service.UserInfoService;

@Controller
@RequestMapping("/card")
public class CardControl {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private CardService cardService;
	
	
	@RequestMapping(value="/getCardMessage", method = RequestMethod.GET)
	public String getCardMessage(@RequestParam String cardNum,HttpSession httpSession,HttpServletRequest request)
	{
		UserInfo uf=(UserInfo) httpSession.getAttribute("user");
		if(uf==null)
		{
			return "user/login";
		}
		else
		{
			Card cd=new Card();
			cd.setuId(uf.getuId());
			cd.setCardNum(Long.valueOf(cardNum));
			Card card=cardService.getCardMessage(cd);
			request.setAttribute("card", card);
			return "card/check_card";
		}
		
	}
	
	//ajax自动获取卡号
	@RequestMapping(value="/autoGetCardNum", method = RequestMethod.POST)
	@ResponseBody
	public String autoGetCardNum()
	{
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("MHHmmss");
		String c=622600000+sd.format(d);
		//生成卡号
		long cardNum=Long.valueOf(c);
		Card card=cardService.findCardNum(cardNum);
		if(card!=null)
		{
			//有重复卡号在自动生成
			 sd=new SimpleDateFormat("MMHHmmss");
			  c=6226000+sd.format(d);
			  cardNum=Long.valueOf(c);
		}
		return String.valueOf(cardNum);
	}
	
	//ajax注册卡号
	@RequestMapping(value="/registerCardNum", method = RequestMethod.POST)
	@ResponseBody
	public String registerCardNum(@RequestParam String cardNum,@RequestParam String address,@RequestParam String password,HttpSession httpSession)
	{
		UserInfo userInfo=(UserInfo) httpSession.getAttribute("user");
		if(userInfo==null)
		{
			System.out.println(">用户失效");
			return "0";
		}
		else
		{
			Card card=cardService.findCardNum(Long.valueOf(cardNum));
			if(card!=null)
			{
				System.out.println("该卡已经存在！");
				return "-1";
			}
			else
			{
				//注册卡号
				Card cd=new Card();
				cd.setuId(userInfo.getuId());
				cd.setCardNum(Long.valueOf(cardNum));
				cd.setCardType("CNY");
				cd.setMoney(new BigDecimal(0));
				cd.setAddress(address);
				cd.setCreateTime(new Date());
				cd.setCardStatu(1);
				cd.setPassword(password);
				boolean b=cardService.addCardNum(cd);
				if(b)
				{
					//注册成功
					System.out.println(">>>>>注册成功");
					return "1";
				}
				else
				{
					return "-1";
				}
			}
		}
	}
	
	//存钱
	@RequestMapping(value="/depositMoney", method = RequestMethod.POST)
	@ResponseBody
	public String depositMoney(@RequestParam String cardNum,@RequestParam String money,HttpSession httpSession)
	{
		UserInfo userInfo=(UserInfo) httpSession.getAttribute("user");
		if(userInfo==null)
		{
			System.out.println(">用户失效");
			return "0";
		}
		else
		{
			//用户存在
			Card card=new Card();
			card.setCardNum(Long.valueOf(cardNum));
			card.setuId(userInfo.getuId());
			Card c=cardService.getCardMessage(card);
			if(c!=null&&c.getCardStatu()==1)
			{
				boolean trade_statu=cardService.selectMethod(c.getCardId(), userInfo.getuId(), 2, new BigDecimal(money));
				if(trade_statu)
				{
					//交易成功
					System.out.println("交易成功");
					return "1";
				}
				else
				{
					//交易失败
					System.out.println("交易失败");
					return  "-2";
				}
			}
			else
			{
				System.out.println(">操作失败");
				return "-2";
			}
		}
	}
	//转账
	@RequestMapping(value="/transferMoney", method = RequestMethod.POST)
	@ResponseBody
	public String transferMoney(@RequestParam String cardNum,@RequestParam String password,@RequestParam String intNum,@RequestParam String money,HttpSession httpSession)
	{
		UserInfo userInfo=(UserInfo) httpSession.getAttribute("user");
		if(userInfo==null)
		{
			System.out.println(">用户失效");
			return "0";
		}
		else
		{
			Card card=new Card();
			card.setCardNum(Long.valueOf(cardNum));
			card.setuId(userInfo.getuId());
			Card c=cardService.getCardMessage(card);
			if(c!=null&&c.getCardStatu()==1)
			{
				//存在卡卡正常
				//判断密码是否正确
				if(c.getPassword().equals(password)){
					boolean trade_statu=cardService.traderMoney(userInfo.getuId(), Long.parseLong(cardNum), Long.parseLong(intNum), new BigDecimal(money));
					if(trade_statu)
					{
						//交易成功
						System.out.println("交易成功");
						return "1";
					}
					else
					{
						//交易失败
						System.out.println("交易失败");
						return "-2";
					}
					
					
				}else
				{
					System.out.println("密码错误");
					String error_transfer_index="error_transfer_index"+userInfo.getPhone();
					int error_transfer_session=(int) httpSession.getAttribute(error_transfer_index);
					if(String.valueOf(error_transfer_session)==null)
					{
						//首次密码失败
						httpSession.setAttribute(error_transfer_index, 1);
					}
					else
					{
						int index=(int) httpSession.getAttribute(error_transfer_index);
						index=index+1;
						httpSession.setAttribute(error_transfer_index, index);
						if (index>4)
						{
							//操作失误过多修改卡的状态
							cardService.updateStatu(c.getCardId(), userInfo.getuId(), c.getCardNum());
						}
						
					}
					return "-1";
				}
			}
			else
			{
				System.out.println(">操作失败");
				return "-2";
			}
		}
		
	}
	
	//取钱
	@RequestMapping(value="/widthDrawMoney", method = RequestMethod.POST)
	@ResponseBody
	public String widthDrawMoney(@RequestParam String cardNum,@RequestParam String password,@RequestParam String money,HttpSession httpSession)
	{
		UserInfo userInfo=(UserInfo) httpSession.getAttribute("user");
		if(userInfo==null)
		{
			System.out.println(">用户失效");
			return "0";
		}
		else
		{
			Card card=new Card();
			card.setCardNum(Long.valueOf(cardNum));
			card.setuId(userInfo.getuId());
			
			Card c=cardService.getCardMessage(card);
			if(c!=null&&c.getCardStatu()==1)
			{
				//存在卡卡正常
				//判断密码是否正确
				if(c.getPassword().equals(password)){
					boolean trade_statu=cardService.selectMethod(c.getCardId(), userInfo.getuId(), 1, new BigDecimal(money));
					if(trade_statu)
					{
						//交易成功
						System.out.println("交易成功");
						return "1";
					}
					else
					{
						//交易失败
						System.out.println("交易失败");
						return "-2";
					}
					
				}
				else
				{
					System.out.println("密码错误");
					String error_id_index="error_index"+userInfo.getPhone();
					int error_id_session=(int) httpSession.getAttribute(error_id_index);
					System.out.println("");
					if(String.valueOf(error_id_session)==null)
					{
						//首次密码失败
						httpSession.setAttribute(error_id_index, 1);
					}
					else
					{
						int index=(int) httpSession.getAttribute(error_id_index);
						index=index+1;
						httpSession.setAttribute(error_id_index, index);
						if (index>4)
						{
							//操作失误过多修改卡的状态
							cardService.updateStatu(c.getCardId(), userInfo.getuId(), c.getCardNum());
						}
						
					}
					return "-1";
				}
			}
			else
			{
				System.out.println(">操作失败");
				return "-2";
			}
			
		}
	}

}
