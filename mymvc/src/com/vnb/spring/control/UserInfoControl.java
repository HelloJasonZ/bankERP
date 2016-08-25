package com.vnb.spring.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.email.EmailUtil;
import com.email.User;
import com.vnb.spring.entity.Card;
import com.vnb.spring.entity.UserInfo;
import com.vnb.spring.service.CardService;
import com.vnb.spring.service.UserInfoService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoControl {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private CardService cardService;
	
	
	/**
	 * 验证登录
	 * @param userName
	 * @param password
	 * @param loginType
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value="/getSelectLogin", method = RequestMethod.POST)
	@ResponseBody
	public UserInfo getSelectLogin(@RequestParam String userName,@RequestParam String password,@RequestParam String loginType,HttpSession httpSession,HttpServletRequest request)
	{
		int logintyId=Integer.parseInt(loginType);
		UserInfo user=null;
		UserInfo info=new UserInfo();
		info.setEmail(userName);
		info.setPhone(userName);
		info.setPassword(password);
		UserInfo u =userInfoService.userLogin(info, logintyId);
		if(u.getUserName()!=null)
		{
			//装入session
			String error_id_index="error_index"+u.getPhone();
			String error_transfer_index="error_transfer_index"+u.getPhone();
			httpSession.setAttribute("user", u);
			httpSession.setAttribute(error_id_index,0);
			httpSession.setAttribute(error_transfer_index, 0);
			//修改登录时间
			boolean f=userInfoService.updateLoginTime(u.getuId(), u);
			
			user=u;
			if(f)
				{
				System.out.println(">>>>>登录成功");
				}
		
		}
		else
		{
			System.out.println("登录失败！");
		}
		return user;
	}
	
	@RequestMapping(value="/loginOut")
	public String loginOut(HttpSession httpSession)
	{
		UserInfo user=(UserInfo) httpSession.getAttribute("user");
		if(user!=null)
		{
			httpSession.removeAttribute("user");
		}
		
		return "user/login";
	}
	
	@RequestMapping(value="/returnPersonal", method = RequestMethod.POST)
	public String returnPersonal(HttpSession httpSession,HttpServletRequest request)
	{
		UserInfo uf=(UserInfo) httpSession.getAttribute("user");
		if(uf!=null)
		{
			List<Card> list=cardService.getUserCard(uf.getuId());
			request.setAttribute("list", list);
			return "user/personal";
		}
		else
		{
			return "user/login";
		}
		//获取卡号信息
	}
	
	
	/**
	 * 手机号码邮箱验证
	 * @param content
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/validPhone", method = RequestMethod.POST)
	@ResponseBody
	public String validPhone(@RequestParam String content,@RequestParam String type)
	{
		
		boolean flag=userInfoService.regMessage(content, Integer.valueOf(type));
		if(flag)
		{
			return "1";
		}
		else
		{
			return "0";
		}
	}
	
	@RequestMapping(value="/addRegister", method = RequestMethod.POST)
	@ResponseBody
	public String addRegister(@RequestParam String userName,@RequestParam String phone,@RequestParam String email,@RequestParam String password)
	{
		UserInfo u=new UserInfo();
		u.setUserName(userName);
		u.setPassword(password);
		u.setPhone(phone);
		u.setEmail(email);
		boolean f=userInfoService.addUserInfo(u);
		if(f)
		{
			return "1";
		}
		else
		{
			return "0";
		}
	}
	
	//生成认证码
	@RequestMapping(value="/validEmail", method = RequestMethod.POST)
	@ResponseBody
	public String validEmail(@RequestParam String email,HttpSession httpSession)
	{
		//调用发送邮箱
		Integer authCode=EmailUtil.autoNum();//生成验证码
		httpSession.setAttribute(email, String.valueOf(authCode));
		User u=new User();
		u.setEmail(email);
		System.out.println(">>>>>>>>>>"+authCode);
		EmailUtil.sendAuthCodeEmail(u, authCode);
		System.out.println(">>>>>>>>>>>>>>>ok");
		return "1";
	}
	
	//验证码校验
	@RequestMapping(value="/toValid", method = RequestMethod.POST)
	@ResponseBody
	public String toValid(@RequestParam String email,@RequestParam String code,HttpSession httpSession)
	{
		String get_code=(String) httpSession.getAttribute(email);
		if(get_code==null)
		{
			return "0";
		}
		else
		{
			if(get_code.equals(code))
			{
				//如果两个人验证码相等，则跳入修改页面
				//验证码通过销毁验证码
				httpSession.removeAttribute(email);
				//加入邮箱session
				httpSession.setAttribute("email_id", email);
				return "1";
				
			}
			else
			{
				//验证码有误
				return "0";
			}
		}
	}
	
	//修改密码
	@RequestMapping(value="/update_passowrd", method = RequestMethod.POST)
	@ResponseBody
	public String toValid(@RequestParam String password,HttpSession httpSession)
	{
		String email_id=(String) httpSession.getAttribute("email_id");
		if(email_id==null)
		{
			System.out.println(">修改失效");
			return "0";
		}
		else
		{
			//email没有失效
			boolean flag=userInfoService.updatePassowrd(email_id, password);
			if(flag)
			{
				System.out.println(">修改成功");
				return "1";
			}
			else
			{
				return "0";
			}
		}
	}
}
