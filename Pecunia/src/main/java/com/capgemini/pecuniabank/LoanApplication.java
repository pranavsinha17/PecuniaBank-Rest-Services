package com.capgemini.pecuniabank;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.pecuniabank.dao.LoanDao;
import com.capgemini.pecuniabank.dao.LoanDaoImplementation;
import com.capgemini.pecuniabank.entity.Account;
import com.capgemini.pecuniabank.entity.Request;
import com.capgemini.pecuniabank.exception.UserException;
import com.capgemini.pecuniabank.service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;


	@SpringBootApplication
	public class LoanApplication implements CommandLineRunner{

		@Autowired
		LoanDaoImplementation loanDaoImplementation;
		
		@Autowired
		private LoanService loanService;
		
		
		public static void main(String[] args) {
			SpringApplication.run(LoanApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			
						
			
		}

	}
