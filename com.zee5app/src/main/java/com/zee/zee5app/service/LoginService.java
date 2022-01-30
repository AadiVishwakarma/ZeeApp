package com.zee.zee5app.service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;

public interface LoginService {
	public String addCredentials(Login login);
	public String deleteCredentials(String username);
	public String changeCredentials(String username, String password);
	public String changeRole(String username, ROLE role);
}
