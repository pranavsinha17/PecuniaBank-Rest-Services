package com.capgemini.accountmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.accountmanagement.entity.Address;
import com.capgemini.accountmanagement.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/address")
	public List<Address> getAllAddress()
	{
		return addressService.getAllAddress();
	}
	@RequestMapping("/address/{addressId}")
	public Optional<Address> getAddress(@PathVariable long addressId)
	{
		return addressService.getAddress(addressId);
	}
	@RequestMapping(method=RequestMethod.POST,value="/address")
	public void addAddress(@RequestBody Address address) {
		
		addressService.addAddress(address);	
	}

}
