package com.zee.zee5app.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.Impl.LoginRepositoryImpl;
import com.zee.zee5app.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{
	
	public LoginServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	private LoginRepository loginRepository = LoginRepositoryImpl.getInstance();
	
	//instance
	private static LoginService loginservice;
	public static LoginService getInstance() throws IOException
	{
		if(loginservice==null)
			loginservice = new LoginServiceImpl();
		return loginservice;
	}
	
	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		return loginRepository.addCredentials(login);
	}

	@Override
	public String deleteCredentials(String username) {
		// TODO Auto-generated method stub
		return loginRepository.deleteCredentials(username);
	}

	@Override
	public String changeCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return loginRepository.changeCredentials(username, password);
	}

	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		return loginRepository.changeRole(username, role);
	}

}
