package com.capgemini.main.entity;
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		private long loanLedgerId;
		@ManyToOne(optional = false)   // One person can always to take more than one loan
		@JoinColumn(name="Account_Number")
		AccountDetails accountDetails;
		@Column(name="EMI_Amount")
		private double EMI_Amount;
		@Column(name="Interest_Rate") //make a list of interest rate of different type of loan
		private float interestRate;
		@Column(name="EMI_Terms")
		private int numberOfEMI;
		@Column(name="Duration")
		private int duration;
		@Column(name="Loan_Status")
		private String status;
		@Column(name="LOAN_REQUESTID")
		private long loanRequestId ;
		public LoanLedger() {
			super();
		}
		public LoanLedger(long loanLedgerId, AccountDetails accountDetails, double eMI_Amount, float interestRate,
				int numberOfEMI, int duration, String status, long loanRequestId) {
			super();
			this.loanLedgerId = loanLedgerId;
			this.accountDetails = accountDetails;
			EMI_Amount = eMI_Amount;
			this.interestRate = interestRate;
			this.numberOfEMI = numberOfEMI;
			this.duration = duration;
			this.status = status;
			this.loanRequestId = loanRequestId;
		}
		/**
		 * @return the loanLedgerId
		 */
		public long getLoanLedgerId() {
			return loanLedgerId;
		}
		/**
		 * @param loanLedgerId the loanLedgerId to set
		 */
		public void setLoanLedgerId(long loanLedgerId) {
			this.loanLedgerId = loanLedgerId;
		}
		/**
		 * @return the accountDetails
		 */
		public AccountDetails getAccountDetails() {
			return accountDetails;
		}
		/**
		 * @param accountDetails the accountDetails to set
		 */
		public void setAccountDetails(AccountDetails accountDetails) {
			this.accountDetails = accountDetails;
		}
		/**
		 * @return the eMI_Amount
		 */
		public double getEMI_Amount() {
			return EMI_Amount;
		}
		/**
		 * @param eMI_Amount the eMI_Amount to set
		 */
		public void setEMI_Amount(double eMI_Amount) {
			EMI_Amount = eMI_Amount;
		}
		/**
		 * @return the interestRate
		 */
		public float getInterestRate() {
			return interestRate;
		}
		/**
		 * @param interestRate the interestRate to set
		 */
		public void setInterestRate(float interestRate) {
			this.interestRate = interestRate;
		}
		/**
		 * @return the numberOfEMI
		 */
		public int getNumberOfEMI() {
			return numberOfEMI;
		}
		/**
		 * @param numberOfEMI the numberOfEMI to set
		 */
		public void setNumberOfEMI(int numberOfEMI) {
			this.numberOfEMI = numberOfEMI;
		}
		/**
		 * @return the duration
		 */
		public int getDuration() {
			return duration;
		}
		/**
		 * @param duration the duration to set
		 */
		public void setDuration(int duration) {
			this.duration = duration;
		}
		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}
		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
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
		@Override
		public String toString() {
			return "LoanLedger [loanLedgerId=" + loanLedgerId + ", accountDetails=" + accountDetails + ", EMI_Amount="
					+ EMI_Amount + ", interestRate=" + interestRate + ", numberOfEMI=" + numberOfEMI + ", duration="
					+ duration + ", status=" + status + ", loanRequestId=" + loanRequestId + "]";
		}
		
		
		
		
	}



