package com.capgemini.main.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.entity.Admin;
import com.capgemini.main.entity.ChequeDetails;
import com.capgemini.main.entity.SlipDetails;
import com.capgemini.main.exception.UserDefineException;
import com.capgemini.main.exception.UserException;
import com.capgemini.main.service.SlipService;
import com.capgemini.main.service.TransationUsingCreditCheque;
import com.capgemini.main.service.TranscationUsingDebitCheque;

//@RestController
public class TransactionController {
	
	@Autowired
	TranscationUsingDebitCheque debitService;  
	
	@Autowired
	TransationUsingCreditCheque creditService;
	
	@Autowired
	SlipService slipService;
	
	
	
	
	@GetMapping("/")
	public ResponseEntity<String> hello()
	{
		return new ResponseEntity<String>("Hello",HttpStatus.OK);	
	}
	
	/** currently I am using command Line Runner 
	 * @throws UserException **/
	
	/*
	 * Transaction using cheque for debitService .
	 */
	@PostMapping("/DebitChequeDetails") //insert the data to database
	public ResponseEntity<ChequeDetails> DebitDetails(@RequestBody ChequeDetails chequeDetails) throws UserDefineException, UserException {
		
		if(creditService.checkAccountExist(chequeDetails.getAccountNumber())&&creditService.checkAccountExist(chequeDetails.getBenificaryAccountNumber())) {
		String []data;
		data=chequeDetails.getIssueDate1().split(",");
		int year = Integer.parseInt( data[0] );
		int month = Integer.parseInt( data[1] );  
		int day = Integer.parseInt( data[2] );
		LocalDate issueDate = LocalDate.of(year,month,day);
		chequeDetails.setIssueDate(issueDate);
		debitService.debitCheque(chequeDetails);
		}
		else
			throw new UserDefineException("Account Number is Invalid");
		return new ResponseEntity<ChequeDetails>(chequeDetails,HttpStatus.OK);
	}
	
	/*
	 * Transaction using cheque for debitService .
	 */
	@PostMapping("/CreditChequeDetails") //insert the data to database
	public ResponseEntity<ChequeDetails> CreditDetails(@RequestBody ChequeDetails chequeDetails) throws UserDefineException, UserException{
		
		//if(creditService.checkAccountExist(chequeDetails.getAccountNumber())&&creditService.checkAccountExist(chequeDetails.getBenificaryAccountNumber())) {
		String []data;
		data=chequeDetails.getIssueDate1().split(",");
		int year = Integer.parseInt( data[0] );
		int month = Integer.parseInt( data[1] );  
		int day = Integer.parseInt( data[2] );
		LocalDate issueDate = LocalDate.of(year,month,day);
		chequeDetails.setIssueDate(issueDate);
		creditService.creditCheque(chequeDetails);
		//}
		//else
		//{
		//	throw new UserDefineException("Account Number is Invalid");
		//}
		
		return new ResponseEntity<ChequeDetails>(chequeDetails,HttpStatus.OK);
	}
	
	/*
	 * Transaction using slip for creditService .
	 */
	@PostMapping("/SlipCrediDetails") //insert the data to database
	public ResponseEntity<SlipDetails>slipDetailsCredit(@RequestBody SlipDetails slipDetails) throws UserDefineException, UserException{
		slipDetails.setSlipDate(LocalDate.now());
		//if(creditService.checkAccountExist(slipDetails.getAccountNumber()))
		slipService.creditSlip(slipDetails);
		//else
		//	throw new UserDefineException("Account Number is Invalid");
			
		
		
		return new ResponseEntity<SlipDetails>(slipDetails,HttpStatus.OK);
	}
	
	/*
	 * Transaction using slip for debitService .
	 */
	@PostMapping("/SlipDebitDetails") //insert the data to database
	public ResponseEntity<SlipDetails>slipDetailsDebit(@RequestBody SlipDetails slipDetails) throws UserException{
		slipDetails.setSlipDate(LocalDate.now());
		//if(creditService.checkAccountExist(slipDetails.getAccountNumber()))
		slipService.debitSlip(slipDetails);
		//else
		//	throw new UserDefineException("Account Number is Invalid");
		
		
		return new ResponseEntity<SlipDetails>(slipDetails,HttpStatus.OK);
	}
	
	
	
	

}
