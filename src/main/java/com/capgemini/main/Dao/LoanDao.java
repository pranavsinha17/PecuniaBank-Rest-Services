package com.capgemini.main.Dao;


import java.util.List;

import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.LoanLedger;
import com.capgemini.main.entity.LoanRequest;


public interface LoanDao {
	
	boolean addRequest(LoanRequest Request);
	AccountDetails existAccount(String accountNumber) ;
	void addledger(LoanLedger ledger);
	boolean findAccount(String accountNumber);
	List<LoanLedger> viewLedger(String accountNumber);
	List<LoanLedger> viewAllLedger();
	
}
