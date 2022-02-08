package com.learning.exception;


//this exception is for records that already exists in database
public class AlreadyExistsException extends Exception{
	public AlreadyExistsException(String message) {
		super(message);
	}
}
