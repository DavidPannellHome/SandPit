package com.rbtech.subscribe;

public class NotificationMessage {
	//Currently just a string but we can extend this.
	
	private String emailAddress;
	private String notifMessageText;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getNotifMessageText() {
		return notifMessageText;
	}

	public void setNotifMessageText(String notifMessageText) {
		this.notifMessageText = notifMessageText;
	}
	
	public void appendNotifMessageText(String notifMessageText) {
		this.notifMessageText = notifMessageText;
	}

}
