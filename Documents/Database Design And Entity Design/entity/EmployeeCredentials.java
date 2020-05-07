package com.capgemini.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Credentails")
public class EmployeeCredentials {
	//Credentials is provide by bank to their employees through any medium to login in bank and do their work.
	//Bank employee has  access of their details. 
	//Id and password provide by bank .
	@Id
	@Column(name="employee_Id")
	private String employeeId;
	@Column(name="employee_password")
	private String employeePassword;
	@OneToOne(cascade=CascadeType.ALL)   // 1:1 unidirectional
	@JoinColumn(name="Employee_Number")
	EmployeeDetails employeeDetails;  //Given by the bank using this we fetch all the information relate to employee.
	
	@Override
	public String toString() {
		return "EmployeeCredentials [employeeId=" + employeeId + ", employeePassword=" + employeePassword
				+ ", EmployeeDetails=" + employeeDetails + "]";
	}
	public EmployeeCredentials(String employeeId, String employeePassword,EmployeeDetails employeeDetails) {
		super();
		this.employeeId = employeeId;
		this.employeePassword = employeePassword;
		this.employeeDetails = employeeDetails;
	}
	public EmployeeCredentials() {
		super();
	}
	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the employeePassword
	 */
	public String getEmployeePassword() {
		return employeePassword;
	}
	/**
	 * @param employeePassword the employeePassword to set
	 */
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	/**
	 * @return the employeeDetails
	 */
	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}
	/**
	 * @param employeeDetails the employeeDetails to set
	 */
	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	
	
	String id;
	String password;
	String mobileNumber;
	String newPassword;
	
	public EmployeeCredentials(String id, String mobileNumber, String newPassword) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.newPassword = newPassword;
	}
	public EmployeeCredentials(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	
	
	
	

}
