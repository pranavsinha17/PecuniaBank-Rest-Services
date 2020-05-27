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
import com.capgemini.main.entity.EmployeeDetails;
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
	
	/****************************
	 * Method:RestFul Service For Employee/Admin Login
                *Description: To make employee logged in to the application.
	 * Login Details       -UserName, Password
	 
                *Created By                                - Pranav Sinha
                *Created Date                            - 24-APR-2020                           
	 
	 ****************************/
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	
	public EmployeeCredentials validateLogin() {
		return new EmployeeCredentials("Employee successfully authenticated");
	}
	
	/****************************
	 * Method:RestFul Service For Add Employee if logged in by admin
                *Description: To make admin able to add employees records in the application.
	 * Employee Details       -FirstName, Lastname,....etc. based on EmployeeCredentials.class model.
	 * @throws AccountException - It is raised if employee age is below 18.
                *Created By                                - Pranav Sinha
                *Created Date                              - 25-APR-2020                           
	 
	 ****************************/
	
	
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
	
	
	/****************************
	 * Method:RestFul Service for resetting password.
                *Description: To reset the password if employee forget his password.
	* Password Reset Details       -Username/Account Number,mobile Number,New Password.
	
                *Created By                                - Satyam sinha
                *Created Date                            - 26-APR-2020                           
	 
	 ****************************/
	
	@PutMapping("/password-reset/{username}")
	public ResponseEntity<String> updatePassword(@RequestBody ForgetPassword e, @PathVariable(value = "username") String username) throws UserException
	{
		emp.resetPassword(username,e.getMobileNumber(),e.getEmployeePassword());
		return new ResponseEntity<String>("Password Updated Successfuly",HttpStatus.OK);
	}
	
	@PutMapping("/employee/{username}")
	public ResponseEntity<String> updateEmployeeDetails(@RequestBody EmployeeDetails e,@PathVariable(value="username")String username) throws UserException
	{
		emp.updateEmployeeDetailsService(username,e.getMobileNumber(),e.getAddress());
		return new ResponseEntity<String>("Employee Details Updated Successfully",HttpStatus.OK);
	}
	

}
