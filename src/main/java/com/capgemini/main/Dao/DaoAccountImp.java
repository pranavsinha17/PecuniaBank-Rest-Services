package com.capgemini.main.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.AccountDetails;

@Transactional
@Repository
@Service
public class DaoAccountImp implements DaoAccount{
	@PersistenceContext
	EntityManager em;

	@Override
	public String updateBalance(long accountNumber, double balance) {
		// TODO Auto-generated method stub
		AccountDetails accountDetails=em.find(AccountDetails.class, accountNumber);
		accountDetails.setAccountBalance(balance);
		return null;
	}

	@Override
	public boolean checkAccountExist(long accountNumber) {
		// TODO Auto-generated method stub
	return em.contains(em.find(AccountDetails.class, accountNumber));
		
	}

	@Override
	public AccountDetails findAccountDetails(long accountNumber) {
		// TODO Auto-generated method stub
		return em.find(AccountDetails.class, accountNumber);
	
	}

}
