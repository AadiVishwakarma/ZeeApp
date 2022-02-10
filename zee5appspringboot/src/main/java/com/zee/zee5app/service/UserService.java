package com.zee.zee5app.service;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

import java.util.List;
import java.util.Optional;


public interface UserService {
	public User addUser(User register) throws AlreadyExistsException;
	public User updateUser(String id, User register) throws IdNotFoundException;
	public User getUserById(Long id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException;
	public User[] getAllUsers() throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException ;
	public String deleteUserById(Long id) throws IdNotFoundException;
	public Optional<List<User>> getAllUserDetails();

}
