package com.cg.pecuniabank.passbook;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.pecuniabank.passbook.entity.AccountDetails;
import com.cg.pecuniabank.passbook.entity.Address;
import com.cg.pecuniabank.passbook.entity.BranchDetails;
import com.cg.pecuniabank.passbook.entity.CustomerDetails;
import com.cg.pecuniabank.passbook.entity.Transaction;
import com.cg.pecuniabank.passbook.service.PassbookService;

@SpringBootApplication
public class PecuniaBankApplication implements CommandLineRunner {

	@Autowired
	PassbookService service;

	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BranchDetails branchDetails1 = new BranchDetails();
		Address address1 = new Address();
		address1.setCity("PHAGWARA");
		address1.setStreet("UNI MALL,LPU");
		address1.setState("PUNJAB");
		address1.setZipCode("144401");
		branchDetails1.setBranchName("LPU PECUNIA");
		branchDetails1.setPhoneNumber("2201");
		branchDetails1.setAddress(address1);
		branchDetails1.setBranchIFSC("PUNB033950");

		BranchDetails branchDetails2 = new BranchDetails();
		Address address2 = new Address();
		address2.setCity("KANPUR");
		address2.setStreet("RAJA PARK");
		address2.setState("UP");
		address2.setZipCode("815520");
		branchDetails2.setBranchName("KANPUR PECUNIA");
		branchDetails2.setPhoneNumber("2202");
		branchDetails2.setAddress(address2);
		branchDetails2.setBranchIFSC("PUNB033951");

		BranchDetails branchDetails3 = new BranchDetails();
		Address address3 = new Address();
		address3.setCity("JAIPUR");
		address3.setStreet("GHANTA GHAR");
		address3.setState("RAJASTHAN");
		address3.setZipCode("808124");
		branchDetails3.setBranchName("JAIPUR PECUNIA");
		branchDetails3.setPhoneNumber("2203");
		branchDetails3.setAddress(address3);
		branchDetails3.setBranchIFSC("PUNB033952");

		BranchDetails branchDetails4 = new BranchDetails();
		Address address4 = new Address();
		address4.setCity("SAHARSA");
		address4.setStreet("GANGJALA");
		address4.setState("BIHAR");
		address4.setZipCode("852201");
		branchDetails4.setBranchName("SAHARSA PECUNIA");
		branchDetails4.setPhoneNumber("2204");
		branchDetails4.setAddress(address4);
		branchDetails4.setBranchIFSC("PUNB033953");

		BranchDetails branchDetails5 = new BranchDetails();
		Address address5 = new Address();
		address5.setCity("NEW DELHI");
		address5.setStreet("RAJIV CHOWK");
		address5.setState("NEW DELHI");
		address5.setZipCode("141101");
		branchDetails5.setBranchName("DELHI PECUNIA");
		branchDetails5.setPhoneNumber("2205");
		branchDetails5.setAddress(address5);
		branchDetails5.setBranchIFSC("PUNB033954");

		service.insertBranchDetails(branchDetails1);
		service.insertBranchDetails(branchDetails2);
		service.insertBranchDetails(branchDetails3);
		service.insertBranchDetails(branchDetails4);
		service.insertBranchDetails(branchDetails5);

		AccountDetails accountDetails = new AccountDetails();
		Address customer1Address = new Address();
		CustomerDetails customerDetails1 = new CustomerDetails();

		accountDetails.setAccountNumber(123456788912L);
		accountDetails.setAccountHolderName("Abhay Sonkhla");
		accountDetails.setAccountInterest("3.5");
		accountDetails.setCreditScore("1700");
		accountDetails.setAccountBalance("7000");
		accountDetails.setAccountStatus("Active");
		accountDetails.setBranchDetails(branchDetails1);

