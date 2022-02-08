package com.learning.service;

import java.util.List;
import java.util.Optional;

import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;



public interface UserService {
	public Register addUser(Register register) throws AlreadyExistsException;
	public Register updateUser(String id, Register register) throws IdNotFoundException;
	public Register getUserById(String id) throws IdNotFoundException; 
	public String deleteUserById(String id) throws IdNotFoundException;
	Optional<List<Register>> getAllUserDetails();
	
}
