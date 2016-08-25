package com.my.email;


public class TestMail {
		
		public static void main(String[] args) {
			MailSendInfo mailinfo=new MailSendInfo();
			mailinfo.setMailServerHost("smtp.exmail.qq.com");///发送者的服务器主机smtp.qq.com
			//mailinfo.setMailServerHost("smtp.exmail.qq.com");
			mailinfo.setMailServerPort("25");//SMTP的端口号
			
			mailinfo.setUserName("383577035@qq.com");//发送者邮件账号
			mailinfo.setPassword("Ilovelingforever");//发送者邮箱密码
			mailinfo.setFromAddress("383577035@qq.com");//发送者的地址
			
			//String[] toAddress={"471819072@qq.com","527371803@qq.com","1405784433@qq.com","383577035@qq.com","214882690@qq.com"};
			//mailinfo.setToAddress(toAddress);
			mailinfo.setToAddress("471819072@qq.com");//接受者地址
			mailinfo.setSubject("作业提交");
			mailinfo.setContent("如果生活这么哈");//邮箱的内容，html格式的内容
			
			SimplrMailSender sms=new SimplrMailSender();
	
			boolean flag=sms.sendHtmlMail(mailinfo);
			if(flag){
				/*for(int i=0;i<mailinfo.getToAddress().length;i++){*/
					
					System.out.println("发送成功！");
				/*}*/
			}
			else{
				System.out.println("发送失败");
			}
			
		}
		
		
}
