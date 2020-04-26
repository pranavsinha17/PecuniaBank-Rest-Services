package com.cg.pecuniabank.passbook.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pecuniabank.passbook.entity.PassbookUpdate;

@Repository
public class PassbookDAOImpl implements PassbookDAO {

	@Autowired
	EntityManager em;

	@Override
	public void passbookUpdateNewEntry(PassbookUpdate passbookUpdate) {
		em.persist(passbookUpdate);
	}

	@Override
	public void passbookUpdateChangeLastUpdate(long accountNumber, LocalDateTime systemDate) {

		Query query = em.createQuery("UPDATE PassbookUpdate SET lastUpdate = :systemDate WHERE accountNumber=:accountNumber");
		query.setParameter("systemDate", systemDate);
		query.setParameter("accountNumber", accountNumber);
		query.executeUpdate();
	}

	@Override
	public PassbookUpdate passbookUpdateDetailsByAccountNumber(long accountNumber) {
		return em.find(PassbookUpdate.class, accountNumber);
	}
}
