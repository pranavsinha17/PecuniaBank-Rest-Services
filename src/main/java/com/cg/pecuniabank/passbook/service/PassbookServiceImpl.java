package com.cg.pecuniabank.passbook.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pecuniabank.passbook.dao.PassbookDAO;
import com.cg.pecuniabank.passbook.entity.AccountDetails;
import com.cg.pecuniabank.passbook.entity.BranchDetails;
import com.cg.pecuniabank.passbook.entity.Transaction;
import com.cg.pecuniabank.passbook.exception.AccountDoesntExistException;
import com.cg.pecuniabank.passbook.exception.TransactionsNotFoundException;

@Service
@Transactional
public class PassbookServiceImpl implements PassbookService {

	@Autowired
	PassbookDAO dao;

	@Override
	public void insertBranchDetails(BranchDetails branchDetails) {
		dao.insertBranchDetails(branchDetails);
	}

	@Override
	public void insertAccountDetails(AccountDetails accountDetails) {
		dao.insertAccountDetails(accountDetails);

	}

	@Override
	public void insertTransactionDetails(Transaction transactionDetails) {
		dao.insertTransactionDetails(transactionDetails);
	}

	@Override
	public AccountDetails getAccountDetailsByAccountId(long accountId) {
		AccountDetails accountDetails = dao.getAccountDetailsByAccountId(accountId);
		if (accountDetails == null)
			throw new AccountDoesntExistException("Account Doesn't Exist.Please Enter the Valid Account Number.");
		else
			return accountDetails;
	}

	@Override
	public List<Transaction> getAccountTransactionDetails(long accountId) {
		List<Transaction> transactionList = dao.getAccountTransactionDetails(accountId);
		System.out.println(transactionList);
		if (transactionList.isEmpty()) throw new TransactionsNotFoundException("Transactions Not Found For this Account Number.");
		else
			return transactionList;
	}

	@Override
	public List<Transaction> getAccountTransactionByDateRange(long accountNumber, LocalDate fromDate,
			LocalDate toDate) {
		return dao.getAccountTransactionByDateRange(accountNumber, fromDate, toDate);
	}
}
