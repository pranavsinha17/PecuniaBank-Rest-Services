package com.capgemini.pecuniabank.entity;
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

	@Entity
	@Table(name="LEDGER")
	public class LoanLedger {
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ledger_seq")
		@SequenceGenerator(sequenceName = "ledger_seq", initialValue=10001, allocationSize = 1, name = "ledger_seq")
		@Column(name="Loan_LedgerId")
		String loanLedgerId;
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
		String status;
		  @OneToOne(optional = false)
		    @JoinColumn(name="LOAN_REQUESTID")
		  private LoanRequest loanRequestId;
		  
		  
		  public LoanLedger() {
		    }
		 
		 
		    public LoanLedger(String accountNumber, String EMI_Amount, String interestRate, String  numberOfEMI, String duration
		    		, String status)
			{
			
				this.accountNumber = accountNumber;
				this.EMI_Amount = EMI_Amount;
				this.interestRate = interestRate;
				this.numberOfEMI = numberOfEMI;
				this.duration = duration;
				this.status = status;
		
			}

			public String getLoanLedgerId() {
				return loanLedgerId;
			}


			public void setLoanLedgerId(String loanLedgerId) {
				this.loanLedgerId = loanLedgerId;
			}
	


			public String getAccountNumber() {
				return accountNumber;
			}


			public void setAccountNumber(String accountNumber) {
				this.accountNumber = accountNumber;
			}


			public String getEMI_Amount() {
				return EMI_Amount;
			}


			public void setEMI_Amount(String eMI_Amount) {
				EMI_Amount = eMI_Amount;
			}


			public String getInterestRate() {
				return interestRate;
			}


			public void setInterestRate(String interestRate) {
				this.interestRate = interestRate;
			}


			public String getNumberOfEMI() {
				return numberOfEMI;
			}


			public void setNumberOfEMI(String numberOfEMI) {
				this.numberOfEMI = numberOfEMI;
			}


			public String getDuration() {
				return duration;
			}


			public void setDuration(String duration) {
				this.duration = duration;
			}


			public String getStatus() {
				return status;
			}


			public void setStatus(String status) {
				this.status = status;
			}


			public LoanRequest getLoanRequestId() {
				return loanRequestId;
			}


			public void setLoanRequestId(LoanRequest loanRequestId) {
				this.loanRequestId = loanRequestId;
			}
		
		


		

	}



