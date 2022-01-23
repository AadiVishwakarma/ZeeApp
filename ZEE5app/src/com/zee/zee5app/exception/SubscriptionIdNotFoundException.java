package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class SubscriptionIdNotFoundException extends Exception {
public SubscriptionIdNotFoundException(String msg) {
	// TODO Auto-generated constructor stub
	super(msg);
	
}
}
