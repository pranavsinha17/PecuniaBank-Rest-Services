package com.cg.pecuniabank.passbook.dao;

import java.time.LocalDateTime;

import com.cg.pecuniabank.passbook.entity.PassbookUpdate;

public interface PassbookDAO {

	void passbookUpdateChangeLastUpdate(long accountNumber, LocalDateTime lastUpdatedDate);
	PassbookUpdate passbookUpdateDetailsByAccountNumber(long accountNumber);
	void passbookUpdateNewEntry(PassbookUpdate passbookUpdate);
	
}
