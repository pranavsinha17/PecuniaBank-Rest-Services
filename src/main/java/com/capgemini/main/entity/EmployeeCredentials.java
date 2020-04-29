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
<<<<<<< HEAD
	private String username;
	@Column(name="employee_password")
	private String password;
=======
	private String employeeId;
	@Column(name="employee_password")
	private String employeePassword;
>>>>>>> 9b1f862cd284aefde5669e0eed3059b5c29d07fb
	@OneToOne(cascade=CascadeType.ALL)   // 1:1 unidirectional
	@JoinColumn(name="Employee_Number")
	EmployeeDetails EmployeeDetails;  //Given by the bank using this we fetch all the information relate to employee.
	@Override
	public String toString() {
<<<<<<< HEAD
		return "EmployeeCredentials [employeeId=" + username + ", employeePassword=" + password
=======
		return "EmployeeCredentials [employeeId=" + employeeId + ", employeePassword=" + employeePassword
>>>>>>> 9b1f862cd284aefde5669e0eed3059b5c29d07fb
				+ ", EmployeeDetails=" + EmployeeDetails + "]";
	}
	public EmployeeCredentials(String employeeId, String employeePassword,EmployeeDetails employeeDetails) {
		super();
<<<<<<< HEAD
		this.username = employeeId;
		this.password = employeePassword;
=======
		this.employeeId = employeeId;
		this.employeePassword = employeePassword;
>>>>>>> 9b1f862cd284aefde5669e0eed3059b5c29d07fb
		EmployeeDetails = employeeDetails;
	}
	public EmployeeCredentials() {
		super();
	}
<<<<<<< HEAD
	public EmployeeCredentials(String string) {
		// TODO Auto-generated constructor stub
	}
=======
>>>>>>> 9b1f862cd284aefde5669e0eed3059b5c29d07fb
	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
<<<<<<< HEAD
		return username;
=======
		return employeeId;
>>>>>>> 9b1f862cd284aefde5669e0eed3059b5c29d07fb
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
<<<<<<< HEAD
		this.username = employeeId;
=======
		this.employeeId = employeeId;
>>>>>>> 9b1f862cd284aefde5669e0eed3059b5c29d07fb
	}
	/**
	 * @return the employeePassword
	 */
	public String getEmployeePassword() {
<<<<<<< HEAD
		return password;
=======
		return employeePassword;
>>>>>>> 9b1f862cd284aefde5669e0eed3059b5c29d07fb
	}
	/**
	 * @param employeePassword the employeePassword to set
	 */
	public void setEmployeePassword(String employeePassword) {
<<<<<<< HEAD
		this.password = employeePassword;
=======
		this.employeePassword = employeePassword;
>>>>>>> 9b1f862cd284aefde5669e0eed3059b5c29d07fb
	}
	/**
	 * @return the employeeDetails
	 */
	public EmployeeDetails getEmployeeDetails() {
		return EmployeeDetails;
	}
	/**
	 * @param employeeDetails the employeeDetails to set
	 */
	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		EmployeeDetails = employeeDetails;
	}
	
	
	
	
	
	
	

}
