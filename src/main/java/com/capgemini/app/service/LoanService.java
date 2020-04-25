package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Ledger;
import com.capgemini.app.entity.Request;

public interface LoanService {
	
	boolean addRequest(Request request);
	boolean  addAccount(Account account);
	public double calculateEMI(double loanAmount,int tenure,double roi);
	public boolean checkCreditScore(int creditScore);
	public boolean loanProcess(Request request);
	public boolean findAccount(String accountNumber);
	public List<Ledger> viewAll();
	public List<Ledger> ViewLedger(String accountNumber);

}
