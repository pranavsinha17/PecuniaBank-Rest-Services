package com.capgemini.accountmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.accountmanagement.entity.AccountDetails;


public interface AccountRepository extends CrudRepository<AccountDetails, String>{

}
