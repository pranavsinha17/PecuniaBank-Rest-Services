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

/********************************************************************************
 * @author       Amardeep Singh
 * Description   This is a service class performing services such as adding request,calculating emi, check credit score
                 , loan process, find account , view ledger by account number and view all ledger data

 *Created On
 
 ********************************************************************************/


@Service
public class LoanServiceImplementation implements LoanService{
	
	@Autowired
	private LoanDao loanDao;

	/********************************************************************************
	* Method           addRequest
	* Description      for adding the details of loan request in request according to loan schemes
	                   
	* returns boolean  returns true if all the details are added successfully else 
	*                  returns false
	* Created By       Amardeep Singh
	* Created on
	**********************************************************************************/
	
	@Override
	public boolean addRequest(Request request) {
		
		return loanDao.addRequest(request);
	}
	

	/********************************************************************************
	* Method           calculateEMI
	* Description      for calculating the emi by applying business logic
	                   
	* returns double  returns emi  
	*                  
	* Created By       Amardeep Singh
	* Created on
	**********************************************************************************/

	@Override
	public double calculateEMI(double loanAmount, int tenure, double roi) {
	
		// TODO Auto-generated method stub
		double EMI;
		roi=roi/(12*100);
		tenure=tenure*12;
		EMI=(loanAmount*roi*Math.pow((1+roi), tenure))/(Math.pow((1+roi),tenure)-1);
		return EMI;
		
	}

	/********************************************************************************
	* Method           checkCreditScore
	* Description      to check credit score according to business logic
	                   
	* returns boolean  returns true if credit score is valid else returns false
	                 
	* Created By       Amardeep Singh
	* Created on
	**********************************************************************************/
	
	@Override
	public boolean checkCreditScore(int creditScore) {
		// TODO Auto-generated method stub
		if(creditScore>=700&&creditScore<=900)
		{
			return true;
		}
		return false;
	}

	
	/********************************************************************************
	* Method           loanProcess
	* Description      to process loan request and set data into ledger if it is approved
	                   
	* returns string  returns message if loan is granted otherwise  returns error message
	                 
	* Created By       Amardeep Singh
	* Created on
	**********************************************************************************/
	
	
	@Override
	public String loanProcess(Request request) throws UserException{
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
				ledger.setEmiAmount(EMI);
				ledger.setDuration(request.getTenure());
				ledger.setInterestRate(request.getRoi());
				ledger.setLoanRequestId(request.getLoanRequestId());
				ledger.setNumberOfEMI((int) (request.getTenure()*12));
				ledger.setStartDate(LocalDate.now());
				ledger.setEndDate(LocalDate.now().plusYears(request.getTenure()));
				ledger.setStatus("Grant");
				
				
				loanDao.addledger(ledger);
				return "Your Loan Request has been approved for more details view Loan Ledger";
			}
			else
			{
			throw new UserException("Your loan request has been rejected because your credit score is not good to grant your Loan Request");
			}
			
			
		}
		else
		{
			throw new UserException("Your Account does not Exist. To take loan first you have to open account in our bank. For that go to Account management branch.");
		}
	}

	
	/********************************************************************************
	* Method           findAccount
	* Description      to check if account is exist or not
	                   
	* returns boolean  returns true if account is exist otherwise  returns false
	                 
	* Created By       Amardeep Singh
	* Created on
	**********************************************************************************/
	 
	
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
	

	/********************************************************************************
	* Method           viewAll
	* Description      to get the all data of ledger 
	                   
	* returns list     return list of all ledger data
	                 
	* Created By       Amardeep Singh
	* Created on
	**********************************************************************************/
	
	@Override
	public List<Ledger> viewAll() {
		// TODO Auto-generated method stub
		return loanDao.viewAllLedger();
	}

	/********************************************************************************
	* Method           ViewLedger
	* Description      to get the all data of ledger search by account number 
	                   
	* returns list     return list of all ledger data according to account number
	                 
	* Created By       Amardeep Singh
	* Created on
	**********************************************************************************/

	@Override
	public List<Ledger> ViewLedger(String accountNumber) {
		// TODO Auto-generated method stub
		return loanDao.viewLedger(accountNumber);
	}



}
