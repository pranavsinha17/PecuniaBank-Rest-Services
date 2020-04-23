package com.capgemini.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.LoanDao;
import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Request;

@Service
public class LoanServiceImplementation implements LoanService{
	
	@Autowired
	private LoanDao centerDao;

	@Override
	public boolean addRequest(Request request) {
		
		return centerDao.addRequest(request);
	}
	
	@Override
	public boolean addAccount(Account account) {
		
		return centerDao.addAccount(account);
	}

	@Override
	public boolean removeCenter(long id) {
		
		return centerDao.removeCenter(id);
	}

	@Override
	public List<Request> getAllCenter() {
		
		return centerDao.getAllCenter();
	}
	@Override
	public double calculateEmi(double amount2,int tenure2, double loanRoi2)
	{
		 loanRoi2=loanRoi2/(12*100); 
		 
	        tenure2=tenure2*12; 
	            
	        double emi= (amount2*loanRoi2*Math.pow(1+loanRoi2,tenure2))/(Math.pow(1+loanRoi2,tenure2)-1);
	      
	        return emi;
		
	}
	@Override
	public boolean checkCreditScore(int creditScore)
	{
		
		if(creditScore>700 && creditScore<900)
		{
			return true;
		}
		
			
		return false;
		
	}
	

}
