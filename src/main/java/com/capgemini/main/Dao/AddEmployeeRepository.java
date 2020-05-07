package com.capgemini.main.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.main.entity.EmployeeCredentials;

public interface AddEmployeeRepository extends JpaRepository<EmployeeCredentials,String>{


}
