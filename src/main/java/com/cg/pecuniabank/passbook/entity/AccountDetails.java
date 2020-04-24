package com.cg.pecuniabank.passbook.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class AccountDetails {
	
	@Id
	@Column(name ="Account_number") 
	private long accountNumber;

	@OneToOne(cascade=CascadeType.ALL)   
	@JoinColumn(name="Customer_ID")
	private CustomerDetails customerDetails;
	
	@Column(name="Account_Holder_Name")
	private String accountHolderName;
	
	@Column(name="Account_Status")
	private String accountStatus;
	
	@Column(name="Account_Balance")
	private String accountBalance;

	@Column(name="Credit_Score")
	private String creditScore;
	
	@Column(name="Account_Interest")
	private String accountInterest;
	
	@ManyToOne(optional = false)  
	@JoinColumn(name="Branch_Id")
	private BranchDetails branchDetails;
	
	public AccountDetails()
	{
		
	}
	
	public AccountDetails(long accountNumber, CustomerDetails customerDetails, String accountHolderName,
			String accountStatus, String accountBalance, String creditScore, String accountInterest,BranchDetails branchDetails) {
		super();
		this.accountNumber = accountNumber;
		this.customerDetails = customerDetails;
		this.accountHolderName = accountHolderName;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.creditScore = creditScore;
		this.accountInterest = accountInterest;
		this.branchDetails=branchDetails;
	}

	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}

	public String getAccountInterest() {
		return accountInterest;
	}

	public void setAccountInterest(String accountInterest) {
		this.accountInterest = accountInterest;
	}

	public BranchDetails getBranchDetails() {
		return branchDetails;
	}

	public void setBranchDetails(BranchDetails branchDetails) {
		this.branchDetails = branchDetails;
	}
}

