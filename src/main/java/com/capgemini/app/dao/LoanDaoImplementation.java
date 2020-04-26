package com.capgemini.app.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Ledger;
import com.capgemini.app.entity.Request;


@Repository
@Transactional
public class LoanDaoImplementation implements LoanDao{
	
	@PersistenceContext
	private EntityManager em;
	
	public void insertAccountDetails(Account account)
	{
		em.persist(account);
	}
	
	public void insertLoanRequest(Request request)
	{
		em.persist(request);
	}
	

	@Override
	public boolean addRequest(Request request) {
		em.persist(request);
		return true;
	}
	
	
	@Override
	public boolean addAccount(Account account) {
		em.persist(account);
		return true;
	}

	@Override
	public Account existAccount(String accountNumber)  {
		// TODO Auto-generated method stub
		Account account=em.find(Account.class, accountNumber);
		return account;
	}

	@Override
	public void addledger(Ledger ledger) {
		// TODO Auto-generated method stub
		em.persist(ledger);
	}

	@Override
	public boolean findAccount(String accountNumber) {
		// TODO Auto-generated method stub
		return em.contains(em.find(Account.class, accountNumber));
		
	}

	@Override
	public List<Ledger> viewLedger(String accountNumber) {
		// TODO Auto-generated method stub
		String Qstr="SELECT ledger FROM Ledger ledger WHERE ledger.accountNumber= :accountNumber";
		TypedQuery<Ledger> query=em.createQuery(Qstr,Ledger.class).setParameter("accountNumber", accountNumber);
		List<Ledger> ledgerList=query.getResultList();
		return ledgerList;
	}

	@Override
	public List<Ledger> viewAllLedger() {
		// TODO Auto-generated method stub
		String Qstr="SELECT ledger FROM Ledger ledger";
		TypedQuery<Ledger> query=em.createQuery(Qstr,Ledger.class);
		List<Ledger> ledgerList=query.getResultList();
		return ledgerList;
	}
	
	

}
