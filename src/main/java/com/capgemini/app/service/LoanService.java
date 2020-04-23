package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Request;

public interface LoanService {
	
	boolean addRequest(Request request);
	boolean addAccount(Account account);

	
	boolean removeCenter(long id);
	
	List<Request> getAllCenter();
	double calculateEmi(double amount2, int tenure2, double loanRoi2);
	boolean checkCreditScore(int creditScore);
	

}
