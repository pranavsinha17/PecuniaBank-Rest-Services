package com.capgemini.accountmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.BranchDetails;
import com.capgemini.accountmanagement.entity.EmployeeCredentials;

@Transactional
@Repository
@Service
public class DaoService {
	
	@PersistenceContext
	EntityManager entityManager;
	/** These function helps me to set up the data base part **/
	public void insertBranchDetails(BranchDetails branchDetails)
	{
		entityManager.persist(branchDetails);
	}
	
	public void insertEmployee(EmployeeCredentials employeeCredentials)
	{
		entityManager.persist(employeeCredentials);
	}
	public void insertAccountDetails(AccountDetails accountDetails)
	{
		entityManager.persist(accountDetails);
	}
}
