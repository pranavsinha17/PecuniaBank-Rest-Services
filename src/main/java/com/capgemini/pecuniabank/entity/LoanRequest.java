package com.capgemini.pecuniabank.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
	@Table(name = "LOAN")
	public class LoanRequest {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
		@SequenceGenerator(sequenceName = "loan_seq", initialValue=11111, allocationSize = 1, name = "loan_seq")
	    @Column(name = "LOAN_REQUESTID")
		private String loanRequestId;
	  
	  
	  @Column(name = "LOAN_AMOUNT")
	  	private double amount;
	  
	  @Column(name = "LOAN_TYPE")
	  	private String type;
	  
	  @Column(name = "LOAN_TENURE")
	  	private int tenure;
	  
	  @Column(name = "LOAN_ROI")
	  private double roi;
	  
	    @ManyToOne(optional = false)
	    @JoinColumn(name="Account_Number")
	  private AccountManagement accountNumber;
	  
	  public LoanRequest() {
	    }
	 
	 
	    public LoanRequest(double amount, String type, int tenure, double roi)
		{
		
			this.amount = amount;
			this.type = type;
			this.tenure = tenure;
			this.roi = roi;
	
		}


		public String getLoanRequestId() {
			return loanRequestId;
		}


		public void setLoanRequestId(String loanRequestId) {
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


		public AccountManagement getAccountNumber() {
			return accountNumber;
		}


		public void setAccountNumber(AccountManagement accountNumber) {
			this.accountNumber = accountNumber;
		}
		
		 @Override
		public String toString()
		{
			return "loan request id is: "+loanRequestId +","+ "loan amount is: " +amount+","+ "loan type is: " +type+","+
		"loan tenure is: " +tenure+","+"loan roi is: " +roi+",";
		}


	
		 
		  
		 

}
