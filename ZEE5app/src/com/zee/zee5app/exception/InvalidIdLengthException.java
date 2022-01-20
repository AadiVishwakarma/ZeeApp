package com.zee.zee5app.exception;

import lombok.ToString;


//internally this will give a call to base class==>exception

@ToString(callSuper = true)
public class InvalidIdLengthException extends Exception {

	public InvalidIdLengthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
//this is another method of lombak(callsuper=true)	
//	@Override
//	public String toString() {
//		return "IdNotFoundException [toString()=" + super.toString() + "]";
//	}

}
