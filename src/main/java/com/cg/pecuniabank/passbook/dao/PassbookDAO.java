package com.cg.pecuniabank.passbook.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.pecuniabank.passbook.entity.AccountDetails;
import com.cg.pecuniabank.passbook.entity.BranchDetails;
import com.cg.pecuniabank.passbook.entity.Transaction;

public interface PassbookDAO {
	
	AccountDetails getAccountDetailsByAccountId(long accountId);
	List<Transaction> getAccountTransactionDetails(long accountId);
	void insertBranchDetails(BranchDetails branchDetails);
	void insertAccountDetails(AccountDetails accountDetails);
	void insertTransactionDetails(Transaction transactionDetails);
	List<Transaction> getAccountTransactionByDateRange(long accountNumber, LocalDate fromDate, LocalDate toDate);
}
