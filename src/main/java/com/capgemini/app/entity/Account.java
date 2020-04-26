package com.capgemini.app.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT_INFOO")
public class Account {
	
	@Id
	@Column(name="Account_Number") 
	private String accountNumber;
	
	
	@Column(name="Account_Holder_Name")
	String accountHolderName;
	
	@Column(name="Account_Balance")
	int accountBalance;

	@Column(name="Credit_Score")
	int creditScore;
	
	@Column(name="Account_Interest")
	String accountInterest;
	
	 


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

		public Account() {
			super();
	    }
	 
	 
	    public Account(String accountNumber, String accountHolderName,  int accountBalance, int  creditScore, String accountInterest
)
		{
		this.accountNumber=accountNumber;
			this.accountHolderName = accountHolderName;
			this.accountBalance = accountBalance;
			this.creditScore = creditScore;
			this.accountInterest = accountInterest;
	
	
		}
}
