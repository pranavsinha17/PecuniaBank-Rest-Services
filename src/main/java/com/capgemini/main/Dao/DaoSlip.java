package com.capgemini.main.Dao;


import com.capgemini.main.entity.SlipDetails;

public interface DaoSlip {
	public void setSlipDetails(SlipDetails slipDetails);
	public void updateSlipStatus(long slipNumber,String checkStatus );
}
