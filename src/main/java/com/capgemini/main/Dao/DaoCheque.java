package com.capgemini.main.Dao;


import com.capgemini.main.entity.ChequeDetails;

public interface DaoCheque {
	public void setChequeDetails(ChequeDetails chequeDetails);
	public void updateChequeStatus(long chequeNumber,String checkStatus );
	
	
}
