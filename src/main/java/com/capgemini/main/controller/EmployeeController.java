package com.capgemini.main.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.EmployeeLoginServiceImp;
import com.capgemini.main.service.EmployeeLoginService;
@CrossOrigin("*")
@RestController
=======
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.entity.EmployeeLoginServiceImp;
import com.capgemini.main.service.EmployeeLoginService;

//@RestController
>>>>>>> 9b1f862cd284aefde5669e0eed3059b5c29d07fb
public class EmployeeController {
	//common for all.........
	//@Autowired
	EmployeeLoginService empLogin=new EmployeeLoginServiceImp();
	
<<<<<<< HEAD
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public EmployeeCredentials validateLogin() {
		return new EmployeeCredentials("Employee successfully authenticated");
	}
	
	
=======
	@PostMapping("/employee/{id}/{password}")
	public ResponseEntity<String> Login( @PathVariable("id") String id, @PathVariable("password")String password) {
		String res;
		boolean result=empLogin.employeeLogin(id, password);
		if(result==true)
		{
			res="LOGIN SUCESSFULY";
		}
		else
		{
			res="Invalid Credentials";
		}
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
>>>>>>> 9b1f862cd284aefde5669e0eed3059b5c29d07fb
	@PostMapping("/employee/{id}/{mobileNumber}/{newpassword}")
	public ResponseEntity<String> resetPassword( @PathVariable("id") String id,@PathVariable("mobileNumber")String mobileNumber, @PathVariable("newpassword") String password) {
		String res;
		boolean result=empLogin.resetPassword(id, mobileNumber, password);
		if(result==true)
		{
			res="Updated SUCESSFULY";
		}
		else
		{
			res="Invalid Credentials";
		}
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	
	

}
