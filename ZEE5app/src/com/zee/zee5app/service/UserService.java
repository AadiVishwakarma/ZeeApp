package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;

import java.util.Optional;


public interface UserService {
	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Optional<Register> getUserById(String id);
	public Register[] getAllUsers();
	public String deleteUserById(String id);

}
