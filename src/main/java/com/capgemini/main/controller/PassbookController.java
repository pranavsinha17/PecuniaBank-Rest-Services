package com.capgemini.main.controller;

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.Transaction;
import com.capgemini.main.exception.UserDefineException;
import com.capgemini.main.service.PassbookService;

@RestController
public class PassbookController {
	@Autowired
	PassbookService service;

	//All transaction related the particular account Number.
	@GetMapping("account/{accountId}")
	public ResponseEntity<AccountDetails> getAccountDetails(@PathVariable long accountId) {
		try {
			AccountDetails accountDetails = service.getAccountDetailsByAccountId(accountId);
			return new ResponseEntity<AccountDetails>(accountDetails, HttpStatus.OK);
		} catch (UserDefineException accountDoesntExistException) {
			throw new UserDefineException(accountDoesntExistException.getMessage());
		}
	}
//making first page of passbook
	@GetMapping("transactions/{accountId}")
	public ResponseEntity<List<Transaction>> getACcountTransactionDetails(@PathVariable long accountId) {
		try {
			List<Transaction> transactionList = service.getAccountTransactionDetails(accountId);
			return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
		} catch (UserDefineException transactionsNotFoundException) {
			throw new UserDefineException(transactionsNotFoundException.getMessage());
		}
	}
//transaction between two dates by account number
	@GetMapping("transactions/search")
	public List<Transaction> getAccountTransactionsByDateRange(@PathParam("accountNumber") long accountNumber,
			@PathParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
			@PathParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {

		return service.getAccountTransactionByDateRange(accountNumber, fromDate, toDate);
	}

}
