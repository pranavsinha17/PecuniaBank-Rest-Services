package com.capgemini.main.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.SlipDetails;


@Transactional
@Repository
@Service
public class DaoSlipImp implements  DaoSlip {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void setSlipDetails(SlipDetails slipDetails) {
		// TODO Auto-generated method stub
		
		em.persist(slipDetails);
	}

	@Override
	public void updateSlipStatus(long slipNumber, String checkStatus) {
		// TODO Auto-generated method stub
		SlipDetails slipDetails=em.find(SlipDetails.class, slipNumber);
		slipDetails.setStatus(checkStatus);
		
	}

}
