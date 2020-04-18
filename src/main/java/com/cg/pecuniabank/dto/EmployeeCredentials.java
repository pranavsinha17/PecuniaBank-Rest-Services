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
	@Column(name="employee_Id")
	String employeeId;
	@Column(name="employee_password")
	String employeePassword;
	@OneToOne(cascade=CascadeType.ALL)   // 1:1 unidirectional
	@JoinColumn(name="Employee_Number")
	String EmployeeDetails;  //Given by the bank
	
	
	
	

}
