package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;

import java.util.List;
import java.util.Optional;


public interface UserService {
	public String addUser(Register register);
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Optional<Register> getUserById(String id) throws IdNotFoundException;
	public Register[] getAllUsers();
	public String deleteUserById(String id) throws IdNotFoundException;
	public List<Register> getAllUserDetails();

}
