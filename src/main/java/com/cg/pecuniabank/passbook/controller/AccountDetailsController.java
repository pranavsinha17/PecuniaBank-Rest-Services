package com.cg.pecuniabank.passbook.controller;

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pecuniabank.passbook.entity.AccountDetails;
import com.cg.pecuniabank.passbook.entity.Transaction;
import com.cg.pecuniabank.passbook.exception.AccountDoesntExistException;
import com.cg.pecuniabank.passbook.exception.TransactionsNotFoundException;
import com.cg.pecuniabank.passbook.service.PassbookService;

@RestController
public class AccountDetailsController {

	@Autowired
	PassbookService service;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("account/{accountId}")
	public ResponseEntity<AccountDetails> getAccountDetails(@PathVariable long accountId) {
		try {
			AccountDetails accountDetails = service.getAccountDetailsByAccountId(accountId);
			return new ResponseEntity<AccountDetails>(accountDetails, HttpStatus.OK);
		} catch (AccountDoesntExistException accountDoesntExistException) {
			throw new AccountDoesntExistException(accountDoesntExistException.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("transactions/{accountId}")
	public ResponseEntity<List<Transaction>> getACcountTransactionDetails(@PathVariable long accountId) {
		try {
			List<Transaction> transactionList = service.getAccountTransactionDetails(accountId);
			return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
		} catch (TransactionsNotFoundException transactionsNotFoundException) {
			throw new TransactionsNotFoundException(transactionsNotFoundException.getMessage());
		}
	}

	@GetMapping("transactions/search")
	public List<Transaction> getAccountTransactionsByDateRange(@PathParam("accountNumber") long accountNumber,
			@PathParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
			@PathParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {

		return service.getAccountTransactionByDateRange(accountNumber, fromDate, toDate);
	}
}
