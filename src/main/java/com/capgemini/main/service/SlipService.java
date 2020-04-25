package com.capgemini.main.service;

import com.capgemini.main.entity.SlipDetails;
import com.capgemini.main.exception.UserException;

public interface SlipService {
	public void debitSlip(SlipDetails slip)throws UserException  ;
	public void creditSlip(SlipDetails slip)throws UserException ;
	

}
