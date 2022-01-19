package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.repository.Impl.SubscriptionRepositoryImpl;

public class SubscriptionServiceImpl implements SubscriptionService {

	private SubscriptionRepository repository = SubscriptionRepositoryImpl.getInstance();
	private static SubscriptionService service;	
	
	public static SubscriptionService getInstance() {
		if(service == null)
			service = new SubscriptionServiceImpl();
		return service;
	}
	
    private SubscriptionServiceImpl() {
		
	}
	
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		return this.repository.addSubscription(subscription);
	}

	@Override
	public Subscription getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return this.repository.getSubscriptionById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		return repository.getAllSubscription();
	}

}
