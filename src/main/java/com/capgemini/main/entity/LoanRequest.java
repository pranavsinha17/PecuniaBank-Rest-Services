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

@Entity
	@Table(name = "LOAN")
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
	  
	  @Column(name="Account_number")
	  private long accountNumber;
	  

		
		 @Override
	public String toString() {
		return "LoanRequest [loanRequestId=" + loanRequestId + ", amount=" + amount + ", type=" + type + ", tenure="
				+ tenure + ", roi=" + roi + ", accountNumber=" + accountNumber + "]";
	}



		public LoanRequest() {
		super();
	}



		public LoanRequest(long loanRequestId, double amount, String type, int tenure, double roi, long accountNumber) {
		super();
		this.loanRequestId = loanRequestId;
		this.amount = amount;
		this.type = type;
		this.tenure = tenure;
		this.roi = roi;
		this.accountNumber = accountNumber;
	}



		/**
	 * @return the loanRequestId
	 */
	public long getLoanRequestId() {
		return loanRequestId;
	}



	/**
	 * @param loanRequestId the loanRequestId to set
	 */
	public void setLoanRequestId(long loanRequestId) {
		this.loanRequestId = loanRequestId;
	}



	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}



	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}



	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	/**
	 * @return the tenure
	 */
	public int getTenure() {
		return tenure;
	}



	/**
	 * @param tenure the tenure to set
	 */
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}



	/**
	 * @return the roi
	 */
	public double getRoi() {
		return roi;
	}



	/**
	 * @param roi the roi to set
	 */
	public void setRoi(double roi) {
		this.roi = roi;
	}



	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}



	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}



		

	
		 
		  
		 

}
