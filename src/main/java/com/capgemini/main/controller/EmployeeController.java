package com.capgemini.main.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.entity.EmployeeLoginServiceImp;
import com.capgemini.main.service.EmployeeLoginService;

//@RestController
public class EmployeeController {
	//common for all.........
	//@Autowired
	EmployeeLoginService empLogin=new EmployeeLoginServiceImp();
	
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
