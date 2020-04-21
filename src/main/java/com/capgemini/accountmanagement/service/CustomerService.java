package com.capgemini.accountmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.entity.CustomerDetails;
import com.capgemini.accountmanagement.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<CustomerDetails>getAllCustomers()
	{
		List<CustomerDetails>customers=new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);	
		return customers;
	}
	public Optional<CustomerDetails> getAccount(long customerId)
	{
		String str=Long.toString(customerId);
		return customerRepository.findById(str);
	}
	public void addCustomer(CustomerDetails customer) {
		
		customerRepository.save(customer);
		
	}
	public void updateCustomer(CustomerDetails customer, long customerId) {
		
		customerRepository.save(customer);
		
	}
	public void deleteCustomer(long customerId) {
		
		String str=Long.toString(customerId);
		customerRepository.deleteById(str);	
		}
}

