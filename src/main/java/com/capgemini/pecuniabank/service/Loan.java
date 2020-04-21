package com.capgemini.pecuniabank.service;

import java.util.List;

import com.capgemini.pecuniabank.entity.LoanRequest;

public interface Loan {

	public void loanApproval();
	public void checkCreditScore();
	public void getLoanLedger();
	public List<LoanRequest>getAllRequests();
}
