package com.capgemini.accountmanagement.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class AccountDetails {
	
		@Id
		@Column(name="Account_number")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long accountNumber;

		@OneToOne(cascade=CascadeType.ALL)   
		@JoinColumn(name="Customer_ID")
		CustomerDetails customerDetails;
		
		@Column(name="Account_Holder_Name")
		String accountHolderName;
		
		@Column(name="Account_Status")
		String accountStatus;
		
		@Column(name="Account_Balance")
		String accountBalance;

		@Column(name="Credit_Score")
		String creditScore;
		
		@Column(name="Account_Interest")
		String accountInterest;
		
		@Column(name="Creation_Date")
		private LocalDateTime creationDate;			
		
		@ManyToOne(optional = false)  
		@JoinColumn(name="Branch_Id")
		BranchDetails branchdetails;
		
		public AccountDetails()
		{
			
		}
		
		

		
		public AccountDetails(long accountNumber, CustomerDetails customerDetails, String accountHolderName,
				String accountStatus, String accountBalance, String creditScore, String accountInterest,
				LocalDateTime creationDate, BranchDetails branchdetails) {
			super();
			this.accountNumber = accountNumber;
			this.customerDetails = customerDetails;
			this.accountHolderName = accountHolderName;
			this.accountStatus = accountStatus;
			this.accountBalance = accountBalance;
			this.creditScore = creditScore;
			this.accountInterest = accountInterest;
			this.creationDate = creationDate;
			this.branchdetails = branchdetails;
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

		public LocalDateTime getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
		}

		public BranchDetails getBranchdetails() {
			return branchdetails;
		}

		public void setBranchdetails(BranchDetails branchdetails) {
			this.branchdetails = branchdetails;
		}
}

