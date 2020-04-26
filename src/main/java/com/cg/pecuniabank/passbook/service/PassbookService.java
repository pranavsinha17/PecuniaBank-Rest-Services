package com.cg.pecuniabank.passbook.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.pecuniabank.passbook.entity.AccountDetails;
import com.cg.pecuniabank.passbook.entity.BranchDetails;
import com.cg.pecuniabank.passbook.entity.PassbookUpdate;
import com.cg.pecuniabank.passbook.entity.Transaction;

public interface PassbookService {
	
	AccountDetails getAccountDetailsByAccountId(long accountId);
	List<Transaction> getAccountTransactionDetails(long accountId);
	void insertBranchDetails(BranchDetails branchDetails);
	void insertAccountDetails(AccountDetails accountDetails);
	void insertTransactionDetails(Transaction transaction);
	List<Transaction> getAccountTransactionByDateRange(long accountNumber, LocalDateTime fromDate, LocalDateTime toDate);
	
	PassbookUpdate passbookUpdateDetailsByAccountNumber(long accountNumber);
	List<Transaction> getTransactionDetailsAfterLastUpdateDate(long accountNumber,LocalDateTime lastUpdateDate);
}
