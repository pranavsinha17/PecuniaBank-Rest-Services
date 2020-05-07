package com.capgemini.main.service;

public interface EmployeeLoginService {
public boolean employeeLogin(String employeeId,String employeePassword);
public boolean resetPassword(String employeeId,String mobileNumber,String newPassword);
}
