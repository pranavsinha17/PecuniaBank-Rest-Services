package com.cg.pecuniabank.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ledger")
public class LoanLedger {
	@Id
	@Column(name="Loan_Id")
	String loanId;
	@Column(name="Account_Number")
	String accountNumber;
	@Column(name="EMI_Amount")
	String EMI_Amount;
	@Column(name="Interest_Rate") //make a list of interest rate of different type of loan
	String interestRate;
	@Column(name="EMI_Terms")
	String numberOfEMI;
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getEMI_Amount() {
		return EMI_Amount;
	}
	public void setEMI_Amount(String eMI_Amount) {
		EMI_Amount = eMI_Amount;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getNumberOfEMI() {
		return numberOfEMI;
	}
	public void setNumberOfEMI(String numberOfEMI) {
		this.numberOfEMI = numberOfEMI;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Column(name="Duration")
	String duration;
	@Column(name="Loan_Status")
	String Status;
	

}
