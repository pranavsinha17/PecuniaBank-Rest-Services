package com.capgemini.main.entity;

public class Admin {
	//Pre-define admin id and password given by the bank to insert employees details and branch details. when something new is happen.
	public static final String adminId = "PECUNIA ADMIN";
	/**
	 * @return the adminid
	 */
	public static String getAdminid() {
		return adminId;
	}
	public static final String adminPassword = "11608106";
	/**
	 * @return the adminpassword
	 */
	public static String getAdminpassword() {
		return adminPassword;
	}
	public String Id;
	public Admin(String id, String password) {
		super();
		Id = id;
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
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
	public String password;

}
