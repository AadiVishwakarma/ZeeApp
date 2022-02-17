package com.zee.zee5app.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.NameNotFoundException;


public interface SubscriptionService {
	public Subscription addSubscription(Subscription subscription);
	public Optional<Subscription> getSubscriptionById(Long id) throws IdNotFoundException, InvalidAmountException;
	public Optional<List<Subscription>> getAllSubscriptions() throws InvalidAmountException;
	public String deleteSubscription(Long id) throws IdNotFoundException, InvalidAmountException;
	public String modifySubscription(Long id, Subscription subscription) throws IdNotFoundException, NameNotFoundException;
	
	public Optional<List<Subscription>> getAllSubscriptionDetails() throws InvalidAmountException;

}
