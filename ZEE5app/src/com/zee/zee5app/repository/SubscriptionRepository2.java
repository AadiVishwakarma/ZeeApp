package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Subscription;

public class SubscriptionsRepository {
	private Subscription[] subscription = new Subscription[10];
	
	private static int count=-1;
	
	public String addSubscription(Subscription subscriptions)
	{
		if(count== subscription.length-1)
		{
			Subscription temp[]= new Subscription[subscription.length*4];
			System.arraycopy(subscription, 0, temp, 0, subscription.length);
			subscription = temp;
			subscription[++count]= subscriptions;
			
			return "success! Added subscription";
		}
		subscription[++count] = subscriptions;
		return "success! Added subscription";
		
	}
	
	public String deleteSubscription(String id)
	{
		return null;
	}
	
	public String modifySubscription(String id, Subscription subscriptions)
	{
		return null;
	}
	
	public Subscription getSubscriptionById(String id)
	{
		
	}
	
	private SubscriptionsRepository()
	{
		
	}
	
	public static SubscriptionsRepository subscriptionRepository;
	public static SubscriptionsRepository getInstance()
	{
		if(subscriptionRepository == null)
			subscriptionRepository = new SubscriptionsRepository();
		return subscriptionRepository;
	}

}
 