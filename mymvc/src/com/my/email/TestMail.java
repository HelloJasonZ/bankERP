package com.my.email;


public class TestMail {
		
		public static void main(String[] args) {
			MailSendInfo mailinfo=new MailSendInfo();
			mailinfo.setMailServerHost("smtp.exmail.qq.com");///�����ߵķ���������smtp.qq.com
			//mailinfo.setMailServerHost("smtp.exmail.qq.com");
			mailinfo.setMailServerPort("25");//SMTP�Ķ˿ں�
			
			mailinfo.setUserName("383577035@qq.com");//�������ʼ��˺�
			mailinfo.setPassword("Ilovelingforever");//��������������
			mailinfo.setFromAddress("383577035@qq.com");//�����ߵĵ�ַ
			
			//String[] toAddress={"471819072@qq.com","527371803@qq.com","1405784433@qq.com","383577035@qq.com","214882690@qq.com"};
			//mailinfo.setToAddress(toAddress);
			mailinfo.setToAddress("471819072@qq.com");//�����ߵ�ַ
			mailinfo.setSubject("��ҵ�ύ");
			mailinfo.setContent("���������ô��");//��������ݣ�html��ʽ������
			
			SimplrMailSender sms=new SimplrMailSender();
	
			boolean flag=sms.sendHtmlMail(mailinfo);
			if(flag){
				/*for(int i=0;i<mailinfo.getToAddress().length;i++){*/
					
					System.out.println("���ͳɹ���");
				/*}*/
			}
			else{
				System.out.println("����ʧ��");
			}
			
		}
		
		
}
