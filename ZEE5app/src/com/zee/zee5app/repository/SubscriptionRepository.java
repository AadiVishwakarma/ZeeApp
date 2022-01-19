package com.zee.zee5app.repository;
import com.zee.zee5app.dto.Subscription;

public interface SubscriptionRepository {
	public String addSubscription(Subscription subscription);
	public String deleteSubscription(String id);
	public String modifySubscription(String id, Subscription subscription);
	public Subscription getSubscriptionById(String id);
	public Subscription[] getAllSubscription();

}
