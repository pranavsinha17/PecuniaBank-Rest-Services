package com.cg.pecuniabank.passbook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.pecuniabank.passbook.dao.PassbookDAOImpl;
import com.cg.pecuniabank.passbook.entity.PassbookUpdate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassbookDAOImplTest {

	@Autowired
	PassbookDAOImpl passbookDAOImpl;

	LocalDateTime lastUpdate;

	private static boolean flag = true;

	@Before
	public void setup() {
		lastUpdate = LocalDateTime.of(LocalDate.of(2019, 03, 01), LocalTime.of(11, 25, 30));
		if (flag) {
			createPassbookUpdateDetails(123456789123L, lastUpdate);
			createPassbookUpdateDetails(223456789901L, lastUpdate);
			flag = false;
		}
	}

	@Test
	public void passbookUpdateDetailsByAccountNumberTest() {
		// given
		Long accountNumber = 123456789123L;
		// when
		PassbookUpdate passbookUpdate = passbookDAOImpl.passbookUpdateDetailsByAccountNumber(accountNumber);
		// then
		assertEquals(accountNumber, passbookUpdate.getAccountNumber());
		assertEquals(lastUpdate, passbookUpdate.getLastUpdate());
	}

	@Test
	public void passbookUpdateChangeLastUpdateTest() {
		Long accountNumber = 223456789901L;
		LocalDateTime systemDate = LocalDateTime.now();
		passbookDAOImpl.passbookUpdateChangeLastUpdate(accountNumber, systemDate);
		PassbookUpdate passbookUpdate = passbookDAOImpl.passbookUpdateDetailsByAccountNumber(accountNumber);

		assertEquals(accountNumber, passbookUpdate.getAccountNumber());
		assertEquals(systemDate, passbookUpdate.getLastUpdate());
	}

	private void createPassbookUpdateDetails(Long accountNumber, LocalDateTime lastUpdate) {
		PassbookUpdate passbookUpdate = new PassbookUpdate();
		passbookUpdate.setAccountNumber(accountNumber);
		passbookUpdate.setLastUpdate(lastUpdate);
		passbookDAOImpl.passbookUpdateNewEntry(passbookUpdate);
	}

	
}