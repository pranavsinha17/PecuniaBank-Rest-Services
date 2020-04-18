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
	@Column(name="Years")
	String numberOfyears;
	
}
