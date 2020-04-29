package com.capgemini.main.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.Dao.DaoAccount;
import com.capgemini.main.Dao.DaoPassbook;
import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.Transaction;
import com.capgemini.main.exception.UserDefineException;
@Service
public class PassbookServiceImp implements  PassbookService {
	@Autowired
	DaoPassbook daoPassbook;
	@Autowired
	DaoAccount daoAccount;

	@Override
	public List<Transaction> getAccountTransactionDetails(long accountId) {
		// TODO Auto-generated method stub
		List<Transaction> transactionList = daoPassbook.getAccountTransactionDetails(accountId);
		System.out.println(transactionList);
		if (transactionList.isEmpty()) throw new UserDefineException("Transactions Not Found For this Account Number.");
		else
			return transactionList;
	}

	@Override
	public AccountDetails getAccountDetailsByAccountId(long accountId) {
		// TODO Auto-generated method stub
		AccountDetails accountDetails = daoAccount.findAccountDetails(accountId);
		if (accountDetails == null)
			throw new UserDefineException("Account Doesn't Exist.Please Enter the Valid Account Number.");
		else
			return accountDetails;
		
	}

	@Override
	public List<Transaction> getAccountTransactionByDateRange(long accountNumber, LocalDate fromDate,
			LocalDate toDate) {
		// TODO Auto-generated method stub
		return daoPassbook.getAccountTransactionByDateRange(accountNumber, fromDate, toDate);
	}

}
