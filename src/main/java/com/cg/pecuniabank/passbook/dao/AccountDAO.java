package com.cg.pecuniabank.passbook.dao;

import com.cg.pecuniabank.passbook.entity.AccountDetails;

public interface AccountDAO {
	void insertAccountDetails(AccountDetails accountDetails);
	AccountDetails getAccountDetailsByAccountId(long accountId);
}
