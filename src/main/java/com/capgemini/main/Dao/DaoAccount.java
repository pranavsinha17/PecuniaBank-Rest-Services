package com.capgemini.main.Dao;

import com.capgemini.main.entity.AccountDetails;

public interface DaoAccount {
	public String updateBalance(long accountNumber,double balance);
	public boolean checkAccountExist(long accountNumber);
	public AccountDetails findAccountDetails(long accountNumber);
}
