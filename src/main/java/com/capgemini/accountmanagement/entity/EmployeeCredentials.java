package com.capgemini.accountmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Credentials")
public class EmployeeCredentials {

	@Id
	@Column(name = "employee_Id")
	private String employeeId;

	@Column(name = "employee_password")
	private String employeePassword;

	@OneToOne(cascade = CascadeType.ALL) // 1:1 unidirectional
	@JoinColumn(name = "Employee_Number")
	EmployeeDetails EmployeeDetails; // Given by the bank using this we fetch all the information relate to employee.

	@Override
	public String toString() {
		return "EmployeeCredentials [employeeId=" + employeeId + ", employeePassword=" + employeePassword
				+ ", EmployeeDetails=" + EmployeeDetails + "]";
	}

	public EmployeeCredentials(String employeeId, String employeePassword, EmployeeDetails employeeDetails) {
		super();
		this.employeeId = employeeId;
		this.employeePassword = employeePassword;
		EmployeeDetails = employeeDetails;
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
		return EmployeeDetails;
	}

	/**
	 * @param employeeDetails the employeeDetails to set
	 */
	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		EmployeeDetails = employeeDetails;
	}

}
