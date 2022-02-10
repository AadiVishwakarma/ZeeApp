package com.zee.zee5app.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="subscription")
public class Subscription implements Comparable<Subscription>{

	@Id
	@Column(name="subId")
	private String id;
	
	@NotNull
	private String dateOfPurchase;
	
	@NotNull
	private String expiryDate;
	
	@NotNull
	private int SubscriptionAmount;
	private String paymentMode;
	
	@NotBlank
	private String status;
	
	@NotBlank
	private String type;
	
	@NotBlank
	private String autoRenewal;
	
	@NotBlank
	private String regId;
	
	
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private User register;
}
