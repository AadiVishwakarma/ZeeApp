package com.learning.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.dto.Login;
import com.learning.dto.Register;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.LoginRepository;
import com.learning.service.LoginService;



public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = loginRepository.save(login);
		if (login2 != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public String deleteCredentials(String email) {
		// TODO Auto-generated method stub
		Optional<Login> optional;
		try {
			optional = loginRepository.findById(email);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				loginRepository.deleteById(email);
				return "login record deleted";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String changePassword(String email, String password) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Login> login = this.loginRepository.findById(email);
		if(login.isEmpty())
			throw new IdNotFoundException("invalid id");
		login.get().setPassword(password);
		return (this.loginRepository.save(login.get())!= null) ? "success":"fail";
	}

	@Override
	public String validateCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = new Login();
		Register register2 = new Register();
		
		if(login.getEmail()==register2.getEmail() && login.getPassword()==register2.getPassword()) {
			return "success";
		}
		else
			return "fail";
	}
}
