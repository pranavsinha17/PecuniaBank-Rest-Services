package com.capgemini.main.entity;

import javax.persistence.CascadeType;
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
@Table(name="Accounts")
public class AccountDetails {
	
	@Id
	@Column(name="Account_number")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="genName1")
	@SequenceGenerator(name="genName1", sequenceName="acc",initialValue=1170001,allocationSize=1)
	private long accountNumber;

	@OneToOne(cascade=CascadeType.ALL)   
	@JoinColumn(name="Customer_ID")
	CustomerDetails customerDetails;
	
	@Column(name="Account_Holder_Name")
	private String accountHolderName;
	
	@Column(name="Account_Status")
	private String accountStatus;
	
	@Column(name="Account_Balance")
	private double accountBalance;

	@Column(name="Credit_Score")
	private int creditScore;
	
	@Column(name="Account_Interest")
	private float accountInterest;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name="Branch_Id") //According the customer location the branch is assigned.
	BranchDetails branchdetails;


	@Override
	public String toString() {
		return "AccountDetails [accountNumber=" + accountNumber + ", customerDetails=" + customerDetails
				+ ", accountHolderName=" + accountHolderName + ", accountStatus=" + accountStatus + ", accountBalance="
				+ accountBalance + ", creditScore=" + creditScore + ", accountInterest=" + accountInterest
				+ ", branchdetails=" + branchdetails + "]";
	}


	public AccountDetails() {
		super();
	}


	public AccountDetails(long accountNumber, CustomerDetails customerDetails, String accountHolderName,
			String accountStatus, double accountBalance, int creditScore, float accountInterest,
			BranchDetails branchdetails) {
		super();
		this.accountNumber = accountNumber;
		this.customerDetails = customerDetails;
		this.accountHolderName = accountHolderName;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.creditScore = creditScore;
		this.accountInterest = accountInterest;
		this.branchdetails = branchdetails;
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


	/**
	 * @return the customerDetails
	 */
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}


	/**
	 * @param customerDetails the customerDetails to set
	 */
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}


	/**
	 * @return the accountHolderName
	 */
	public String getAccountHolderName() {
		return accountHolderName;
	}


	/**
	 * @param accountHolderName the accountHolderName to set
	 */
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	/**
	 * @return the accountStatus
	 */
	public String getAccountStatus() {
		return accountStatus;
	}


	/**
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}


	/**
	 * @return the accountBalance
	 */
	public double getAccountBalance() {
		return accountBalance;
	}


	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	/**
	 * @return the creditScore
	 */
	public int getCreditScore() {
		return creditScore;
	}


	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}


	/**
	 * @return the accountInterest
	 */
	public float getAccountInterest() {
		return accountInterest;
	}


	/**
	 * @param accountInterest the accountInterest to set
	 */
	public void setAccountInterest(float accountInterest) {
		this.accountInterest = accountInterest;
	}


	/**
	 * @return the branchdetails
	 */
	public BranchDetails getBranchdetails() {
		return branchdetails;
	}


	/**
	 * @param branchdetails the branchdetails to set
	 */
	public void setBranchdetails(BranchDetails branchdetails) {
		this.branchdetails = branchdetails;
	}

	
}

