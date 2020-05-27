package com.capgemini.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Credentials")
public class EmployeeCredentials {
	//Credentials is provide by bank to their employees through any medium to login in bank and do their work.
	//Bank employee has  access of their details. 
	//Id and password provide by bank .
	@Id
	@Column(name="employee_Id")
	private String username;
	@Column(name="employee_password")
	private String password;
	@OneToOne(cascade=CascadeType.ALL)   // 1:1 unidirectional
	@JoinColumn(name="Employee_Number")
	EmployeeDetails employeeDetails;  //Given by the bank using this we fetch all the information relate to employee.
	
	@Override
	public String toString() {
		return "EmployeeCredentials [employeeId=" + username + ", employeePassword=" + password
				+ ", EmployeeDetails=" + employeeDetails + "]";
	}
	public EmployeeCredentials(String employeeId, String employeePassword,EmployeeDetails employeeDetails) {
		super();
		this.username = employeeId;
		this.password = employeePassword;
		this.employeeDetails = employeeDetails;
	}
	public EmployeeCredentials() {
		super();
	}
	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return username;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.username = employeeId;
	}
	/**
	 * @return the employeePassword
	 */
	public String getEmployeePassword() {
		return password;
	}
	/**
	 * @param employeePassword the employeePassword to set
	 */
	public void setEmployeePassword(String employeePassword) {
		this.password = employeePassword;
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
	

	
	
	public EmployeeCredentials(String string) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */



	
	
	
	

}
