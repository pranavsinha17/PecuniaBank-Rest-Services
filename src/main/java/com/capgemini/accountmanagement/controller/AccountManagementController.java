package com.capgemini.accountmanagement.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.AddressDetails;
import com.capgemini.accountmanagement.entity.CustomerDetails;
import com.capgemini.accountmanagement.entity.UpdateData;
import com.capgemini.accountmanagement.exception.UserDefinedException;
import com.capgemini.accountmanagement.service.AccountService;

@RestController
public class AccountManagementController {
	
    @Autowired
	AccountService accountService;
	
	String res;
	
	//According to the employee's  branch the branch of the customer is set in the database.
	//working
	@PostMapping("/account")
	public ResponseEntity<String> addBranch(@RequestBody CustomerDetails customerDetails) {
		System.out.println("--------------------------------------------------------------");
		System.out.println(customerDetails);
		System.out.println("--------------------------------------------------------------");
		boolean result=accountService.addAccount(customerDetails);
		if(result)
		{
			res=" Account added Sucessfully";
		}
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	//working 
	@PostMapping("/updateMobile")
	public ResponseEntity<String> updateMobileNumber(@RequestBody UpdateData data) 
	{
		//System.out.println(mobileNumber+" "+accountNumber);
		boolean result=accountService.updateAccountMobileNumber(data.getMobileNumber(),data.getAccountNumber());
		if(result)
		{
			res=" Account updated Sucessfully";
		}
		else
			throw new UserDefinedException("Account Number is Invalid");
		
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
	 }
	//Working
	@DeleteMapping("/account/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable long accountNumber) {
		boolean result=accountService.deleteAccount(accountNumber);
		if(result)
		{
			res=" Account deleted Sucessfully";
		}
		else
			throw new UserDefinedException("Account Number is Invalid");
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	//working
	@PostMapping("/updateaddress")
	public ResponseEntity<String> updateAddress(@RequestBody UpdateData data ) {
		boolean result=accountService.updateAccountAddress(data.getAccountNumber(), data.getAddress());
		if(result)
		{
			res=" Account updated Sucessfully";
		}
		else
			throw new UserDefinedException("Account Number is Invalid");
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	//working
	@PostMapping("/updateName")
	public ResponseEntity<String> updateName(@RequestBody UpdateData data ) {
		boolean result=accountService.updateName(data.getName(),data.getAccountNumber());
		if(result)
		{
			res=" Account updated Sucessfully";
		}
		else
			throw new UserDefinedException("Account Number is Invalid");
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	//working
	@GetMapping("/accounts")
	public ResponseEntity<List<AccountDetails>> getAllAccount() {
		List<AccountDetails> accountlist=accountService.allAccount();
		List<AccountDetails> accountlist1=new ArrayList<AccountDetails>();
		for(AccountDetails accountDetails:accountlist)
		{
			if(accountDetails.getAccountStatus().equals("Close"));
			else
			{
				accountlist1.add(accountDetails);
			}
		}
		 return new ResponseEntity<List<AccountDetails>>(accountlist1,HttpStatus.OK);
	}

}

