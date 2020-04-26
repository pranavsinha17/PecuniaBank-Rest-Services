package com.cg.pecuniabank.passbook.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pecuniabank.passbook.entity.AccountDetails;

@Repository
public class AccountDAOImpl implements AccountDAO{
	
	@Autowired
	EntityManager em;

	@Override
	public AccountDetails getAccountDetailsByAccountId(long accountId)
	{
		return em.find(AccountDetails.class, accountId);
	}
	
	@Override
	public void insertAccountDetails(AccountDetails accountDetails) {
		accountDetails.setCreateDate(LocalDateTime.now());
		em.persist(accountDetails);
	}


}
