package com.capgemini.accountmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.accountmanagement.entity.CustomerDetails;
import com.capgemini.accountmanagement.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
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
