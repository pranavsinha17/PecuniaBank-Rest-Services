package com.capgemini.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Request;
import com.capgemini.app.service.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	
	
	@PostMapping("/addRequest")
	public ResponseEntity<Request> addRequest(@RequestBody Request request) {
		loanService.loanProcess(request);
		return new ResponseEntity<Request>(HttpStatus.OK);
	}
	
	@PostMapping("/addAccountDetails")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		loanService.addAccount(account);
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	



}
