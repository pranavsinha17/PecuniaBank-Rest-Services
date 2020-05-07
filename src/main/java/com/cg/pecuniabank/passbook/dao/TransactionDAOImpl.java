package com.cg.pecuniabank.passbook.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pecuniabank.passbook.entity.Transaction;

/**************************************************************************************************
 * 
 * @author Prabhjot
 * Description: The Transaction Dao is for inserting the transaction data in the database,
 * for getting account transaction details by the date range , for getting the account transaction
 * details from the lastUpdatedDate
 * created by : Prabhjot ,21 April 2020
 *
 ***************************************************************************************************/
@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public void insertTransactionDetails(Transaction transactionDetails) {
		 entityManager.persist(transactionDetails);
		 }

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getAccountTransactionDetails(long accountId)
	{
		Query query=entityManager.createQuery("select t from Transaction t where t.accountNumber=:accountNumberParam");
		query.setParameter("accountNumberParam", accountId);
		return query.getResultList();	
	}

	
	/***********************************************************************************
	 * 
	 * Method:getAccountTransactionByDateRange
	 * Description: for fetching the transaction Details by lastUpdateDate.
	 * @param accountNumber 
	 * customer accountNumber
	 * @param fromDate
	 * the starting date
	 * @param toDate
	 * the ending date
	 * @return the transaction list from the starting to the ending date.
	 * 
	 * created by : Prabhjot ,22 April 2020
	 ************************************************************************************/

	@Override
	public List<Transaction> getAccountTransactionByDateRange(long accountNumber,LocalDateTime fromDate,LocalDateTime toDate) {
		Query query=entityManager.createQuery("SELECT t FROM Transaction t WHERE t.accountNumber =: accountNumber AND t.transactionDate BETWEEN :fromDate AND :toDate");
		query.setParameter("accountNumber",accountNumber);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		
		@SuppressWarnings("unchecked")
		List<Transaction> transactions = query.getResultList();
		return transactions;
	}
	
	
	/************************************************************************************
	 * 
	 * Method:getTransactionDetailsAfterLastUpdateDate
	 * Description: it is for fetching the transaction from the last updated date. 
	 * @param accountNumber 
	 * customer accountNumber
	 * @param lastUpdateDate
	 * last Update Date 
	 * @return the transaction list from the lastUpdateDate.
	 * 
	 * created by : Prabhjot ,22 April 2020
	 * 
	 **************************************************************************************/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionDetailsAfterLastUpdateDate(long accountNumber, LocalDateTime lastUpdateDate) {
		
		Query query=entityManager.createQuery("select t from Transaction t WHERE t.accountNumber =:accountNumber and t.transactionDate > :lastUpdateDate");
		query.setParameter("accountNumber", accountNumber);
		query.setParameter("lastUpdateDate",lastUpdateDate);
		return query.getResultList();
	}


}
