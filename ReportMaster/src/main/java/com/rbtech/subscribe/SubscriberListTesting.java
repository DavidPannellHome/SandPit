package com.rbtech.subscribe;

import java.util.HashMap;
import java.util.Map;

public class SubscriberListTesting {
	
	public static void main(String[] args) {
		
		SubscriberManager subscriberManager = new SubscriberManager();
		 
		System.out.println("Adding notifications and creating Subscribers where necessary....");
		System.out.println("=================================================================\n");
		
		subscriberManager.addNotifToSubscriber("djloki@yahoo.com", "First notification text is here.");
		subscriberManager.addNotifToSubscriber("djloki@yahoo.com", "Second notification text.  What time is love?");
		subscriberManager.addNotifToSubscriber("djloki@yahoo.com", "Third notification text.  Justified and Ancient");
		subscriberManager.addNotifToSubscriber("", "This should not create an email address but through an error instead");
		subscriberManager.addNotifToSubscriber("mike.sparx@gmail.com", "First notification text for this user.");

	    subscriberManager.printList();
		
	}

	public static void oldTests() {
        Map <String, Subscriber> subscriberList = new HashMap<String, Subscriber>();
		
		//Set up a couple of subscribers
		Subscriber subscriberOne = new Subscriber("djloki@yahoo.com");
		Subscriber subscriberTwo = new Subscriber("mike.sparx@gmail.com");
		
		//Some notifications
		//NotificationMessage notifOne = new NotificationMessage();
		//notifOne.setNotifMessageText("Hello David!");
		
		//NotificationMessage notifTwo = new NotificationMessage();
		//notifTwo.setNotifMessageText("Hello Mike!");
		
		//Associate the notifications to subscribers
		//subscriberOne.setNotificationMessage(notifOne);
		//subscriberOne.setNotificationMessage(notifTwo);
		
		subscriberList.put(subscriberOne.getEmailAddress(), subscriberOne);
		subscriberList.put(subscriberTwo.getEmailAddress(), subscriberTwo);
		
		System.out.println();
	    System.out.println(" Map Elements are:");
	    System.out.print("\t" + subscriberList);
	}
}
