package com.capgemini.main.Dao;

import com.capgemini.main.entity.Transaction;

public interface DaoTransactio {
	public Transaction getTranscationDetails(long transactionId);
	public void setTranscationDetails(Transaction transactionDetails);
}
