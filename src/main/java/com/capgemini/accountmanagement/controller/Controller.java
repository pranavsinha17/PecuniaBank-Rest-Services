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
import com.capgemini.accountmanagement.service.AccountService;
import com.capgemini.accountmanagement.service.AddressService;
import com.capgemini.accountmanagement.service.CustomerService;

@RestController
public class Controller {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CustomerService customerService;
	
	
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
	
	@RequestMapping("/address")
	public List<Address> getAllAddress()
	{
		return addressService.getAllAddress();
	}
	@RequestMapping("/address/{addressId}")
	public Optional<Address> getAddress(@PathVariable long addressId)
	{
		return addressService.getAddress(addressId);
	}
	@RequestMapping(method=RequestMethod.POST,value="/address")
	public void addAddress(@RequestBody Address address) {
		
		addressService.addAddress(address);	
	}
	
	@RequestMapping("/customers")
	public List<CustomerDetails> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	@RequestMapping("/customers/{customerId}")
	public Optional<CustomerDetails> getCustomer(@PathVariable long customerId)
	{
		return customerService.getAccount(customerId);
	}
	@RequestMapping(method=RequestMethod.POST,value="/customers")
	public void addCustomer(@RequestBody CustomerDetails customer) {
		
		customerService.addCustomer(customer);	
	}
	@RequestMapping(method=RequestMethod.PUT,value="/customers/{customerId}")
	public void updateCustomer(@RequestBody CustomerDetails customer,@PathVariable long customerId) {
		
		customerService.updateCustomer(customer,customerId);	
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/customers/{customerId}")
	public void deletCustomer(@PathVariable long customerId) {
		
		customerService.deleteCustomer(customerId);	
	}


	
	
}
