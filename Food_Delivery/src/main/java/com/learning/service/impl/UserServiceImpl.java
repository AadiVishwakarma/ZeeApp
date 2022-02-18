package com.learning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.Login;
import com.learning.dto.User;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.LoginRepository;
import com.learning.repo.UserRepository;
import com.learning.service.UserService;


//for singleton instance
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
	public User addUser(User register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
	
//		if(userRepository.existsByEmail(user.getEmail())) {
//			throw new AlreadyExistsException("this record already exists");
//		}
//		User register2 = userRepository.save(user);
//		if (register2 != null) {
//			Login login = new Login(user.getEmail(), user.getPassword(),register2);
//			if(loginRepository.existsByEmailAndPassword(user.getEmail(), user.getPassword())) {
//				throw new AlreadyExistsException("this record already exists");
//			}
//			
//			if(loginService.addCredentials(login) == "success") {
//				return register2;
//			}
//			else {
//				return null;
//			}
//		}	
//		else {
//			return null;
//		}
		
		boolean status = userRepository.existsByEmail(register.getEmail());
		if(status) {
			throw new AlreadyExistsException("this record already exists");
		}
	
		User register2 = userRepository.save(register);
		
		if(register2 != null)
		{
			return register2;
		}
		else
		{
			return null;
		}
	}

	@Override
	public User updateUser(Long id, User user) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(!this.userRepository.existsById(id))
			throw new IdNotFoundException("invalid id");
		
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optional =  userRepository.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id not exist");
		}
		else {
			return optional.get();
		}
	}

	@Override
	public String deleteUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		User optional;
		try {
			optional = this.getUserById(id);
			if(optional==null) {
				throw new IdNotFoundException("record not found");
			}
			else {
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
	public Optional<List<User>> getAllUserDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}
	
}
