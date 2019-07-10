package com.servlet;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class WhatsApp {
	

		public static final String ACCOUNT_SID = "ACe4664be2c4d6d95a4df7cd311d0b8b3d";
		 public static final String AUTH_TOKEN = "0e11679fa3f6e9c9a7196964e279d5fe";
		 public static String to = "whatsapp:+917795189256";
		 public static String from = "whatsapp:+14155238886";
		 
		 public static void main(String[] args) {
		     sendMessage(to, from, "Hello gud evng");
		 }
		 
		 public static void sendMessage(String to,String from,String msg) {
			 try {
				 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			     Message message = Message.creator(
			             new PhoneNumber(to),
			             new PhoneNumber(from),
			             msg)
			         .create();
			     System.out.println("sms send to mobile "+to);
			     System.out.println(message.getSid());
			 }catch (Exception e) {
				 e.printStackTrace();
			}
		 }

}
