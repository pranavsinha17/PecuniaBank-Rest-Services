package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Ledger;
import com.capgemini.app.entity.Request;
import com.capgemini.app.exception.UserException;

public interface LoanService {
	
	boolean addRequest(Request request);
	public double calculateEMI(double loanAmount,int tenure,double roi);
	public boolean checkCreditScore(int creditScore);
	public String loanProcess(Request request)throws UserException;
	public boolean findAccount(String accountNumber)throws UserException;
	public List<Ledger> viewAll();
	public List<Ledger> ViewLedger(String accountNumber);

}
