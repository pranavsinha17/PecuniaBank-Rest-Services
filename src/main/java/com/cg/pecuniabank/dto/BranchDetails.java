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
	@OneToOne(cascade=CascadeType.ALL)   // 1:1 unidirectional
	@JoinColumn(name="address_id")
	Address Address;
	

}
