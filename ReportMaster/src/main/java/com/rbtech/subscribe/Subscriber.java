package com.rbtech.subscribe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Subscriber {
	
	//email address should not change for a subscriber.
	private final String emailAddress;
	private final List<NotificationMessage> notificationMessages = new ArrayList<NotificationMessage>();
	
	public void addNotification(String notificationMessageText) {
		NotificationMessage notificationMessage = new NotificationMessage(notificationMessageText);
		this.notificationMessages.add(notificationMessage);
	}

	public Collection<NotificationMessage> getNotificationMessages() {
		return notificationMessages;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	
	Subscriber(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
