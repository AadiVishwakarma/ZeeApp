package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.UserService;

@RestController // version:4
//RestController is a combination of @ResponseBody and @Controller
//1000methods-->@ResponseBody --> 1000times so they merge with controller to solve this issue


@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//adding user info into the table
	//info will be shared by the client in terms of JSON object
	//we will read JSON object and this json object is available in request(particularly in requestbody)
	
	//we need to read requestbody content and also transform json object to java object ==> 
	//will be taken care by @RequestBody
	
	//we nee to inform when this method will be called and for that we need to specify endpoint.
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlreadyExistsException
	{
		//try {
		Register result =	userService.addUser(register);
		System.out.println(result);
		return ResponseEntity.status(201).body(result);
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			Map<String,String> hashMap= new HashMap<>();
//			hashMap.put("message","record already exists");
//			return ResponseEntity.badRequest().body(hashMap);
//		}
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException
	{
		Register register = userService.getUserById(id);
		return ResponseEntity.ok(register);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUserDetails()
	{
		Optional<List<Register>> optional = userService.getAllUserDetails();
		
		if(optional.isEmpty())
		{
			Map<String,String> map= new HashMap<>();
			map.put("message","no record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		
		}
		return ResponseEntity.ok(optional.get());
	}
	
	
}
