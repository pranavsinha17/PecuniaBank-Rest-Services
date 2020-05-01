package com.capgemini.main.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.Transaction;


@Transactional
@Repository
@Service
public class DaoTransactionImp implements DaoTransactio {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Transaction getTranscationDetails(long transactionId) {
		// TODO Auto-generated method stub
		return em.find(Transaction.class, transactionId);
	}

	@Override
	public void setTranscationDetails(Transaction transactiondetails) {
		// TODO Auto-generated method stub
		em.persist(transactiondetails);
		
	}

}
