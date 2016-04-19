package com.rbtech.subscribe;

import com.rbtech.subscribe.NotificationMessage;

public class Subscriber {
	
	private String emailAddress;
	//I think we talked about allowing a set of Notifications per user, at the moment just a single string value
	private NotificationMessage notificationMessage;

	public NotificationMessage getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(NotificationMessage notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	Subscriber(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
