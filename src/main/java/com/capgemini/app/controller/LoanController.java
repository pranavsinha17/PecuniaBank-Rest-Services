package com.capgemini.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Ledger;
import com.capgemini.app.entity.Request;
import com.capgemini.app.exception.UserException;
import com.capgemini.app.service.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@PostMapping("/addRequest")
	public ResponseEntity<Request> addRequest(@RequestBody Request request) {
		loanService.addRequest(request);
		return new ResponseEntity<Request>(HttpStatus.OK);
	}
	
	@PostMapping("/addAccountDetails")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		loanService.addAccount(account);
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@PostMapping("/loanRequest")
	public String LoanRequest(@Valid @RequestBody Request request, BindingResult br) throws UserException{
		System.out.println(request.toString());
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + " ";
			throw new UserException(err);
		}
		try {
			loanService.loanProcess(request);
			return "Your loan Request has been granted for more information view loan ledger";
		}
		catch(Exception e) {
			throw new UserException("Your credit score is not good to grant your Loan Request");
		}
		
	}
	@PostMapping("/viewLedger/{accountNumber}")
	public String viewLedger(@Valid @RequestBody Ledger ledger, BindingResult br) throws UserException{
		System.out.println(ledger.toString());
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + " ";
			throw new UserException(err);
		}
		try {
			loanService.ViewLedger(ledger.getAccountNumber());
			return "your requested data is here";
			//return "Your loan Request has been granted for more information view loan ledger";
		}
		catch(Exception e) {
			throw new UserException("Your loan request has been rejected");
		}
		
	}
	@PostMapping("/checkAccount/{accountNumber}")
	public String checkAccount(@Valid @RequestBody Account account, BindingResult br) throws UserException{
		System.out.println(account.toString());
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + " ";
			throw new UserException(err);
		}
		try {
			loanService.findAccount(account.getAccountNumber());
			return "Account Exist";
		}
		catch(Exception e) {
			throw new UserException("Your Account does not Exist. To take loan first you have to open account in our bank. For that go to Account management branch.");
		}
		
	}
	@GetMapping("/viewLedgerData")
	public String viewLedgerData(@Valid @RequestBody Ledger ledger, BindingResult br) throws UserException{
		System.out.println(ledger.toString());
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + " ";
			throw new UserException(err);
		}
		try {
			loanService.viewAll();
			return "your requested data is here";
			//return "Your loan Request has been granted for more information view loan ledger";
		}
		catch(Exception e) {
			throw new UserException("No data in ledger");
		}
		
	}
	
	
	


}
