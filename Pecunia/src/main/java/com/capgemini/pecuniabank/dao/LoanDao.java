package com.capgemini.pecuniabank.dao;


import java.util.List;

import com.capgemini.pecuniabank.entity.Account;
import com.capgemini.pecuniabank.entity.Ledger;
import com.capgemini.pecuniabank.entity.Request;


public interface LoanDao {
	
	boolean addRequest(Request Request);
	Account existAccount(String accountNumber) ;
	void addledger(Ledger ledger);
	boolean findAccount(String accountNumber);
	List<Ledger> viewLedger(String accountNumber);
	List<Ledger> viewAllLedger();
	
}
