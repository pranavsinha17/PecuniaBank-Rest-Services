package com.capgemini.accountmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerDetails {
	
	@Id
	@Column(name="Customer_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long customerId; 

	@Column(name="Customer_First_Name")
	private String customerFirstName;
	
	@Column(name="Customer_Last_Name")
	private String customerLastName;
	
	@Column(name="DOB")
	private String DOB;
	
	@Column(name="Age")
	private String age;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Contact_Number")
	private String contactNumber;
	
	@Column(name="Pan_Number")
	private String panNumber;
	
	@Column(name="Adhaar_Number")
	private String adhaarNumber;
	
	@Column(name="Account_Type") 
	private String accountType;
	
	@Column(name="Opening_Balance") 
	private String openingBalance;
	
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="address_id")
	private Address address;
	
	public CustomerDetails()
	{
		
	}

	public CustomerDetails(long customerId, String customerFirstName, String customerLastName, String dOB, String age,
			String gender, String contactNumber, String panNumber, String adhaarNumber, String accountType,
			String openingBalance, Address address) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.DOB = dOB;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.panNumber = panNumber;
		this.adhaarNumber = adhaarNumber;
		this.accountType = accountType;
		this.openingBalance = openingBalance;
		this.address = address;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}
