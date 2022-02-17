package com.zee.zee5app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.SubscriptionService;

@CrossOrigin("*")
@RestController

@RequestMapping("/api/subscription")
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;
	
	@PostMapping("/addSubscription")
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<?> addSubscription(@Valid @RequestBody Subscription subscription) throws AlreadyExistsException
	{
		Subscription result = subscriptionService.addSubscription(subscription);
        return ResponseEntity.status(201).body(result);
	}
	
	@GetMapping("/all")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    public ResponseEntity<?> getAllSubscriptions() throws InvalidAmountException {
        Optional<List<Subscription>> optional = subscriptionService.getAllSubscriptions();
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No subscription found");
        }
        return ResponseEntity.status(200).body(optional.get());
    }
	
	 @GetMapping("/{id}")
	    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	    public ResponseEntity<?> getSubscriptionById(@PathVariable("id") long id) throws IdNotFoundException, InvalidAmountException {
	        Optional<Subscription> optional = subscriptionService.getSubscriptionById(id);
	        if (optional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No subscription found");
	        }
	        return ResponseEntity.status(200).body(optional.get());
	    }
}
