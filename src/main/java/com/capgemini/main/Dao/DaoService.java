package com.capgemini.main.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.BranchDetails;
import com.capgemini.main.entity.EmployeeDetails;

@Transactional
@Repository
@Service
public class DaoService {
	
	@PersistenceContext
	EntityManager em;
	
	public void insertBranchDetails(BranchDetails bd)
	{
		em.persist(bd);
	}
	
	public void insertEmployee(EmployeeDetails ec)
	{
		em.persist(ec);
	}
	
	

}
