package com.zee.zee5app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Register;

@RestController // version:4
//RestController is a combination of @ResponseBody and @Controller
//1000methods-->@ResponseBody --> 1000times so they merge with controller to solve this issue


@RequestMapping("/api/user")
public class UserController {
	
	//adding user info into the table
	//info will be shared by the client in terms of JSON object
	//we will read JSON object and this json object is available in request(particularly in requestbody)
	
	//we need to read requestbody content and also transform json object to java object ==> 
	//will be taken care by @RequestBody
	
	//we nee to inform when this method will be called and for that we need to specify endpoint.
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody Register register)
	{
		return register.toString();
	}
}
