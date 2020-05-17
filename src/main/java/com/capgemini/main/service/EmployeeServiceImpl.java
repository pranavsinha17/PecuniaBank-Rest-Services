package com.capgemini.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.Dao.EmployeeDao;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.exception.UserException;
@Service
public class EmployeeServiceImpl implements EmployeeService{
     @Autowired
     EmployeeDao em;
	@Override
	public void addEmployee(EmployeeCredentials e) throws UserException{
		if(em.findByAdharNumber(e.getEmployeeDetails().getAdharNumber())==true && em.findByPanNumber(e.getEmployeeDetails().getPanNumber())==true)
		 em.addEmployee(e);
		else
			throw new UserException("Employee with same Adhar Card and Pan Card Already Present");
}
	@Override
	public void resetPassword(String employeeId, String mobileNumber, String employeePassword) throws UserException {
		
		em.resetPasswordDao(employeeId,mobileNumber,employeePassword);
		
	}
	

}
