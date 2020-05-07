package com.capgemini.main.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.Dao.AddEmployeeRepository;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.EmployeeLoginServiceImp;
import com.capgemini.main.service.EmployeeLoginService;
/********************************************************************************
 * @author      Pranav Sinha 
 * Description  This is the controller class, it is responsible to manage the
 *              flow of the application.
 * Created On   21-April-2020 
 ********************************************************************************/
@CrossOrigin("*")
@RestController
public class EmployeeController {
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public EmployeeCredentials validateLogin() {
		return new EmployeeCredentials("Employee successfully authenticated");
	}
	@Autowired
	AddEmployeeRepository emp;
	@PostMapping("/addEmployee")
	public ResponseEntity<EmployeeCredentials> addEmployee(@RequestBody EmployeeCredentials e) {
		EmployeeCredentials em = emp.save(e);
		
		return new ResponseEntity<EmployeeCredentials>(em,HttpStatus.OK);
	}

}
