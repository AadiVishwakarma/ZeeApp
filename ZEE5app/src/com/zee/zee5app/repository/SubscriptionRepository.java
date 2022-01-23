package com.zee.zee5app.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.exception.SubscriptionIdNotFoundException;

public interface SubscriptionRepository {
	public String addSubscription(Subscription subscription);
	public String deleteSubscription(String id) throws SubscriptionIdNotFoundException;
	public String modifySubscription(String id, Subscription subscription) throws SubscriptionIdNotFoundException, NameNotFoundException;
	public Optional<Subscription> getSubscriptionById(String id) throws SubscriptionIdNotFoundException;
	public Subscription[] getAllSubscription();
	public ArrayList<Subscription> getAllSubscriptionDetails();

}
