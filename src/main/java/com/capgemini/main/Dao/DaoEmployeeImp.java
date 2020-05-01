package com.capgemini.main.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.EmployeeCredentials;

@Service
@Transactional
@Repository
public class DaoEmployeeImp implements DaoEmpoyee {
	
	@PersistenceContext
	EntityManager em;


	@Override
	public boolean validateCredentails(String employeeId, String employeePassword) {
		// TODO Auto-generated method stub
		boolean result= em.contains(em.find(EmployeeCredentials.class, employeeId));
		if(result==true)
		{
			if(em.find(EmployeeCredentials.class, employeeId).getEmployeePassword().equals(employeePassword))
				return true;
			
			return false;
		}
		return false;
	
	}

	@Override
	public boolean updatePassword(String employeeId, String mobileNumber, String newPassword) {
		// TODO Auto-generated method stub
		boolean result= em.contains(em.find(EmployeeCredentials.class, employeeId));
		if(result==true)
		{
			if(em.find(EmployeeCredentials.class, employeeId).getEmployeeDetails().getMobileNumber().equals(mobileNumber))
			{
				em.find(EmployeeCredentials.class, employeeId).setEmployeePassword(newPassword);
				return true;
			}
				
			
			return false;
		}
		return false;
	}

}
