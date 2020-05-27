package com.capgemini.main.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.main.Dao.EmployeeDao;
import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.exception.UserException;

/****************************
 *          @author          Pranav Sinha
 *          Description      It is a service implementation class that provides the services for Employee/Admin 
  *         Version             1.0
  *         Created Date    18-APR-2020
 ****************************/
@Service
public class EmployeeServiceImpl implements EmployeeService{
     @Autowired
     EmployeeDao em;
	@Override
	public void addEmployee(EmployeeCredentials e) throws UserException{
		if(em.findByAdharNumber(e.getEmployeeDetails().getAdharNumber())==true && em.findByPanNumber(e.getEmployeeDetails().getPanNumber())==true)
		 em.addEmployee(e);
		else
			throw new UserException("Employee with same Adhar Card/Pan Card Already Present:Operation Cancelled");
}
	@Override
	public void resetPassword(String employeeId, String mobileNumber, String employeePassword) throws UserException {
		
		em.resetPasswordDao(employeeId,mobileNumber,employeePassword);
		
	}
	@Override
	public void updateEmployeeDetailsService(String username, String mobileNumber, Address address)
			throws UserException {
		
		// TODO Auto-generated method stub
		em.updateEmployeeDetailsDao(username,mobileNumber,address);
		
	}
	

}
