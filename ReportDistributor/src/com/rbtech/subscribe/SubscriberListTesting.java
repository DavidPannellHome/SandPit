package com.rbtech.subscribe;

import java.util.HashMap;
import java.util.Map;

public class SubscriberListTesting {
	
	public static void main(String[] args) {
		Map <String, Subscriber> subscriberList = new HashMap<String, Subscriber>();
		
		//Set up a couple of subscribers
		Subscriber subscriberOne = new Subscriber("djloki@yahoo.com");
		Subscriber subscriberTwo = new Subscriber("mike.sparx@gmail.com");
		
		//Some notifications
		NotificationMessage notifOne = new NotificationMessage();
		notifOne.setNotifMessageText("Hello David!");
		
		NotificationMessage notifTwo = new NotificationMessage();
		notifTwo.setNotifMessageText("Hello Mike!");
		
		//Associate the notifications to subscribers
		subscriberOne.setNotificationMessage(notifOne);
		subscriberOne.setNotificationMessage(notifTwo);
		
		subscriberList.put(subscriberOne.getEmailAddress(), subscriberOne);
		subscriberList.put(subscriberTwo.getEmailAddress(), subscriberTwo);
		
		System.out.println();
	    System.out.println(" Map Elements are:");
	    System.out.print("\t" + subscriberList);
	}

}
