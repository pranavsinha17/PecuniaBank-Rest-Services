package com.capgemini.app.dao;


import java.util.List;

import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Ledger;
import com.capgemini.app.entity.Request;
import com.capgemini.app.exception.AccountException;

public interface LoanDao {
	
	boolean addRequest(Request Request);
	boolean addAccount(Account account);
	Account existAccount(String accountNumber) ;
	void addledger(Ledger ledger);
	
	boolean removeCenter(long id);
	
	List<Request> getAllCenter();
	
}
