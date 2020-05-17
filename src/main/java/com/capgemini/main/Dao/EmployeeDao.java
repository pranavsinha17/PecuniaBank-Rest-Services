package com.capgemini.main.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.EmployeeDetails;
import com.capgemini.main.exception.UserException;

public interface EmployeeDao {
    
	public void addEmployee(EmployeeCredentials e);

	public void resetPasswordDao(String employeeId, String mobileNumber, String employeePassword) throws UserException;

    boolean findByPanNumber(String panNumber);
    boolean findByAdharNumber(String adarNumber);

}
