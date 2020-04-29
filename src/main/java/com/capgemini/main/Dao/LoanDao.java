package com.capgemini.main.Dao;


import java.util.List;

import com.capgemini.main.entity.LoanLedger;
import com.capgemini.main.entity.LoanRequest;

public interface LoanDao {
	
	boolean addRequest(LoanRequest Request);
	void addledger(LoanLedger ledger);
	List<LoanLedger> viewLedger(long accountNumber);
	List<LoanLedger> viewAllLedger();
	
}
