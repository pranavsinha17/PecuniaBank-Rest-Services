package com.capgemini.main.Dao;

public interface DaoEmpoyee {
	public boolean validateCredentails(String employeeId, String employeePassword);
	public boolean updatePassword(String employeeId, String mobileNumber,String newPassword);

}
