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
	public String getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public String getPayeeAccountNumber() {
		return payeeAccountNumber;
	}
	public void setPayeeAccountNumber(String payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getPayName() {
		return payName;
	}
	public void setPayName(String payName) {
		this.payName = payName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
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
