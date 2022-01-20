package com.zee.zee5app.dto;

import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Register {
	
	
	public Register(String id,String firstname,String lastName, String email, String password) throws InvalidIdLengthException, InvalidNameException	
	{
		super();
		this.setId(id);
		this.setFirstName(firstname);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPassword(password);
	}
	
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	//want to have length of 6 min
	
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	private String email;
	private String password;
	
	
	
	public void setId(String id) throws InvalidIdLengthException
	{
		if(id.length()<6)
		{
			//this should raise the invalid id exception
			throw new InvalidIdLengthException("id length is lesser than or equal to 6");
		}
		this.id=id;
	}
    
	public void setFirstName(String firstName) throws InvalidNameException {
		// TODO Auto-generated method stub
		if(firstName==null || firstName=="" || firstName.length()<2)
		{
			throw new InvalidNameException("first name is not valid");
		}
		this.firstName=firstName;
	}
	
	public void setLastName(String lastName) throws InvalidNameException {
		// TODO Auto-generated method stub
		if(lastName==null || lastName=="" || lastName.length()<2)
		{
			throw new InvalidNameException("last name is not valid");
		}
		this.lastName=lastName;
	}
	
	
	
	
}
