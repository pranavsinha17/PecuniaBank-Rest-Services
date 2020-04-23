package com.capgemini.accountmanagement.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.accountmanagement.entity.Address;

public interface AddressRepository extends CrudRepository<Address,Serializable>{

}
