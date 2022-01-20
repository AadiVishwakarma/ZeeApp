package com.zee.zee5app.repository;

import java.util.Optional;

import com.zee.zee5app.dto.Register;

public interface UserRepository {
	
	//these are abstract methods as we have declared the methods but not their bodies
	
	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Optional<Register> getUserById(String id);
	public Register[] getAllUsers();
	public String deleteUserById(String id);

}
