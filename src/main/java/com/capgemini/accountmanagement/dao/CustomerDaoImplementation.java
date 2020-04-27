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
		entityManager.remove(account);
		account.setAccountStatus("Close");
		account.setAccountInterest((float) 0.0);
		entityManager.persist(account);
		return true;
		}
		return false;
		
	}

	@Override
	public boolean updateMobile( String mobileNumber,long accountNumber) {
		
		if(entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
			AccountDetails account=entityManager.find(AccountDetails.class, accountNumber);
			entityManager.remove(account);
			account.getCustomerDetails().setContactNumber(mobileNumber);
			entityManager.persist(account);
			return true;
			}
			return false;
	}

	@Override
	public boolean updateAddress(long accountNumber, AddressDetails address) {
		
		if(entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
			AccountDetails account=entityManager.find(AccountDetails.class, accountNumber);
			entityManager.remove(account);
			AddressDetails address1=entityManager.find(AddressDetails.class, account.getCustomerDetails().getAddress().getAddressId());
			address1.setCity(address.getCity());
			address1.setState(address.getState());
			address1.setStreet(address.getStreet());
			address1.setZipCode(address.getZipCode());
			account.getCustomerDetails().setAddress(address1);
			entityManager.persist(account);
			return true;
			}
			return false;
	}

	@Override
	public boolean updateName(String name,long accountNumber) {
		
		if(entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
			AccountDetails account=entityManager.find(AccountDetails.class, accountNumber);
			entityManager.remove(account);
			account.setAccountHolderName(name);
			entityManager.persist(account);
			return true;
			}
			return false;
	}

}
