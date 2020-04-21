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
@Table(name="Employee")
public class EmployeeDetails {
//It is a hard copy of Employees details form.
	//We assume that the bank verify all the details of employees.
	   //And generate employee_id and password and provide to employees.
	
	@Id
	@Column(name="Employee_Number")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="genName")
	@SequenceGenerator(name="genName", sequenceName="id2",initialValue=116001,allocationSize=1)
	private int  employeeNumber;  //Given by the bank
	@Column(name="Branch_Id")
	private int branchId;
	@Column(name="Employee_First_Name")
	private String employeeFirstName;
	@Column(name="Employee_Last_Name")
	private String employeeLastName;
	//date of birth format like (day/Mon/Year)
	@Column(name="DOB")
	private String DOB;      
	@Column(name="Age")
	private String age;
	@Column(name="gender")
	private String gender;
	@Column(name="Pan_Number")
	private String panNumber;
	@Column(name="Adhar_Number")
	private String adharNumber;
    @Column(name="Mobile_Number")
    private String mobileNumber;
    //one to one mapping of employee address because every employees having differents adress.
	@OneToOne(cascade=CascadeType.ALL)   
	@JoinColumn(name="address_id")
	Address address;
	public EmployeeDetails() {
		super();
	}
	public EmployeeDetails(int employeeNumber, int branchId, String employeeFirstName, String employeeLastName,
			String dOB, String age, String panNumber, String adharNumber, String mobileNumber,String gender,
			Address address) {
		super();
		this.employeeNumber = employeeNumber;
		this.branchId = branchId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		DOB = dOB;
		this.age = age;
		this.panNumber = panNumber;
		this.adharNumber = adharNumber;
		this.mobileNumber = mobileNumber;
		this.gender=gender;
		this.address = address;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the employeeNumber
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	/**
	 * @return the branchId
	 */
	public int getBranchId() {
		return branchId;
	}
	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	/**
	 * @return the employeeFirstName
	 */
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	/**
	 * @param employeeFirstName the employeeFirstName to set
	 */
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	/**
	 * @return the employeeLastName
	 */
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	/**
	 * @param employeeLastName the employeeLastName to set
	 */
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	/**
	 * @return the dOB
	 */
	public String getDOB() {
		return DOB;
	}
	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return the panNumber
	 */
	public String getPanNumber() {
		return panNumber;
	}
	/**
	 * @param panNumber the panNumber to set
	 */
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	/**
	 * @return the adharNumber
	 */
	public String getAdharNumber() {
		return adharNumber;
	}
	/**
	 * @param adharNumber the adharNumber to set
	 */
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
