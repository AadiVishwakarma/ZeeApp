package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class MovieIdNotFoundException extends Exception {
public MovieIdNotFoundException(String msg) {
	// TODO Auto-generated constructor stub
	super(msg);
}
}
