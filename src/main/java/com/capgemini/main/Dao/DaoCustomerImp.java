package com.capgemini.main.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.CustomerDetails;


@Transactional
@Repository
@Service
public class DaoCustomerImp implements DaoCustomer {

	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addCustomer(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		em.persist(customerDetails);
		
	}

	@Override
	public CustomerDetails findCustomer(long customerId) {
		// TODO Auto-generated method stub
		
		return em.find(CustomerDetails.class, customerId);
	}

	@Override
	public boolean deleteAccount(long accountId) {
		// TODO Auto-generated method stub
		if(em.contains(em.find(AccountDetails.class, accountId))) {
		AccountDetails account=em.find(AccountDetails.class, accountId);
		account.setAccountStatus("Close");
		account.setAccountInterest((float) 0.0);
		return true;
		}
		return false;
		
	}

	@Override
	public boolean updateMobile(long accountId, String mobileNumber) {
		// TODO Auto-generated method stub
		if(em.contains(em.find(AccountDetails.class, accountId))) {
			AccountDetails account=em.find(AccountDetails.class, accountId);
			account.getCustomerDetails().setContactNumber(mobileNumber);
			return true;
			}
			return false;
	}

	@Override
	public boolean updateAddress(long accountId, Address address) {
		// TODO Auto-generated method stub
		if(em.contains(em.find(AccountDetails.class, accountId))) {
			AccountDetails account=em.find(AccountDetails.class, accountId);
			account.getCustomerDetails().setAddress(address);
			return true;
			}
			return false;
	}

}
