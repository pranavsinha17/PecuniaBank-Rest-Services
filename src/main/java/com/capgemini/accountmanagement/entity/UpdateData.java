package com.capgemini.accountmanagement.entity;



public class UpdateData {
	 String mobileNumber;
	 long accountNumber;
	 AddressDetails address;
	 String name;
	public UpdateData() {
		super();
	}
	public UpdateData(long accountNumber, String name) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
	}
	public UpdateData(long accountNumber, AddressDetails address) {
		super();
		this.accountNumber = accountNumber;
		this.address = address;
	}
	/**
	 * @return the address
	 */
	public AddressDetails getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDetails address) {
		this.address = address;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public UpdateData(String mobileNumber, long accountNumber) {
		super();
		this.mobileNumber = mobileNumber;
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

}


