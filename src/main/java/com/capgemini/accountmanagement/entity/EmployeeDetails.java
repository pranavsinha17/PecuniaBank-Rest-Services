package com.capgemini.accountmanagement.entity;

import javax.persistence.CascadeType;
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
@Table(name = "Employees")
public class EmployeeDetails {

	@Id
	@Column(name = "Employee_Number")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genName")
	@SequenceGenerator(name = "genName", sequenceName = "id2", initialValue = 116001, allocationSize = 1)
	private int employeeNumber; // Given by the bank

	@Column(name = "Branch_Id")
	private int branchId;

	@Column(name = "Employee_First_Name")
	private String employeeFirstName;

	@Column(name = "Employee_Last_Name")
	private String employeeLastName;

	// date of birth format like (day/Mon/Year)
	@Column(name = "DOB")
	private String DOB;

	@Column(name = "Age")
	private String age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "Pan_Number")
	private String panNumber;

	@Column(name = "Adhaar_Number")
	private String adhaarNumber;

	@Column(name = "Mobile_Number")
	private String mobileNumber;
	// one to one mapping of employee address because every employees having
	// differents adress.

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	AddressDetails address;

	@Override
	public String toString() {
		return "EmployeeDetails [employeeNumber=" + employeeNumber + ", branchId=" + branchId + ", employeeFirstName="
				+ employeeFirstName + ", employeeLastName=" + employeeLastName + ", DOB=" + DOB + ", age=" + age
				+ ", gender=" + gender + ", panNumber=" + panNumber + ", adhaarNumber=" + adhaarNumber
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}

	public EmployeeDetails() {
		super();
	}

	public EmployeeDetails(int employeeNumber, int branchId, String employeeFirstName, String employeeLastName,
			String dOB, String age, String panNumber, String adhaarNumber, String mobileNumber, String gender,
			AddressDetails address) {
		super();
		this.employeeNumber = employeeNumber;
		this.branchId = branchId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.DOB = dOB;
		this.age = age;
		this.panNumber = panNumber;
		this.adhaarNumber = adhaarNumber;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
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

	public void setAdhaarNumber(String adharNumber) {
		this.adhaarNumber = adharNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public AddressDetails getAddress() {
		return address;
	}

	public void setAddress(AddressDetails address) {
		this.address = address;
	}

}
