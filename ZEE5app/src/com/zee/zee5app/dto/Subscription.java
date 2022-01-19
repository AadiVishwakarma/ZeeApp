package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Subscription {
	private String type;
	private String dateOfPurchase;
	private String id;
	private String paymentMode;
	private String packCountry;
	private String status;
	private String autoRenewal;
	private String expiryDate;
	
	

}
