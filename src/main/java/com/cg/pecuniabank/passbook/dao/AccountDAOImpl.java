package com.cg.pecuniabank.passbook.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pecuniabank.passbook.entity.AccountDetails;

/**************************************************************************
 * 
 * @author Prabhjot This Dao is for inserting account details, for getting
 *         Account Details by the account Id.
 *         
 *         created by : Prabhjot, 21 April 2020
 *
 **************************************************************************/

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	EntityManager entityManager;

	/******************************************************************************
	 * 
	 * Method:insertAccountDetails Description: for persiting the account details.
	 * created by : 22 April, 2020
	 *
	 ******************************************************************************/

	@Override
	public void insertAccountDetails(AccountDetails accountDetails) {
		accountDetails.setOpeningDate((LocalDateTime.now()));
		entityManager.persist(accountDetails);
	}

	/******************************************************************************
	 * 
	 * Method:getAccountDetailsByAccountId. Description: for fetching the account
	 * detail by the account id.
	 * @return accountDetails by Account Id
	 * created by : 22 April, 2020
	 * 
	 ******************************************************************************/

	@Override
	public AccountDetails getAccountDetailsByAccountId(long accountId) {
		return entityManager.find(AccountDetails.class, accountId);
	}

}
