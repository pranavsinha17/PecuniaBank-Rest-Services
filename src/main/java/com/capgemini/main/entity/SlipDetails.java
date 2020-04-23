package com.capgemini.main.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Slip")
public class SlipDetails {
	
	//we have to deposit the money from account or (only provide benificary Account number whom you want to deposit).
	//we have to withdrawal money from account we use slip.(only payee Account Number to get money from bank).

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slip_seq")
	@SequenceGenerator(sequenceName = "slip_seq", initialValue=122901, allocationSize = 1, name = "slip_seq")
	@Column(name="Slip_Number")
	private long  slipNumber;        // Slip number by default written in the slip.
	@Column(name="Account_Number")
	private long AccountNumber;
	@Column(name="Amount")
	private double amount;             //amount that you want to pay.
	@Column(name="Type")
	String transactionType;  //Debit or credit
	@Column(name="Holder_Name")
	String HolderName;                
	LocalDate slipDate;   //current date 
	@Column(name="Bank_Name")//by default pecunia
	String bankName;
	@Column(name="IFSC")
	String IFSC;
	
	@Override
	public String toString() {
		return "SlipDetails [slipNumber=" + slipNumber + ", AccountNumber=" + AccountNumber + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", HolderName=" + HolderName + ", slipDate=" + slipDate
				+ ", bankName=" + bankName + ", IFSC=" + IFSC + "]";
	}
	
	public SlipDetails() {
		super();
	}
	
	public SlipDetails(long slipNumber, long accountNumber, double amount, String transactionType, String holderName,
			LocalDate slipDate, String bankName, String iFSC) {
		super();
		this.slipNumber = slipNumber;
		AccountNumber = accountNumber;
		this.amount = amount;
		this.transactionType = transactionType;
		HolderName = holderName;
		this.slipDate = slipDate;
		this.bankName = bankName;
		IFSC = iFSC;
	}
	/**
	 * @return the slipNumber
	 */
	public long getSlipNumber() {
		return slipNumber;
	}
	/**
	 * @param slipNumber the slipNumber to set
	 */
	public void setSlipNumber(long slipNumber) {
		this.slipNumber = slipNumber;
	}
	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return AccountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
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
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the holderName
	 */
	public String getHolderName() {
		return HolderName;
	}
	/**
	 * @param holderName the holderName to set
	 */
	public void setHolderName(String holderName) {
		HolderName = holderName;
	}
	/**
	 * @return the slipDate
	 */
	public LocalDate getSlipDate() {
		return slipDate;
	}
	/**
	 * @param slipDate the slipDate to set
	 */
	public void setSlipDate(LocalDate slipDate) {
		this.slipDate = slipDate;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the iFSC
	 */
	public String getIFSC() {
		return IFSC;
	}
	/**
	 * @param iFSC the iFSC to set
	 */
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	
	
}
