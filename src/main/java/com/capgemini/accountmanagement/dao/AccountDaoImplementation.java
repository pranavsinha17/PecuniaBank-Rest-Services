package com.capgemini.accountmanagement.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.BranchDetails;

@Transactional
@Repository
@Service
public class AccountDaoImplementation implements AccountDao{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public String updateBalance(long accountNumber, double balance) 
	{
		
		AccountDetails accountDetails=entityManager.find(AccountDetails.class, accountNumber);
		accountDetails.setAccountBalance(balance);
		return null;
	}

	@Override
	public boolean checkAccountExist(long accountNumber) 
	{
		
	return entityManager.contains(entityManager.find(AccountDetails.class, accountNumber));
		
	}

	@Override
	public AccountDetails findAccountDetails(long accountNumber) 
	{
		
		return entityManager.find(AccountDetails.class, accountNumber);
	
	}

	@Override
	public BranchDetails findBranch(int branchId) 
	{
	
		return entityManager.find(BranchDetails.class, branchId);
	}

	@Override
	public List<AccountDetails> getAllAccount() 
	{
		String sqlQuery="SELECT account FROM AccountDetails account";
		TypedQuery<AccountDetails> query=entityManager.createQuery(sqlQuery,AccountDetails.class);
		List<AccountDetails> accountList=query.getResultList();
		return accountList;
	}

}
