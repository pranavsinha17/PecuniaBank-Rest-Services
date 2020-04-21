package com.capgemini.accountmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.accountmanagement.entity.Address;

public interface AddressRepository extends CrudRepository<Address,String>{

}
