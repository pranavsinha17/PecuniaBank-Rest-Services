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
	@Column(name="Duration")
	String duration;
	@Column(name="Loan_Status")
	String Status;
	

}
