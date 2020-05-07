package com.capgemini.pecuniabank.service;

import java.util.List;

import com.capgemini.pecuniabank.entity.Account;
import com.capgemini.pecuniabank.entity.Ledger;
import com.capgemini.pecuniabank.entity.Request;
import com.capgemini.pecuniabank.exception.UserException;

public interface LoanService {
	
	boolean addRequest(Request request);
	public double calculateEMI(double loanAmount,int tenure,double roi);
	public boolean checkCreditScore(int creditScore);
	public String loanProcess(Request request)throws UserException;
	public boolean findAccount(String accountNumber)throws UserException;
	public List<Ledger> viewAll();
	public List<Ledger> ViewLedger(String accountNumber);

}
