package com.cg.pecuniabank.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Branch")
public class BranchDetails {
	//We Auto put the information of branch.
	@Id
	@Column(name="Branch_Id")
	String branchId;
	@Column(name="Branch_Name")
	String branchName;
	@Column(name="IFSC_Code")
	String branchIFSC;
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
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
//	public Address getAddress() {
//		return Address;
//	}
//	public void setAddress(Address address) {
//		Address = address;
//	}
//	@OneToOne(cascade=CascadeType.ALL)   // 1:1 unidirectional
//	@JoinColumn(name="address_id")
//	Address Address;
//	

}
