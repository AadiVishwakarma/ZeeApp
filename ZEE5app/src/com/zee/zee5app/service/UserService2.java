package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
//service objects are used to just call the services inside the main method
// can we do this using 1 object?
// to fix they provided a solution called singleton Design Pattern.
// one  =  to get only one object for the specific type
//import com.zee.zee5app.repository.UserRepository2;

public class UserService2 {
	
	private UserRepository repository = UserRepository.getInstance();
	// service is consuming repository
	
	private UserService() {
		
	}
    // if we want to create that single object then we have to create it inside the same class
	// and we have to share reference with others
	// to do the same we have to declare a method
	
	private static UserService service = null;
	//this would be static only one copy
	// private makes it inaccessible to outside world, so we make it static to make it accessible outside
	
	public static UserService2 getInstance() {
		// is it obj dependent or independent?
		// it is dependent 
		// when we use static method becomes obj independent
		
		//UserService = null;
		//this is a local reference but this wont work
		
		
		// static method will access only static ref
		//it create an object in 1st call and then other 99 calls can use the existing creating object
		if(service==null)
		 service = new UserService();
		return service;
	}
	public String addUser(Register register) {
		return this.repository.addUser(register);
	}
	
	public Register getUserById(String id) {
		return this.repository.getUserById(id);
		// we use this to follow standard practice to access things from a class
	}
	
	public Register[] getUsers() {
		return repository.getUsers();
	}
	
}
