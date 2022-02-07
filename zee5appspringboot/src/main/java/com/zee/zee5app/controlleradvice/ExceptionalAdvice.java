package com.zee.zee5app.controlleradvice;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

@ControllerAdvice
public class ExceptionalAdvice {
// expecting that this class should be used when any undefined exception
	//is called throughtout all the controller 
	
	//to handle particular type exception(i.e., alreadyexists exception )
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyRecordExistsExceptionHandler()
	{
		HashMap<String,String> map = new HashMap<>();
		map.put("message","Record already exists");
		return ResponseEntity.badRequest().body(map);
	}
	
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> IdNotFoundExceptionHandler(IdNotFoundException e)
	{
		HashMap<String,String> map = new HashMap<>();
		map.put("message","Id already exists"+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
	
	//this can handle all unknown exception
	//if no match above then will take this exception 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception e)
	{
		HashMap<String,String> map = new HashMap<>();
		map.put("message","unknown exception"+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
	
}
