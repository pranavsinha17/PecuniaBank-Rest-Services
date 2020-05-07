package com.capgemini.pecuniabank.entity;

import java.time.LocalDate;


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
@Table(name="Ledger_IAS")
public class Ledger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ledger_seq")
	@SequenceGenerator(sequenceName = "ledger_seq", initialValue=10001, allocationSize = 1, name = "ledger_seq")
	@Column(name="Loan_LedgerId")
	private long loanLedgerId;
	@Column(name="Loan_Type")
	private String loanType;
	@Column(name="emi_Amount")
	private double emiAmount;
	@Column(name="Interest_Rate") 
	private double interestRate;
	@Column(name="EMI_Terms")
	private int numberOfEMI;
	@Column(name="Duration")
	private int duration;
	@Column(name="Loan_Status")
	private String status;
	@Column(name="startDate")
	private LocalDate startDate;
	@Column(name="endDate")
	private LocalDate endDate;
	@Column(name="LOAN_REQUESTID")
	private long loanRequestId ;
	@ManyToOne(optional = false)   
	@JoinColumn(name="Account_Number")
	Account accountDetails;
	
	public Ledger(long loanLedgerId, String loanType, double emiAmount, double interestRate,
			int numberOfEMI, int duration, String status, LocalDate startDate, LocalDate endDate,
			long loanRequestId, Account accountDetails) {
		super();
		this.loanLedgerId = loanLedgerId;
		this.loanType=loanType;
		this.emiAmount = emiAmount;
		this.interestRate = interestRate;
		this.numberOfEMI = numberOfEMI;
		this.duration = duration;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.loanRequestId = loanRequestId;
		this.accountDetails = accountDetails;
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
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	public Account getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(Account accountDetails) {
		this.accountDetails = accountDetails;
	}


	/**
	 * @return the eMI_Amount
	 */
	public double getEmiAmount() {
		return emiAmount;
	}
	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
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
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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
		return "LoanLedger [loanLedgerId=" + loanLedgerId + ", loanType=" +loanType+ ", EMI_Amount="
				+ emiAmount + ", interestRate=" + interestRate + ", numberOfEMI=" + numberOfEMI + ", duration="
				+ duration + ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", loanRequestId=" + loanRequestId + ", accountDetails=" + accountDetails + "]";
	}
	public Ledger() {
		super();
	}
	
	
	

	
	
}
