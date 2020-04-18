package com.cg.pecuniabank.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Passbook")
public class PassBook {
	@Id
	@Column(name="Account_Number")
	String accountNumber;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public List<Transaction> getTranscationList() {
		return transcationList;
	}
	public void setTranscationList(List<Transaction> transcationList) {
		this.transcationList = transcationList;
	}
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="Account_Number")
    private List<Transaction> transcationList;

}
