package com.cg.pecuniabank.passbook.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pecuniabank.passbook.entity.BranchDetails;

@Repository
public class BranchDetailsDAOImpl implements BranchDetailsDAO{
	
	@Autowired
	EntityManager entityManager;
	
	/*********************************************************
	 * 
	 * Method: insertBranchDetails
	 * Description: it is for saving the branch details.
	 * created by : Prabhjot, 22 April 2020  
	 * 
	 **********************************************************/
	
	@Override
	public void insertBranchDetails(BranchDetails branchDetails) {
		entityManager.persist(branchDetails);		
	}


}
