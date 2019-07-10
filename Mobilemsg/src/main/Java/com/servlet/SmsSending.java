package com.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SmsSending {
	TwilioMessageExample mm=new TwilioMessageExample();
	public JSONObject sendRequest(String message){
		//	String countrycode"";
			
		JSONObject obj=JSONObject.fromObject(message);
		
		//		JSONArray mobile1=obj.getJSONArray(mobilenumber);
		//obj.containsKey("mobilenumber");
//		mobile1.add(mobilenumber);
//		message=obj.getString(message);
//		countrycode=obj.getString(countrycode);
		
//		String code=obj.getString(key)
		textmessage(obj);
		return obj;
			
			
		}
		public String textmessage(JSONObject obj) {
			String countrycode=null;
			JSONArray mobilenumber=null;
			String message=null;
			try {
				if(obj.containsKey("countrycode")) {
					countrycode=obj.getString("countrycode");
					System.out.println(countrycode);
					countrycode = "+"+countrycode.trim();
				}else {
					System.out.println("no countrycode");
					return null;
				}if(obj.containsKey("mobilenumber")) {
					mobilenumber=obj.getJSONArray("mobilenumber");
					System.out.println(mobilenumber);
				}else {
					System.out.println("no mobilenumber");
					return null;
				}if(obj.containsKey("message")) {
					message=obj.getString("message");
					System.out.println(message);
				}else {
					System.out.println("no message");
					return null;
				}
				
				for(int i=0;i<mobilenumber.size();i++) {
				mm.sendMessage(countrycode+ mobilenumber.getString(i),message);
					
				}
			/*
			 * //JSONObject sendMessageTo=mm.msg(countrycode, mobilenumber, message);
			 * //if(sendMessageTo==null) { System.out.println("msg not sent"); }
			 */
				
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
		}


}
