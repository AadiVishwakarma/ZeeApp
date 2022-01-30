package com.zee.zee5app.dto;

import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Subscription implements Comparable<Subscription>{
	
	
	
	public Subscription(String id, String dateOfPurchase, String expiryDate, int subscriptionAmount, String paymentMode,
			String status, String type, String autoRenewal) {
		super();
		this.id = id;
		this.dateOfPurchase = dateOfPurchase;
		this.expiryDate = expiryDate;
		this.SubscriptionAmount = subscriptionAmount;
		this.paymentMode = paymentMode;
		this.status = status;
		this.type = type;
		this.autoRenewal = autoRenewal;
	}

	private String id;
	private String dateOfPurchase;
	private String expiryDate;
	
	@Setter(value = AccessLevel.NONE)
	private int SubscriptionAmount;
	private String paymentMode;
	private String status;
	private String type;
	private String autoRenewal;
	
	
	
	public void setSubscriptionAmount(int subsamount) throws InvalidAmountException  {
		// TODO Auto-generated method stub
		if(subsamount < 600)
		{
			throw new InvalidAmountException("Invalid amount");
		}
		this.SubscriptionAmount = subsamount;
	}
	
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	

	
	

}
