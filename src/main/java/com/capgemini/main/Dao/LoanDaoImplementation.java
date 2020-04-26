package com.capgemini.main.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.capgemini.main.entity.LoanLedger;
import com.capgemini.main.entity.LoanRequest;

@Repository
@Transactional
public class LoanDaoImplementation implements LoanDao{
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	
	

	@Override
	public boolean addRequest(LoanRequest request) {
		em.persist(request);
		return true;
	}
	
	

	
/*
	@Override
	public List<LoanRequest> getAllCenter() {
		return null;
		String Qstr="SELECT center FROM DiagnosticCenter center";
		TypedQuery<Request> query=em.createQuery(Qstr,Request.class);
		return query.getResultList();	
	}*/


	@Override
	public void addledger(LoanLedger ledger) {
		// TODO Auto-generated method stub
		em.persist(ledger);
	}

	

	@Override
	public List<LoanLedger> viewLedger(long accountNumber) {
		// TODO Auto-generated method stub
		String Qstr="SELECT ledger FROM Ledger ledger WHERE ledger.accountNumber= :accountNumber";
		TypedQuery<LoanLedger> query=em.createQuery(Qstr,LoanLedger.class).setParameter("accountNumber", accountNumber);
		List<LoanLedger> ledgerList=query.getResultList();
		return ledgerList;
	}

	@Override
	public List<LoanLedger> viewAllLedger() {
		// TODO Auto-generated method stub
		String Qstr="SELECT ledger FROM LoanLedger ledger";
		TypedQuery<LoanLedger> query=em.createQuery(Qstr,LoanLedger.class);
		List<LoanLedger> ledgerList=query.getResultList();
		return ledgerList;
	}
	
	

}
