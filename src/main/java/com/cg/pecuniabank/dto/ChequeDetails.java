package com.cg.pecuniabank.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cheque")
public class ChequeDetails {
	//cheque is given to the employee.
	

	@Id
	@Column(name="Cheque_Number")//mention in cheque
	String chequeNumber;   //written in cheque at bottom.  
	@Column(name="Issue_Date")
    LocalDate issueDate;  //date when cheque is generate by the cheque owner.
	@Column(name="Account_Holder_Number")//mention in cheque
	String payeeAccountNumber;   
	@Column(name="account_Number")
	String accountNumber;    
	@Column(name="Amount")
	String amount;             
	@Column(name="Type")
	String transactionType;  
	@Column(name="Pay_Name") 
	String payName;
	@Column(name="Bank_Name")
	String bankName;
	@Column(name="IFSC")
	String IFSC;
	         

}
