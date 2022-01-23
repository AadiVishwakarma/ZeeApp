package com.zee.zee5app.repository.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.exception.SubscriptionIdNotFoundException;
import com.zee.zee5app.repository.SubscriptionRepository;


public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	
	//AL will hold 10 elements of type subscription
	private ArrayList<Subscription> arrayList = new ArrayList<>();
//	private Subscription[] subscriptions = new Subscription[10];
//	private static int count = -1;
	
    private SubscriptionRepositoryImpl() {
		
	}
	
    
    //singleton instance
	private static SubscriptionRepository subscriptionRepository;
	public static SubscriptionRepository getInstance() {
		if(subscriptionRepository==null)
			subscriptionRepository = new SubscriptionRepositoryImpl();
		
		return subscriptionRepository;
	
	}
	
    
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		boolean result = this.arrayList.add(subscription);
		if(result)
		{
			return "successfully added subscription";
		}
		else
		{
			return "failed to add subscription";
		}
	}

	@Override
	public String deleteSubscription(String id) throws SubscriptionIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Subscription> optional = this.getSubscriptionById(id);
		
		if(optional.isPresent())
		{
			boolean result = arrayList.remove(optional.get());
			if(result)
			{
				return "subscription successfully deleted";
			}
			else
			{
				return "subscription failed to delete";
			}
		}

		return "fail";
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) throws SubscriptionIdNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		String result = this.deleteSubscription(id);
		if(result=="Failed")
			return "Failed to delete subscription";
		result = this.addSubscription(subscription);
		if(result=="Fail")
			return "Failed to Add Subscription";
		return "Subscription Modified";
	}

	
	/*
	 * Optional is a class which is specifically designed to handle null pointer exception
	 * if we are total confident about the object(will surely get object =) then use optional.of()
	 */
	
	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws SubscriptionIdNotFoundException {
		// TODO Auto-generated method stub
		Subscription subscription2 = null;
		for (Subscription subscription : arrayList) {
			if(subscription.getId().equals(id))
			{
				//return Optional.of(subscription);
				subscription2 = subscription;
			}
		}
		return Optional.ofNullable(Optional.of(subscription2).orElseThrow(()-> new SubscriptionIdNotFoundException("subscription id not found")));
		/*Optional.ofNullable():
		 * if subscription2 is holding null it will act like an empty()
		 * if subscription2 is holding object it will act like of()
		 */
	}

	@Override
	public Subscription[] getAllSubscription() {
		// TODO Auto-generated method stub
		Subscription subscription[] = new Subscription[arrayList.size()];
		
		return arrayList.toArray(subscription);
	}
	
	@Override
	public ArrayList<Subscription> getAllSubscriptionDetails()
	{
		return arrayList;
	}

}
