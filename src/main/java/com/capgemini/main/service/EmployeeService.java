package com.capgemini.main.service;

import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.exception.UserException;

/****************************
 *          @author          Pranav Sinha
 *          Description      It is a service class that provides the services for Employee/Admin   
  *         Version             1.0
  *         Created Date    18-APR-2020
 ****************************/

public interface EmployeeService {
	
	public void addEmployee(EmployeeCredentials e) throws UserException;

	public void resetPassword(String employeeId, String mobileNumber, String employeePassword) throws UserException;

	public void updateEmployeeDetailsService(String username, String mobileNumber, Address address) throws UserException;

	

}
