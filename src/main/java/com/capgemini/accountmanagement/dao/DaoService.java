package com.capgemini.accountmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.BranchDetails;
import com.capgemini.accountmanagement.entity.EmployeeCredentials;

@Transactional
@Repository
@Service
public class DaoService {
	
	@Autowired
	EntityManager entityManager;
	
	public void insertBranchDetails(BranchDetails branchDetails)
	{
		entityManager.persist(branchDetails);
	}
	
	public void insertEmployee(EmployeeCredentials employeeCredentails )
	{
		entityManager.persist(employeeCredentails);
	}

	public void insertAccountDetails(AccountDetails accountDetails) {
		
		entityManager.persist(accountDetails);
		
	}
	
}
