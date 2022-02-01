package com.zee.zee5app.service.impl;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.repository.Impl.SubscriptionRepositoryImpl;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	public SubscriptionRepository subscriptionRepository;
//	private SubscriptionRepository subscriptionRepository = SubscriptionRepositoryImpl.getInstance();
//	private static SubscriptionService service;	
//	
//	public static SubscriptionService getInstance() throws IOException { 
//		if(service == null)
//			service = new SubscriptionServiceImpl();
//		return service;
//	}
//	
//    private SubscriptionServiceImpl() throws IOException{
//		
//	}
	
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		return this.subscriptionRepository.addSubscription(subscription);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidAmountException  {
		// TODO Auto-generated method stub
		return subscriptionRepository.getSubscriptionById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() throws InvalidAmountException {
		// TODO Auto-generated method stub
		return subscriptionRepository.getAllSubscription();
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return subscriptionRepository.deleteSubscription(id);
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
		return subscriptionRepository.modifySubscription(id, subscription);
	}

	

	
	public Optional<ArrayList<Subscription>> getAllSubscriptionDetails() throws InvalidAmountException {
		// TODO Auto-generated method stub
		return subscriptionRepository.getAllSubscriptionDetails();
	}

	
	
	
	
	}


