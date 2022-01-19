package com.zee.zee5app.service;
import com.zee.zee5app.dto.Subscription;

public interface SubscriptionService {
	public String addSubscription(Subscription subscription);
	public Subscription getSubscriptionById(String id);
	public Subscription[] getAllSubscriptions();

}
