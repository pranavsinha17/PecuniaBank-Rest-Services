package com.cg.pecuniabank.dto;

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
	@Id
	@Column(name="username")
	String username;
	@Column(name="password")
	String password;
//	@OneToOne(cascade=CascadeType.ALL)   // 1:1 unidirectional
//	@JoinColumn(name="Employee_Number")
//	String EmployeeDetails;  //Given by the bank
	public String getEmployeeId() {
		return username;
	}
	public void setEmployeeId(String employeeId) {
		this.username = employeeId;
	}
	public String getEmployeePassword() {
		return password;
	}
	public void setEmployeePassword(String employeePassword) {
		this.password = employeePassword;
	}
//	public String getEmployeeDetails() {
//		return EmployeeDetails;
//	}
//	public void setEmployeeDetails(String employeeDetails) {
//		EmployeeDetails = employeeDetails;
//	}
	
	
	
	

}
