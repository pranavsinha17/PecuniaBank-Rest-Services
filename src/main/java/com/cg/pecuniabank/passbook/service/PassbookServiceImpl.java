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
import com.cg.pecuniabank.passbook.exception.TransactionFailedException;

/**************************************************************************************************
 *
 * @author  Prabhjot 
 * Description : It a service class that provides service for inserting a AccountDetails,
 * BranchDetails,TransactionDetails,fetching the transaction details by date range ,
 * inserting a newPassbookUpdateDetails,fetching the transactions from the last updated date.
 * Version : 1.0
 * 
 * Created by : Prabhjot  21 April ,2020
 * 
 **************************************************************************************************/

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
	public void insertAccountDetails(AccountDetails accountDetails){
		accountDao.insertAccountDetails(accountDetails);
	}

	@Override
	public void insertTransactionDetails(Transaction transactionDetails) {
		transactionDao.insertTransactionDetails(transactionDetails);
	}
	
	
	/********************************************************************************
	 * 
	 * Method : getAccoundDetailsByAccountId
	 * Description: for fetching the AccountDetails By AccountId.
	 * @param accountId .
	 * customer accountId.
	 * @return Accountdetails object i.e accountDetails If Account exist otherwise 
	 * throws AccountDoesn't Exist Exception.
	 * @throws AccountDoesntExistException : It is raised due to the invalid accountId.
	 * 
	 * Created by: Prabhjot ,23 April 2020
	 * 
	 **********************************************************************************/

	@Override
	public AccountDetails getAccountDetailsByAccountId(long accountId) throws AccountDoesntExistException  {
		AccountDetails accountDetails = accountDao.getAccountDetailsByAccountId(accountId);
		if (accountDetails == null)
			throw new AccountDoesntExistException("Account Doesn't Exist.Please Enter the Valid Account Number.");
		else
			return accountDetails;
	}
	

	/********************************************************************************
	 * 
	 * Method: getAccountTransactionDetails
	 * Description: for fetching the Transaction Details  By AccountId.
	 * @param accountId .
	 * customer accountId.
	 * @return transactionList object i.e transactionList If Account exist otherwise 
	 * throws th
	 * @throws TransactionFailedException 
	 * @throws AccountDoesntExistException :It is raised due to the invalid accountId.
	 * 
	 * Created by: Prabhjot, 23 April 2020
	 * 
	 **********************************************************************************/

	
	
	@Override
	public List<Transaction> getAccountTransactionDetails(long accountId) throws AccountDoesntExistException,TransactionFailedException  {
		AccountDetails accountDetails = accountDao.getAccountDetailsByAccountId(accountId);
		if (accountDetails != null)
		{
			List<Transaction> transactionList = transactionDao.getAccountTransactionDetails(accountId);
			if (transactionList.isEmpty())
				throw new TransactionFailedException("There is no transaction on this account number.");
			else
				return transactionList;
		}
		throw new AccountDoesntExistException("Account doesn't Exist.Please Enter the Valid Account Number.");
	}


	/************************************************************************************************
	 * 
	 *  Method :  getAccountTransactionByDateRange
	 * Description : for fetching the TransactionDetails By Date Range.
	 * @param accountNumber 
	 * customer accountNumber
	 * @param fromDate
	 * starting Date
	 * @return  toDate
	 * ending Date
	 * @return TransactionList If there is transaction happen between fromDate and toDate ,
	 * Otherwise Throw an UserDefinedException.
	 * @throws TransactionFailedException :It is raised when there
	 * is no transactions details found between the specified dates.
	 * @throws AccountDoesntExistException 
	 * 
	 * Created by : Prabhjot, 23 April 2020
	 * 
	 * 
	 ***************************************************************************************************/

	@Override
	public List<Transaction> getAccountTransactionByDateRange(long accountNumber, LocalDateTime fromDate,
			LocalDateTime toDate) throws TransactionFailedException, AccountDoesntExistException {
		AccountDetails accountDetails = accountDao.getAccountDetailsByAccountId(accountNumber);
		if (accountDetails != null) {
			
			LocalDateTime systemDate=LocalDateTime.now();
		    boolean isAfter = fromDate.isAfter(toDate)|| toDate.isAfter(systemDate);
		    if(isAfter) throw new TransactionFailedException("Invalid Date.Please Enter the valid Starting and Ending date.");
			
		    List<Transaction> transaction_list = transactionDao.getAccountTransactionByDateRange(accountNumber,
					fromDate, toDate);
			if (transaction_list.isEmpty())
				throw new TransactionFailedException("No Transaction In this Time Duration");
			else
				return transaction_list;
		}
		throw new AccountDoesntExistException("Account doesn't Exist.Please Enter the Valid Account Number.");
	}


	/**************************************************************************************** 
	 * 
	 * Method : passbookUpdateDetailsByAccountNumber
	 * Description : for fetching the passbookUpdateDetails By Account Number.
	 * @param accountNumber 
	 * customer accountNumber
	 * @return Accountdetails object i.e accountDetails If Account exist otherwise 
	 * throws AccountDoesn't Exist Exception.
	 * @throws AccountDoesntExistException :It is raised due to the invalid accountId.
	 * 
	 * Created by : Prabhjot ,23 April 2020
	 * 
	 ******************************************************************************************/	
	@Override
	public PassbookUpdate passbookUpdateDetailsByAccountNumber(long accountNumber) throws AccountDoesntExistException {
		AccountDetails accountDetails = accountDao.getAccountDetailsByAccountId(accountNumber);
		if (accountDetails != null) {
			PassbookUpdate passbookUpdateDetails = passbookDao.passbookUpdateDetailsByAccountNumber(accountNumber);
			LocalDateTime systemDate = LocalDateTime.now();
			if (passbookUpdateDetails == null) {
				passbookUpdateDetails = getNewPassbookUpdate(accountNumber, accountDetails.getOpeningDate());
			}
			passbookDao.passbookUpdateChangeLastUpdate(accountNumber, systemDate);
			return passbookUpdateDetails;
		}
		throw new AccountDoesntExistException("Account doesn't Exist.Please Enter the Valid Account Number.");
	}
	
	
	/***************************************************************************************** 
	 * 
	 * Method : getNewPassbookUpdate
	 * Description : for fetching the passbookUpdateDetails By Account Number.
	 * @param accountNumber 
	 * customer accountNumber
	 * @param createDate
	 * Account Created Date.
	 * @return the passbookUpdateDetails
	 * after saving the the data in the PassbookUpdate Entity.
	 * 
	 * Created by : Prabhjot ,23 April 2020
	 * 
	 *******************************************************************************************/
	private PassbookUpdate getNewPassbookUpdate(long accountNumber, LocalDateTime createDate) {
		PassbookUpdate passbookUpdateDetails = new PassbookUpdate();
		passbookUpdateDetails.setAccountNumber(accountNumber);
		passbookUpdateDetails.setLastUpdate(createDate);
		passbookDao.passbookUpdateNewEntry(passbookUpdateDetails);
		return passbookUpdateDetails;
	}
	
	

	/********************************************************************************************
	 * 
	 * Method : getTransactionDetailsAfterLastUpdateDate
	 * Description : for fetching the transaction Details by lastUpdateDate.
	 * @param accountNumber 
	 * customer accountNumber
	 * @param lastUpdateDate
	 * Passbook LastUpdateDate.
	 * @return the transaction list from the lastUpdateDate,Otherwise throw an TransactionFailedException
	 * @throws TransactionFailedException it occurs if there will be no recent transactions.
	 * 
	 * Created by : Prabhjot, 23 April 2020
	 * 
	 **********************************************************************************************/
	
	@Override
	public List<Transaction> getTransactionDetailsAfterLastUpdateDate(long accountNumber, LocalDateTime lastUpdateDate)
			throws TransactionFailedException {
		List<Transaction> transaction_list = transactionDao.getTransactionDetailsAfterLastUpdateDate(accountNumber,
				lastUpdateDate);
		if (transaction_list.isEmpty())
			throw new TransactionFailedException("No Recent Transactions.");
		return transaction_list;
	}
}