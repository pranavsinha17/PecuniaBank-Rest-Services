package com.capgemini.accountmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.dao.AccountDao;
import com.capgemini.accountmanagement.dao.CustomerDao;
import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.AddressDetails;
import com.capgemini.accountmanagement.entity.CustomerDetails;


@Service
public class AccountManagementImplementation implements AccountService {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public boolean addAccount(CustomerDetails customerDetails) {
		
		customerDao.addCustomer(customerDetails);
		AccountDetails account=new AccountDetails();
		account.setAccountBalance(customerDetails.getOpeningBalance());
		account.setAccountHolderName(customerDetails.getCustomerFirstName()+""+customerDetails.getCustomerLastName());
		if(customerDetails.getAccountType().equals("Savings"))
		account.setAccountInterest((float) 3.5);
		else if(customerDetails.getAccountType().equals("Current"))
		account.setAccountInterest((float) 3.0);
		account.setAccountStatus("Active");
		account.setBranchdetails(accountDao.findBranch(customerDetails.getBranchId()));//which branch customer want to open an account..
		account.setCustomerDetails(customerDetails);
		System.out.println("Account added successfully");
		return true;
		
	}

	@Override
	public boolean deleteAccount(long accountNumber) {
		return customerDao.deleteAccount(accountNumber);
	}

	@Override
	public boolean updateAccountAddress(long accountNumber, AddressDetails address) {
		return customerDao.updateAddress(accountNumber, address);
	}

	@Override
	public boolean updateAccountMobileNumber(String mobileNumber ,long accountNumber) {
		return customerDao.updateMobile(mobileNumber,accountNumber);
	}

	@Override
	public boolean updateName(String name,long accountNumber) {
		
		return customerDao.updateName(name,accountNumber) ;
	}

	@Override
	public List<AccountDetails> allAccount() {

		return accountDao.getAllAccount();
	}

}
