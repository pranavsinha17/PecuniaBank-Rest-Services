package com.capgemini.main.Dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.EmployeeDetails;
import com.capgemini.main.exception.UserException;

@Service
@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@PersistenceContext
	EntityManager em;
		@Override
	public void addEmployee(EmployeeCredentials e) {
		
		em.persist(e);
	}

	@Override
	public void resetPasswordDao(String employeeId, String mobileNumber, String employeePassword) throws UserException{
		
		boolean result= em.contains(em.find(EmployeeCredentials.class, employeeId));
	    
		if(result==true)
		{
		System.out.println(em.find(EmployeeCredentials.class, employeeId).getEmployeeDetails().getMobileNumber());
		if(em.find(EmployeeCredentials.class, employeeId).getEmployeeDetails().getMobileNumber().equals(mobileNumber))
			{
			System.out.println("Hello");
			
				em.find(EmployeeCredentials.class, employeeId).setEmployeePassword(employeePassword);
			
				
	}
		else {
			throw new UserException("Mobile Number not matched...Please try again!!");
		}
		}
		else {
			throw new UserException("Account Does Not Exists");
			
		}
		
		
	}

	@Override
	public boolean findByPanNumber(String panNumber) {
		// TODO Auto-generated method stub
		EmployeeDetails emp=null;
		try {
		TypedQuery<EmployeeDetails> query=em.createQuery("SELECT employee_details FROM EmployeeDetails employee_details WHERE employee_details.panNumber=:panNumber", EmployeeDetails.class);
	    query.setParameter("panNumber", panNumber);
	    System.out.println(query.getSingleResult());
	    emp=query.getSingleResult();
		}
		catch(NoResultException e){
			
		}
	   
	    if(emp!=null)
	   return false;
	    return true;

	}

	@Override
	public boolean findByAdharNumber(String adharNumber) {
		// TODO Auto-generated method stub
		EmployeeDetails emp=null;
		try {
		TypedQuery<EmployeeDetails> query=em.createQuery("SELECT employee_details FROM EmployeeDetails employee_details WHERE employee_details.adharNumber=:adharNumber", EmployeeDetails.class);
	    query.setParameter("adharNumber", adharNumber);
	    System.out.println(query.getSingleResult());
	    emp= query.getSingleResult();
		}
		catch(NoResultException e)
		{
			
		}
	    if(emp!=null)
	    	return false;
	    return true;
	}


}
