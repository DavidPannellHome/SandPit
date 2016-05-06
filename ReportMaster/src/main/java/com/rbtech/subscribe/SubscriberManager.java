package com.rbtech.subscribe;

import java.util.HashMap;
import java.util.Map;

public class SubscriberManager {
	
	private Map <String, Subscriber> subscribers = new HashMap<String, Subscriber>();
	
	public void addNotifToSubscriber(String emailAddress, String notifMessage) {
		
		//Not keen on this if then else - must be a better way to handle a null email address
		if (emailAddress == "") {
			System.out.println("No email address supplied, subscriber not created.");
		}
		else {

				if (subscriberExists(emailAddress)  == false){
					createSubscriber(emailAddress);		
				}
					
				Subscriber subscriber = getSubscriber(emailAddress);
				subscriber.addNotification(notifMessage);
		}
    }
		
	private Subscriber getSubscriber(String emailAddress) {
		return subscribers.get(emailAddress);
	}
		
		
	private boolean subscriberExists(String emailAddress) {
		// Add test that emailAddress is not null - 
		// not really happy doing the test here - if the email address is null we have a problem
		// and there is no point in creating a subscriber with null email address
		// such an error should be handled elsewhere.  But where?
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
	
//    private void setNotificationMessage(String emailAddress, String notifMessage) {
//	    subscribers.get(emailAddress).addNotification(notifMessage);
//	    System.out.println("Adding notification for subscriber: " + emailAddress);
//    }
    
    public void printList() {
    	printAll(subscribers);
    }
    
    public static void printAll(Map <String, Subscriber> mp) {
        System.out.println("\nHere are all Subscribers and their notifications");
        System.out.println("================================================");
	    for(Map.Entry<String, Subscriber> subscribers : mp.entrySet()) {
	    	//System.out.println(entries.getKey() + ": " + entries.getValue().getNotificationMessage());
	    	System.out.println("\n" + subscribers.getKey() + ": " + subscribers.getValue().getEmailAddress());
	    	subscribers.getValue().showNotifications();
	//    	entries.getValue().showAll();
	    }
	}
	
}
