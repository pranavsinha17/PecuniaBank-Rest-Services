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
import com.capgemini.accountmanagement.entity.Address;
import com.capgemini.accountmanagement.entity.CustomerDetails;
import com.capgemini.accountmanagement.service.Services;


@RestController
public class Controller {
	
	@Autowired
	private Services service;
	
	@RequestMapping("/accounts")
	public List<AccountDetails> getAllAccounts()//for getting all account information
	{
		return service.getAllAccounts();
	}
	@RequestMapping(method=RequestMethod.POST,value="/accounts")
	public String addAccount(@RequestBody AccountDetails account) //adding a new account
	{
		
		service.addAccount(account);
		return "Account added successfully";
	}
	@RequestMapping("/accounts/{accountNumber}")
	public Optional<AccountDetails> getAccount(@PathVariable long accountNumber)//for getting detail of an specific account
	{
		return service.getAccount(accountNumber);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/accounts/{accountNumber}")
	public String updateAccount(@RequestBody AccountDetails account,@PathVariable long accountNumber) //for updating details
	{	
		service.updateAccount(account,accountNumber);
		return "Account has been updated successfully";
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/accounts/{accountNumber}")
	public String deleteAccount(@PathVariable long accountNumber)//for deleting an account
	{
		
		service.deleteAccount(accountNumber);	
		return "Account has been deleted successfully";

	}
	
	@RequestMapping("/address")
	public List<Address> getAllAddress()//for getting all address(customer,employee,branch)
	{
		return service.getAllAddress();
	}
	@RequestMapping(method=RequestMethod.POST,value="/address")
	public String addAddress(@RequestBody Address address) //for adding address
	{
		
		service.addAddress(address);
		return "Address addded successfully";
	}
	
	@RequestMapping("/customers")
	public List<CustomerDetails> getAllCustomers()//for getting details of all customer
	{
		return service.getAllCustomers();
	}
	@RequestMapping(method=RequestMethod.POST,value="/customers")
	public String addCustomer(@RequestBody CustomerDetails customer)//To add a new customer
	{
		
		service.addCustomer(customer);	
		return "Customer added successfully";
	}
	@RequestMapping(method=RequestMethod.PUT,value="/customers/{customerId}")
	public String updateCustomer(@RequestBody CustomerDetails customer,@PathVariable long customerId)//for updating customer details
	{
		
		service.updateCustomer(customer,customerId);
		return "Customer details updated successfully";
	}	
}
