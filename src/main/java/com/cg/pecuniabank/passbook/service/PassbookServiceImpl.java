package com.cg.pecuniabank.passbook.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pecuniabank.passbook.dao.AccountDAO;
import com.cg.pecuniabank.passbook.dao.BranchDetailsDAO;
import com.cg.pecuniabank.passbook.dao.PassbookDAO;
import com.cg.pecuniabank.passbook.dao.TransactionDAO;
import com.cg.pecuniabank.passbook.entity.AccountDetails;
import com.cg.pecuniabank.passbook.entity.BranchDetails;
import com.cg.pecuniabank.passbook.entity.PassbookUpdate;
import com.cg.pecuniabank.passbook.entity.Transaction;
import com.cg.pecuniabank.passbook.exception.AccountDoesntExistException;
import com.cg.pecuniabank.passbook.exception.TransactionsNotFoundException;

@Service
@Transactional
public class PassbookServiceImpl implements PassbookService {

	@Autowired
	PassbookDAO passbookDao;

	@Autowired
	AccountDAO accountDao;

	@Autowired
	BranchDetailsDAO branchDao;

	@Autowired
	TransactionDAO transactionDao;

	@Override
	public void insertBranchDetails(BranchDetails branchDetails) {
		branchDao.insertBranchDetails(branchDetails);
	}

	@Override
	public void insertAccountDetails(AccountDetails accountDetails) {
		accountDao.insertAccountDetails(accountDetails);

	}

	@Override
	public void insertTransactionDetails(Transaction transactionDetails) {
		transactionDao.insertTransactionDetails(transactionDetails);
	}

	@Override
	public AccountDetails getAccountDetailsByAccountId(long accountId) throws AccountDoesntExistException {
		AccountDetails accountDetails = accountDao.getAccountDetailsByAccountId(accountId);
		if (accountDetails == null)
			throw new AccountDoesntExistException("Account Doesn't Exist.Please Enter the Valid Account Number.");
		else
			return accountDetails;
	}

	@Override
	public List<Transaction> getAccountTransactionDetails(long accountId) {
		AccountDetails accountDetails = accountDao.getAccountDetailsByAccountId(accountId);
		if (accountDetails != null)
		{
			List<Transaction> transactionList = transactionDao.getAccountTransactionDetails(accountId);
			if (transactionList.isEmpty())
				throw new TransactionsNotFoundException("Transactions Not Found on this Account Number.");
			else
				return transactionList;
		}
		throw new AccountDoesntExistException("Account doesn't Exist.Please Enter the Valid Account Number.");
	}

	@Override
	public List<Transaction> getAccountTransactionByDateRange(long accountNumber, LocalDateTime fromDate,
			LocalDateTime toDate) throws TransactionsNotFoundException {
		AccountDetails accountDetails = accountDao.getAccountDetailsByAccountId(accountNumber);
		if (accountDetails != null) {
			List<Transaction> transaction_list = transactionDao.getAccountTransactionByDateRange(accountNumber,
					fromDate, toDate);
			if (transaction_list.isEmpty()) 
				throw new TransactionsNotFoundException("No Transaction In this Time Period");
			else
				return transaction_list;
		}
		throw new AccountDoesntExistException("Account doesn't Exist.Please Enter the Valid Account Number.");
	}

	@Override
	public PassbookUpdate passbookUpdateDetailsByAccountNumber(long accountNumber) throws AccountDoesntExistException {
		AccountDetails accountDetails = accountDao.getAccountDetailsByAccountId(accountNumber);
		if (accountDetails != null) {
			PassbookUpdate passbookUpdate = passbookDao.passbookUpdateDetailsByAccountNumber(accountNumber);
			LocalDateTime systemDate = LocalDateTime.now();
			if (passbookUpdate == null) {
				passbookUpdate = getNewPassbookUpdate(accountNumber, accountDetails.getCreateDate());
			}
			passbookDao.passbookUpdateChangeLastUpdate(accountNumber, systemDate);
			return passbookUpdate;
		}
		 throw new AccountDoesntExistException("Account doesn't Exist.Please Enter the Valid Account Number.");
	}

	private PassbookUpdate getNewPassbookUpdate(long accountNumber, LocalDateTime createDate) {
		PassbookUpdate passbookUpdate = new PassbookUpdate();
		passbookUpdate.setAccountNumber(accountNumber);
		passbookUpdate.setLastUpdate(createDate);
		passbookDao.passbookUpdateNewEntry(passbookUpdate);
		return passbookUpdate;
	}

	@Override
	public List<Transaction> getTransactionDetailsAfterLastUpdateDate(long accountNumber, LocalDateTime lastUpdateDate)
			throws TransactionsNotFoundException {

		List<Transaction> transaction_list = transactionDao.getTransactionDetailsAfterLastUpdateDate(accountNumber,
				lastUpdateDate);
		if (transaction_list.isEmpty())
			throw new TransactionsNotFoundException("No Recent Transactions.");
		return transaction_list;
	}
}