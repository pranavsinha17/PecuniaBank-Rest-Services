package com.capgemini.accountmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.entity.Address;
import com.capgemini.accountmanagement.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address>getAllAddress()
	{
		List<Address>address=new ArrayList<>();
		addressRepository.findAll().forEach(address::add);	
		return address;
	}
	public Optional<Address> getAddress(long addressId)
	{
		String str=Long.toString(addressId);
		return addressRepository.findById(str);
	}
	public void addAddress(Address address) {
		
		addressRepository.save(address);
		
	}

}
