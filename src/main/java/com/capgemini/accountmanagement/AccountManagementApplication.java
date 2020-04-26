package com.capgemini.accountmanagement;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.accountmanagement.dao.DaoService;
import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.Address;
import com.capgemini.accountmanagement.entity.BranchDetails;
import com.capgemini.accountmanagement.entity.CustomerDetails;
import com.capgemini.accountmanagement.entity.EmployeeCredentials;
import com.capgemini.accountmanagement.entity.EmployeeDetails;

@SpringBootApplication
public class AccountManagementApplication implements CommandLineRunner{
	
	@Autowired
	DaoService daoService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(AccountManagementApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		//Branch details 
		BranchDetails branchDetails1=new BranchDetails();
		Address address1=new Address();
		address1.setStreet("UNI MALL,LPU");
		address1.setCity("PHAGWARA");
		address1.setState("PUNJAB");
		address1.setZipCode("144401");
		branchDetails1.setBranchName("LPU PECUNIA");
		branchDetails1.setBranchIFSC("PUNB033950");
		branchDetails1.setPhoneNumber("2201");
		branchDetails1.setAddress(address1);
		
		
		BranchDetails branchDetails2=new BranchDetails();
		Address address2=new Address();
		address2.setStreet("RAJA PARK");
		address2.setCity("KANPUR");
		address2.setState("UP");
		address2.setZipCode("815520");
		branchDetails2.setBranchName("KANPUR PECUNIA");
		branchDetails2.setBranchIFSC("PUNB033951");
		branchDetails2.setPhoneNumber("2202");
		branchDetails2.setAddress(address2);
		
		
		BranchDetails branchDetails3=new BranchDetails();
		Address address3=new Address();
		address3.setStreet("GHANTA GHAR");
		address3.setCity("JAIPUR");
		address3.setState("RAJASTHAN");
		address3.setZipCode("808124");
		branchDetails3.setBranchName("JAIPUR PECUNIA");
		branchDetails3.setBranchIFSC("PUNB033952");
		branchDetails3.setPhoneNumber("2203");
		branchDetails3.setAddress(address3);

		
		BranchDetails branchDetails4=new BranchDetails();
		Address address4=new Address();
		address4.setStreet("GANGJALA");
		address4.setCity("SAHARSA");
		address4.setState("BIHAR");
		address4.setZipCode("852201");
		branchDetails4.setBranchName("SAHARSA PECUNIA");
		branchDetails4.setBranchIFSC("PUNB033953");
		branchDetails4.setPhoneNumber("2204");
		branchDetails4.setAddress(address4);
		
		
		BranchDetails branchDetails5=new BranchDetails();
		Address address5=new Address();
		address5.setStreet("RAJIV CHOWK");
		address5.setCity("NEW DELHI");
		address5.setState("NEW DELHI");
		address5.setZipCode("141101");
		branchDetails5.setBranchName("DELHI PECUNIA");
		branchDetails5.setBranchIFSC("PUNB033954");
		branchDetails5.setPhoneNumber("2205");
		branchDetails5.setAddress(address5);
	
		
		daoService.insertBranchDetails(branchDetails1);
		daoService.insertBranchDetails(branchDetails2);
		daoService.insertBranchDetails(branchDetails3);
		daoService.insertBranchDetails(branchDetails4);
		daoService.insertBranchDetails(branchDetails5);
		
		//employee credentials
		
		
		EmployeeDetails employee1details=new EmployeeDetails();
		Address employee1Address=new Address();
		EmployeeCredentials employee1=new EmployeeCredentials();
		
		employee1.setEmployeeId("116001");//empNumber
		employee1.setEmployeePassword("satyam118001");
		employee1.setEmployeeDetails(employee1details);//Firstname + branchid
		employee1details.setBranchId(118001);
		employee1details.setEmployeeFirstName("Satyam");
		employee1details.setEmployeeLastName("Sinha");
		employee1details.setDOB("04/02/1999");
		employee1details.setAge("21");
		employee1details.setGender("Male");
		employee1details.setPanNumber("QSWBG125L");
		employee1details.setAdharNumber("1598 3652 6984");
		employee1details.setMobileNumber("7789548230");
		employee1Address.setStreet("East of Bus Stand Gangajala");
		employee1Address.setCity("Saharsa");
		employee1Address.setState("Bihar");
		employee1Address.setZipCode("852201");
		employee1details.setAddress(employee1Address);
		
	    EmployeeCredentials employee2=new EmployeeCredentials();
		EmployeeDetails employee2details=new EmployeeDetails();
		Address employee2Address=new Address();
		
		employee2.setEmployeeId("116002");//empNumber
		employee2.setEmployeePassword("pranav118002");//Firstname + branchid
		employee2.setEmployeeDetails(employee2details);
		employee2details.setBranchId(118002);
		employee2details.setEmployeeFirstName("Pranav");
		employee2details.setEmployeeLastName("Sinha");
		employee2details.setDOB("14/06/1998");
		employee2details.setAge("22");
		employee2details.setGender("Male");
		employee2details.setPanNumber("QSPFG325S");
		employee2details.setAdharNumber("1698 3152 2084");
		employee2details.setMobileNumber("9963528412");
		employee2Address.setStreet("Near ram chowk");
		employee2Address.setCity("jaipur");
		employee2Address.setCity("Rajasthan");
		employee2Address.setZipCode("808124");
		employee2details.setAddress(employee2Address);
		
		EmployeeCredentials employee3=new EmployeeCredentials();
		EmployeeDetails employee3details=new EmployeeDetails();
		Address employee3Address=new Address();
		employee3.setEmployeeId("116003");//empNumber
		employee3.setEmployeePassword("vaishali118002");//Firstname + branchid
		employee1.setEmployeeDetails(employee3details);
		employee3details.setBranchId(118003);
		employee3details.setEmployeeFirstName("Vaiahali");
		employee3details.setEmployeeLastName("Tiwari");
		employee3details.setDOB("14/06/1998");
		employee3details.setAge("22");
		employee3details.setGender("Female");
		employee3details.setPanNumber("QSPUI858M");
		employee3details.setAdharNumber("3435 7687 7654");
		employee3details.setMobileNumber("9815406012");
		employee3Address.setStreet("rajiv moor");
		employee3Address.setCity("Kanpur");
		employee3Address.setCity("UP");
		employee3Address.setZipCode("855124");
		employee3details.setAddress(employee3Address);
		
		daoService.insertEmployee(employee1);
		daoService.insertEmployee(employee2);
		daoService.insertEmployee(employee3);
		
		
//		
//		EmployeeCredentials employee4=new EmployeeCredentials();
//		EmployeeDetails employee4details=new EmployeeDetails();
//		Address employee4Address=new Address();
//		
//		
//		
//		
//		EmployeeCredentials employee5=new EmployeeCredentials();
//		EmployeeDetails employee5details=new EmployeeDetails();
//		Address employee5Address=new Address();
//		
//		
//		
//		EmployeeCredentials employee6=new EmployeeCredentials();
//		EmployeeDetails employee6details=new EmployeeDetails();
//		Address employee6Address=new Address();
//		
//		
//		
//		
//		
//		
//		EmployeeCredentials employee7=new EmployeeCredentials();
//		EmployeeDetails employee7details=new EmployeeDetails();
//		Address employee7Address=new Address();
//		
//		
//		
//		
//		
//		EmployeeCredentials employee8=new EmployeeCredentials();
//		EmployeeDetails employee8details=new EmployeeDetails();
//		Address employee8Address=new Address();
//		
//		
//		
//		
//		
//		EmployeeCredentials employee9=new EmployeeCredentials();
//		EmployeeDetails employee9details=new EmployeeDetails();
//		Address employee9Address=new Address();
//		
//		
//		
//		
//		EmployeeCredentials employee10=new EmployeeCredentials();
//		EmployeeDetails employee10details=new EmployeeDetails();
//		Address employee10Address=new Address();
//		
//		
//		EmployeeCredentials employee11=new EmployeeCredentials();
//		EmployeeDetails employee11details=new EmployeeDetails();
//		Address employee11Address=new Address();
//		
//		
//		
//		EmployeeCredentials employee12=new EmployeeCredentials();
//		EmployeeDetails employee12details=new EmployeeDetails();
//		Address employee12Address=new Address();
//		
//		
//		
//		EmployeeCredentials employee13=new EmployeeCredentials();
//		EmployeeDetails employee13details=new EmployeeDetails();
//		Address employee13Address=new Address();
//		
//		
//		EmployeeCredentials employee14=new EmployeeCredentials();
//		EmployeeDetails employee14details=new EmployeeDetails();
//		Address employee14Address=new Address();
//		
//		
//		EmployeeCredentials employee15=new EmployeeCredentials();
//		EmployeeDetails employee15details=new EmployeeDetails();
//		Address employee15Address=new Address();
//		
		
		//Account 1
		AccountDetails accountDetails1=new AccountDetails();
		Address customer1Address=new Address();
		CustomerDetails customerDetails1=new CustomerDetails();

		
		customerDetails1.setCustomerFirstName("Vaishali");
		customerDetails1.setCustomerLastName("Tiwari");
		customerDetails1.setDOB("07/07/1998");
		customerDetails1.setAge("21");
		customerDetails1.setGender("Female");
		customerDetails1.setContactNumber("9815406012");
		customerDetails1.setPanNumber("QSWED2341M");
		customerDetails1.setAdhaarNumber("3650 7451 9856");
		customerDetails1.setAccountType("Current");
		customerDetails1.setOpeningBalance("25000");
		customer1Address.setStreet("127/211 W-2 Juhi Kalan");
		customer1Address.setState("UP");
		customer1Address.setCity("Kanpur");
		customer1Address.setZipCode("208027");
		customerDetails1.setAddress(customer1Address);
		accountDetails1.setCustomerDetails(customerDetails1);
		accountDetails1.setAccountHolderName("Vaishali Tiwari");
		accountDetails1.setAccountStatus("Active");
		accountDetails1.setAccountBalance("25000");
		accountDetails1.setCreditScore("1400");
		accountDetails1.setAccountInterest("3");
		accountDetails1.setCreditScore("1400");
		accountDetails1.setCreationDate(LocalDateTime.now());
	    accountDetails1.setBranchdetails(branchDetails1);

//		
////		//Account 2
//		
	AccountDetails accountDetails2=new AccountDetails();
	Address customer2Address=new Address();
	CustomerDetails customerDetails2=new CustomerDetails();

		accountDetails2.setAccountHolderName("Ashish Singh");
		accountDetails2.setAccountInterest("3.5");
		accountDetails2.setCreditScore("980");
		accountDetails2.setAccountBalance("12000");
		accountDetails2.setAccountStatus("Active");
		accountDetails2.setCreationDate(LocalDateTime.now());
		//accountDetails.insertAccountDetails(accountDetails);
		accountDetails2.setBranchdetails(branchDetails1);

		customerDetails2.setOpeningBalance("12000");
		customerDetails2.setAccountType("Savings");
		customerDetails2.setAdhaarNumber("7485 8555 3330");
		customerDetails2.setContactNumber("9041459865");
		customerDetails2.setPanNumber("RTYUO8522L");
		customerDetails2.setDOB("06/02/1998");
		customerDetails2.setCustomerFirstName("Ashish");
		customerDetails2.setCustomerLastName("Singh");
		customerDetails2.setAge("22");
		customerDetails2.setGender("Male");
		customer2Address.setStreet("58,Govindpura");
		customer2Address.setState("New Delhi");
		customer2Address.setCity("New Delhi");
		customer2Address.setZipCode("1110011");
        customerDetails2.setAddress(customer2Address);
		accountDetails2.setCustomerDetails(customerDetails2);

////		//Account 3
		AccountDetails accountDetails3=new AccountDetails();
		Address customer3Address=new Address();
		CustomerDetails customerDetails3=new CustomerDetails();

		accountDetails3.setAccountHolderName("Vishal Tiwari");
		accountDetails3.setAccountInterest("3.5");
		accountDetails3.setCreditScore("500");
		accountDetails3.setAccountBalance("6000");
		accountDetails3.setAccountStatus("Active");
		accountDetails3.setCreationDate(LocalDateTime.now());
		accountDetails3.setBranchdetails(branchDetails2);

		customerDetails3.setOpeningBalance("6000");
		customerDetails3.setAccountType("Savings");
		customerDetails3.setAdhaarNumber("9652 2222 6000");
		customerDetails3.setContactNumber("7007820982");
		customerDetails3.setPanNumber("AATRE7472P");
		customerDetails3.setDOB("23/10/1994");
		customerDetails3.setCustomerFirstName("Vishal");
		customerDetails3.setCustomerLastName("Tiwari");
		customerDetails3.setAge("26");
		customerDetails3.setGender("Male");
		customer3Address.setStreet("718,Collector Ganj");
		customer3Address.setState("UP");
		customer3Address.setCity("Unnao");
		customer3Address.setZipCode("209801");
		customerDetails3.setAddress(customer3Address);
		accountDetails3.setCustomerDetails(customerDetails3);
		
		//Account4
		AccountDetails accountDetails4=new AccountDetails();
		Address customer4Address=new Address();
		CustomerDetails customerDetails4=new CustomerDetails();
        accountDetails4.setAccountHolderName("Mradula Shukla");
		accountDetails4.setAccountInterest("3");
		accountDetails4.setCreditScore("905");
		accountDetails4.setAccountBalance("8500");
		accountDetails4.setAccountStatus("Active");
		accountDetails4.setCreationDate(LocalDateTime.now());
		accountDetails4.setBranchdetails(branchDetails2);
        customerDetails4.setOpeningBalance("8500");
		customerDetails4.setAccountType("Current");
		customerDetails4.setAdhaarNumber("9854 4569 2345");
		customerDetails4.setContactNumber("8004255984");
		customerDetails4.setPanNumber("YTRFV6624L");
		customerDetails4.setDOB("21/06/1994");
		customerDetails4.setCustomerFirstName("Mradula");
		customerDetails4.setCustomerLastName("Shukla");
		customerDetails4.setAge("44");
		customerDetails4.setGender("Female");
		customer4Address.setStreet("126,Sector-11");
		customer4Address.setState("Gujrat");
		customer4Address.setCity("Gandhi Nagar");
		customer4Address.setZipCode("362011");
		customerDetails4.setAddress(customer4Address);
		accountDetails4.setCustomerDetails(customerDetails4);
		customerDetails4.setAddress(customer4Address);
		accountDetails4.setCustomerDetails(customerDetails4);

		//Account5
		AccountDetails accountDetails5=new AccountDetails();
		Address customer5Address=new Address();
		CustomerDetails customerDetails5=new CustomerDetails();
		accountDetails5.setAccountHolderName("Anushkaa Awasthi");
		accountDetails5.setAccountInterest("3");
		accountDetails5.setCreditScore("700");
		accountDetails5.setAccountBalance("9700");
		accountDetails5.setAccountStatus("Active");
		accountDetails5.setCreationDate(LocalDateTime.now());
		accountDetails5.setBranchdetails(branchDetails3);
		customerDetails5.setOpeningBalance("9700");
		customerDetails5.setAccountType("Current");
		customerDetails5.setAdhaarNumber("7458 5464 2545");
		customerDetails5.setContactNumber("8317016118");
		customerDetails5.setPanNumber("QCFRE8546F");
		customerDetails5.setDOB("06/04/1989");
		customerDetails5.setCustomerFirstName("Anushkaa");
		customerDetails5.setCustomerLastName("Awasthi");
		customerDetails5.setAge("31");
		customerDetails5.setGender("Female");
		customer5Address.setStreet("2-9-2,Arihant Majestiv Towers");
		customer5Address.setState("Tamil Nadu");
		customer5Address.setCity("Chennai");
		customer5Address.setZipCode("600107");
		customerDetails5.setAddress(customer5Address);
		accountDetails5.setCustomerDetails(customerDetails5);
		customerDetails5.setAddress(customer5Address);
		accountDetails5.setCustomerDetails(customerDetails5);

		//Account6
		AccountDetails accountDetails6=new AccountDetails();
		Address customer6Address=new Address();
		CustomerDetails customerDetails6=new CustomerDetails();
		accountDetails6.setAccountHolderName("Prabhjot");
		accountDetails6.setAccountInterest("3");
		accountDetails6.setCreditScore("1250");
		accountDetails6.setAccountBalance("5000");
		accountDetails6.setAccountStatus("Active");
		accountDetails6.setCreationDate(LocalDateTime.now());
		accountDetails6.setBranchdetails(branchDetails3);
		customerDetails6.setOpeningBalance("5000");
		customerDetails6.setAccountType("Current");
		customerDetails6.setAdhaarNumber("9656 4565 2421");
		customerDetails6.setContactNumber("8968117732");
		customerDetails6.setPanNumber("TYRFD5617P");
		customerDetails6.setDOB("05/03/1997");
		customerDetails6.setCustomerFirstName("Prabhjot");
		customerDetails6.setCustomerLastName("Kaur");
		customerDetails6.setAge("23");
		customerDetails6.setGender("Female");
		customer6Address.setStreet("900,Bhagat Singh Nagar Model House");
		customer6Address.setState("Punjab");
		customer6Address.setCity("Jalandhar");
		customer6Address.setZipCode("144003");
		customerDetails6.setAddress(customer6Address);
		accountDetails6.setCustomerDetails(customerDetails6);
		customerDetails6.setAddress(customer6Address);
		accountDetails6.setCustomerDetails(customerDetails6);
								
		//Account 7
		AccountDetails accountDetails7=new AccountDetails();
		Address customer7Address=new Address();
		CustomerDetails customerDetails7=new CustomerDetails();
		accountDetails7.setAccountHolderName("Rahul Bajaj");
		accountDetails7.setAccountInterest("3.5");
		accountDetails7.setCreditScore("2200");
		accountDetails7.setAccountBalance("7500");
		accountDetails7.setAccountStatus("Active");
		accountDetails7.setCreationDate(LocalDateTime.now());
		accountDetails7.setBranchdetails(branchDetails3);
		customerDetails7.setOpeningBalance("7500");
		customerDetails7.setAccountType("Savings");
		customerDetails7.setAdhaarNumber("7546 8598 2115");
		customerDetails7.setContactNumber("9415546297");
		customerDetails7.setPanNumber("ASWED1099D");
		customerDetails7.setDOB("04/12/1978");
		customerDetails7.setCustomerFirstName("Rahul");
		customerDetails7.setCustomerLastName("Bajaj");
		customerDetails7.setAge("42");
		customerDetails7.setGender("Male");
		customer7Address.setStreet("101 Circular Rd, Bemloi");
		customer7Address.setState("Himachal Pradesh");
		customer7Address.setCity("Shimla");
		customer7Address.setZipCode("171001");
		customerDetails7.setAddress(customer7Address);
		accountDetails7.setCustomerDetails(customerDetails7);
		customerDetails7.setAddress(customer7Address);
		accountDetails7.setCustomerDetails(customerDetails7);

		//Account 8
		AccountDetails accountDetails8=new AccountDetails();
		Address customer8Address=new Address();
		CustomerDetails customerDetails8=new CustomerDetails();
		accountDetails8.setAccountHolderName("Amardeep Singh");
		accountDetails8.setAccountInterest("3");
		accountDetails8.setCreditScore("300");
		accountDetails8.setAccountBalance("9000");
		accountDetails8.setAccountStatus("Active");
		accountDetails8.setCreationDate(LocalDateTime.now());
		accountDetails8.setBranchdetails(branchDetails2);
		customerDetails8.setOpeningBalance("9000");
		customerDetails8.setAccountType("Current");
		customerDetails8.setAdhaarNumber("4829 5542 8768");
		customerDetails8.setContactNumber("8840864659");
		customerDetails8.setPanNumber("PYGTF4267P");
		customerDetails8.setDOB("03/05/1990");
		customerDetails8.setCustomerFirstName("Amardeep");
		customerDetails8.setCustomerLastName("Singh");
		customerDetails8.setAge("30");
		customerDetails8.setGender("Male");
		customer8Address.setStreet("Gujela, Ghatampur");
		customer8Address.setState("Uttar Pradesh");
		customer8Address.setCity("Kanpur");
		customer8Address.setZipCode("209206");
		customerDetails8.setAddress(customer8Address);
		accountDetails8.setCustomerDetails(customerDetails8);
		customerDetails8.setAddress(customer8Address);
		accountDetails8.setCustomerDetails(customerDetails8);
		      
		//Account 9
		AccountDetails accountDetails9=new AccountDetails();
		Address customer9Address=new Address();
		CustomerDetails customerDetails9=new CustomerDetails();
		accountDetails9.setAccountHolderName("Satyam Sinha");
		accountDetails9.setAccountInterest("3.5");
		accountDetails9.setCreditScore("1610");
		accountDetails9.setAccountBalance("20000");
		accountDetails9.setAccountStatus("Active");
		accountDetails9.setCreationDate(LocalDateTime.now());
		accountDetails9.setBranchdetails(branchDetails4);
		customerDetails9.setOpeningBalance("20000");
		customerDetails9.setAccountType("Savings");
		customerDetails9.setAdhaarNumber("6985 2345 6528");
		customerDetails9.setContactNumber("9973060640");
		customerDetails9.setPanNumber("BSTUM81565M");
		customerDetails9.setDOB("02/04/1984");
		customerDetails9.setCustomerFirstName("Satyam");
		customerDetails9.setCustomerLastName("Sinha");
		customerDetails9.setAge("36");
		customerDetails9.setGender("Male");
		customer9Address.setStreet("East off Bustand, Gangjala");
		customer9Address.setState("Bihar");
		customer9Address.setCity("Saharasa");
		customer9Address.setZipCode("855201");
		customerDetails9.setAddress(customer9Address);
		accountDetails9.setCustomerDetails(customerDetails9);
		customerDetails9.setAddress(customer9Address);
		accountDetails9.setCustomerDetails(customerDetails9);		
				
		//Account 10
		AccountDetails accountDetails10=new AccountDetails();
		Address customer10Address=new Address();
		CustomerDetails customerDetails10=new CustomerDetails();
		accountDetails10.setAccountHolderName("Pranav Kapoor");
		accountDetails10.setAccountInterest("3.5");
		accountDetails10.setCreditScore("1980");
		accountDetails10.setAccountBalance("5600");
		accountDetails10.setAccountStatus("Active");
		accountDetails10.setCreationDate(LocalDateTime.now());
		accountDetails10.setBranchdetails(branchDetails5);
		customerDetails10.setOpeningBalance("5600");
		customerDetails10.setAccountType("Savings");
		customerDetails10.setAdhaarNumber("5298 1114 8262");
		customerDetails10.setContactNumber("9115513073");
		customerDetails10.setPanNumber("APMUT4815B");
		customerDetails10.setDOB("03/10/1992");
		customerDetails10.setCustomerFirstName("Pranav");
		customerDetails10.setCustomerLastName("Kapoor");
		customerDetails10.setAge("28");
		customerDetails10.setGender("Male");
		customer10Address.setStreet("Near Ashram Marg, Jawahar Circle");
		customer10Address.setState("Rajasthan");
		customer10Address.setCity("Jaipur");
		customer10Address.setZipCode("302015");
		customerDetails10.setAddress(customer10Address);
		accountDetails10.setCustomerDetails(customerDetails10);
		customerDetails10.setAddress(customer10Address);
		accountDetails10.setCustomerDetails(customerDetails10);
						
		daoService.insertAccountDetails(accountDetails1);
		daoService.insertAccountDetails(accountDetails2);
		daoService.insertAccountDetails(accountDetails3);
		daoService.insertAccountDetails(accountDetails4);
		daoService.insertAccountDetails(accountDetails5);
		daoService.insertAccountDetails(accountDetails6);
		daoService.insertAccountDetails(accountDetails7);
		daoService.insertAccountDetails(accountDetails8);
		daoService.insertAccountDetails(accountDetails9);
		daoService.insertAccountDetails(accountDetails10);
	}
}

