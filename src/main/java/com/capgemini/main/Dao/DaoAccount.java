package com.capgemini.main.Dao;

import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.BranchDetails;

public interface DaoAccount {
	public String updateBalance(long accountNumber,double balance);
	public boolean checkAccountExist(long accountNumber);
	public AccountDetails findAccountDetails(long accountNumber);
	public BranchDetails findBranch(int branchid);
}
