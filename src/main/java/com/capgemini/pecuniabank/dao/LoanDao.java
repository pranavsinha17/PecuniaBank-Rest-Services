package com.capgemini.pecuniabank.dao;

public interface LoanDao {

	public void setLoanDetails();
	public void getLoanDetails();
	public void setLoanStatus();
	public void getCreditScore();
	public boolean checkAccountExist();
}
