package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;

@Service

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public String addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(userRepository.existsByEmailAndContactNumber(register.getEmail(),register.getContactNumber())==true) {
			throw new AlreadyExistsException("this record already exists");
		}
		userRepository.findById(register.getId());
		
		Register register2 = userRepository.save(register);
		
		if(register2 != null)
		{
			//addCredentials LoginService
//			Login login = new Login();
//			login.setUserName(register.getEmail());
//			login.setPassword(register.getPassword());
//			login.setRegId(register.getId());
//			login.setRole(EROLE.ROLE_USER);
//			
//			if(loginRepository.existsByUserName("abhi@gmail.com"))
//			{
//				throw new AlreadyExistsException("record exists");
//			}
//			String result = loginService.addCredentials(login);
//			if(result != "success")
//			{
//				return "success! user added in register";
//			}
//			else
//			{
//				return "fail";
//			}
			return "success";
		}
		else
		{
			return "fail to add user";
		}
	}

	
	//update() will be handled automatically
	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
		
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		List<Register> list = userRepository.findAll();
		Register[] array = new Register[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Register> optional = this.getUserById(id);
			if(optional.isEmpty())
			{
				throw new IdNotFoundException("record not found ");
			}
			else
			{
				userRepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	
	}

	@Override
	public Optional<List<Register>> getAllUserDetails(){
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}

	
}