		customerDetails1.setOpeningBalance("7000");
		customerDetails1.setAccountType("Savings");
		customerDetails1.setAdhaarNumber("4444 2222 7878");
		customerDetails1.setContactNumber("9882522687");
		customerDetails1.setPanNumber("AHSGI787F");
		customerDetails1.setDOB("19/05/1998");
		customerDetails1.setCustomerFirstName("Abhay");
		customerDetails1.setCustomerLastName("Sonkhla");
		customerDetails1.setAge("21");
		customerDetails1.setGender("Male");
		customer1Address.setStreet("529,PWD Colony Near Lohna Estate");
		customer1Address.setState("Himachal Pardesh");
		customer1Address.setCity("Palampur");
		customer1Address.setZipCode("170091");
		customerDetails1.setAddress(customer1Address);
		accountDetails.setCustomerDetails(customerDetails1);

		AccountDetails account1Details = new AccountDetails();
		Address customer2Address = new Address();
		CustomerDetails customer2Details=new CustomerDetails();

		account1Details.setAccountNumber(123424283939L);
		account1Details.setAccountHolderName("Sujey Singh");
		account1Details.setAccountInterest("3");
		account1Details.setCreditScore("718");
		account1Details.setAccountBalance("5000");
		account1Details.setAccountStatus("Active");
		account1Details.setBranchDetails(branchDetails1);

		customer2Details.setOpeningBalance("5000");
		customer2Details.setAccountType("Current");
		customer2Details.setAdhaarNumber("7899 8123 76262");
		customer2Details.setContactNumber("7389881849");
		customer2Details.setPanNumber("PJKLQ757D");
		customer2Details.setDOB("19/09/1997");
		customer2Details.setCustomerFirstName("Sujey");
		customer2Details.setCustomerLastName("Singh");
		customer2Details.setAge("22");
		customer2Details.setGender("Male");
		customer2Address.setStreet("423,Ghai Nagar Colony");
		customer2Address.setState("Madhya Pardesh");
		customer2Address.setCity("Bhopal");
		customer2Address.setZipCode("140038");
		customer2Details.setAddress(customer2Address);
		account1Details.setCustomerDetails(customer2Details);

		
		  AccountDetails account3Details=new AccountDetails();
		  Address customer3Address=new Address();
		  CustomerDetails customer3Details=new CustomerDetails();
		  
		  account3Details.setAccountNumber(789782828282L);
		  account3Details.setAccountHolderName("Dripti Sinha");
		  account3Details.setAccountInterest("3");
		  account3Details.setCreditScore("800");
		  account3Details.setAccountBalance("8000");
		  account3Details.setAccountStatus("Active");
		  account3Details.setBranchDetails(branchDetails1);
		  
		  customer3Details.setOpeningBalance("8000");
		  customer3Details.setAccountType("Savings");
		  customer3Details.setAdhaarNumber("4513 7868 9911");
		  customer3Details.setContactNumber("9814098995");
		  customer3Details.setPanNumber("KILAK651W");
		  customer3Details.setDOB("23/06/1998");
		  customer3Details.setCustomerFirstName("Dripti");
		  customer3Details.setCustomerLastName("Sinha");
		  customer3Details.setAge("21");
		  customer3Details.setGender("Female");
		  customer3Address.setStreet("989,G.T.B Nagar Road");
		  customer3Address.setState("Punjab");
		  customer3Address.setCity("Jalandhar");
		  customer3Address.setZipCode("140001");
		  customer3Details.setAddress(customer3Address);
		  account3Details.setCustomerDetails(customer3Details);
		  
		  AccountDetails account4Details=new AccountDetails(); 
		  Address customer4Address=new Address();
		  CustomerDetails customer4Details=new CustomerDetails();
		  
		  account4Details.setAccountNumber(738383883892L);
		  account4Details.setAccountHolderName("Renu Huria");
		  account4Details.setAccountInterest("3");
		  account4Details.setCreditScore("1200");
		  account4Details.setAccountBalance("8500");
		  account4Details.setAccountStatus("Active");
		  account4Details.setBranchDetails(branchDetails2);
		  
