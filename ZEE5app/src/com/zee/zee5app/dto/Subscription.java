package com.zee.zee5app.dto;

import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Subscription implements Comparable<Subscription>{
	private String type;
	private String dateOfPurchase;
	private String id;
	
	@Setter(value = AccessLevel.NONE)
	private int SubscriptionAmount;
	private String packCountry;
	private String status;
	private String autoRenewal;
	private String expiryDate;
	
	
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
