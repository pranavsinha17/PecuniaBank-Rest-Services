package com.capgemini.main.Dao;

import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.CustomerDetails;

public interface DaoCustomer {
	public void addCustomer(CustomerDetails customerDetails);
	public CustomerDetails findCustomer(long customerId);
    public boolean deleteAccount(long accountId);
    public boolean updateMobile(long accountId, String mobileNumber);
    public boolean updateAddress(long accountId, Address address);
    public boolean updateName(long accountId, String Name);
}
