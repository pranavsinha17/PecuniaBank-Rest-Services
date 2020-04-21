package com.capgemini.pecuniabank.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")

public class AccountManagement {

		
		@Id
		@Column(name="Account_Number") 
		String accountNumber;
		
		
		@Column(name="Account_Holder_Name")
		String accountHolderName;
		
		@Column(name="Account_Status")
		String accountStatus;
		
		@Column(name="Account_Balance")
		int accountBalance;

		@Column(name="Credit_Score")
		int creditScore;
		
		@Column(name="Account_Interest")
		String accountInterest;
		
		 public AccountManagement() {
		    }
		 
		 
		    public AccountManagement(String accountHolderName, String accountStatus, int accountBalance, int  creditScore, String accountInterest
	)
			{
			
				this.accountHolderName = accountHolderName;
				this.accountStatus = accountStatus;
				this.accountBalance = accountBalance;
				this.creditScore = creditScore;
				this.accountInterest = accountInterest;
		
		
			}


			public String getAccountNumber() {
				return accountNumber;
			}


			public void setAccountNumber(String accountNumber) {
				this.accountNumber = accountNumber;
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


			public int getAccountBalance() {
				return accountBalance;
			}


			public void setAccountBalance(int accountBalance) {
				this.accountBalance = accountBalance;
			}


			public int getCreditScore() {
				return creditScore;
			}


			public void setCreditScore(int creditScore) {
				this.creditScore = creditScore;
			}


			public String getAccountInterest() {
				return accountInterest;
			}


			public void setAccountInterest(String accountInterest) {
				this.accountInterest = accountInterest;
			}

		
		
		
	}


	
