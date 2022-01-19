package com.zee.zee5app.service;

import com.zee.zee5app.repository.SubscriptionsRepository;


public class SubscriptionService {
	private SubscriptionsRepository subscriptionRepo = SubscriptionsRepository.getInstance();
	
	private static SubscriptionService subscriptionservice = null;
	
	public static SubscriptionService getInstance()
	{
		if(subscriptionservice==null)
		{
			subscriptionservice = new SubscriptionService();
		}
		return subscriptionservice;
	}
	
}