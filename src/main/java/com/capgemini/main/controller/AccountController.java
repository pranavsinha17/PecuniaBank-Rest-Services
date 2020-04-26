package com.capgemini.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.CustomerDetails;
import com.capgemini.main.exception.UserDefineException;
import com.capgemini.main.service.AccountService;

//@RestController
public class AccountController {
	

	@Autowired
	AccountService accountService;
	
	String res;
	
	//According the employee the branch of the customer is set in the database.
	@PostMapping("/Account/{creditScore}")
	public ResponseEntity<String> addBranch(@RequestBody CustomerDetails customerDetails,@PathVariable("creditScore")int creditScore) {
		boolean result=accountService.addAccount(customerDetails, creditScore);
		if(result)
		{
			res="Add Account Sucessfuly";
		}
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@PostMapping("/AccountUpdateMobile/{accountId}/{mobileNumber}")
	public ResponseEntity<String> updateMobileNumber(@PathVariable("accountId")long accountId,@PathVariable("mobileNumber")String mobileNumber) {
		boolean result=accountService.updateAccountMobileNumber(accountId, mobileNumber);
		if(result)
		{
			res=" Account updated Sucessfuly";
		}
		else
			throw new UserDefineException("Account Number is Invalid");
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@PostMapping("/AccountDelete/{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accountId")long accountId) {
		boolean result=accountService.deleteAccount(accountId);
		if(result)
		{
			res=" Account deleted Sucessfuly";
		}
		else
			throw new UserDefineException("Account Number is Invalid");
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@PostMapping("/AccountUpdateAddress/{accountId}/{mobileNumber}")
	public ResponseEntity<String> updateAddress(@RequestBody Address address,@PathVariable("accountId")long accountId) {
		boolean result=accountService.updateAccountAddress(accountId, address);
		if(result)
		{
			res=" Account updated Sucessfuly";
		}
		else
			throw new UserDefineException("Account Number is Invalid");
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@PostMapping("/AccountUpdateName/{accountId}/{Name}")
	public ResponseEntity<String> updateName(@PathVariable("accountId")long accountId,@PathVariable("name")String Name) {
		boolean result=accountService.updateName(accountId, Name);
		if(result)
		{
			res=" Account updated Sucessfuly";
		}
		else
			throw new UserDefineException("Account Number is Invalid");
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}

}
