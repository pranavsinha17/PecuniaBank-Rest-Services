package com.capgemini.pecunia.controller;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.Data;
import com.capgemini.pecunia.entity.Data1;
import com.capgemini.pecunia.entity.DepositSlip;
import com.capgemini.pecunia.entity.TransactionDetails;
import com.capgemini.pecunia.entity.TransferSlip;
import com.capgemini.pecunia.entity.withdrawalSlip;
import com.capgemini.pecunia.exception.UserException;
import com.capgemini.pecunia.service.TransactionService;


/****************************
 *          @author          Satyam Sinha
 *          Description      It is a Rest full service class that provides the services for Transaction
  *         Version             1.0
  *         Created Date    18-APR-2020
  *         
 ****************************/

//This crossOrgin helps us to connect with angular application.
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	/****************************
	 * Method:RestFul Service For Deposit Money From Slip
                *Description: To withdrawal money from an account
	 * Slip Details       -Account Number,CurrentDate,Amount ,Holder Name
	 
	 * @throws AccountException - It is raised due to amount range Exception
                *Created By                                - Satyam sinha
                *Created Date                            - 24-APR-2020                           
	 
	 ****************************/
	
	@PostMapping("/DepositUsingSlip")
	public ResponseEntity<String> DepositSlip(@RequestBody DepositSlip slip) throws UserException   {
		System.out.println(slip.toString());
		
		if(!(slip.getAmount()>=100 && slip.getAmount()<=100000))
			throw new UserException("Amount Range In Between 100 to 100000");
				
			
		TransactionDetails transactionDetails = null;
		
				transactionDetails = transactionService.depositMoneyBySlip(slip);
			
		return new ResponseEntity<String>("Transaction Sucessful"+"\n"+"Transaction Id:"+transactionDetails.getTransactionId(),HttpStatus.OK);
	}
	
	/****************************
	 * Method:RestFul Service For Withdrawal Money From Slip
                *Description: To withdrawal money from an account
	 * Slip Details       -Account Number,CurrentDate,Amount ,Holder Name
	 
	 * @throws AccountException - It is raised due to amount range Exception
                *Created By                                - Satyam sinha
                *Created Date                            - 24-APR-2020                           
	 
	 ****************************/
	@PostMapping("/WithdrawingUsingSlip")
	public ResponseEntity<String>  WithdrawalSlip(@RequestBody withdrawalSlip slip) throws UserException   {
		TransactionDetails transactionDetails = null;
		
		if(!(slip.getAmount()>=100 && slip.getAmount()<=100000))
			throw new UserException("Amount Range In Between 100 to 100000");
	
		
				transactionDetails = transactionService.withdrawalMoneyBySlip(slip);
			
		
		return new ResponseEntity<String>("Transaction Sucessful"+"\n"+"Transaction Id:"+transactionDetails.getTransactionId(),HttpStatus.OK);
	}
	
	/****************************
	 * Method:Getting Today's transaction history .
     
                *Created By                                - Satyam sinha
                *Created Date                            - 24-APR-2020                           
	 
	 ****************************/
	@GetMapping("/todayTransaction")
	public ResponseEntity<List<TransactionDetails>>todayTransaction() {
		List<TransactionDetails> transactionList=transactionService.showTransaction();
		return new ResponseEntity<List<TransactionDetails>>(transactionList,HttpStatus.OK);
	}
	
	/****************************
	 * Method:RestFul Service ForWithdrawal money using cheque
                *Description: To withdrawal money from an account
	* Cheque Details       -Account Number,CurrentDate,Amount ,Holder Name,IFSC ,Issue Date
	
	 
	 * @throws AccountException - It is raised due to amount range Exception
                *Created By                                - Satyam sinha
                *Created Date                            - 24-APR-2020                           
	 
	 ****************************/
	@PostMapping("/WithdrawingUsingCheque")
	public ResponseEntity<String>  withdrawalCheque(@RequestBody Cheque cheque) throws UserException  {
		System.out.println(cheque);
		String []data;
		data=cheque.getIssuedate().split("-");
		int year = Integer.parseInt( data[0] );
		int month = Integer.parseInt( data[1] );  
		int day = Integer.parseInt( data[2] );
		LocalDate issueDate = LocalDate.of(year,month,day);
		cheque.setIssueDate(issueDate);
		Period p=Period.between(issueDate, LocalDate.now());
		if(!(cheque.getAmount()>=100 && cheque.getAmount()<=200000))
			throw new UserException("Amount Range In Between 100 to 100000");
		else if(!(p.getMonths()<3 && p.getMonths()>=0))
			throw new UserException("Cheque Expired Within Three Month");
		TransactionDetails transactionDetails = null;
	
			transactionDetails = transactionService.withdrawalMoneyUsingCheque(cheque);
		
		return new ResponseEntity<String>("Transaction Sucessful"+"\n"+"Transaction Id:"+transactionDetails.getTransactionId(),HttpStatus.OK);
	}
	
	
	/****************************
	 * Method:Transfer money from one account to another using cheque and transfer slip(carry benificary details)
                *Description: To withdrawal money from an account
	* Cheque Details       -Account Number,CurrentDate,Amount ,Holder Name,IFSC ,Issue Date
	 * * Slip Details       -Account Number,CurrentDate,Amount ,Holder Name
	 * @throws AccountException - It is raised due to amount range Exception
                *Created By                                - Satyam sinha
                *Created Date                            - 24-APR-2020                           
	 
	 ****************************/
	@PostMapping("/TransferMoneyUsingCheque")
	public ResponseEntity<String>  transferCheque(@RequestBody Data1 data1) throws UserException  {
		String []data;
		data=data1.getCheque().getIssuedate().split("-");
		int year = Integer.parseInt( data[0] );
		int month = Integer.parseInt( data[1] );  
		int day = Integer.parseInt( data[2] );
		LocalDate issueDate = LocalDate.of(year,month,day);
		data1.getCheque().setIssueDate(issueDate);
		
		Period p=Period.between(issueDate, LocalDate.now());
		if(!(data1.getCheque().getAmount()>=100 &&data1.getCheque().getAmount()<=200000))
			throw new UserException("Amount Range In Between 100 to 100000");
		else if(!(p.getMonths()<3 && p.getMonths()>=0))
			throw new UserException("Cheque Expired Within Three Month");
		TransactionDetails transactionDetails = null;
		
			transactionDetails = transactionService.transferMoneyUsingCheque(data1.getCheque(), data1.getTransferSlip());
			return new ResponseEntity<String>("Transaction Sucessful"+"\n"+"Transaction Id:"+transactionDetails.getTransactionId(),HttpStatus.OK);
		
	
	}
	
	/****************************
	 * Method:deposit cheque restful service
                *Description: To withdrawal money from an account
	* Cheque Details       -Account Number,CurrentDate,Amount ,Holder Name,IFSC ,Issue Date
	 * * Slip Details       -Account Number,CurrentDate,Amount ,Holder Name
	 * @throws AccountException - It is raised due to amount range Exception
                *Created By                                - Satyam sinha
                *Created Date                            - 24-APR-2020                           
	 
	 ****************************/
	@PostMapping("/DepositMoneyUsingChequee")
	public ResponseEntity<String>  depositCheque(@RequestBody Data data2) throws UserException {
		String []data;
		//if(data2.getDepositSlip().getAmount()==data2.getCheque().getAmount())
		//System.out.println(data2.getCheque().getAmount()+""+data2.getDepositSlip().getAmount());
		data=data2.getCheque().getIssuedate().split("-");
		int year = Integer.parseInt( data[0] );
		int month = Integer.parseInt( data[1] );  
		int day = Integer.parseInt( data[2] );
		LocalDate issueDate = LocalDate.of(year,month,day);
		data2.getCheque().setIssueDate(issueDate);
		TransactionDetails transactionDetails = null;
		Period p=Period.between(issueDate, LocalDate.now());
		if(!(data2.getCheque().getAmount()>=100 &&data2.getCheque().getAmount()<=200000))
			throw new UserException("Amount Range In Between 100 to 100000");
		else if(!(p.getMonths()<3 && p.getMonths()>=0))
			throw new UserException("Cheque Expired Within Three Month");
		//else if(data2.getDepositSlip().getAmount()==data2.getCheque().getAmount())
			//
			transactionDetails = transactionService.depositChequeInAccount(data2.getCheque(), data2.getDepositSlip());
			
		
		return new ResponseEntity<String>("Transaction Sucessful"+"\n"+"Transaction Id:"+transactionDetails.getTransactionId(),HttpStatus.OK);
		
	}
	
	
}
