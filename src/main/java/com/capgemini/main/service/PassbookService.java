package com.capgemini.main.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.Transaction;

public interface PassbookService {
	List<Transaction> getAccountTransactionDetails(long accountId);
	AccountDetails getAccountDetailsByAccountId(long accountId);
	List<Transaction> getAccountTransactionByDateRange(long accountNumber, LocalDate fromDate, LocalDate toDate);

}
