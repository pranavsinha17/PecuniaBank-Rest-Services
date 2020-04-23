package com.capgemini.accountmanagement.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.accountmanagement.entity.AccountDetails;


public interface AccountRepository extends CrudRepository<AccountDetails, Serializable>{

	//void deleteById(long accountNumber);
	
//	@Modifying
//	@Query("delete from ACCOUNTS A where A.id = ?1")
//	void delete(Long accountNumber);


}
