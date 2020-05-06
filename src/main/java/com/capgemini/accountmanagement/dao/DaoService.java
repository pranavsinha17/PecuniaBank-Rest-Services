package com.capgemini.accountmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.BranchDetails;
import com.capgemini.accountmanagement.entity.EmployeeCredentials;

/********************************************************************************
 * @author      Vaishali Tiwari 
 * Description  This Dao is for setting up the database
 * Created On
 * 
 *********************************************************************************/
@Transactional
@Repository
@Service
public class DaoService {

	@PersistenceContext
	EntityManager entityManager;

	/**************************************************************************************
	 * Method       insertBranchDetails 
	 * Description  To setting up the database for branch details 
	 * Created By   Vaishali Tiwari 
	 * Created on
	 ***************************************************************************************/

	public void insertBranchDetails(BranchDetails branchDetails) {
		entityManager.persist(branchDetails);
	}

	/**************************************************************************************
	 * Method         insertEmployee 
	 * Description    To setting up the database for Employee
	 * Created By     Vaishali Tiwari 
	 * Created on
	 ***************************************************************************************/

	public void insertEmployee(EmployeeCredentials employeeCredentials) {
		entityManager.persist(employeeCredentials);
	}

	/**************************************************************************************
	 * Method         insertAccountDetails 
	 * Description    To setting up the database for account details
	 * Created By     Vaishali Tiwari 
	 * Created on
	 ***************************************************************************************/

	public void insertAccountDetails(AccountDetails accountDetails) {
		entityManager.persist(accountDetails);
	}
}
