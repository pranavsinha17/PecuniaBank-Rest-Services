package com.capgemini.pecuniabank.dao;


	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.transaction.Transactional;

	import org.springframework.stereotype.Repository;
	import org.springframework.stereotype.Service;

import com.capgemini.pecuniabank.entity.AccountManagement;
import com.capgemini.pecuniabank.entity.LoanRequest;


	@Transactional
	@Repository
	@Service
	public class LoanDaoImp {
		
		@PersistenceContext
		EntityManager em;
		
		public void insertLoanDetails(LoanRequest lr)
		{
			em.persist(lr);
		}
		
		public void insertAccountDetails(AccountManagement am)
		{
			em.persist(am);
		}
		
		

	}

