package com.zee.zee5app.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.NameNotFoundException;


public interface SubscriptionService {
	public String addSubscription(Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidAmountException;
	public Subscription[] getAllSubscriptions() throws InvalidAmountException;
	public String deleteSubscription(String id) throws IdNotFoundException;
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException, NameNotFoundException;
	
	public Optional<ArrayList<Subscription>> getAllSubscriptionDetails() throws InvalidAmountException;

}
