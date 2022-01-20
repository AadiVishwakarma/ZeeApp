package com.zee.zee5app.service.impl;

import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.Impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

public class UserServiceImpl implements UserService {

	private UserServiceImpl()
	{
		
	}
	
	private static UserService service;
	
	public static UserService getInstance(){
		if(service==null)
			service = new UserServiceImpl();
		return service;
	}
	
	private UserRepository userRepository = UserRepositoryImpl.getInstance() ;
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return userRepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
