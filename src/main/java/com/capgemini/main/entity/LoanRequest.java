package com.capgemini.main.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Request_Lpz")
@DynamicUpdate(true)
@DynamicInsert(true)
public class LoanRequest {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
		@SequenceGenerator(sequenceName = "loan_seq", initialValue=11111, allocationSize = 1, name = "loan_seq")
	    @Column(name = "LOAN_REQUESTID")
		private long loanRequestId;
	  
	  
	  @Column(name = "LOAN_AMOUNT")
	  	private double amount;
	  
	  @Column(name = "LOAN_TYPE")
	  	private String type;
	  
	  @Column(name = "LOAN_TENURE")
	  	private int tenure;
	  
	  @Column(name = "LOAN_ROI")
	  private double roi;
	  
	  @Column(name = "ACCOUNT_NUMBER")
	  private String accountNumber;
	  
	  
	 
	 
	    


		public long getLoanRequestId() {
			return loanRequestId;
		}


		public void setLoanRequestId(long loanRequestId) {
			this.loanRequestId = loanRequestId;
		}



		public double getAmount() {
			return amount;
		}


		public void setAmount(double amount) {
			this.amount = amount;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public int getTenure() {
			return tenure;
		}


		public void setTenure(int tenure) {
			this.tenure = tenure;
		}


		public double getRoi() {
			return roi;
		}


		public void setRoi(double roi) {
			this.roi = roi;
		}


		public String getAccountNumber() {
			return accountNumber;
		}


		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		
		public LoanRequest(double amount, String type, int tenure, double roi, String accountNumber)
		{
		
			this.amount = amount;
			this.type = type;
			this.tenure = tenure;
			this.roi = roi;
	        this.accountNumber=accountNumber;
	
		}
		
	



	public LoanRequest() {
		super();
	}

}
