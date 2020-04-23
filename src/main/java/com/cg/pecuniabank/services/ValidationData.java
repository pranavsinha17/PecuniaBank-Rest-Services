package com.cg.pecuniabank.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ValidationData {
	
	
	 static Logger logger;
     
	 // check the number is numberic or not
	 public static boolean  stringContainsNumber(String accountID) 
	 {
		 return Pattern.compile("[0-9]").matcher(accountID).find();
	 }
	 
	 
	
	 
	
	 public static boolean ChequeAccountNumber(String accountID) {
		 if(accountID.length()==12 && stringContainsNumber(accountID) )
			 return true;
		 
		 return false;
		
			/* logger.info ("AccountId should contain numeric value and length=12 ");
			 throw new UserDefineException("Invalid accountId");*/
		 
	 }
	 public static boolean ChequeAmount(double amount) {
		 if(amount>=100.00&&amount<=200000.00)
			 return true;
		 
		 return false;
		/*
			 logger.info ("amount in between 100 to 2 lakhs ");
				throw new UserDefineException(exceptionclass+"Invalid cheque amount");*/
		
	 }
	 public static boolean validateChequeNumber(String chequeNum) {
		 if(chequeNum.length()==6 && stringContainsNumber(chequeNum))
			 return true;
		 
		 return false;
			
			/*	 logger.info ("cheque number should be integer and length=6 ");
				throw new UserDefineException(exceptionclass+"Invalid cheque Number");*/
			
		    
	 }
		  public static boolean ValidateIssueDate(LocalDate IssueDate) {
			  LocalDate transcationDate=LocalDate.now();
			Period period =  Period.between(IssueDate,transcationDate);
				if(period.getMonths()<3)
					return true;
				
				return false;
				
				/*	 logger.info ("wthin in 3 month ");
					throw new UserDefineException(exceptionclass+"Invalid cheque date");
				*/
		  }
				 
				public static boolean ChequeIFSC(String chequeIFSC ) {
				if( chequeIFSC.length()==10)
					return true;
				
				return false;
				
				/*	 logger.info ("IFSC code is alpha numeric length=10 ");
					throw new UserDefineException(exceptionclass+"Invalid IFSC code");*/
					
				
				}


}
