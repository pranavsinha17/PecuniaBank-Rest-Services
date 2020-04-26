package com.cg.pecuniabank.passbook;

import java.time.LocalDateTime;

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

		// Account Details...

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
		CustomerDetails customer2Details = new CustomerDetails();

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

		AccountDetails account3Details = new AccountDetails();
		Address customer3Address = new Address();
		CustomerDetails customer3Details = new CustomerDetails();

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

		AccountDetails account4Details = new AccountDetails();
		Address customer4Address = new Address();
		CustomerDetails customer4Details = new CustomerDetails();

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

		AccountDetails account5Details = new AccountDetails();
		Address customer5Address = new Address();
		CustomerDetails customer5Details = new CustomerDetails();

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

		AccountDetails account6Details = new AccountDetails();
		Address customer6Address = new Address();
		CustomerDetails customer6Details = new CustomerDetails();

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

		AccountDetails account7Details = new AccountDetails();
		Address customer7Address = new Address();
		CustomerDetails customer7Details = new CustomerDetails();

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
		customer7Details.setAge("22");
		customer7Details.setGender("Male");
		customer7Address.setStreet("613,Austin Town Market");
		customer7Address.setState("Meerut");
		customer7Address.setCity("Uttar Pradesh");
		customer7Address.setZipCode("144001");
		customer7Details.setAddress(customer7Address);
		account7Details.setCustomerDetails(customer7Details);

		AccountDetails accountDetails8 = new AccountDetails();
		Address customer8Address = new Address();
		CustomerDetails customerDetails8 = new CustomerDetails();

		accountDetails8.setAccountNumber(425162626782L);
		customerDetails8.setCustomerFirstName("Vaishali");
		customerDetails8.setCustomerLastName("Tiwari");
		customerDetails8.setDOB("07/07/1998");
		customerDetails8.setAge("21");
		customerDetails8.setGender("Female");
		customerDetails8.setContactNumber("9815406012");
		customerDetails8.setPanNumber("QSWED234M");
		customerDetails8.setAdhaarNumber("3650 7451 9856");
		customerDetails8.setAccountType("Current");
		customerDetails8.setOpeningBalance("25000");
		customer8Address.setStreet("127/211 W-2 Juhi Kalan");
		customer8Address.setState("UP");
		customer8Address.setCity("Kanpur");
		customer8Address.setZipCode("208027");
		customerDetails8.setAddress(customer8Address);
		accountDetails8.setCustomerDetails(customerDetails8);
		accountDetails8.setAccountHolderName("Vaishali Tiwari");
		accountDetails8.setAccountStatus("Active");
		accountDetails8.setAccountBalance("25000");
		accountDetails8.setCreditScore("1400");
		accountDetails8.setAccountInterest("3");
		accountDetails8.setCreditScore("1400");
		accountDetails8.setBranchDetails(branchDetails1);

		
		AccountDetails accountDetails9 = new AccountDetails();
		Address customer9Address = new Address();
		CustomerDetails customerDetails9 = new CustomerDetails();
		
		accountDetails9.setAccountNumber(981727277272L);
		accountDetails9.setAccountHolderName("Ashish Singh");
		accountDetails9.setAccountInterest("3.5");
		accountDetails9.setCreditScore("980");
		accountDetails9.setAccountBalance("12000");
		accountDetails9.setAccountStatus("Active");
		accountDetails9.setBranchDetails(branchDetails1);
		customerDetails9.setOpeningBalance("12000");
		customerDetails9.setAccountType("Savings");
		customerDetails9.setAdhaarNumber("7485 8555 3330");
		customerDetails9.setContactNumber("9041459865");
		customerDetails9.setPanNumber("RTYUO852L");
		customerDetails9.setDOB("06/02/1998");
		customerDetails9.setCustomerFirstName("Ashish");
		customerDetails9.setCustomerLastName("Singh");
		customerDetails9.setAge("22");
		customerDetails9.setGender("Male");
		customer9Address.setStreet("58,Govindpura");
		customer9Address.setState("New Delhi");
		customer9Address.setCity("New Delhi");
		customer9Address.setZipCode("1110011");
		customerDetails9.setAddress(customer9Address);
		accountDetails9.setCustomerDetails(customerDetails9);
		
		
		AccountDetails accountDetails10=new AccountDetails();
		Address customer10Address=new Address();
		CustomerDetails customerDetails10=new CustomerDetails();
		
		account7Details.setAccountNumber(89081282283L);
		accountDetails10.setAccountHolderName("Vishal Tiwari");
		accountDetails10.setAccountInterest("3.5");
		accountDetails10.setCreditScore("500");
		accountDetails10.setAccountBalance("6000");
		accountDetails10.setAccountStatus("Active");
		accountDetails10.setBranchDetails(branchDetails2);

		customerDetails10.setOpeningBalance("6000");
		customerDetails10.setAccountType("Savings");
		customerDetails10.setAdhaarNumber("9652 2222 6000");
		customerDetails10.setContactNumber("7007820982");
		customerDetails10.setPanNumber("AATRE747P");
		customerDetails10.setDOB("23/10/1994");
		customerDetails10.setCustomerFirstName("Vishal");
		customerDetails10.setCustomerLastName("Tiwari");
		customerDetails10.setAge("26");
		customerDetails10.setGender("Male");
		customer10Address.setStreet("718,Collector Ganj");
		customer10Address.setState("UP");
		customer10Address.setCity("Unnao");
		customer10Address.setZipCode("209801");
		customerDetails10.setAddress(customer10Address);
		accountDetails10.setCustomerDetails(customerDetails10);
		
		//Account4
		AccountDetails accountDetails11=new AccountDetails();
		Address customer11Address=new Address();
		CustomerDetails customerDetails11=new CustomerDetails();
		
		account7Details.setAccountNumber(764893027479L);
        accountDetails11.setAccountHolderName("Mradula Shukla");
		accountDetails11.setAccountInterest("3");
		accountDetails11.setCreditScore("905");
		accountDetails11.setAccountBalance("8500");
		accountDetails11.setAccountStatus("Active");
		accountDetails11.setBranchDetails(branchDetails2);
        customerDetails11.setOpeningBalance("8500");
		customerDetails11.setAccountType("Current");
		customerDetails11.setAdhaarNumber("9854 4569 2345");
		customerDetails11.setContactNumber("8004255984");
		customerDetails11.setPanNumber("YTRFV664L");
		customerDetails11.setDOB("21/06/1994");
		customerDetails11.setCustomerFirstName("Mradula");
		customerDetails11.setCustomerLastName("Shukla");
		customerDetails11.setAge("44");
		customerDetails11.setGender("Female");
		customer11Address.setStreet("126,Sector-11");
		customer11Address.setState("Gujrat");
		customer11Address.setCity("Gandhi Nagar");
		customer11Address.setZipCode("362011");
		customerDetails11.setAddress(customer11Address);
		accountDetails11.setCustomerDetails(customerDetails11);
		customerDetails11.setAddress(customer11Address);
		accountDetails11.setCustomerDetails(customerDetails11);

		//Account5
		AccountDetails accountDetails12=new AccountDetails();
		Address customer12Address=new Address();
		CustomerDetails customerDetails12=new CustomerDetails();
		accountDetails12.setAccountHolderName("Anushkaa Awasthi");
		accountDetails12.setAccountInterest("3");
		accountDetails12.setCreditScore("700");
		accountDetails12.setAccountBalance("9700");
		accountDetails12.setAccountStatus("Active");
		accountDetails12.setBranchDetails(branchDetails3);
		customerDetails12.setOpeningBalance("9700");
		customerDetails12.setAccountType("Current");
		customerDetails12.setAdhaarNumber("7458 5464 2545");
		customerDetails12.setContactNumber("8317016118");
		customerDetails12.setPanNumber("QCFRE856F");
		customerDetails12.setDOB("06/04/1989");
		customerDetails12.setCustomerFirstName("Anushkaa");
		customerDetails12.setCustomerLastName("Awasthi");
		customerDetails12.setAge("31");
		customerDetails12.setGender("Female");
		customer12Address.setStreet("2-9-2,Arihant Majestiv Towers");
		customer12Address.setState("Tamil Nadu");
		customer12Address.setCity("Chennai");
		customer12Address.setZipCode("600107");
		customerDetails12.setAddress(customer12Address);
		accountDetails12.setCustomerDetails(customerDetails12);
		customerDetails12.setAddress(customer12Address);
		accountDetails12.setCustomerDetails(customerDetails12);

		//Account6
		AccountDetails accountDetails13=new AccountDetails();
		Address customer13Address=new Address();
		CustomerDetails customerDetails13=new CustomerDetails();
		accountDetails13.setAccountHolderName("Prabhjot");
		accountDetails13.setAccountInterest("3");
		accountDetails13.setCreditScore("1250");
		accountDetails13.setAccountBalance("5000");
		accountDetails13.setAccountStatus("Active");
		accountDetails13.setBranchDetails(branchDetails3);
		customerDetails13.setOpeningBalance("5000");
		customerDetails13.setAccountType("Current");
		customerDetails13.setAdhaarNumber("9656 4565 2421");
		customerDetails13.setContactNumber("8968117732");
		customerDetails13.setPanNumber("TYRFD567P");
		customerDetails13.setDOB("05/03/1997");
		customerDetails13.setCustomerFirstName("Prabhjot");
		customerDetails13.setCustomerLastName("Kaur");
		customerDetails13.setAge("23");
		customerDetails13.setGender("Female");
		customer13Address.setStreet("900,Bhagat Singh Nagar Model House");
		customer13Address.setState("Punjab");
		customer13Address.setCity("Jalandhar");
		customer13Address.setZipCode("144003");
		customerDetails13.setAddress(customer13Address);
		accountDetails13.setCustomerDetails(customerDetails13);
		customerDetails13.setAddress(customer13Address);
		accountDetails13.setCustomerDetails(customerDetails13);
								
		//Account 7
		AccountDetails accountDetails14=new AccountDetails();
		Address customer14Address=new Address();
		CustomerDetails customerDetails14=new CustomerDetails();
		
		accountDetails14.setAccountHolderName("Rahul Bajaj");
		accountDetails14.setAccountInterest("3.5");
		accountDetails14.setCreditScore("2200");
		accountDetails14.setAccountBalance("7500");
		accountDetails14.setAccountStatus("Active");
		accountDetails14.setBranchDetails(branchDetails3);
		customerDetails14.setOpeningBalance("7500");
		customerDetails14.setAccountType("Savings");
		customerDetails14.setAdhaarNumber("7546 8598 2115");
		customerDetails14.setContactNumber("9415546297");
		customerDetails14.setPanNumber("ASWED099D");
		customerDetails14.setDOB("04/12/1978");
		customerDetails14.setCustomerFirstName("Rahul");
		customerDetails14.setCustomerLastName("Bajaj");
		customerDetails14.setAge("42");
		customerDetails14.setGender("Male");
		customer14Address.setStreet("101 Circular Rd, Bemloi");
		customer14Address.setState("Himachal Pradesh");
		customer14Address.setCity("Shimla");
		customer14Address.setZipCode("171001");
		customerDetails14.setAddress(customer14Address);
		accountDetails14.setCustomerDetails(customerDetails14);
		customerDetails14.setAddress(customer14Address);
		accountDetails14.setCustomerDetails(customerDetails14);

		//Account 8
		AccountDetails accountDetails15=new AccountDetails();
		Address customer15Address=new Address();
		CustomerDetails customerDetails15=new CustomerDetails();
		
		accountDetails15.setAccountHolderName("Amardeep Singh");
		accountDetails15.setAccountInterest("3");
		accountDetails15.setCreditScore("300");
		accountDetails15.setAccountBalance("9000");
		accountDetails15.setAccountStatus("Active");
		accountDetails15.setBranchDetails(branchDetails2);
		customerDetails15.setOpeningBalance("9000");
		customerDetails15.setAccountType("Current");
		customerDetails15.setAdhaarNumber("4829 5542 8768");
		customerDetails15.setContactNumber("8840864659");
		customerDetails15.setPanNumber("PYGTF467P");
		customerDetails15.setDOB("03/05/1990");
		customerDetails15.setCustomerFirstName("Amardeep");
		customerDetails15.setCustomerLastName("Singh");
		customerDetails15.setAge("30");
		customerDetails15.setGender("Male");
		customer15Address.setStreet("Gujela, Ghatampur");
		customer15Address.setState("Uttar Pradesh");
		customer15Address.setCity("Kanpur");
		customer15Address.setZipCode("209206");
		customerDetails15.setAddress(customer15Address);
		accountDetails15.setCustomerDetails(customerDetails15);
		customerDetails15.setAddress(customer15Address);
		accountDetails15.setCustomerDetails(customerDetails15);
		      
		//Account 9
		AccountDetails accountDetails16=new AccountDetails();
		Address customer16Address=new Address();
		CustomerDetails customerDetails16=new CustomerDetails();
		accountDetails16.setAccountHolderName("Satyam Sinha");
		accountDetails16.setAccountInterest("3.5");
		accountDetails16.setCreditScore("1610");
		accountDetails16.setAccountBalance("20000");
		accountDetails16.setAccountStatus("Active");
		accountDetails16.setBranchDetails(branchDetails4);
		customerDetails16.setOpeningBalance("20000");
		customerDetails16.setAccountType("Savings");
		customerDetails16.setAdhaarNumber("6985 2345 6528");
		customerDetails16.setContactNumber("9973060640");
		customerDetails16.setPanNumber("BSTUM8565M");
		customerDetails16.setDOB("02/04/1984");
		customerDetails16.setCustomerFirstName("Satyam");
		customerDetails16.setCustomerLastName("Sinha");
		customerDetails16.setAge("36");
		customerDetails16.setGender("Male");
		customer16Address.setStreet("East off Bustand, Gangjala");
		customer16Address.setState("Bihar");
		customer16Address.setCity("Saharasa");
		customer16Address.setZipCode("855201");
		customerDetails16.setAddress(customer16Address);
		accountDetails16.setCustomerDetails(customerDetails16);
		customerDetails16.setAddress(customer16Address);
		accountDetails16.setCustomerDetails(customerDetails16);		
				
		//Account 10
		AccountDetails accountDetails17=new AccountDetails();
		Address customer17Address=new Address();
		CustomerDetails customerDetails17=new CustomerDetails();
		accountDetails17.setAccountHolderName("Pranav Kapoor");
		accountDetails17.setAccountInterest("3.5");
		accountDetails17.setCreditScore("1980");
		accountDetails17.setAccountBalance("5600");
		accountDetails17.setAccountStatus("Active");
		accountDetails17.setBranchDetails(branchDetails5);
		customerDetails17.setOpeningBalance("5600");
		customerDetails17.setAccountType("Savings");
		customerDetails17.setAdhaarNumber("5298 1114 8262");
		customerDetails17.setContactNumber("9115513073");
		customerDetails17.setPanNumber("APMUT485B");
		customerDetails17.setDOB("03/10/1992");
		customerDetails17.setCustomerFirstName("Pranav");
		customerDetails17.setCustomerLastName("Kapoor");
		customerDetails17.setAge("28");
		customerDetails17.setGender("Male");
		customer17Address.setStreet("Near Ashram Marg, Jawahar Circle");
		customer17Address.setState("Rajasthan");
		customer17Address.setCity("Jaipur");
		customer17Address.setZipCode("302015");
		customerDetails17.setAddress(customer17Address);
		accountDetails17.setCustomerDetails(customerDetails17);
		customerDetails17.setAddress(customer17Address);
		accountDetails17.setCustomerDetails(customerDetails17);
						
	
		service.insertAccountDetails(accountDetails);
		service.insertAccountDetails(account1Details);
		service.insertAccountDetails(account3Details);
		service.insertAccountDetails(account4Details);
		service.insertAccountDetails(account5Details);
		service.insertAccountDetails(account6Details);
		service.insertAccountDetails(account7Details);
	//	service.insertAccountDetails(accountDetails8);
	//	service.insertAccountDetails(accountDetails9);
	//	service.insertAccountDetails(accountDetails10);
	//	service.insertAccountDetails(accountDetails11);
		//service.insertAccountDetails(accountDetails12);
		//service.insertAccountDetails(accountDetails13);
		//service.insertAccountDetails(accountDetails14);
		//service.insertAccountDetails(accountDetails15);
		//service.insertAccountDetails(accountDetails16);
		//service.insertAccountDetails(accountDetails17);
		
		
		
		//Transaction Details...

		Transaction transaction = new Transaction();
		transaction.setAccountNumber(123424283939L);
		transaction.setBenificaryName("Kamal Roy");
		transaction.setBenificaryAccoountNumber("321456789100");
		transaction.setTransactionAmount("7000");
		transaction.setTransactionOption("Slip");
		transaction.setTransactionStatus("Success");
		transaction.setTransactionType("Credit");
		LocalDateTime transactionDate = LocalDateTime.of(2019, 03, 01, 11, 30);
		transaction.setTransactionDate(transactionDate);
		transaction.setBankName("SBI Bank");

		Transaction transaction1 = new Transaction();
		transaction1.setAccountNumber(123424283939L);
		transaction1.setBenificaryName("Preeti kaur");
		transaction1.setBenificaryAccoountNumber("328799954326");
		transaction1.setTransactionAmount("8000");
		transaction1.setTransactionOption("Slip");
		transaction1.setTransactionStatus("Success");
		transaction1.setTransactionType("Credit");
		LocalDateTime transactionDate1 = LocalDateTime.of(2019, 04, 01, 16, 30);

		transaction1.setTransactionDate(transactionDate1);
		transaction1.setBankName("ICIC Bank");

		Transaction transaction3 = new Transaction();
		transaction3.setAccountNumber(123424283939L);
		transaction3.setBenificaryName("Sahil Saini");
		transaction3.setBenificaryAccoountNumber("898989876665");
		transaction3.setTransactionAmount("7000");
		transaction3.setTransactionOption("Slip");
		transaction3.setTransactionStatus("Success");
		transaction3.setTransactionType("Debit");
		LocalDateTime transactionDate3 = LocalDateTime.of(2019, 05, 12, 14, 30);
		transaction3.setTransactionDate(transactionDate3);
		transaction3.setBankName("SBI Bank");

		Transaction transaction4 = new Transaction();
		transaction4.setAccountNumber(123424283939L);
		transaction4.setBenificaryName("Preeti kaur");
		transaction4.setBenificaryAccoountNumber("321456789100");
		transaction4.setTransactionAmount("2000");
		transaction4.setTransactionOption("Slip");
		transaction4.setTransactionStatus("Success");
		transaction4.setTransactionType("Debit");
		LocalDateTime transactionDate4 = LocalDateTime.of(2019, 07, 11, 19, 30);
		transaction4.setTransactionDate(transactionDate4);
		transaction4.setBankName("ICIC Bank");

		Transaction transaction5 = new Transaction();
		transaction5.setAccountNumber(123424283939L);
		transaction5.setBenificaryName("Kamal Roy");
		transaction5.setBenificaryAccoountNumber("321456789100");
		transaction5.setTransactionAmount("7000");
		transaction5.setTransactionOption("Slip");
		transaction5.setTransactionStatus("Success");
		transaction5.setTransactionType("Credit");
		LocalDateTime transactionDate5 = LocalDateTime.of(2019, 9, 01, 11, 30);
		transaction5.setTransactionDate(transactionDate5);
		transaction5.setBankName("SBI Bank");

		service.insertTransactionDetails(transaction);
		service.insertTransactionDetails(transaction1);
		service.insertTransactionDetails(transaction3);
		service.insertTransactionDetails(transaction4);
		service.insertTransactionDetails(transaction5);
	}
}
