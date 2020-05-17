package com.capgemini.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ForgetPassword {
    @Id
	private String employeeId;
    private String mobileNumber;
    public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	private String employeePassword;
	
}