		  customer4Details.setOpeningBalance("8500");
		  customer4Details.setAccountType("Savings");
		  customer4Details.setAdhaarNumber("5423 0099 6677");
		  customer4Details.setContactNumber("7896541326");
		  customer4Details.setPanNumber("AHKLG765J");
		  customer4Details.setDOB("03/06/1998");
		  customer4Details.setCustomerFirstName("Renu");
		  customer4Details.setCustomerLastName("Huria"); 
		  customer4Details.setAge("21");
		  customer4Details.setGender("Female");
		  customer4Address.setStreet("514,New Kartar Colony Model Town");
		  customer4Address.setState("Punjab");
		  customer4Address.setCity("Jalandhar");
		  customer4Address.setZipCode("140008");
		  customer4Details.setAddress(customer4Address);
		  account4Details.setCustomerDetails(customer4Details);
		  
		  
		  AccountDetails account5Details=new AccountDetails();
		  Address customer5Address=new Address(); 
		  CustomerDetails customer5Details=new CustomerDetails();
		 
		  account5Details.setAccountNumber(987865673421L);
		  account5Details.setAccountHolderName("Manoj Kumar Meena");
		  account5Details.setAccountInterest("3.5");
		  account5Details.setCreditScore("1000");
		  account5Details.setAccountBalance("5000");
		  account5Details.setAccountStatus("Active");
		  account5Details.setBranchDetails(branchDetails2);
		  
		  customer5Details.setOpeningBalance("5000");
		  customer5Details.setAccountType("Savings");
		  customer5Details.setAdhaarNumber("5141 9823  6151");
		  customer5Details.setContactNumber("8146409991");
		  customer5Details.setPanNumber("AHKLG765J");
		  customer5Details.setDOB("05/05/1998");
		  customer5Details.setCustomerFirstName("Manoj Kumar");
		  customer5Details.setCustomerLastName("Meena"); 
		  customer5Details.setAge("21");
		  customer5Details.setGender("Male");
		  customer5Address.setStreet("152,Zinc Colony Hurda");
		  customer5Address.setState("Bhilwara"); 
		  customer5Address.setCity("Rajasthan");
		  customer5Address.setZipCode("311002");
		  customer5Details.setAddress(customer5Address);
		  account5Details.setCustomerDetails(customer5Details);
		  
		  
		  AccountDetails account6Details=new AccountDetails();
		  Address customer6Address=new Address();
		  CustomerDetails customer6Details=new CustomerDetails();
		  
		  
		  account6Details.setAccountNumber(745636378921L);
		  account6Details.setAccountHolderName("Anjali Singh");
		  account6Details.setAccountInterest("3");
		  account6Details.setCreditScore("800");
		  account6Details.setAccountBalance("7500");
		  account6Details.setAccountStatus("Active");
		  account6Details.setBranchDetails(branchDetails2);
		  
		  customer6Details.setOpeningBalance("7500");
		  customer6Details.setAccountType("Savings");
		  customer6Details.setAdhaarNumber("6667 8768 9142");
		  customer6Details.setContactNumber("8210123908");
		  customer6Details.setPanNumber("TREHA876Y");
		  customer6Details.setDOB("23/06/1997");
		  customer6Details.setCustomerFirstName("Anjali");
		  customer6Details.setCustomerLastName("Singh"); 
		  customer6Details.setAge("22");
		  customer6Details.setGender("Female");
		  customer6Address.setStreet("55,Shastri Market Road");
		  customer6Address.setState("Dhanbaad"); 
		  customer6Address.setCity("Bihar");
		  customer6Address.setZipCode("100451");
		  customer6Details.setAddress(customer6Address);
		  account6Details.setCustomerDetails(customer6Details);
		  
		  
		  
		  AccountDetails account7Details=new AccountDetails();
		  Address customer7Address=new Address(); 
		  CustomerDetails customer7Details=new CustomerDetails();
		  
		  account7Details.setAccountNumber(764893027473L);
		  account7Details.setAccountHolderName("Ayush Chaudhary");
		  account7Details.setAccountInterest("3.5");
		  account7Details.setCreditScore("450");
		  account7Details.setAccountBalance("6000");
		  account7Details.setAccountStatus("Active");
		  account7Details.setBranchDetails(branchDetails3);
		  
