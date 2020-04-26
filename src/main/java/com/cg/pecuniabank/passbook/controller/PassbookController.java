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
import com.cg.pecuniabank.passbook.service.PassbookService;

@RestController
public class PassbookController {

	@Autowired
	PassbookService passbookService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("account/{accountId}")
	public ResponseEntity<AccountDetails> getAccountDetails(@PathVariable long accountId) {
			AccountDetails accountDetails = passbookService.getAccountDetailsByAccountId(accountId);
			return new ResponseEntity<AccountDetails>(accountDetails, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("passbook/transactions/{accountId}")
	public ResponseEntity<List<Transaction>> getACcountTransactionDetails(@PathVariable long accountId) {
			List<Transaction> transactionList = passbookService.getAccountTransactionDetails(accountId);
			return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("transactions/search/{accountNumber}/{fromDate}/{toDate}")
	public List<Transaction> getAccountTransactionsByDateRange(@PathVariable("accountNumber") long accountNumber,
			@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime fromDate,
			@PathVariable("toDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime toDate) {
		return passbookService.getAccountTransactionByDateRange(accountNumber, fromDate, toDate);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("updatepassbook/{accountNumber}")
	public PassbookUpdate getLastUpdatePassbookDetails(@PathVariable long accountNumber) {
		return passbookService.passbookUpdateDetailsByAccountNumber(accountNumber);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("passbook/transactions/{accountNumber}/{lastUpdateDate}")
	public List<Transaction> getTransactions(@PathVariable("accountNumber") long accountNumber,
			@PathVariable("lastUpdateDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime lastUpdatedDate) {
		return passbookService.getTransactionDetailsAfterLastUpdateDate(accountNumber, lastUpdatedDate);
	}
}
                  