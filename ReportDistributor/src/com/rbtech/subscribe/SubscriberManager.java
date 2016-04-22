package com.rbtech.subscribe;

import com.rbtech.subscribe.SubscriberList;
import com.rbtech.subscribe.Subscriber;
import com.rbtech.subscribe.NotificationMessage;

import java.util.Map;
import java.util.HashMap;

public class SubscriberManager {
	
	//public void CreateSubscriberOrAppendMessage(String emailAddress, NotificationMessage notifMessage, SubscriberList subscriberList) {
	public void CreateSubscriberOrAppendMessage(String emailAddress, String notifMessage, Map<String, Subscriber> subscriberList) {
		//Test if emailAddress exists in the hashMap
		if ( subscriberList.containsKey(emailAddress) ) {
			//if it does
			//append the NotificationMessage to the existing Notif in for the Subscriber	
			System.out.println("Adding notification for subscriber: " + subscriberList.get(emailAddress));
			//System.out.println((subscriberList.get(emailAddress)).getNotificationMessage);
			
			//Subscriber subscriberToUpdate = new Subscriber();
			
			subscriberList.get(emailAddress).appendNotificationMessage(notifMessage);

		}
		else {
		//if it doesn't
		//Create a new Subscriber with the emailAddress and the NotificationMessage
			Subscriber subscriber = new Subscriber(emailAddress);
			subscriber.setNotificationMessage(notifMessage);
			subscriberList.put(emailAddress, subscriber);
			
			System.out.println("Adding new subscriber: " + subscriberList.get(emailAddress));
		
		}
	}

}
