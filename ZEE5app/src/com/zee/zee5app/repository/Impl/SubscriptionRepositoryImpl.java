package com.zee.zee5app.repository.Impl;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepository;


public class SubscriptionRepositoryImpl implements SubscriptionRepository {

	private Subscription[] subscriptions = new Subscription[10];
	private static int count = -1;
	
    private SubscriptionRepositoryImpl() {
		
	}
	
	private static SubscriptionRepository subscriptionRepository;
	public static SubscriptionRepository getInstance() {
		if(subscriptionRepository==null)
			subscriptionRepository = new SubscriptionRepositoryImpl();
		
		return subscriptionRepository;
	
	}
	
    
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		if(count == subscriptions.length-1) {
			Subscription temp[] = new Subscription[subscriptions.length*4];
		    System.arraycopy(subscription, 0, temp, 0, subscriptions.length);
		    subscriptions = temp;
		    subscriptions[++count] = subscription;
		    
		    return "success1";
		}
		subscriptions[++count] = subscription;
	    return "success1";
	}

	@Override
	public String deleteSubscription(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscription getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		for (Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getId().equals(id))
				return subscription;		
		}
		return null;
	}

	@Override
	public Subscription[] getAllSubscription() {
		// TODO Auto-generated method stub
		return subscriptions;
	}

}
