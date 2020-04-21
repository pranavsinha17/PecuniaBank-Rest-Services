package com.capgemini.accountmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts")
	public List<AccountDetails> getAllAccounts()
	{
		return accountService.getAllAccounts();
	}
	@RequestMapping("/accounts/{accountNumber}")
	public Optional<AccountDetails> getAccount(@PathVariable long accountNumber)
	{
		return accountService.getAccount(accountNumber);
	}
	@RequestMapping(method=RequestMethod.POST,value="/accounts")
	public void addAccount(@RequestBody AccountDetails account) {
		
		accountService.addAccount(account);	
	}
	@RequestMapping(method=RequestMethod.PUT,value="/accounts/{accountNumber}")
	public void updateAccount(@RequestBody AccountDetails account,@PathVariable long accountNumber) {
		
		accountService.updateAccount(account,accountNumber);	
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/accounts/{accountNumber}")
	public void deleteAccount(@PathVariable long accountNumber) {
		
		accountService.deleteAccount(accountNumber);	
	}

	
	
}
