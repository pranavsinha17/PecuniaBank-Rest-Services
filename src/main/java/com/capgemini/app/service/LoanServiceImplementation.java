package com.capgemini.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.LoanDao;
import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Ledger;
import com.capgemini.app.entity.Request;

@Service
public class LoanServiceImplementation implements LoanService{
	
	@Autowired
	private LoanDao loanDao;

	@Override
	public boolean addRequest(Request request) {
		
		return loanDao.addRequest(request);
	}
	
	@Override
	public boolean addAccount(Account account) {
		
		return loanDao.addAccount(account);
	}

	@Override
	public double calculateEMI(double loanAmount, int tenure, double roi) {
	
		// TODO Auto-generated method stub
		double EMI;
		roi=roi/(12*100);
		tenure=tenure*12;
		EMI=(loanAmount*roi*Math.pow((1+roi), tenure))/(Math.pow((1+roi),tenure)-1);
		return EMI;
		
	}

	@Override
	public boolean checkCreditScore(int creditScore) {
		// TODO Auto-generated method stub
		if(creditScore>=700&&creditScore<=900)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean loanProcess(Request request) {
		// TODO Auto-generated method stub
		Account account=loanDao.existAccount(request.getAccountNumber().getAccountNumber());
		if(account!=null)
		{
			int creditScore=account.getCreditScore();
			if(checkCreditScore( creditScore))
			{
				double EMI=calculateEMI(request.getAmount(),request.getTenure(),request.getRoi());
				Ledger ledger=new Ledger();
				ledger.setAccountNumber(account.getAccountNumber());
				ledger.setEMI_Amount(EMI);
				ledger.setDuration(request.getTenure());
				ledger.setInterestRate(request.getRoi());
				ledger.setLoanRequestId(request);
				ledger.setNumberOfEMI((int) (request.getTenure()*12));
				ledger.setStatus("Grant");
				
				loanDao.addledger(ledger);
				System.out.println("Loan approved your ledger report");
			}
			else
			{
			System.out.println("You can't get loan due to your previous track record");
			}
			
			
		}
		else
		{
			System.out.println("Your account is not exists in our account firstly open account and then apply");
		}
		
		return false;
	}



}
