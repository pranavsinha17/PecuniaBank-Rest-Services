package com.cg.pecuniabank.passbook.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pecuniabank.passbook.entity.PassbookUpdate;

/********************************************************************************
 * 
 * @author Prabhjot
 * Description : It provides the dao for saving the passbook update details in
 * the passbook Update entity, updating the lastupdatedate of the account number.
 * created by : Prabhjot ,21 April 2020
 *
 ********************************************************************************/

@Repository
@Transactional
public class PassbookDAOImpl implements PassbookDAO {

	@Autowired
	EntityManager entityManager;
	

	/****************************************************************************
	 * 
	 * Method : passbookUpdateNewEntry
	 * Description : for saving the new passbookDetails in PassbookUpdate entity.
	 * created by : Prabhjot ,22 April 2020
	 * 
	 *****************************************************************************/

	@Override
	public void passbookUpdateNewEntry(PassbookUpdate passbookUpdateDetails) {
		entityManager.persist(passbookUpdateDetails);
	}

	
	/**************************************************************************
	 * 
	 * Method : passbookUpdateChangeLastUpdate
	 * Description : for updating the details in the PassbookUpdate table.
	 * created by : Prabhjot ,22 April 2020
	 * 
	 ***************************************************************************/
	
	@Override
	public void passbookUpdateChangeLastUpdate(long accountNumber, LocalDateTime systemDate) 
	{
		Query query = entityManager.createQuery("UPDATE PassbookUpdate SET lastUpdate = :systemDate WHERE accountNumber=:accountNumber");
		query.setParameter("systemDate", systemDate);
		query.setParameter("accountNumber", accountNumber);
		query.executeUpdate();
	}
	

	/******************************************************************************* 
	 * 
	 * Method : passbookUpdateDetailsByAccountNumber
	 * Description : for fetching the PassbookUpdate details by the account Number.
	 * @return it will return the passbook update details by account number.
	 * created by : Prabhjot ,22 April 2020
	 * 
	 *******************************************************************************/
	
	@Override
	public PassbookUpdate passbookUpdateDetailsByAccountNumber(long accountNumber) {
		return entityManager.find(PassbookUpdate.class, accountNumber);
	}
}
