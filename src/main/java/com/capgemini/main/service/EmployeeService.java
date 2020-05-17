package com.capgemini.main.service;

import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.exception.UserException;

public interface EmployeeService {
	
	public void addEmployee(EmployeeCredentials e) throws UserException;

	public void resetPassword(String employeeId, String mobileNumber, String employeePassword) throws UserException;

	

}
