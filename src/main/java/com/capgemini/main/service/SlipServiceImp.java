package com.capgemini.main.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.Dao.DaoAccount;
import com.capgemini.main.Dao.DaoSlip;
import com.capgemini.main.Dao.DaoTransactio;
import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.SlipDetails;
import com.capgemini.main.entity.Transaction;
import com.capgemini.main.exception.UserException;

@Service
public class SlipServiceImp implements SlipService {
	@Autowired
	DaoSlip daoSlip;
	
	@Autowired
	DaoAccount daoAccount;
	@Autowired
	DaoTransactio daoTransaction;
	
	  String slipType []= {"Debit","Credit"};
	  String transactionOption="Slip";
	  String transactionStatus[]= {"Successful","Pending"};
	  double balance;
	  boolean checkBalance;

	@Override
	public void debitSlip(SlipDetails slip) throws UserException {
		// TODO Auto-generated method stub
		
		daoSlip.setSlipDetails(slip);
		   
		   //Check account exist or not.
		if(daoAccount.checkAccountExist(slip.getAccountNumber()))
		{
			AccountDetails accountDetails=daoAccount.findAccountDetails(slip.getAccountNumber());
			
			//check the balance exits in account or not.
			checkBalance=checkBalance(accountDetails.getAccountBalance(),slip.getAmount()); 
			if(checkBalance)
			{
					System.out.println("Transcation is Succesful");
					daoSlip.updateSlipStatus(slip.getSlipNumber(), transactionStatus[0]);
					daoAccount.updateBalance(slip.getAccountNumber(), balance);
					setTranscationReport( accountDetails,slip, transactionStatus[0],slipType[1]);	
				
				}
				else
				{
					System.out.println("Low Balance Transcation failed");
					setTranscationReport( accountDetails,slip, transactionStatus[0],slipType[1]);
					throw new UserException("Account balance is low kindly add balance in your accound ");
				}
		  }
		else
		{
			System.out.println("Account Not exist");
			throw new UserException("Invalid Account Number Kindly check the Account Number");
		}
		
	}

	@Override
	public void creditSlip(SlipDetails slip) throws UserException {
		// TODO Auto-generated method stub
		
		daoSlip.setSlipDetails(slip);
		   
		   //Check account exist or not.
		if(daoAccount.checkAccountExist(slip.getAccountNumber()))
		{
			AccountDetails accountDetails=daoAccount.findAccountDetails(slip.getAccountNumber());
			
			//check the balance exits in account or not.
			double newBalance;
			newBalance=slip.getAmount()+accountDetails.getAccountBalance();
			
					System.out.println("Transcation is Succesful");
					daoSlip.updateSlipStatus(slip.getSlipNumber(), transactionStatus[0]);
					daoAccount.updateBalance(slip.getAccountNumber(), newBalance);
					setTranscationReport( accountDetails,slip, transactionStatus[0],slipType[1]);	
			
		  }
		else
		{
			System.out.println("Account Not exist");
			throw new UserException("Invalid Account Number Kindly check the Account Number");
		}
		
	}
	
	public void setTranscationReport(AccountDetails accountDetails, SlipDetails slip, String status,String slipType) {
		// TODO Auto-generated method stub
		Transaction transaction=new Transaction();
		transaction.setAccountNumber(accountDetails.getAccountNumber());
		transaction.setBankName(slip.getBankName());
		transaction.setBenificaryAccoountNumber(accountDetails.getAccountNumber());
		transaction.setTransactionDate(LocalDate.now());
		transaction.setBenificaryName(slip.getHolderName());
		transaction.setTransactionOption(transactionOption);
		transaction.setTransactionType(slipType);
		transaction.setTransactionAmount(slip.getAmount());
		transaction.setTransactionStatus(status);
		transaction.setTransactionTime(LocalTime.now());
		daoTransaction.setTranscationDetails(transaction);
		
	}
	
	public boolean checkBalance(double balance1, double balance2) {
		// TODO Auto-generated method stub
		
		if(balance1>=balance2)
		{
			balance=balance1-balance2; //get balance by subtracting the account balance and the cheque balance.
			return true;
		}
			
		
		return false;
	}

	

}
