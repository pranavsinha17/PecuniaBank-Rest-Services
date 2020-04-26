package com.capgemini.accountmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.AddressDetails;
import com.capgemini.accountmanagement.entity.CustomerDetails;

@Transactional
@Repository
@Service
public class CustomerDaoImplementation implements CustomerDao{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void addCustomer(CustomerDetails customerDetails) {
		
	//	System.out.println(customerDetails);
		entityManager.persist(customerDetails);
		
		
	}

	@Override
	public CustomerDetails findCustomer(long customerId) {
		
		return entityManager.find(CustomerDetails.class, customerId);
	}

	@Override
	public boolean deleteAccount(long accountNumber) {
		
		if(entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
		AccountDetails account=entityManager.find(AccountDetails.class, accountNumber);
		account.setAccountStatus("Close");
		account.setAccountInterest((float) 0.0);
		return true;
		}
		return false;
		
	}

	@Override
	public boolean updateMobile( String mobileNumber,long accountNumber) {
		
		if(entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
			AccountDetails account=entityManager.find(AccountDetails.class, accountNumber);
			account.getCustomerDetails().setContactNumber(mobileNumber);
			return true;
			}
			return false;
	}

	@Override
	public boolean updateAddress(long accountNumber, AddressDetails address) {
		
		if(entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
			AccountDetails account=entityManager.find(AccountDetails.class, accountNumber);
			account.getCustomerDetails().setAddress(address);
			return true;
			}
			return false;
	}

	@Override
	public boolean updateName(String name,long accountNumber) {
		
		if(entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
			AccountDetails account=entityManager.find(AccountDetails.class, accountNumber);
			account.setAccountHolderName(name);
			return true;
			}
			return false;
	}

}
