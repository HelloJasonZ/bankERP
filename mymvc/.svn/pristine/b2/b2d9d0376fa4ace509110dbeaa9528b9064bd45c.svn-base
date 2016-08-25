package com.email;


import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 閫氳繃閭鍙戦�楠岃瘉鐮�
 * 
 * @author pengkejie
 * 
 */

public class EmailUtil {

	public static String FROM = "";
	public static String PASSWORD = "";

	public static void main(String[] args) {
		User user = new User();
		user.setEmail("1351371760@qq.com");
		Integer authCode = 15679785;
		EmailUtil.sendAuthCodeEmail(user, authCode);
		//System.out.println(">>>>>>>>"+autoNum());
	}

	/**
	 * 用户注册和找回密码的时,发送验证码到邮箱进行验证
	 * 
	 * @param user
	 * @param authCode
	 */

	public static void sendAuthCodeEmail(User user, Integer authCode) {
		try {
			Session session = getSession();
			MimeMessage message = new MimeMessage(session);
			Date date = new Date();
			// 设置发送时间
			message.setSentDate(date);
			// 设置邮件主题
			message.setSubject("网上银行——By小强", "UTF-8");
			// 设置发件人
			message.setFrom(new InternetAddress(FROM));
			// 设置收件人
			message.setRecipient(RecipientType.TO,new InternetAddress(user.getEmail()));
			// 设置右键内容
			message.setContent("网上银行——By小强for you:"+authCode,"text/html;charset=utf-8");
			Transport.send(message);
			System.out.println("验证码发送完毕!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 随机生成6为验证码
	 * @return
	 */
	public static Integer autoNum()
	{
		int radomInt = new Random().nextInt(999999);
		
		return radomInt;
	}

	/**
	 * 获取properties文件
	 * 
	 * @return
	 * @throws Exception
	 */

	public static Properties getProperties() throws Exception {
		Properties props = new Properties();
		InputStream inStream = EmailUtil.class
				.getResourceAsStream("email.properties");
		props.load(inStream);
		FROM = props.getProperty("emailfrom");
		PASSWORD = props.getProperty("password");
		return props;
	}

	/**
	 * 设置邮箱session
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Session getSession() throws Exception {
		Properties props = getProperties();
		Authenticator authenticator = new Authenticator() {// 发送邮件帐号权限认证
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PASSWORD);
			}
		};
		Session session = Session.getInstance(props, authenticator);
		session.setDebug(true);
		return session;
	}
}
