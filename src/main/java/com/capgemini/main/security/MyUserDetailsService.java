package com.capgemini.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.EmployeeCredentials;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
     private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		EmployeeCredentials employee=repository.findByUsername(username);
		if(employee==null)
			throw new UsernameNotFoundException("Error: Employee does not exists");
		return new UserDetailsClass(employee);
	}

}
