package com.rbtech.subscribe;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotificationMessage {
		
	private String notifMessageText;
	private String timeDateStamp;
	
	NotificationMessage(String notifText){
		setTimeDateStamp();
		setNotifMessageText(notifText);
	}

	public String getTimeDateStamp() {
		return timeDateStamp;
	}

	public void setTimeDateStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeDateStamp = dateFormat.format(new Date());
		this.timeDateStamp = timeDateStamp;
	}

	public String getNotifMessageText() {
		return notifMessageText;
	}

	public void setNotifMessageText(String notifMessageText) {
		setTimeDateStamp();
		this.notifMessageText = getTimeDateStamp() + ":" + notifMessageText;
	}
	
	public void appendNotifMessageText(String notifMessageText) {
		this.notifMessageText = notifMessageText;
	}

}
