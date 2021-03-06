package com.zee.zee5app.service.impl;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.repository.SubscriptionRepository;



@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	
	@Override
	public Subscription addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		Subscription subscription2 = subscriptionRepository.save(subscription);
		
		if(subscription2 != null)
		{
			return subscription2;
		}
		else
		{
			return null;
		}
	}


	@Override
	public Optional<List<Subscription>> getAllSubscriptions()  {
		// TODO Auto-generated method stub
//		List<Subscription> list = subscriptionRepository.findAll();
//		Subscription[] array = new Subscription[list.size()];
//		return list.toArray(array);
		return Optional.ofNullable(subscriptionRepository.findAll());
	}



	@Override
	public String modifySubscription(Long id, Subscription subscription)
			throws IdNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<List<Subscription>> getAllSubscriptionDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(subscriptionRepository.findAll());
	}


	@Override
	public Optional<Subscription> getSubscriptionById(Long id) throws IdNotFoundException, InvalidAmountException {
		// TODO Auto-generated method stub
		return subscriptionRepository.findById(id);
	}


	@Override
	public String deleteSubscription(Long id) throws IdNotFoundException, InvalidAmountException {
		// TODO Auto-generated method stub
		try {
			Optional<Subscription> optional = this.getSubscriptionById(id);
			if(optional.isEmpty())
			{
				throw new IdNotFoundException("record not found ");
			}
			else
			{
				subscriptionRepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	
}


