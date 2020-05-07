package com.capgemini.main.service;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session.LockRequest;

import com.capgemini.main.entity.LoanLedger;
import com.capgemini.main.entity.LoanRequest;
import com.capgemini.main.exception.UserException;


public interface LoanService {
	
	boolean addRequest( LoanRequest request);
	public double calculateEMI(double loanAmount,int tenure,double roi);
	public boolean checkCreditScore(int creditScore);
	public String loanProcess(LoanRequest request)throws UserException;
	public boolean findAccount(String accountNumber)throws UserException;
	public List<LoanLedger> viewAll();
	public List<LoanLedger> ViewLedger(String accountNumber);

}

