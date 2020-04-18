package com.cg.pecuniabank.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// @Column(name="EMP_ID", unique = true, nullable = false)
@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@Column(name="Transaction_Id")
	String transactionId;
	@Column(name="Account_Number")
	String  accountNumber;
	@Column(name="Transaction_Option")//slip or cheque
	String transactionOption;
	@Column(name="Transaction_Type")//credit debit
	String transactionType;
	@Column(name="Transaction_Status")
	String transactionStatus;
	@Column(name="Transaction_Amount")
	String transactionAmount;
	@Column(name="Transaction_Date")
	LocalDate transactionDate;
	@Column(name="Benificary_Name")
	String benificaryName;
	@Column(name="Benificary_Accoount_Number")
	String benificaryAccoountNumber;
	@Column(name="Benificary_Bank_Name")
	String bankName;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransactionOption() {
		return transactionOption;
	}
	public void setTransactionOption(String transactionOption) {
		this.transactionOption = transactionOption;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getBenificaryName() {
		return benificaryName;
	}
	public void setBenificaryName(String benificaryName) {
		this.benificaryName = benificaryName;
	}
	public String getBenificaryAccoountNumber() {
		return benificaryAccoountNumber;
	}
	public void setBenificaryAccoountNumber(String benificaryAccoountNumber) {
		this.benificaryAccoountNumber = benificaryAccoountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	

}