		  customer7Details.setOpeningBalance("6000");
		  customer7Details.setAccountType("Savings");
		  customer7Details.setAdhaarNumber("8918 8171 8181");
		  customer7Details.setContactNumber("9557102414");
		  customer7Details.setPanNumber("TREHA876Y");
		  customer7Details.setDOB("06/06/1997");
		  customer7Details.setCustomerFirstName("Ayush");
		  customer7Details.setCustomerLastName("Chaudhary");
		  customer7Details.setAge("22"); customer7Details.setGender("Male");
		  customer7Address.setStreet("613,Austin Town Market");
		  customer7Address.setState("Meerut");
		  customer7Address.setCity("Uttar Pradesh");
		  customer7Address.setZipCode("144001");
		  customer7Details.setAddress(customer7Address);
		  account7Details.setCustomerDetails(customer7Details);
		  
		  
		 
		service.insertAccountDetails(accountDetails);
		service.insertAccountDetails(account1Details);
		service.insertAccountDetails(account3Details);
	    service.insertAccountDetails(account4Details);
	    service.insertAccountDetails(account5Details);
		service.insertAccountDetails(account6Details);
		service.insertAccountDetails(account7Details);
		
		
		Transaction transaction=new Transaction();
		transaction.setAccountNumber(123424283939L);
		transaction.setBenificaryName("Kamal Roy");
		transaction.setBenificaryAccoountNumber("321456789100");
		transaction.setTransactionAmount("7000");
		transaction.setTransactionOption("Slip");
		transaction.setTransactionStatus("Success");
		transaction.setTransactionType("Credit");
		LocalDate transactionDate=LocalDate.of(1998,04,23);
		transaction.setTransactionDate(transactionDate);
		transaction.setBankName("SBI Bank");
		

		Transaction transaction1=new Transaction();
		transaction1.setAccountNumber(123424283939L);
		transaction1.setBenificaryName("Preeti kaur");
		transaction1.setBenificaryAccoountNumber("328799954326");
		transaction1.setTransactionAmount("8000");
		transaction1.setTransactionOption("Slip");
		transaction1.setTransactionStatus("Success");
		transaction1.setTransactionType("Credit");
		LocalDate transactionDate1=LocalDate.of(2019,04,23);
		transaction1.setTransactionDate(transactionDate1);
		transaction1.setBankName("ICIC Bank");
		

		Transaction transaction3=new Transaction();
		transaction3.setAccountNumber(123424283939L);
		transaction3.setBenificaryName("Sahil Saini");
		transaction3.setBenificaryAccoountNumber("898989876665");
		transaction3.setTransactionAmount("7000");
		transaction3.setTransactionOption("Slip");
		transaction3.setTransactionStatus("Success");
		transaction3.setTransactionType("Debit");
		LocalDate transactionDate3=LocalDate.of(2019,04,28);
		transaction3.setTransactionDate(transactionDate3);
		transaction3.setBankName("SBI Bank");
		

		Transaction transaction4=new Transaction();
		transaction4.setAccountNumber(123424283939L);
		transaction4.setBenificaryName("Preeti kaur");
		transaction4.setBenificaryAccoountNumber("321456789100");
		transaction4.setTransactionAmount("2000");
		transaction4.setTransactionOption("Slip");
		transaction4.setTransactionStatus("Success");
		transaction4.setTransactionType("Debit");
		LocalDate transactionDate4=LocalDate.of(2019,05,20);
		transaction4.setTransactionDate(transactionDate4);
		transaction4.setBankName("ICIC Bank");
		

		Transaction transaction5=new Transaction();
		transaction5.setAccountNumber(123424283939L);
		transaction5.setBenificaryName("Kamal Roy");
		transaction5.setBenificaryAccoountNumber("321456789100");
		transaction5.setTransactionAmount("7000");
		transaction5.setTransactionOption("Slip");
		transaction5.setTransactionStatus("Success");
		transaction5.setTransactionType("Credit");
		LocalDate transactionDate5=LocalDate.of(2019,06,21);
		transaction5.setTransactionDate(transactionDate5);
		transaction5.setBankName("SBI Bank");
		
		service.insertTransactionDetails(transaction);
		service.insertTransactionDetails(transaction1);
		service.insertTransactionDetails(transaction3);
		service.insertTransactionDetails(transaction4);
		service.insertTransactionDetails(transaction5);
		
	}
}
