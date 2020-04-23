package com.capgemini.accountmanagement.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.dao.AccountRepository;
import com.capgemini.accountmanagement.dao.AddressRepository;
import com.capgemini.accountmanagement.dao.CustomerRepository;
import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.Address;
import com.capgemini.accountmanagement.entity.CustomerDetails;


@Service
public class Services {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	
	//Account Service
	public List<AccountDetails>getAllAccounts()
	{
		List<AccountDetails>accounts=new ArrayList<>();
		accountRepository.findAll().forEach(accounts::add);	
		return accounts;
	}
	public void addAccount(AccountDetails account) {
		
		accountRepository.save(account);
		
	}
	public void updateAccount(AccountDetails account, long accountNumber) {
		
		accountRepository.save(account);
		
	}
	public Optional<AccountDetails> getAccount(long accountNumber)
	{
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return accountRepository.findById(accountNumber);
	}
	public void deleteAccount(long accountNumber) {
		
		accountRepository.deleteById(accountNumber);
		}
	

	//Customer Service
	public List<CustomerDetails>getAllCustomers()
	{
		List<CustomerDetails>customers=new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);	
		return customers;
	}
	public void addCustomer(CustomerDetails customer) {
		
		customerRepository.save(customer);
		
	}
	public void updateCustomer(CustomerDetails customer, long customerId) {
		
		customerRepository.save(customer);
		
	}
//	public void deleteCustomer(long customerId) {
//		
//		String str=Long.toString(customerId);
//		customerRepository.deleteById(str);	
//		}
	//address Service
	public List<Address>getAllAddress()
	{
		List<Address>address=new ArrayList<>();
		addressRepository.findAll().forEach(address::add);	
		return address;
	}
	public void addAddress(Address address) {
		
		addressRepository.save(address);
		
	}

}
	
	
	
	
	


