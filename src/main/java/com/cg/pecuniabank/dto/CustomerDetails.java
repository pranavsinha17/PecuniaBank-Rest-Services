package com.cg.pecuniabank.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerDetails {
	
	@Id
	@Column(name="Customer_ID")
	String customerId; 

	@Column(name="Customer_First_Name")
	String customerFirstName;
	
	@Column(name="Employee_Last_Name")
	String customerLastName;
	
	@Column(name="DOB")
	String DOB;
	
	@Column(name="Age")
	String age;
	
	@Column(name="Pan_Number")
	String panNumber;
	
	@Column(name="Adhaar_Number")
	String adhaarNumber;
	
	@Column(name="Account_Type") 
	String accountType;
	
	@Column(name="Opening_Balance") 
	String openingBalance;
	
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="address_id")
	Address Address;
	
	public CustomerDetails()
	{
		
	}
	
	public CustomerDetails(String customerId, String customerFirstName, String customerLastName, String dOB, String age,
			String panNumber, String adhaarNumber, String accountType, String openingBalance,
			Address address) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		DOB = dOB;
		this.age = age;
		this.panNumber = panNumber;
		this.adhaarNumber = adhaarNumber;
		this.accountType = accountType;
		this.openingBalance = openingBalance;
		Address = address;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAdhaarNumber() {
		return adhaarNumber;
	}

	public void setAdhaarNumber(String adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address address) {
		Address = address;
	}
	

}
