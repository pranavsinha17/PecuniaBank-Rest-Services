package com.capgemini.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.entity.LoanLedger;
import com.capgemini.main.exception.UserException;
import com.capgemini.main.service.LoanService;
import com.capgemini.main.entity.LoanRequest;

//@RestController
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@PostMapping("/addRequest")
	public ResponseEntity<LoanRequest> addRequest(@RequestBody LoanRequest request) {
		loanService.addRequest(request);
		return new ResponseEntity<LoanRequest>(HttpStatus.OK);
	}
	
	
	
	@PostMapping("/loanRequest")
	public String LoanRequest(@Valid @RequestBody LoanRequest request, BindingResult br) throws UserException{
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
	
	//find ledger for particular Account
	@PostMapping("/viewLedger/{accountNumber}")
	  public ResponseEntity<List<LoanLedger>> getData(@Valid @PathVariable("accountNumber") long accountNumber, BindingResult br) throws UserException{
		//System.out.println(ledger.toString());
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + " ";
			throw new UserException(err);
		}
		try {
			//return "your requested data is here";
			List<LoanLedger> list = loanService.ViewLedger(accountNumber);
			return new ResponseEntity<List<LoanLedger>>(list,HttpStatus.OK);
			//return "Your loan Request has been granted for more information view loan ledger";
		}
		catch(Exception e) {
			throw new UserException("Your loan request has been rejected");
		}
		
	}
	//check account exist or not
	@PostMapping("/checkAccount/{accountNumber}")
	public String checkAccount(@Valid  @PathVariable("accountNumber") long accountNumber, BindingResult br) throws UserException{
		
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + " ";
			throw new UserException(err);
		}
		try {
			loanService.findAccount(accountNumber);
			return "Account Exist";
		}
		catch(Exception e) {
			throw new UserException("Your Account does not Exist. To take loan first you have to open account in our bank. For that go to Account management branch.");
		}
		
	}
	//View all the loan details.
	@GetMapping("/viewLedgerData")
	public ResponseEntity<List<LoanLedger>> getLedgerData(@Valid  BindingResult br) throws UserException{
	//	System.out.println(ledger.toString());
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + " ";
			throw new UserException(err);
		}
		try {
			List<LoanLedger> list = loanService.viewAll();
			return new ResponseEntity<List<LoanLedger>>(list,HttpStatus.OK);
			//return "Your loan Request has been granted for more information view loan ledger";
		}
		catch(Exception e) {
			throw new UserException("No data in ledger");
		}
		
	}
	
	

}
