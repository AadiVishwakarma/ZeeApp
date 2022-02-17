package com.zee.zee5app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.service.LoginService;
@CrossOrigin("*")
@RestController

@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
}
