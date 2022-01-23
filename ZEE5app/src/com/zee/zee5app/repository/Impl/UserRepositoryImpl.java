package com.zee.zee5app.repository.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.UserRepository;

// this can be used for 1st database
//similary make another file and use it for 2nd database and so on
// here UserRepository act as an interface which has 5 specific functionalities
public class UserRepositoryImpl implements UserRepository {
	
	//private Register[] registers = new Register[10];
//	private set<Register> set = new set<>();
	private TreeSet<Register> set = new TreeSet<>();
	//for heterogenous just remove angular brackets
	//private static int count = -1;
	
	//now we make an singleton object for this
	private UserRepositoryImpl() {
		
	}
	
	//we cant declare/create objects for interface
	// we can declare only references
	/// when we will refer the object whose class is implementting the interface
	// then object will behave like interface i.e.
	//w we can only access the interface overridden methods
	
	//we use UserRepository here coz we need reference sfrom UserRepository(interface class) not the impl thing.
	

	
	private static UserRepository repository;
	public static UserRepository getInstance() {
		if(repository ==null)
			//but we refer using interface only i.e.
			//repository = new UserRepository()
			// we can only access interface methods
			
			// this will use functionalities of the interface and both class only
			repository = new UserRepositoryImpl();
		return repository;
	}
	
	@Override
	public String addUser(Register register)
	{
		boolean result = this.set.add(register);
		System.out.println(this.set.size());
		if(result)
		{
			return "success";
		}
		return "fail";
	}
	

//	@Override
//	public String addUser(Register register) {
//		// TODO Auto-generated method stub
//		if(count==registers.length-1) {
//			// array is full or we should go for dynamically increasing the size of array
//			Register temp[] = new Register[registers.length*4];
//			
//			//now we need to copy the contents from old to new array
//			System.arraycopy(registers, 0, temp, 0, registers.length);
//			registers = temp;
//			registers[++count] = register;
//			
//			
//			return "sucesss";
//		}
//		// count is -1 initially, then here it will start with 0
//		registers[++count]= register;
//		return "success";
//	}

	
	
	//assignment
	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		String result = this.deleteUserById(id);
		if(result=="Failed")
			return "Failed";
		result = this.addUser(register);
		if(result=="Fail")
			return "Failed";
		return "Updated";
	}

	@Override
	public Optional<Register> getUserById(String id)throws IdNotFoundException {
		// TODO Auto-generated method stub
		Register register2 = null;
		for (Register register : set) {
			if(register.getId().equals(id))
			{
				register2 = register;
				//break;
			}
		
		}
		return Optional.ofNullable(Optional.of(register2).orElseThrow(()-> new IdNotFoundException("id not found")));
	    //in both cases (null or object) , should return optional or throwexception
	}
		

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		Register register[] = new Register[set.size()];
		
		return set.toArray(register);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = this.getUserById(id);
		
		if(optional.isPresent())
		{
			boolean result = set.remove(optional.get());
			if(result)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
		}
//    for understanding part		
//		else
//		{
//			//throw id not found exception
//			throw new IdNotFoundException("id not found exception");
//		}
		return "fail";
	}
	
	@Override
	public List<Register> getAllUserDetails()
	{
		return new ArrayList<>(set.descendingSet());
	}

}
