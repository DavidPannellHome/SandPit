package com.rbtech.bhc008.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//import java.util.logging.*;



import com.rbtech.bhc008.data.Message;

public class MessageLog {
	
   public static final String LOG_TYPE_INFO = "Info";
   public static final String LOG_TYPE_WARN = "Warning";
   public static final String LOG_TYPE_ERROR = "Error";
   public static final String LOG_TYPE_FORMAT = "Format";
   public static final String UNDER_SCORE  = "____________________________________________________________________________";
   public static final String UNDER_LINE   = "----------------------------------------------------------------------------";
   public static final String DOUBLE_UNDER = "============================================================================";

   private static ArrayList<Message> Messages = new ArrayList<Message>();
	
   public void logNewMessage(Message message) {
	   Messages.add(message);
   }
   
   public static void logNewMessage(String messageText, String messageType) {
	   
	   Message message = new Message(); 
	   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   
	   message.setDateStamp(dateFormat.format(new Date()));
	   message.setMessageText(messageText);
	   message.setMessageType(messageType);
	   Messages.add(message);
	   
   }
   
    public static String outputAllMessages() {
	   
     String OutputString = "";
     
     for(Message mes : Messages) {
    	 OutputString = OutputString + mes.getDateStamp()
    			                     + " "
    			                     + mes.getMessageText()
    			                     + " <"
    			                     + mes.getMessageType()
    			                     + ">\n";
     }
     return OutputString; 	 
     
   }
}
