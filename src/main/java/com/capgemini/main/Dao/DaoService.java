package com.capgemini.main.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.BranchDetails;
import com.capgemini.main.entity.ChequeDetails;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.Transaction;


@Transactional
@Repository
@Service
public class DaoService implements DaoCheque {
	
	@PersistenceContext
	EntityManager em;
	/** These function me to set up the data base part **/
	public void insertBranchDetails(BranchDetails bd)
	{
		em.persist(bd);
	}
	
	public void insertEmployee(EmployeeCredentials ec)
	{
		em.persist(ec);
	}
	public void insertAccountDetails(AccountDetails ad)
	{
		em.persist(ad);
	}
	/*********************************/

	/* set the cheque Details in database*/
	@Override
	public void setChequeDetails(ChequeDetails chequeDetails) {
		// TODO Auto-generated method stub
		em.persist(chequeDetails);
		
	}


	@Override
	public void updateChequeStatus(long chequeNumber,String checkStatus ) {
		// TODO Auto-generated method stub
		ChequeDetails chequeDetails=em.find(ChequeDetails.class, chequeNumber);
		chequeDetails.setCheckStatus(checkStatus);
		
	}

	
	
	

}
