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
import com.capgemini.app.exception.AccountException;

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
	public boolean removeCenter(long id) {
		Request center = em.find(Request.class, id);
		if(center!=null)
			{
			em.remove(center);
			return true;
			}
		return false;
	}

	@Override
	public List<Request> getAllCenter() {
		return null;
	/*	String Qstr="SELECT center FROM DiagnosticCenter center";
		TypedQuery<Request> query=em.createQuery(Qstr,Request.class);
		return query.getResultList();	*/
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
	
	

}
