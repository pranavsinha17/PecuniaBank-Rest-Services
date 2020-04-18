package com.cg.pecuniabank.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="genName")
	@SequenceGenerator(name="genName", sequenceName="id",initialValue=101,allocationSize=1)
	private int addressId;
	@Column(name="ADDRESS_STREET")
	private String street;
	@Column(name="ADDRESS_CITY")
	private String city;
	@Column(name="ADDRESS_STATE")
	private String state;
	@Column(name="ADDRESS_ZIPCODE")
	private String zipCode;

}
