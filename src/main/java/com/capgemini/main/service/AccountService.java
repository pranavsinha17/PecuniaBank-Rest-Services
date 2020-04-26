package com.capgemini.main.service;

import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.BranchDetails;
import com.capgemini.main.entity.CustomerDetails;

public interface AccountService {
	public boolean addAccount(CustomerDetails customerDetails,int creditScore);
	public boolean deleteAccount(long accountId);
	public boolean updateAccountAddress(long accountId, Address address);
	public boolean updateAccountMobileNumber(long accountId, String mobileNumber);
	
}
