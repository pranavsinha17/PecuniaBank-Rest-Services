package com.capgemini.app.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Ledger;
import com.capgemini.app.entity.Request;
import com.capgemini.app.exception.UserException;
import com.capgemini.app.service.LoanService;

/********************************************************************************
 * @author       Amardeep Singh
 * Description   This is the controller class, it is responsible to manage the
  				 flow of the application
 * Created On
 
 ********************************************************************************/


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	/********************************************************************************
	* Method             LoanRequest
	* Description        to call the service function add request and loanprocess to perform the 
	                     loan approval of data
	* returns Response   returns response as grant message if loan is approved
	                     
	* Created By         Amardeep Singh
	* Created on
	**********************************************************************************/
	
	//loan process
	@PostMapping("/loanRequest")
	public String LoanRequest(@Valid @RequestBody Request request) throws UserException{
		try {
			loanService.addRequest(request);
			loanService.loanProcess(request);
			return "Your loan Request has been granted for more information view loan ledger";
		}
		catch(Exception e) {
			throw new UserException(e.getMessage());
		}
		
	}

	/********************************************************************************
	* Method             getData
	* Description        to call the service function viewLedger to retrieve the 
	                     loan ledger data by account number
	* returns Response   returns list of ledger data
	                     
	* Created By         Amardeep Singh
	* Created on
	**********************************************************************************/
	
	@GetMapping("/viewLedger/{accountNumber}")
	  public ResponseEntity<List<Ledger>> viewLedger(@Valid @PathVariable("accountNumber") String accountNumber) throws UserException{
		
			
			List<Ledger> ledgerList = loanService.ViewLedger(accountNumber);
			if(ledgerList==null)
				throw new UserException("Your loan request has been rejected");
			
			
			return new ResponseEntity<List<Ledger>>(ledgerList,HttpStatus.OK);
	
		}
	
	/********************************************************************************
	* Method             checkAccount
	* Description        to call the service function findAccount to check if account exist or not
	                     
	* returns Response   returns response as account exist if findAccount returns true
	                     
	* Created By         Amardeep Singh
	* Created on
	**********************************************************************************/
	
	
	@GetMapping("/checkAccount/{accountNumber}")
	public String checkAccount(@PathVariable("accountNumber") String accountNumber) throws UserException{
		try {
			loanService.findAccount(accountNumber);
			return "Account Exist";
	
		}
		catch(Exception e) {
			throw new UserException(e.getMessage());
		}
		
	}
	
	/********************************************************************************
	* Method             getLedgerData
	* Description        to call the service function viewAll to retrieve the whole loan ledger data
	                     
	* returns Response   returns list of loan ledger data
	                     
	* Created By         Amardeep Singh
	* Created on
	**********************************************************************************/

	@GetMapping("/viewLedgerData")
	public ResponseEntity<List<Ledger>> viewLedgerData() throws UserException{

		
			List<Ledger> ledgerList = loanService.viewAll();
			if(ledgerList==null)
				throw new UserException("No data in ledger");
			
			return new ResponseEntity<List<Ledger>>(ledgerList,HttpStatus.OK);
		
}
	
	
	
	
	
	


}
