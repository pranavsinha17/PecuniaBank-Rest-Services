package com.capgemini.main.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.Dao.DaoAccount;
import com.capgemini.main.Dao.DaoCheque;
import com.capgemini.main.Dao.DaoTransactio;
import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.ChequeDetails;
import com.capgemini.main.entity.Transaction;
import com.capgemini.main.exception.UserException;


@Service
public class TranscationDebitServices implements TranscationUsingDebitCheque{
	
	@Autowired
	DaoCheque daoCheque;
	@Autowired
	DaoAccount daoAccount;
	@Autowired
	DaoTransactio daoTransaction;

	String checkStatus[]= {"Bounced","Passed","Pending","Expired"};
    String transactionOption="Cheque";
    String transactionType []= {"Debit","Credit"};
    boolean checkBalance;
    double balance;
    String transactionStatus[]= {"Successful","Pending"};
	
    /*
     * Function that perform cheque using debating money from the account.
     * Find if account of cheque owner is exits in bank or not
     * cheque cheque issue date that cheque is valid or not
     * check the balance if that much amount exist in owner account or not
     * update the cheque status
     * make a transaction statement 
     * update the account balance
     */

	@Override
	public String debitCheque(ChequeDetails chequeDetails) throws UserException  {
		// TODO Auto-generated method stub
		   daoCheque.setChequeDetails(chequeDetails);
		   
		   //Check account exist or not.
		if(daoAccount.checkAccountExist(chequeDetails.getAccountNumber()))
		{
			Period period =  Period.between(chequeDetails.getIssueDate(),LocalDate.now());
			
			//Check cheque Issue Date within 90 day or above.
			if(period.getDays()<=90)
			{
			AccountDetails accountDetails=daoAccount.findAccountDetails(chequeDetails.getAccountNumber());
			
			//check the balance exits in account or not.
			checkBalance=checkBalance(accountDetails.getAccountBalance(),chequeDetails.getAmount()); 
			
			if(checkBalance)
			{
				if(chequeDetails.getBankName().equals("PECUNIA"))
				{

					System.out.println("Transcation is Succesful");
					daoCheque.updateChequeStatus(chequeDetails.getChequeNumber(),checkStatus[1]);
					UpdateBalance(chequeDetails.getAccountNumber(), balance);
					 setTranscationReport( accountDetails,chequeDetails, transactionStatus[0]);	
				}
				else
				{
					//We are not connected with server of there banks to validate the information that why we set status pending.
					System.out.println("Transcation is pending for conformation of other bank but the balance is dedicated ");
					daoCheque.updateChequeStatus(chequeDetails.getChequeNumber(),checkStatus[2]);
					UpdateBalance(chequeDetails.getAccountNumber(), balance);
					setTranscationReport( accountDetails,chequeDetails, transactionStatus[1]);	
				}
				
			}
			else
			{
				System.out.println("Low Balance Transcation failed");
				daoCheque.updateChequeStatus(chequeDetails.getChequeNumber(),checkStatus[0]);
				throw new UserException("Account balance is low kindly add balance in your accound this cheque is bounced");
			}
			
		    }
			else
			{
				System.out.println("Cheque expired");
				
				daoCheque.updateChequeStatus(chequeDetails.getChequeNumber(),checkStatus[2]);
				throw new UserException("Cheque is Expired the Time period of cheque is issue date + 90 days");
			}
		  }
		else
		{
			System.out.println("Account Not exist");
			throw new UserException("Invalid Account Number Kindly check the Account Number");
		}
		
		
		return null;
	}

	

	



	

	@Override
	public void  setTranscationReport(AccountDetails accountDetails,ChequeDetails chequeDetails,String status) {
		// TODO Auto-generated method stub
		
		Transaction transaction=new Transaction();
		transaction.setAccountNumber(accountDetails.getAccountNumber());
		transaction.setBankName(chequeDetails.getBankName());
		transaction.setBenificaryAccoountNumber(chequeDetails.getBenificaryAccountNumber());//Debating money from the account .
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setBenificaryName(chequeDetails.getPayName());
		transaction.setTransactionOption(transactionOption);
		transaction.setTransactionType(transactionType[0]);
		transaction.setTransactionAmount(chequeDetails.getAmount());
		transaction.setTransactionStatus(status);
		daoTransaction.setTranscationDetails(transaction);
	}


	

	/*
	 * check the balance exits or not and dedicated the balance store in balance variable.
	 */

	@Override
	public boolean checkBalance(double balance1, double balance2) {
		// TODO Auto-generated method stub
		
		if(balance1>=balance2)
		{
			balance=balance1-balance2; //get balance by subtracting the account balance and the cheque balance.
			return true;
		}
			
		
		return false;
	}



/*
 * update the balance after at the processing time of transaction.
 */
	@Override
	public String UpdateBalance(long accountNumber, double balance) {
		// TODO Auto-generated method stub
		daoAccount.updateBalance(accountNumber, balance);
		return null;
	}


}
