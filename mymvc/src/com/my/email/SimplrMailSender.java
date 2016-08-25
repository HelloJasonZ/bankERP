package com.my.email;


import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * 邮件发送的主类
 * 
 */
public class SimplrMailSender {
	/*
	 * 以HTml格式发送邮件
	 * 
	 */
		public boolean sendHtmlMail(MailSendInfo mailinfo){   //检测邮件发送的失败
			//身份验证
			MyAutherticator autherticator=new MyAutherticator(mailinfo.getUserName(),mailinfo.getPassword());
			Properties pro=mailinfo.getProperties();//获取服务器的主机和端口
			//根据邮件会话属性和密码验证器构造一个发送邮件sessiom
			Session sendmailSession = Session.getDefaultInstance(pro, autherticator);
			
			try{
				//根据session创建一个邮件消息
			Message mailMessage=new MimeMessage(sendmailSession);
			
			//创建发送者地址
			Address from = new InternetAddress(mailinfo.getFromAddress());
			//设置邮件消息的发送者
			mailMessage.setFrom(from);
			
			//创建邮件的接受者地址并设置邮件的消息中
			Address to = new InternetAddress(mailinfo.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			/*int len=mailinfo.getToAddress().length;   // 接受者数量
			Address[] to = new InternetAddress[len];
			for(int i=0;i<len;i++){
				to[i]=new InternetAddress(mailinfo.getToAddress()[i]);
			}*/
			//mailMessage.setRecipients(Message.RecipientType.TO, to);
			
			//定义邮件主题
			mailMessage.setSubject(mailinfo.getSubject());
			//设置发送的时间
			mailMessage.setSentDate(new Date());
			
			//邮件的内容
			//创建一个容器类
			Multipart mainPart=new MimeMultipart();
			//创建一个包含html内容的MimeBodyPart
			MimeBodyPart html=new MimeBodyPart();
			
			//设置HTml的内容
			html.setContent(mailinfo.getContent(),"text/html;charset=utf-8");
			mainPart.addBodyPart(html);
			
			mailMessage.setContent(mainPart);
			
			//发送邮件
			 MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
		      mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		      mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		      mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		      mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		      mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		      CommandMap.setDefaultCommandMap(mc);

		      Transport.send(mailMessage);
		      return true;
			
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			return false;
			
		}
	
}
