package com.learning.exception;


//if Id is not avaialbel in database
public class IdNotFoundException extends Exception {
	public IdNotFoundException(String msg)
	{
		super(msg);
	}
}
