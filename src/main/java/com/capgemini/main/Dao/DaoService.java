package com.capgemini.main.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.capgemini.main.entity.BranchDetails;

import com.capgemini.main.entity.EmployeeCredentials;


/*This class is for creating a existing database through command line runner*/ 


@Transactional
@Repository
@Service
public class DaoService  {
	
	@PersistenceContext
	EntityManager em;
	/** These function me to set up the data base part **/
	public void insertBranchDetails(BranchDetails bd)
	{
		em.persist(bd);
	}
	
	public void insertEmployee(EmployeeCredentials ec)
	{
		em.persist(ec);
	}
	
	/*********************************/

}
