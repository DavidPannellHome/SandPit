package com.rbtech.subscribe;

import java.util.HashMap;
import java.util.Map;

public class SubscriberManager {
	
	private Map <String, Subscriber> subscribers = new HashMap<String, Subscriber>();
	
	//public void CreateSubscriberOrAppendMessage(String emailAddress, NotificationMessage notifMessage, SubscriberList subscriberList) {
	public void addNotifToSubscriber(String emailAddress, String notifMessage) {
		
		if (subscriberExists(emailAddress)  == false){
			createSubscriber(emailAddress);		
		}
			
		Subscriber subscriber = getSubscriber(emailAddress);
		subscriber.addNotification(notifMessage);
	}
		
	private Subscriber getSubscriber(String emailAddress) {
		return subscribers.get(emailAddress);
	}
		
		
	private boolean subscriberExists(String emailAddress) {
		//Would it be better to have a boolean variable to ensure the function returns with value? 
		// Add test that emailAddress is not null
		if ( subscribers.containsKey(emailAddress) ) {
	    	return true;
	      }
		else {
			return false;
		  }
	}
	
	private void createSubscriber(String emailAddress) {
		Subscriber subscriber = new Subscriber(emailAddress);
        subscribers.put(emailAddress, subscriber);
		
		System.out.println("Adding new subscriber: " + emailAddress);
	}
	
    private void setNotificationMessage(String emailAddress, String notifMessage) {
	    subscribers.get(emailAddress).addNotification(notifMessage);
	    System.out.println("Adding notification for subscriber: " + emailAddress);
    }
    
    
    public void printList() {
    	printAll(subscribers);
    }
    
    public static void printAll(Map <String, Subscriber> mp) {
        System.out.println("\nAll entries in List");
        System.out.println("===================");
	    for(Map.Entry<String, Subscriber> entries : mp.entrySet()) {
	    	//System.out.println(entries.getKey() + ": " + entries.getValue().getNotificationMessage());
	//    	entries.getValue().showAll();
	    }
	}
	
}
