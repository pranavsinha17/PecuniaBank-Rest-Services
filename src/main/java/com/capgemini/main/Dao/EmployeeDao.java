package com.capgemini.main.Dao;

import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.EmployeeCredentials;

import com.capgemini.main.exception.UserException;


/****************************
 *          @author          Pranav Sinha
 *          Description      It is a dao class that provides the data access layer for Employee/Admin information. 
  *         Version             1.0
  *         Created Date    18-APR-2020
 ****************************/

public interface EmployeeDao {
    
	public void addEmployee(EmployeeCredentials e);

	public void resetPasswordDao(String employeeId, String mobileNumber, String employeePassword) throws UserException;

    boolean findByPanNumber(String panNumber);
    boolean findByAdharNumber(String adarNumber);

	public void updateEmployeeDetailsDao(String username, String mobileNumber, Address address) throws UserException;

}
