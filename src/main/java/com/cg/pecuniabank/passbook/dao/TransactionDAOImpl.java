package com.cg.pecuniabank.passbook.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pecuniabank.passbook.entity.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getAccountTransactionDetails(long accountId)
	{
		Query query=em.createQuery("select t from Transaction t where t.accountNumber=:accountNumberParam");
		query.setParameter("accountNumberParam", accountId);
		return query.getResultList();	
	}


	@Override
	public List<Transaction> getAccountTransactionByDateRange(long accountNumber,LocalDateTime fromDate,LocalDateTime toDate) {
		Query query=em.createQuery("SELECT t FROM Transaction t WHERE t.accountNumber =: accountNumber AND t.transactionDate BETWEEN :fromDate AND :toDate");
		query.setParameter("accountNumber",accountNumber);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		
		@SuppressWarnings("unchecked")
		List<Transaction> transactions = query.getResultList();
		return transactions;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionDetailsAfterLastUpdateDate(long accountNumber, LocalDateTime lastUpdateDate) {
		
		Query query=em.createQuery("select t from Transaction t WHERE t.accountNumber =:accountNumber and t.transactionDate > :lastUpdateDate");
		query.setParameter("accountNumber", accountNumber);
		query.setParameter("lastUpdateDate",lastUpdateDate);
		return query.getResultList();
	}

	@Override
	public void insertTransactionDetails(Transaction transactionDetails) {
		 em.persist(transactionDetails);
			
		}

}
