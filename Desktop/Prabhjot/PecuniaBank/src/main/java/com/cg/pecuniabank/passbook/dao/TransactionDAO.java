package com.cg.pecuniabank.passbook.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.pecuniabank.passbook.entity.Transaction;

public interface TransactionDAO {
	
	void insertTransactionDetails(Transaction transactionDetails);
	List<Transaction> getAccountTransactionByDateRange(long accountNumber, LocalDateTime fromDate, LocalDateTime toDate);
	List<Transaction> getTransactionDetailsAfterLastUpdateDate(long accountNumber,LocalDateTime lastUpdateDate);
	List<Transaction> getAccountTransactionDetails(long accountId);

}
