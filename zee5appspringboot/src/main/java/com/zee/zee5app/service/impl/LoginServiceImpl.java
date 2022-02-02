package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepository loginRepository;
	//private LoginRepository loginRepository = LoginRepositoryImpl.getInstance();
	
	
//	@Override
//	public String addCredentials(Login login) {
//		// TODO Auto-generated method stub
//		return loginRepository.addCredentials(login);
//	}
//	
	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = loginRepository.save(login);
		
		if(login2 != null)
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}
	@Override
	public String deleteCredentials(String username) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Login> optional = loginRepository.findById(username);
		if (optional.isEmpty())
			throw new IdNotFoundException("login record not found");
		else {
			loginRepository.deleteById(username);
			return "success";
		}
	}
	@Override
	public String changeCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
