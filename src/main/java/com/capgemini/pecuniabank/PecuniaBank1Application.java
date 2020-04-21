package com.capgemini.pecuniabank;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.pecuniabank.dao.LoanDaoImp;
import com.capgemini.pecuniabank.entity.AccountManagement;
import com.capgemini.pecuniabank.entity.LoanRequest;

	@SpringBootApplication
	public class PecuniaBank1Application implements CommandLineRunner{

		@Autowired
		LoanDaoImp loanDaoImp;
		
		
		public static void main(String[] args) {
			SpringApplication.run(PecuniaBank1Application.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			
			
			
			AccountManagement accountManagement=new AccountManagement();
			LoanRequest loanRequest=new LoanRequest();
			accountManagement.setAccountNumber("323232325657");
			accountManagement.setAccountHolderName("amardeep");
			accountManagement.setAccountBalance(3000000);
			accountManagement.setAccountInterest("12");
			accountManagement.setAccountStatus("active");
			accountManagement.setCreditScore(789);
			loanRequest.setAccountNumber(accountManagement);
			loanRequest.setAmount(200000);
			loanRequest.setRoi(10.5);
			loanRequest.setTenure(6);
			loanRequest.setType("Home");
			
			
			AccountManagement accountManagement1=new AccountManagement();
			LoanRequest loanRequest1=new LoanRequest();
			accountManagement1.setAccountNumber("323232999875");
			accountManagement1.setAccountHolderName("Deep");
			accountManagement1.setAccountBalance(2000000);
			accountManagement1.setAccountInterest("11");
			accountManagement1.setAccountStatus("closed");
			accountManagement1.setCreditScore(989);
			loanRequest1.setAccountNumber(accountManagement);
			loanRequest1.setAmount(300000);
			loanRequest1.setRoi(11.5);
			loanRequest1.setTenure(7);
			loanRequest1.setType("Home");
			
			AccountManagement accountManagement2=new AccountManagement();
			LoanRequest loanRequest2=new LoanRequest();
			accountManagement2.setAccountNumber("456752325657");
			accountManagement2.setAccountHolderName("Amar");
			accountManagement2.setAccountBalance(3450000);
			accountManagement2.setAccountInterest("10");
			accountManagement2.setAccountStatus("active");
			accountManagement2.setCreditScore(989);
			loanRequest2.setAccountNumber(accountManagement2);
			loanRequest2.setAmount(20456);
			loanRequest2.setRoi(9.5);
			loanRequest2.setTenure(9);
			loanRequest2.setType("Car");
			
			
			AccountManagement accountManagement3=new AccountManagement();
			LoanRequest loanRequest3=new LoanRequest();
			accountManagement3.setAccountNumber("998232325657");
			accountManagement3.setAccountHolderName("Rajawat");
			accountManagement3.setAccountBalance(80000);
			accountManagement3.setAccountInterest("11");
			accountManagement3.setAccountStatus("active");
			accountManagement3.setCreditScore(879);
			loanRequest3.setAccountNumber(accountManagement2);
			loanRequest3.setAmount(20000);
			loanRequest3.setRoi(10);
			loanRequest3.setTenure(4);
			loanRequest3.setType("Education");
			
			
			
			AccountManagement accountManagement4=new AccountManagement();
			LoanRequest loanRequest4=new LoanRequest();
			accountManagement4.setAccountNumber("883232325657");
			accountManagement4.setAccountHolderName("Singh");
			accountManagement4.setAccountBalance(1000000);
			accountManagement4.setAccountInterest("12");
			accountManagement4.setAccountStatus("active");
			accountManagement4.setCreditScore(950);
			loanRequest4.setAccountNumber(accountManagement4);
			loanRequest4.setAmount(70000);
			loanRequest4.setRoi(10.5);
			loanRequest4.setTenure(6);
			loanRequest4.setType("Home");
			
			
		}

	}

