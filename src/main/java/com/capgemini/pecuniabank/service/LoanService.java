package com.capgemini.pecuniabank.service;

	import java.util.logging.Logger;
	import java.util.regex.Pattern;

	public class LoanService {
		
		
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
			
			
		 }
		 public static boolean validateLoanNumber(String loanNum) {
			 if(loanNum.length()==6 && stringContainsNumber(loanNum))
				 return true;
			 
			 return false;
				
				
				
			    
		 }
			 


}
