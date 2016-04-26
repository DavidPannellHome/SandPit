package com.rbtech.subscribe;

import java.util.HashMap;
import java.util.Map;
import com.rbtech.subscribe.SubscriberList;

public class SubscriberListTesting {
	
	public static void main(String[] args) {
		//SubscriberList subscriberList = new SubscriberList();
		Map <String, Subscriber> subscriberList = new HashMap<String, Subscriber>();
		SubscriberManager subscriberManager = new SubscriberManager();
		
		
		/// reame to send Message to Subscriber (the create can happen in the background user doesnt need to know) 
		subscriberManager.CreateSubscriberOrAppendMessage("djloki@yahoo.com", "First message Text", subscriberList);
		subscriberManager.CreateSubscriberOrAppendMessage("djloki@yahoo.com", "2nd message Text", subscriberList);
		subscriberManager.CreateSubscriberOrAppendMessage("mike.sparx@gmail.com", "First message Text", subscriberList);

	    printAll(subscriberList);
		
	}
	
	public static void printAll(Map <String, Subscriber> mp) {

	    for(Map.Entry<String, Subscriber> entries : mp.entrySet()) {
	    	//System.out.println(entries.getKey() + ": " + entries.getValue().getNotificationMessage());
	    	entries.getValue().showAll();
	    }
	}

	public static void oldTests() {
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
		//subscriberOne.setNotificationMessage(notifOne);
		//subscriberOne.setNotificationMessage(notifTwo);
		
		subscriberList.put(subscriberOne.getEmailAddress(), subscriberOne);
		subscriberList.put(subscriberTwo.getEmailAddress(), subscriberTwo);
		
		System.out.println();
	    System.out.println(" Map Elements are:");
	    System.out.print("\t" + subscriberList);
	}
}
