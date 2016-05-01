package com.rbtech.subscribe;

import java.util.ArrayList;

import com.rbtech.subscribe.NotificationMessage;

public class Subscriber {
	
	private String emailAddress;
	//I think we talked about allowing a set of Notifications per user, at the moment just a single string value
	private String notificationMessage;
	private ArrayList<NotificationMessage> notifs = new ArrayList<NotificationMessage>();
	
	public void addNotification(String notifText) {
		NotificationMessage notif = new NotificationMessage(notifText);
		this.notifs.add(notif);
	}
	
	public void appendNotificationMessage(String notificationMessage) {
		System.out.println("Appending message");
		this.notificationMessage = this.notificationMessage + "\n\n" + notificationMessage;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void showAll() {
		System.out.println("Subscriber Email: " + getEmailAddress()
		                 + "  Messages: " + getNotificationMessage());	
	}
	
	Subscriber(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
