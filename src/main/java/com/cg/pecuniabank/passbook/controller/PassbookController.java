package com.cg.pecuniabank.passbook.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pecuniabank.passbook.entity.AccountDetails;
import com.cg.pecuniabank.passbook.entity.PassbookUpdate;
import com.cg.pecuniabank.passbook.entity.Transaction;
import com.cg.pecuniabank.passbook.exception.AccountDoesntExistException;
import com.cg.pecuniabank.passbook.exception.TransactionFailedException;
import com.cg.pecuniabank.passbook.service.PassbookService;


@RestController
public class PassbookController {

	@Autowired
	PassbookService passbookService;
	
	
	/**************************************************************************************************
	 * 
	 * Method   : getAccountDetails
	 * Description : to call a service method for fetching the account details.      
	 * @param accountNumber  : Customer account Number
	 * @return account details 
	 * @throws AccountDoesntExistException 
	 * 
	 **************************************************************************************************/

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("account/{accountNumber}")
	public ResponseEntity<AccountDetails> getAccountDetails(@PathVariable long accountNumber) throws AccountDoesntExistException {
			AccountDetails accountDetails = passbookService.getAccountDetailsByAccountId(accountNumber);
			return new ResponseEntity<AccountDetails>(accountDetails, HttpStatus.OK);
	}
	
	
	
	/***************************************************************************************************
	 * 
	 * Method  :  getAccountallTransactionsDetails
	 * Description : to call a service method for fetching the all the transaction details.
	 * @param accountNumber : Customer account Number
	 * @return transaction list.
	 * @throws AccountDoesntExistException 
	 * @throws TransactionFailedException 
	 * 
	 **************************************************************************************************/
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("passbook/transactions/{accountNumber}")
	public ResponseEntity<List<Transaction>> getAccountallTransactionsDetails(@PathVariable long accountNumber) throws AccountDoesntExistException, TransactionFailedException {
			List<Transaction> transactionList = passbookService.getAccountTransactionDetails(accountNumber);
			return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
	}
	
	
	
	/********************************************************************************************************
	 * 
	 * Method : getAccountTransactionsByDateRange
	 * Description : it call a service Method for fetching the transactions between the  fromDate and toDate.
	 * @param accountNumber
	 * @param fromDate
	 * @param toDate
	 * @return transactions list as a response.
	 * @throws AccountDoesntExistException 
	 * @throws TransactionFailedException 
	 * 
	 ********************************************************************************************************/

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("transactions/search/{accountNumber}/{fromDate}/{toDate}")
	public List<Transaction> getAccountTransactionsByDateRange(@PathVariable("accountNumber") long accountNumber,
			@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime fromDate,
			@PathVariable("toDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime toDate) throws TransactionFailedException, AccountDoesntExistException {
		return passbookService.getAccountTransactionByDateRange(accountNumber, fromDate, toDate);
	}

	
	
	/**********************************************************************************************************
	 *
	 * Method : getLastUpdatePassbookDetails
	 * Description : it call's the service method for fetching the passbook update details by account Number.
	 * @param accountNumber 
	 * @return passbookUpdateDetails
	 * @throws AccountDoesntExistException 
	 *  
	 **********************************************************************************************************/
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("updatepassbook/{accountNumber}")
	public PassbookUpdate getLastUpdatePassbookDetails(@PathVariable long accountNumber) throws AccountDoesntExistException {
		return passbookService.passbookUpdateDetailsByAccountNumber(accountNumber);
	}
	
	
	
	/**********************************************************************************************************
	 * 
	 * Method : getTransactions
	 * Despcription : It calls the service method for fetching the transactions by account Number.
	 * @param accountNumber
	 * @param lastUpdatedDate
	 * @return transactions list
	 * @throws TransactionFailedException 
	 *  
	 **********************************************************************************************************/
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("passbook/transactions/{accountNumber}/{lastUpdateDate}")
	public List<Transaction> getTransactions(@PathVariable("accountNumber") long accountNumber,
			@PathVariable("lastUpdateDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime lastUpdatedDate) throws TransactionFailedException {
		return passbookService.getTransactionDetailsAfterLastUpdateDate(accountNumber, lastUpdatedDate);
	}
}
                  