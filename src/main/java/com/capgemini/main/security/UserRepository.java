package com.capgemini.main.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.main.entity.EmployeeCredentials;

@Repository
public interface UserRepository extends JpaRepository<EmployeeCredentials,String>{

	EmployeeCredentials findByUsername(String username);
   //EmployeeCredentials findByUserName(String employeeId);
}
