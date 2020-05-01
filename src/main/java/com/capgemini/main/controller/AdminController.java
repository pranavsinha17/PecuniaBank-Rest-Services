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
import com.capgemini.main.exception.UserDefineException;
import com.capgemini.main.exception.UserException;
import com.capgemini.main.service.AdminService;
import com.capgemini.main.service.AdminServiceImp;


//@RestController
public class AdminController {

	//@Autowired
	AdminService adminService=new AdminServiceImp();
	
	
	// For Admin Login url to fetch id and password of Admin. 
	 
	
	//Using postman to add these details.
	
	@PostMapping("/Adminlogin")
	public ResponseEntity<String> login(@RequestBody Admin admin) throws UserDefineException{
		String reply;
		boolean result=adminService.checkCredentails(admin);
		if(result==false) {
			reply="Login Failed";
			throw new UserDefineException("Admin Id or password is wrong please try again with correct credentails");
		}
		else
		{
			reply="Login Scuessfuly";
		}
		return new ResponseEntity<String>(reply,HttpStatus.OK);
	}
	
	
	
	//For Admin to add new branch Details.
	
	
	@PostMapping("/AdminaddBranch")
	public ResponseEntity<String> addBranch(@RequestBody BranchDetails branchDetails) {
		String result=adminService.addBranch(branchDetails, branchDetails.getAddress());
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	
	
	 // For Admin to add new Employee Details.
	
	
	@PostMapping("/AdminaddEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeCredentials employeeCredentials) {
		String result=adminService.addEmployeeDetails(employeeCredentials.getEmployeeDetails(), employeeCredentials.getEmployeeDetails().getAddress(), employeeCredentials);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
}
