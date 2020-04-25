package com.capgemini.app.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="Ledger_Info")
//@SequenceGenerator(name ="test_seq",initialValue=101, allocationSize = 1)
public class Ledger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ledger_seq")
	@SequenceGenerator(sequenceName = "ledger_seq", initialValue=10001, allocationSize = 1, name = "ledger_seq")
	@Column(name="Loan_LedgerId")
	private long loanLedgerId;
	
	@Column(name="Account_Number")
	private String accountNumber;
	@Column(name="EMI_Amount")
	private double EMI_Amount;
	@Column(name="Interest_Rate") //make a list of interest rate of different type of loan
	private double interestRate;
	@Column(name="EMI_Terms")
	private int numberOfEMI;
	@Column(name="Duration")
	private int duration;
	@Column(name="Loan_Status")
	private String status;
	
	  @Override
	public String toString() {
		return "Ledger [loanLedgerId=" + loanLedgerId + ", accountNumber=" + accountNumber + ", EMI_Amount="
				+ EMI_Amount + ", interestRate=" + interestRate + ", numberOfEMI=" + numberOfEMI + ", duration="
				+ duration + ", status=" + status + ", loanRequestId=" + loanRequestId + "]";
	}

	public Ledger() {
		super();
	}

	public Ledger(long loanLedgerId, String accountNumber, double eMI_Amount, double interestRate, int numberOfEMI,
			int duration, String status, Request loanRequestId) {
		super();
		this.loanLedgerId = loanLedgerId;
		this.accountNumber = accountNumber;
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
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
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
	public Request getLoanRequestId() {
		return loanRequestId;
	}

	/**
	 * @param loanRequestId the loanRequestId to set
	 */
	public void setLoanRequestId(Request loanRequestId) {
		this.loanRequestId = loanRequestId;
	}

	@OneToOne(optional = false)
	  @JoinColumn(name="LOAN_REQUESTID")
	  private Request loanRequestId;
	  
	  


}
