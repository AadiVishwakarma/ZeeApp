package com.zee.zee5app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.exception.SubscriptionIdNotFoundException;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.repository.Impl.SubscriptionRepositoryImpl;

public class SubscriptionServiceImpl implements SubscriptionService {

	private SubscriptionRepository subscriptionRepository = SubscriptionRepositoryImpl.getInstance();
	private static SubscriptionService service;	
	
	public static SubscriptionService getInstance() { 
		if(service == null)
			service = new SubscriptionServiceImpl();
		return service;
	}
	
    private SubscriptionServiceImpl() {
		
	}
	
	@Override
	public String addSubscription(Subscription subscriptionRepository) {
		// TODO Auto-generated method stub
		return this.subscriptionRepository.addSubscription(subscriptionRepository);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws SubscriptionIdNotFoundException  {
		// TODO Auto-generated method stub
		return subscriptionRepository.getSubscriptionById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		return subscriptionRepository.getAllSubscription();
	}

	@Override
	public String deleteSubscription(String id) throws SubscriptionIdNotFoundException {
		// TODO Auto-generated method stub
		return subscriptionRepository.deleteSubscription(id);
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) throws SubscriptionIdNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
		return subscriptionRepository.modifySubscription(id, subscription);
	}

	

	
	public ArrayList<Subscription> getAllSubscriptionDetails() {
		// TODO Auto-generated method stub
		return subscriptionRepository.getAllSubscriptionDetails();
	}

	
	
	
	
	}


