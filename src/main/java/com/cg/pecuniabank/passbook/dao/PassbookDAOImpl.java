package com.cg.pecuniabank.passbook.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pecuniabank.passbook.entity.AccountDetails;
import com.cg.pecuniabank.passbook.entity.BranchDetails;
import com.cg.pecuniabank.passbook.entity.Transaction;

@Repository
public class PassbookDAOImpl implements PassbookDAO{
	
	@Autowired
	EntityManager em;


	@Override
	public void insertBranchDetails(BranchDetails branchDetails) {
		em.persist(branchDetails);		
	}


	@Override
	public void insertAccountDetails(AccountDetails accountDetails) {
		em.persist(accountDetails);
	}


	public void insertTransactionDetails(Transaction transactionDetails) {
	 em.persist(transactionDetails);
		
	}

	
	@Override
	public AccountDetails getAccountDetailsByAccountId(long accountId)
	{
		return em.find(AccountDetails.class, accountId);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getAccountTransactionDetails(long accountId)
	{
		Query query=em.createQuery("select t from Transaction t where t.accountNumber=:accountNumberParam");
		query.setParameter("accountNumberParam", accountId);
		return query.getResultList();	
	}


	@Override
	public List<Transaction> getAccountTransactionByDateRange(long accountNumber,LocalDate fromDate,LocalDate toDate) {
		Query query=em.createQuery("SELECT t FROM Transaction t WHERE t.accountNumber =: accountNumber AND t.transactionDate BETWEEN :fromDate AND :toDate");
		query.setParameter("accountNumber",accountNumber);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		
		@SuppressWarnings("unchecked")
		List<Transaction> transactions = query.getResultList();
		return transactions;
	}
}
