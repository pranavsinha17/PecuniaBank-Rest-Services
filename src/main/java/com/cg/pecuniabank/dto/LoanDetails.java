package com.cg.pecuniabank.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Loan")
public class LoanDetails {
	@Id
	@Column(name="Loan_Number")
	String loanNumber;
	@Column(name="Loan_Amount")
	String loanAmount;
	@Column(name="Loan_Type")
	String loanType;
	@Column(name="Account_Number")
	String accountNumber;
	public String getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getNumberOfyears() {
		return numberOfyears;
	}
	public void setNumberOfyears(String numberOfyears) {
		this.numberOfyears = numberOfyears;
	}
	@Column(name="Years")
	String numberOfyears;
	
}
