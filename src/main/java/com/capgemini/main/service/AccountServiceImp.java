package com.capgemini.main.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.Dao.DaoAccount;
import com.capgemini.main.Dao.DaoCustomer;
import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.BranchDetails;
import com.capgemini.main.entity.CustomerDetails;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	DaoAccount daoAccount;
	
	@Autowired
	DaoCustomer daoCustomer;

	@Override
	public boolean addAccount(CustomerDetails customerDetails,int creditScore) {
		// TODO Auto-generated method stub
		daoCustomer.addCustomer(customerDetails);
		AccountDetails account=new AccountDetails();
		account.setAccountBalance(customerDetails.getOpeningBalance());
		account.setAccountHolderName(customerDetails.getCustomerFirstName()+""+customerDetails.getCustomerLastName());
		if(customerDetails.getAccountType().equals("Saving"))
		account.setAccountInterest((float) 3.5);
		else if(customerDetails.getAccountType().equals("Current"))
		account.setAccountInterest((float) 4.0);
		account.setAccountStatus(customerDetails.getAccountType());
		account.setBranchdetails(daoAccount.findBranch(customerDetails.getBranchId()));//which branch customer want to open an account.
		account.setCreditScore(creditScore);//According to there previous loan record.
		account.setCustomerDetails(customerDetails);
		account.setDate(customerDetails.getDate());
		return true;
		
	}

	@Override
	public boolean deleteAccount(long accountId) {
		return daoCustomer.deleteAccount(accountId);
	}

	@Override
	public boolean updateAccountAddress(long accountId, Address address) {
		return daoCustomer.updateAddress(accountId, address);
	}

	@Override
	public boolean updateAccountMobileNumber(long accountId, String mobileNumber) {
		return daoCustomer.updateMobile(accountId, mobileNumber);
	}

	@Override
	public boolean updateName(long accountId, String accountHolderName) {
		// TODO Auto-generated method stub
		return daoCustomer.updateName(accountId, accountHolderName) ;
	}

}
