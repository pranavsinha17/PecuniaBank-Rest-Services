package com.capgemini.main.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.main.Dao.DaoEmpoyee;
import com.capgemini.main.service.EmployeeLoginService;

public class EmployeeLoginServiceImp implements EmployeeLoginService{
	
	@Autowired
	DaoEmpoyee daoEmployee;

	@Override
	public boolean employeeLogin(String employeeId, String employeePassword) {
		// TODO Auto-generated method stub
		
		return daoEmployee.validateCredentails(employeeId, employeePassword);
	}

	@Override
	public boolean resetPassword(String employeeId, String mobileNumber, String newPassword) {
		// TODO Auto-generated method stub
		return daoEmployee.updatePassword(employeeId, mobileNumber, newPassword);
	}

	
}
