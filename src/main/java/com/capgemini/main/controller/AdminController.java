package com.capgemini.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.entity.Admin;
import com.capgemini.main.entity.BranchDetails;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.EmployeeDetails;
import com.capgemini.main.exception.UserException;
import com.capgemini.main.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	/*
	 * For Admin Login url to fetch id and password of Admin. 
	 */
	
	@PostMapping("/Admin")
	public ResponseEntity<String> login(@RequestBody Admin admin) throws UserException{
		String reply;
		boolean result=adminService.checkCredentails(admin);
		if(result==false) {
			reply="Login Failed";
			throw new UserException("Admin Id or password is wrong please try again with correct credentails");
		}
		else
		{
			reply="Login Scuessfuly";
		}
		return new ResponseEntity<String>(reply,HttpStatus.OK);
	}
	
	/*
	 * For Admin to add new branch Details.
	 */
	
	@PostMapping("/Admin")
	public ResponseEntity<String> addBranch(@RequestBody BranchDetails branchDetails) throws UserException{
		String result=adminService.addBranch(branchDetails, branchDetails.getAddress());
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	
	/*
	 * For Admin to add new Employee Details.
	 */
	
	@PostMapping("/Admin")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeCredentials employeeCredentials) throws UserException{
		String result=adminService.addEmployeeDetails(employeeCredentials.getEmployeeDetails(), employeeCredentials.getEmployeeDetails().getAddress(), employeeCredentials);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
}
