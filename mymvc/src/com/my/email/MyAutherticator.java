package com.my.email;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;



public class MyAutherticator extends Authenticator{
	/*
	 * 身份验证类
	 * 
	 */
		String userName = null;
		String password  =  null;
		
		
		public MyAutherticator(){
			
		}
		
		public MyAutherticator(String userName,String password){
			this.userName=userName;
			this.password=password;
		}
		
		protected PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(userName,password);
		}
	
}
