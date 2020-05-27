package com.capgemini.main.Dao;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.EmployeeDetails;
import com.capgemini.main.exception.UserException;

/****************************
 *          @author          Pranav Sinha
 *          Description      It is a dao implementation class that provides the data access layer for Employee/Admin information. 
  *         Version             1.0
  *         Created Date    18-APR-2020
 ****************************/

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

	@Override
	public void updateEmployeeDetailsDao(String username, String mobileNumber, Address address) throws UserException {
		// TODO Auto-generated method stub
boolean result= em.contains(em.find(EmployeeCredentials.class, username));
	    
		if(result==true)
		{
		System.out.println(em.find(EmployeeCredentials.class, username).getEmployeeDetails().getMobileNumber());
			System.out.println("Hello");
			
				em.find(EmployeeCredentials.class, username).getEmployeeDetails().setMobileNumber(mobileNumber);
				em.find(EmployeeCredentials.class, username).getEmployeeDetails().setAddress(address);
				
	
		}
		else {
			throw new UserException("Account Does Not Exists");
			
		}
		
	
	}


}
