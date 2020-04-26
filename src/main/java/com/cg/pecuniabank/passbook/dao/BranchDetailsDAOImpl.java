package com.cg.pecuniabank.passbook.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pecuniabank.passbook.entity.BranchDetails;

@Repository
public class BranchDetailsDAOImpl implements BranchDetailsDAO{
	
	@Autowired
	EntityManager em;
	
	@Override
	public void insertBranchDetails(BranchDetails branchDetails) {
		em.persist(branchDetails);		
	}


}
