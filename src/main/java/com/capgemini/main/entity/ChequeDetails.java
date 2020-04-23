package com.capgemini.main.entity;

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
	private long chequeNumber;   //written in cheque at bottom.  
	@Column(name="Issue_Date")
    LocalDate issueDate;  //date when cheque is generate by the cheque owner.
	@Column(name="Account_Holder_Number")//mention in cheque
	private long payeeAccountNumber;   
	@Column(name="account_Number")
	private long accountNumber;    
	@Column(name="Amount")
	private double amount;             
	@Column(name="Type")
	private String transactionType;  
	@Column(name="Pay_Name") 
	private String payName;
	@Column(name="Bank_Name")
	private String bankName;
	@Column(name="IFSC")
	private String IFSC;
	@Column(name="status")
	private String checkStatus;
	

	@Override
	public String toString() {
		return "ChequeDetails [chequeNumber=" + chequeNumber + ", issueDate=" + issueDate + ", payeeAccountNumber="
				+ payeeAccountNumber + ", accountNumber=" + accountNumber + ", amount=" + amount + ", transactionType="
				+ transactionType + ", payName=" + payName + ", bankName=" + bankName + ", IFSC=" + IFSC + "]";
	}
	
	public ChequeDetails() {
		super();
	}
	
	public ChequeDetails(long chequeNumber, LocalDate issueDate, long payeeAccountNumber, long accountNumber,
			double amount, String transactionType, String payName, String bankName, String iFSC,String checkStatus) {
		super();
		this.chequeNumber = chequeNumber;
		this.issueDate = issueDate;
		this.payeeAccountNumber = payeeAccountNumber;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.transactionType = transactionType;
		this.payName = payName;
		this.bankName = bankName;
		IFSC = iFSC;
		this.checkStatus=checkStatus;
	}
	/**
	 * @return the chequeNumber
	 */
	public long getChequeNumber() {
		return chequeNumber;
	}
	/**
	 * @param chequeNumber the chequeNumber to set
	 */
	public void setChequeNumber(long chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	/**
	 * @return the issueDate
	 */
	public LocalDate getIssueDate() {
		return issueDate;
	}
	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * @return the payeeAccountNumber
	 */
	public long getPayeeAccountNumber() {
		return payeeAccountNumber;
	}
	/**
	 * @param payeeAccountNumber the payeeAccountNumber to set
	 */
	public void setPayeeAccountNumber(long payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}
	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the payName
	 */
	public String getPayName() {
		return payName;
	}
	/**
	 * @param payName the payName to set
	 */
	public void setPayName(String payName) {
		this.payName = payName;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the iFSC
	 */
	public String getIFSC() {
		return IFSC;
	}
	/**
	 * @param iFSC the iFSC to set
	 */
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	/**
	 * @return the checkStatus
	 */
	public String getCheckStatus() {
		return checkStatus;
	}

	/**
	 * @param checkStatus the checkStatus to set
	 */
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	

}
