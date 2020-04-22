package com.capgemini.accountmanagement.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Branches")
public class BranchDetails {
	
	@Id
	@Column(name="Branch_Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="genName1")
	@SequenceGenerator(name="genName1", sequenceName="id1",initialValue=118001,allocationSize=1)
	private int branchId;
	@Column(name="Branch_Name")
	private String branchName;
	@Column(name="IFSC_Code")
	private String branchIFSC;
	@Column(name="Phone_Number")
	private String phoneNumber;
	@OneToOne(cascade=CascadeType.ALL)   // 1:1 unidirectional
	@JoinColumn(name="address_id")
	Address address;
	
	public BranchDetails(int branchId, String branchName, String branchIFSC, Address address ,String phoneNumber) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchIFSC = branchIFSC;
		this.address = address;
		this.phoneNumber=phoneNumber;
	}
	

	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchIFSC() {
		return branchIFSC;
	}
	public void setBranchIFSC(String branchIFSC) {
		this.branchIFSC = branchIFSC;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public BranchDetails() {
		super();
	}

	

}
