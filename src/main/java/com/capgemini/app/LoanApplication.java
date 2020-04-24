package com.capgemini.app;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.app.dao.LoanDao;
import com.capgemini.app.dao.LoanDaoImplementation;
import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Request;
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
			
			
			
			Account accountManagement=new Account();
			Request loanRequest=new Request();
			accountManagement.setAccountNumber("872323432313");
			accountManagement.setAccountHolderName("Anjali Singh");
			accountManagement.setAccountBalance(7500);
			accountManagement.setAccountInterest("3.5");
			accountManagement.setCreditScore(450);
			loanRequest.setAccountNumber(accountManagement);
			loanRequest.setAmount(200000);
			loanRequest.setRoi(10.5);
			loanRequest.setTenure(6);
			loanRequest.setType("Home");
			
			
			Account accountManagement1=new Account();
			Request loanRequest1=new Request();
			accountManagement1.setAccountNumber("516118161782");
			accountManagement1.setAccountHolderName("Sonia Bhardwaaj");
			accountManagement1.setAccountBalance(8000);
			accountManagement1.setAccountInterest("3.5");
			accountManagement1.setCreditScore(740);
			loanRequest1.setAccountNumber(accountManagement1);
			loanRequest1.setAmount(700000);
			loanRequest1.setRoi(8.5);
			loanRequest1.setTenure(4);
			loanRequest1.setType("car");
			

			
			
			Account accountManagement3=new Account();
			Request loanRequest3=new Request();
			accountManagement3.setAccountNumber("998177885423");
			accountManagement3.setAccountHolderName("Manoj Kumar Meena");
			accountManagement3.setAccountBalance(5000);
			accountManagement3.setAccountInterest("3");
			accountManagement3.setCreditScore(900);
			loanRequest3.setAccountNumber(accountManagement3);
			loanRequest3.setAmount(300000);
			loanRequest3.setRoi(10);
			loanRequest3.setTenure(6);
			loanRequest3.setType("Education");
			
			
			loanDaoImplementation.insertAccountDetails(accountManagement);
			loanDaoImplementation.insertAccountDetails(accountManagement1);
			loanDaoImplementation.insertAccountDetails(accountManagement3);
			loanDaoImplementation.insertLoanRequest(loanRequest);
			loanDaoImplementation.insertLoanRequest(loanRequest1);

			loanDaoImplementation.insertLoanRequest(loanRequest3);
			
			
			//Requesting for a loan.
			loanService.loanProcess(loanRequest);
			
			
		}

	}
