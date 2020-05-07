package com.capgemini.main.service;

import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.ChequeDetails;
import com.capgemini.main.entity.Transaction;
import com.capgemini.main.exception.UserDefineException;
import com.capgemini.main.exception.UserException;

public interface TranscationUsingDebitCheque {
	//Implement each function is Different classes so it easily replace with other code. 
	public String  debitCheque(ChequeDetails chequeDetails) throws UserException;
	public void setTranscationReport(AccountDetails accountDetails,ChequeDetails chequeDetails,String status);
	public String  UpdateBalance(long accountNumber,double balance);
	public boolean checkBalance(double balance1,double balance2);
}
