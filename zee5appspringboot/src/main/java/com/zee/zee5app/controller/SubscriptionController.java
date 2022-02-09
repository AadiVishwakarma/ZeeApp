package com.zee.zee5app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.SubscriptionService;

@RestController

@RequestMapping("/subscription")
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;
}
