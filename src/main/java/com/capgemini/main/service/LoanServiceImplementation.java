package com.capgemini.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.Dao.DaoAccount;
import com.capgemini.main.Dao.LoanDao;
import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.LoanLedger;
import com.capgemini.main.entity.LoanRequest;

@Service
public class LoanServiceImplementation implements LoanService{
	
	@Autowired
	private LoanDao loanDao;

	@Autowired
	DaoAccount daoAccount;
	
	@Override
	public boolean addRequest(LoanRequest request) {
		
		return loanDao.addRequest(request);
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
	public boolean loanProcess(LoanRequest request) {
		// TODO Auto-generated method stub
		loanDao.addRequest(request);
		AccountDetails account=daoAccount.findAccountDetails(request.getAccountNumber());
		if(account!=null)
		{
			int creditScore=account.getCreditScore();
			if(checkCreditScore( creditScore))
			{
				double EMI=calculateEMI(request.getAmount(),request.getTenure(),request.getRoi());
				LoanLedger ledger=new LoanLedger();
		    	ledger.setAccountDetails(account);
				ledger.setEMI_Amount(EMI);
				ledger.setDuration(request.getTenure());
				if(request.getType().equals("Home"))
				ledger.setInterestRate((float) 10.0);
				else if(request.getType().equals("Education"))
				ledger.setInterestRate((float) 6.0);
				else if(request.getType().equals("Car"))
				ledger.setInterestRate((float) 8.0);
				else if(request.getType().equals("Personal"))
				ledger.setInterestRate((float) 12.0);
				ledger.setLoanRequestId(request.getLoanRequestId());
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

	@Override
	public boolean findAccount(long accountNumber) {
		// TODO Auto-generated method stub
		
		return daoAccount.checkAccountExist(accountNumber);
	}

	@Override
	public List<LoanLedger> viewAll() {
		// TODO Auto-generated method stub
		return loanDao.viewAllLedger();
	}

	@Override
	public List<LoanLedger> ViewLedger(long accountNumber) {
		// TODO Auto-generated method stub
		return loanDao.viewLedger(accountNumber);
	}



}
