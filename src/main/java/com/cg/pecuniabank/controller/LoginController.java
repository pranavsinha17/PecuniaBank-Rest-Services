package com.cg.pecuniabank.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pecuniabank.dto.EmployeeCredentials;
@CrossOrigin("*")
@RestController
public class LoginController {
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public EmployeeCredentials validateLogin() {
		return new EmployeeCredentials("Employee successfully authenticated");
	}

}
