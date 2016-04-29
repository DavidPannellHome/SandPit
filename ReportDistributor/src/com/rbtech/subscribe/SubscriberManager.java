package com.rbtech.subscribe;

import java.util.HashMap;
import java.util.Map;

public class SubscriberManager {
	
	private Map <String, Subscriber> subscriberList = new HashMap<String, Subscriber>();
	
	//public void CreateSubscriberOrAppendMessage(String emailAddress, NotificationMessage notifMessage, SubscriberList subscriberList) {
	public void CreateSubscriberOrAppendMessage(String emailAddress, String notifMessage) {
		
		if (subscriberExists(emailAddress)  == false){
			createSubscriber(emailAddress);
			setNotificationMessage(emailAddress, notifMessage);			
		}
		else {
			appendNotificationMessage(emailAddress, notifMessage);
		}
	}

	private boolean subscriberExists(String emailAddress) {
		//Would it be better to have a boolean variable to ensure the function returns with value? 
		if ( subscriberList.containsKey(emailAddress) ) {
	    	return true;
	      }
		else {
			return false;
		  }
	}
	
	private void createSubscriber(String emailAddress) {
		Subscriber subscriber = new Subscriber(emailAddress);
        subscriberList.put(emailAddress, subscriber);
		
		System.out.println("Adding new subscriber: " + emailAddress);
	}
	
    private void setNotificationMessage(String emailAddress, String notifMessage) {
	    subscriberList.get(emailAddress).setNotificationMessage(notifMessage);
	    System.out.println("Adding notification for subscriber: " + emailAddress);
    }
    
    private void appendNotificationMessage(String emailAddress, String notifMessage) {
 	   subscriberList.get(emailAddress).appendNotificationMessage(notifMessage);
	   System.out.println("Adding notification for subscriber: " + emailAddress);
    }
    
    public void printList() {
    	printAll(subscriberList);
    }
    
    public static void printAll(Map <String, Subscriber> mp) {
        System.out.println("\nAll entries in List");
        System.out.println("===================");
	    for(Map.Entry<String, Subscriber> entries : mp.entrySet()) {
	    	//System.out.println(entries.getKey() + ": " + entries.getValue().getNotificationMessage());
	    	entries.getValue().showAll();
	    }
	}
	
}
