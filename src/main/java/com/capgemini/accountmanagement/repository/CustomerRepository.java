package com.capgemini.accountmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.accountmanagement.entity.CustomerDetails;

public interface CustomerRepository extends CrudRepository<CustomerDetails,String>{

}
