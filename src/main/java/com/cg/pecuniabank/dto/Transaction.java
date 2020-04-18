package com.cg.pecuniabank.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// @Column(name="EMP_ID", unique = true, nullable = false)
@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@Column(name="Transaction_Id")
	String transactionId;
	@Column(name="Account_Number")
	String  accountNumber;
	@Column(name="Transaction_Option")//slip or cheque
	String transactionOption;
	@Column(name="Transaction_Type")//credit debit
	String transactionType;
	@Column(name="Transaction_Status")
	String transactionStatus;
	@Column(name="Transaction_Amount")
	String transactionAmount;
	@Column(name="Transaction_Date")
	LocalDate transactionDate;
	@Column(name="Benificary_Name")
	String benificaryName;
	@Column(name="Benificary_Accoount_Number")
	String benificaryAccoountNumber;
	@Column(name="Benificary_Bank_Name")
	String bankName;
	
	
	

}
