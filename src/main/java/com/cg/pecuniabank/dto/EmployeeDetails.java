package com.cg.pecuniabank.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmployeeDetails {
//It is a hard copy of Employees details form.
	//We assume that the bank verify all the details of employees.
	   //And generate employee_id and password and provide to employees.
	
	@Id
	@Column(name="Employee_Number")
	String employeeNumber;  //Given by the bank
	@Column(name="Employee_First_Name")
	String employeeFirstName;
	@Column(name="Employee_Last_Name")
	String employeeLastName;
	@Column(name="DOB")
	String DOB;//date of birth format like (day/Mon/Year)
	@Column(name="Age")
	String age;
	@Column(name="Pan_Number")
	String panNumber;
	@Column(name="Adhar_Number")
	String adharNumber;
	@OneToOne(cascade=CascadeType.ALL)   // 1:1 unidirectional
	@JoinColumn(name="address_id")
	Address Address;
	@ManyToOne(optional = false)  // N:1 unidirectional 
	@JoinColumn(name="Branch_Id")  //We use optional is false it means by default every Account holder get same branch details.
	BranchDetails branchdetails;
	
}
