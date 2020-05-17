package com.capgemini.main.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.ForgetPassword;
import com.capgemini.main.exception.UserException;
import com.capgemini.main.service.EmployeeService;
/********************************************************************************
 * @author      Pranav Sinha 
 * Description  This is the controller class, it is responsible to manage the
 *              flow of the application.
 * Created On   21-April-2020 
 ********************************************************************************/
@CrossOrigin("*") 
@RestController
public class EmployeeController {
	
	
	@Autowired
	EmployeeService emp;
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	
	public EmployeeCredentials validateLogin() {
		return new EmployeeCredentials("Employee successfully authenticated");
	}
	
	
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeCredentials e) throws UserException {
		 if(Integer.parseInt(e.getEmployeeDetails().getAge())>=18)
		 {
		 emp.addEmployee(e);
		 
		 return new ResponseEntity<String>("Employee Added Successfully",HttpStatus.OK);
		 }
		 else {
			 throw new UserException("Employee age must be above 18");
		 }
		}
	
//	@GetMapping("/employee/{username}")
//	public void employeeById(@RequestBody EmployeeCredentials e,@PathVariable String username)
//	{
//		emp.getEmployeeByIdService()
//	}
	@PutMapping("/password-reset/{username}")
	public ResponseEntity<String> updatePassword(@RequestBody ForgetPassword e, @PathVariable(value = "username") String username) throws UserException
	{
		emp.resetPassword(username,e.getMobileNumber(),e.getEmployeePassword());
		return new ResponseEntity<String>("Password Updated Successfuly",HttpStatus.OK);
	}
	

}
