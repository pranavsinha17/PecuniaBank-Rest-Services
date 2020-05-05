package com.cg.pecuniabank.passbook.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.pecuniabank.passbook.entity.AccountDetails;
import com.cg.pecuniabank.passbook.entity.BranchDetails;
import com.cg.pecuniabank.passbook.entity.PassbookUpdate;
import com.cg.pecuniabank.passbook.entity.Transaction;
import com.cg.pecuniabank.passbook.exception.AccountDoesntExistException;
import com.cg.pecuniabank.passbook.exception.TransactionFailedException;

public interface PassbookService {
	
	AccountDetails getAccountDetailsByAccountId(long accountId) throws AccountDoesntExistException;

	void insertBranchDetails(BranchDetails branchDetails);
	void insertAccountDetails(AccountDetails accountDetails);
	void insertTransactionDetails(Transaction transaction);
	
	List<Transaction> getAccountTransactionByDateRange(long accountNumber, LocalDateTime fromDate, LocalDateTime toDate) throws TransactionFailedException, AccountDoesntExistException;	
	PassbookUpdate passbookUpdateDetailsByAccountNumber(long accountNumber) throws AccountDoesntExistException;
	List<Transaction> getTransactionDetailsAfterLastUpdateDate(long accountNumber,LocalDateTime lastUpdateDate) throws TransactionFailedException;

	List<Transaction> getAccountTransactionDetails(long accountId) throws AccountDoesntExistException, TransactionFailedException;
}
