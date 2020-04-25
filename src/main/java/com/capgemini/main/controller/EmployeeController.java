package com.capgemini.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.service.EmployeeLoginService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeLoginService empLogin;

}
