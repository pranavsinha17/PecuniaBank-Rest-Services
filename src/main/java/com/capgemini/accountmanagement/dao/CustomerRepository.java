package com.capgemini.accountmanagement.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.accountmanagement.entity.CustomerDetails;

public interface CustomerRepository extends CrudRepository<CustomerDetails,Serializable> {

}
