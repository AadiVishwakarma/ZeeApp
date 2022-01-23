package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class SeriesIdNotFoundException extends Exception {
public SeriesIdNotFoundException(String msg) {
	// TODO Auto-generated constructor stub
	super(msg);
}
}
