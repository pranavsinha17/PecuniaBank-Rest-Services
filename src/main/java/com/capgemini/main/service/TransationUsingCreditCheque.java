package com.capgemini.main.service;

import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.ChequeDetails;
import com.capgemini.main.exception.UserException;

public interface TransationUsingCreditCheque {
	public String  creditCheque(ChequeDetails chequeDetails) throws UserException;
	public void setDebitTranscationReport(AccountDetails accountDetails,ChequeDetails chequeDetails,String status);
	public void setCreditTranscationReport(AccountDetails accountDetails,ChequeDetails chequeDetails,String status);
	public String  UpdateBalance(long accountNumber,double balance);
	public boolean checkBalance(double balance1,double balance2);
	public void addBalance(double balance1,double balance2);
	public boolean checkAccountExist(long accountNumber);

}
