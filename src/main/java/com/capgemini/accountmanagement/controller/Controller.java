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
//	@Autowired
//	private AddressService addressService;
//	@Autowired
//	private CustomerService customerService;
	
	
	@RequestMapping("/accounts")
	public List<AccountDetails> getAllAccounts()
	{
		return service.getAllAccounts();
	}
	@RequestMapping(method=RequestMethod.POST,value="/accounts")
	public void addAccount(@RequestBody AccountDetails account) {
		
		service.addAccount(account);	
	}
	@RequestMapping("/accounts/{accountNumber}")
	public Optional<AccountDetails> getAccount(@PathVariable long accountNumber)
	{
		return service.getAccount(accountNumber);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/accounts/{accountNumber}")
	public void updateAccount(@RequestBody AccountDetails account,@PathVariable long accountNumber) {
		
		
		service.updateAccount(account,accountNumber);	
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/accounts/{accountNumber}")
	public String deleteAccount(@PathVariable long accountNumber) {
		
		service.deleteAccount(accountNumber);	
		return "Customer has been deleted successfully";

	}
	
	@RequestMapping("/address")
	public List<Address> getAllAddress()
	{
		return service.getAllAddress();
	}
	@RequestMapping(method=RequestMethod.POST,value="/address")
	public void addAddress(@RequestBody Address address) {
		
		service.addAddress(address);	
	}
	
	@RequestMapping("/customers")
	public List<CustomerDetails> getAllCustomers()
	{
		return service.getAllCustomers();
	}
	@RequestMapping(method=RequestMethod.POST,value="/customers")
	public void addCustomer(@RequestBody CustomerDetails customer) {
		
		service.addCustomer(customer);	
	}
	@RequestMapping(method=RequestMethod.PUT,value="/customers/{customerId}")
	public void updateCustomer(@RequestBody CustomerDetails customer,@PathVariable long customerId) {
		
		service.updateCustomer(customer,customerId);	
	}
//	@RequestMapping(method=RequestMethod.DELETE,value="/customers/{customerId}")
//	public void deletCustomer(@PathVariable long customerId) {
//		
//		service.deleteCustomer(customerId);	
//	}


	
	
}
