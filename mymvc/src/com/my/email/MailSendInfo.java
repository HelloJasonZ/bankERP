package com.my.email;


import java.util.Properties;

public class MailSendInfo {
	
	//邮件的服务器的IP和端口
	private String mailServerHost;//邮件服务器的主机
	private String mailServerPort;//邮件服务器的端口
	
	//发送的地址
	private String fromAddress;
	//登陆的密码和账号
	private String userName;
	private String password;
	
	
	//接受者的地址
	private String toAddress;
	//private String[] toAddress;
	
	//邮件的主题
	private String subject;
	//邮件的内容
	private String content; 
	
	//封装主机和端口
	public Properties getProperties(){
		Properties p=new Properties();
		p.put("mail.smtp.host", this.mailServerHost);//主机
		p.put("mail.smtp.port", this.mailServerPort);//服务器的端口
		p.put("mail.smtp.auth", true);
		return p;
	}

	public String getMailServerHost() {
		return mailServerHost;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}

	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	/*public String[] getToAddress() {
		return toAddress;
	}

	public void setToAddress(String[] toAddress) {
		this.toAddress = toAddress;
	}*/

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	
	
	
}
