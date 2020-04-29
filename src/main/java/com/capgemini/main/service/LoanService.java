package com.capgemini.main.service;

import java.util.List;


import com.capgemini.main.entity.LoanLedger;
import com.capgemini.main.entity.LoanRequest;

public interface LoanService {
	
	boolean addRequest(LoanRequest request);
	public double calculateEMI(double loanAmount,int tenure,double roi);
	public boolean checkCreditScore(int creditScore);
	public boolean loanProcess(LoanRequest request);
	public boolean findAccount(long accountNumber);
	public List<LoanLedger> viewAll();
	public List<LoanLedger> ViewLedger(long accountNumber);

}
