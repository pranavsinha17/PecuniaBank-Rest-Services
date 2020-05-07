package com.capgemini.main.Dao;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.main.entity.Transaction;

public interface DaoPassbook {
	List<Transaction> getAccountTransactionDetails(long accountId);
	List<Transaction> getAccountTransactionByDateRange(long accountNumber, LocalDate fromDate, LocalDate toDate);
}
