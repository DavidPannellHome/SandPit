package com.rbtech.subscribe;

import java.util.HashMap;
import java.util.Map;

public class SubscriberListTesting {
	
	public static void main(String[] args) {
		//SubscriberList subscriberList = new SubscriberList();
		
		SubscriberManager subscriberManager = new SubscriberManager();
		
		
		/// reame to send Message to Subscriber (the create can happen in the background user doesnt need to know) 
		subscriberManager.addNotifToSubscriber("djloki@yahoo.com", "First message Text");
		subscriberManager.addNotifToSubscriber("djloki@yahoo.com", "2nd message Text");
		subscriberManager.addNotifToSubscriber("mike.sparx@gmail.com", "First message Text");

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
