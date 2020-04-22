package com.capgemini.accountmanagement.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.Address;
import com.capgemini.accountmanagement.entity.CustomerDetails;
import com.capgemini.accountmanagement.repository.AccountRepository;
import com.capgemini.accountmanagement.repository.AddressRepository;
import com.capgemini.accountmanagement.repository.CustomerRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public List<AccountDetails>getAllAccounts()
	{
		List<AccountDetails>accounts=new ArrayList<>();
		accountRepository.findAll().forEach(accounts::add);	
		return accounts;
	}
	public Optional<AccountDetails> getAccount(long accountNumber)
	{
		String str=Long.toString(accountNumber);
		return accountRepository.findById(str);
	}
	public void addAccount(AccountDetails account) {
		
		accountRepository.save(account);
		
	}
	public void updateAccount(AccountDetails account, long accountNumber) {
		
		accountRepository.save(account);
		
	}
	public void deleteAccount(long accountNumber) {
		
		String str=Long.toString(accountNumber);
		accountRepository.deleteById(str);	
		}
}
	
	
	
	
	


