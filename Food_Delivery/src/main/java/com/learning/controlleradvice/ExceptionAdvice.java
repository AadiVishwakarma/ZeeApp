package com.learning.controlleradvice;

import java.util.HashMap;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.apierror.ApiError;






@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler{

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
		
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, org.springframework.http.HttpHeaders headers
				, HttpStatus status, WebRequest request)
		{
			ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
			apiError.setMessage("Validation Error");
			apiError.addValidationErrors(ex.getBindingResult().getFieldErrors()); //field wise errors
			apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
			return buiResponseEntity(apiError);
		}
		
		private ResponseEntity<Object> buiResponseEntity(ApiError apiError){
			return new ResponseEntity<>(apiError, apiError.getHttpStatus());
		}
		
		
		@ExceptionHandler(ConstraintViolationException.class)
		protected ResponseEntity<?> handleConstraintViolation() {
			return null;
		}
}
