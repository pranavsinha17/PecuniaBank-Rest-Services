package com.capgemini.app;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.app.dao.LoanDao;
import com.capgemini.app.dao.LoanDaoImplementation;
import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Request;
import com.capgemini.app.exception.UserException;
import com.capgemini.app.service.LoanService;

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
			
			
			
		

			
			
		/*	Account accountManagement3=new Account();
			Request loanRequest3=new Request();
			accountManagement3.setAccountNumber("123456780000");
			accountManagement3.setAccountHolderName("Prabhjot");
			accountManagement3.setAccountBalance(230000);
			accountManagement3.setAccountInterest(3);
			accountManagement3.setCreditScore(725);
			loanDaoImplementation.insertAccountDetails(accountManagement3);
		/*	loanRequest3.setAccountNumber("500000115014");
			loanRequest3.setAmount(100000);
			loanRequest3.setRoi(8);
			loanRequest3.setTenure(6);
			loanRequest3.setType("Personal");
			
			
		//	loanDaoImplementation.insertAccountDetails(accountManagement);
		//	loanDaoImplementation.insertAccountDetails(accountManagement1);
			loanDaoImplementation.insertAccountDetails(accountManagement3);
		//	loanDaoImplementation.insertLoanRequest(loanRequest);
			//loanDaoImplementation.insertLoanRequest(loanRequest1);

			loanDaoImplementation.insertLoanRequest(loanRequest3);
			
			//Requesting for a loan
		
	/*		try {
			loanService.loanProcess(loanRequest3);
			}
	     catch (UserException e) {
				
				System.out.println(""+e);
			}
			loanService.viewAll();
			
			
*/
			
			
		}

	}
