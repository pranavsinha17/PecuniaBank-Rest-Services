package com.cg.pecuniabank.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Slip")
public class SlipDetails {
	
	//we have to deposit the money from account or (only provide benificary Account number whom you want to deposit).
	//we have to withdrawal money from account we use slip.(only payee Account Number to get money from bank).

	@Id
	@Column(name="Slip_Number")
	String slipNumber;        // Slip number by default written in the slip.
	@Column(name="Account_Number")
	String AccountNumber;
	public String getSlipNumber() {
		return slipNumber;
	}
	public void setSlipNumber(String slipNumber) {
		this.slipNumber = slipNumber;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
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
	public String getHolderName() {
		return HolderName;
	}
	public void setHolderName(String holderName) {
		HolderName = holderName;
	}
	public LocalDate getSlipDate() {
		return slipDate;
	}
	public void setSlipDate(LocalDate slipDate) {
		this.slipDate = slipDate;
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
	String amount;             //amount that you want to pay.
	@Column(name="Type")
	String transactionType;  //Debit or credit
	@Column(name="Holder_Name")
	String HolderName;                
	LocalDate slipDate;   //current date 
	@Column(name="Bank_Name")//by default pecunia
	String bankName;
	@Column(name="IFSC")
	String IFSC;
	
	
	
}
