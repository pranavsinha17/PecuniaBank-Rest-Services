package com.capgemini.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.LoanDao;
import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Ledger;
import com.capgemini.app.entity.Request;
import com.capgemini.app.exception.UserException;

@Service
public class LoanServiceImplementation implements LoanService{
	
	@Autowired
	private LoanDao loanDao;

	@Override
	public boolean addRequest(Request request) {
		
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
	public boolean loanProcess(Request request) throws UserException{
		// TODO Auto-generated method stub
		Account account=loanDao.existAccount(request.getAccountNumber());
		if(account!=null)
		{
			int creditScore=account.getCreditScore();
			if(checkCreditScore( creditScore))
			{
				double EMI=calculateEMI(request.getAmount(),request.getTenure(),request.getRoi());
				Ledger ledger=new Ledger();
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
				ledger.setStartDate(LocalDate.now());
				ledger.setEndDate(LocalDate.now().plusYears(request.getTenure()));
				ledger.setStatus("Grant");
				
				
				loanDao.addledger(ledger);
				System.out.println("Your Loan Request has been approved for more details view Loan Ledger");
			}
			else
			{
			System.out.println("You can't get loan due to your previous track record");
			throw new UserException("Your credit score is not good to grant your Loan Request");
			}
			
			
		}
		else
		{
			System.out.println("Your account is not exists in our account firstly open account and then apply");
			throw new UserException("Your Account does not Exist. To take loan first you have to open account in our bank. For that go to Account management branch.");
		}
		return false;
	}

	@Override
	public boolean findAccount(String accountNumber) throws UserException {
		// TODO Auto-generated method stub
	
		boolean Exists=loanDao.findAccount(accountNumber);
		if(Exists)
		{
			return true;
		}
		else
		{
			throw new UserException("Your Account does not Exist. To take loan first you have to open account in our bank. For that go to Account management branch.");
		}
		
}
	

	@Override
	public List<Ledger> viewAll() {
		// TODO Auto-generated method stub
		return loanDao.viewAllLedger();
	}

	@Override
	public List<Ledger> ViewLedger(String accountNumber) {
		// TODO Auto-generated method stub
		return loanDao.viewLedger(accountNumber);
	}



}
