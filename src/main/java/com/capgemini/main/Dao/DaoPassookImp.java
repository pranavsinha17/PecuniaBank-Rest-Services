package com.capgemini.main.Dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.Transaction;
@Service
@Repository
@Transactional
public class DaoPassookImp implements DaoPassbook  {
	@PersistenceContext
	EntityManager em;

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
