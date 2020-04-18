package com.cg.pecuniabank.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.cg.pecuniabank.dto.EmployeeCredentials;
@Repository
public interface UserRepository extends JpaRepository<EmployeeCredentials,String>{

	EmployeeCredentials findByUsername(String username);
   //EmployeeCredentials findByUserName(String employeeId);
}
