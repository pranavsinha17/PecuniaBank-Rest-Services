package com.capgemini.main;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.main.Dao.DaoService;
import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.BranchDetails;
import com.capgemini.main.entity.ChequeDetails;
import com.capgemini.main.entity.CustomerDetails;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.EmployeeDetails;
import com.capgemini.main.exception.UserException;
import com.capgemini.main.service.TransationUsingCreditCheque;
import com.capgemini.main.service.TranscationUsingDebitCheque;


@SpringBootApplication
public class Sprint2DemoApplication implements CommandLineRunner{

	@Autowired
	DaoService daoService;  //This is used to insert pre-existing Data.
	
	@Autowired
	TranscationUsingDebitCheque debitService;  
	
	@Autowired
	TransationUsingCreditCheque creditService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Sprint2DemoApplication.class, args);
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
//				EmployeeCredentials employee4=new EmployeeCredentials();
//				EmployeeDetails employee4details=new EmployeeDetails();
//				Address employee4Address=new Address();
//				
//				
//				
//				
//				EmployeeCredentials employee5=new EmployeeCredentials();
//				EmployeeDetails employee5details=new EmployeeDetails();
//				Address employee5Address=new Address();
//				
//				
//				
//				EmployeeCredentials employee6=new EmployeeCredentials();
//				EmployeeDetails employee6details=new EmployeeDetails();
//				Address employee6Address=new Address();
//				
//				
//				
//				
//				
//				
//				EmployeeCredentials employee7=new EmployeeCredentials();
//				EmployeeDetails employee7details=new EmployeeDetails();
//				Address employee7Address=new Address();
//				
//				
//				
//				
//				
//				EmployeeCredentials employee8=new EmployeeCredentials();
//				EmployeeDetails employee8details=new EmployeeDetails();
//				Address employee8Address=new Address();
//				
//				
//				
//				
//				
//				EmployeeCredentials employee9=new EmployeeCredentials();
//				EmployeeDetails employee9details=new EmployeeDetails();
//				Address employee9Address=new Address();
//				
//				
//				
//				
//				EmployeeCredentials employee10=new EmployeeCredentials();
//				EmployeeDetails employee10details=new EmployeeDetails();
//				Address employee10Address=new Address();
//				
//				
//				EmployeeCredentials employee11=new EmployeeCredentials();
//				EmployeeDetails employee11details=new EmployeeDetails();
//				Address employee11Address=new Address();
//				
//				
//				
//				EmployeeCredentials employee12=new EmployeeCredentials();
//				EmployeeDetails employee12details=new EmployeeDetails();
//				Address employee12Address=new Address();
//				
//				
//				
//				EmployeeCredentials employee13=new EmployeeCredentials();
//				EmployeeDetails employee13details=new EmployeeDetails();
//				Address employee13Address=new Address();
//				
//				
//				EmployeeCredentials employee14=new EmployeeCredentials();
//				EmployeeDetails employee14details=new EmployeeDetails();
//				Address employee14Address=new Address();
//				
//				
//				EmployeeCredentials employee15=new EmployeeCredentials();
//				EmployeeDetails employee15details=new EmployeeDetails();
//				Address employee15Address=new Address();
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
				customerDetails1.setPanNumber("QSWED234M");
				customerDetails1.setAdhaarNumber("3650 7451 9856");
				customerDetails1.setAccountType("Current");
				customerDetails1.setOpeningBalance(25000);
				customerDetails1.setBranchId(branchDetails1.getBranchId());
				customer1Address.setStreet("127/211 W-2 Juhi Kalan");
				customer1Address.setState("UP");
				customer1Address.setCity("Kanpur");
				customer1Address.setZipCode("208027");
				customerDetails1.setAddress(customer1Address);
				customerDetails1.setDate(LocalDate.of(2020, 04, 21));
				accountDetails1.setCustomerDetails(customerDetails1);
				accountDetails1.setAccountHolderName("Vaishali Tiwari");
				accountDetails1.setAccountStatus("Active");
				accountDetails1.setAccountBalance(25000);
				accountDetails1.setCreditScore(1400);
				accountDetails1.setAccountInterest(3);
				accountDetails1.setDate(customerDetails1.getDate());
			    accountDetails1.setBranchdetails(branchDetails1);

				
			//Account 2
			
			AccountDetails accountDetails2=new AccountDetails();
			Address customer2Address=new Address();
			CustomerDetails customerDetails2=new CustomerDetails();
		
				accountDetails2.setAccountHolderName("Ashish Singh");
				accountDetails2.setAccountInterest((float) 3.5);
				accountDetails2.setCreditScore(980);
				accountDetails2.setAccountBalance(12000);
				accountDetails2.setAccountStatus("Active");
			    accountDetails2.setBranchdetails(branchDetails1);
			    customerDetails2.setBranchId(branchDetails1.getBranchId());
				customerDetails2.setOpeningBalance(12000);
				customerDetails2.setAccountType("Savings");
				customerDetails2.setDate(LocalDate.of(2020, 04, 21));
				customerDetails2.setAdhaarNumber("7485 8555 3330");
				customerDetails2.setContactNumber("9041459865");
				customerDetails2.setPanNumber("RTYUO852L");
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
				accountDetails2.setDate(customerDetails2.getDate());
		
				//Account 3
				AccountDetails accountDetails3=new AccountDetails();
				Address customer3Address=new Address();
				CustomerDetails customerDetails3=new CustomerDetails();
		
				accountDetails3.setAccountHolderName("Vishal Tiwari");
				accountDetails3.setAccountInterest((float) 3.5);
				accountDetails3.setCreditScore(500);
				accountDetails3.setAccountBalance(6000);
				accountDetails3.setAccountStatus("Active");
				accountDetails3.setBranchdetails(branchDetails2);
		//
				customerDetails3.setBranchId(branchDetails2.getBranchId());
				customerDetails3.setOpeningBalance(6000);
				customerDetails3.setDate(LocalDate.of(2020, 04, 21));
				customerDetails3.setAccountType("Savings");
				customerDetails3.setAdhaarNumber("9652 2222 6000");
				customerDetails3.setContactNumber("7007820982");
				customerDetails3.setPanNumber("AATRE747P");
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
				accountDetails3.setDate(customerDetails3.getDate());
				
		
				
				AccountDetails accountDetails4=new AccountDetails();
				Address customer4Address=new Address();
				CustomerDetails customerDetails4=new CustomerDetails();

				accountDetails4.setAccountHolderName("Mradula Shukla");
				accountDetails4.setAccountInterest(3);
				accountDetails4.setCreditScore(905);
				accountDetails4.setAccountBalance(8500);
				accountDetails4.setAccountStatus("Active");
				accountDetails4.setBranchdetails(branchDetails2);
				customerDetails4.setBranchId(branchDetails2.getBranchId());
				customerDetails4.setOpeningBalance(8500);
				customerDetails4.setAccountType("Current");
				customerDetails4.setAdhaarNumber("9854 4569 2345");
				customerDetails4.setContactNumber("8004255984");
				customerDetails4.setPanNumber("YTRFV664L");
				customerDetails4.setDOB("21/06/1994");
				customerDetails4.setDate(LocalDate.of(2020, 04, 21));
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
				accountDetails4.setDate(customerDetails4.getDate());

				//Account5
				AccountDetails accountDetails5=new AccountDetails();
				Address customer5Address=new Address();
				CustomerDetails customerDetails5=new CustomerDetails();

				accountDetails5.setAccountHolderName("Anushkaa Awasthi");
				accountDetails5.setAccountInterest(3);
				accountDetails5.setCreditScore(700);
				accountDetails5.setAccountBalance(9700);
				accountDetails5.setAccountStatus("Active");
				accountDetails5.setBranchdetails(branchDetails3);
				customerDetails5.setBranchId(branchDetails3.getBranchId());
				customerDetails5.setOpeningBalance(9700);
				customerDetails5.setAccountType("Current");
				customerDetails5.setAdhaarNumber("7458 5464 2545");
				customerDetails5.setContactNumber("8317016118");
				customerDetails5.setPanNumber("QCFRE856F");
				customerDetails5.setDate(LocalDate.of(2020, 04, 21));
				customerDetails5.setDOB("06/04/1989");
				customerDetails5.setCustomerFirstName("Anushkaa");
				customerDetails5.setCustomerLastName("Awasthi");
				customerDetails5.setAge("31");
				customerDetails5.setGender("Female");
				customer5Address.setStreet("2-9-2,Arihant Majestiv Towers");
				customer5Address.setState("Tamil Nadu");
				customer5Address.setCity("Chennai");
				customer5Address.setZipCode("600107");
				accountDetails5.setDate(customerDetails5.getDate());
				customerDetails5.setAddress(customer5Address);
				accountDetails5.setCustomerDetails(customerDetails5);
				customerDetails5.setAddress(customer5Address);
				accountDetails5.setCustomerDetails(customerDetails5);

				//Account6
				AccountDetails accountDetails6=new AccountDetails();
				Address customer6Address=new Address();
				CustomerDetails customerDetails6=new CustomerDetails();
				accountDetails6.setAccountHolderName("Prabhjot");
				accountDetails6.setAccountInterest(3);
				accountDetails6.setCreditScore(1250);
				customerDetails6.setDate(LocalDate.of(2020, 04, 21));
				accountDetails6.setAccountBalance(5000);
				accountDetails6.setAccountStatus("Active");
				accountDetails6.setBranchdetails(branchDetails3);
				customerDetails6.setOpeningBalance(5000);
				customerDetails6.setAccountType("Current");
				customerDetails6.setAdhaarNumber("9656 4565 2421");
				customerDetails6.setContactNumber("8968117732");
				customerDetails6.setPanNumber("TYRFD567P");
				customerDetails6.setDOB("05/03/1997");
				customerDetails6.setCustomerFirstName("Prabhjot");
				customerDetails6.setCustomerLastName("Kaur");
				customerDetails6.setAge("23");
				accountDetails6.setDate(customerDetails6.getDate());
				customerDetails6.setGender("Female");
				customer6Address.setStreet("900,Bhagat Singh Nagar Model House");
				customer6Address.setState("Punjab");
				customer6Address.setCity("Jalandhar");
				customer6Address.setZipCode("144003");
				customerDetails6.setAddress(customer6Address);
				accountDetails6.setCustomerDetails(customerDetails6);
				customerDetails6.setAddress(customer6Address);
				accountDetails6.setCustomerDetails(customerDetails6);
				customerDetails6.setBranchId(branchDetails3.getBranchId());
				//Account 7
				AccountDetails accountDetails7=new AccountDetails();
				Address customer7Address=new Address();
				CustomerDetails customerDetails7=new CustomerDetails();
				accountDetails7.setAccountHolderName("Rahul Bajaj");
				accountDetails7.setAccountInterest((float) 3.5);
				accountDetails7.setCreditScore(2200);
				accountDetails7.setAccountBalance(7500);
				accountDetails7.setAccountStatus("Active");
				accountDetails7.setBranchdetails(branchDetails3);
				customerDetails7.setOpeningBalance(7500);
				customerDetails7.setBranchId(branchDetails3.getBranchId());
				customerDetails7.setAccountType("Savings");
				customerDetails7.setAdhaarNumber("7546 8598 2115");
				customerDetails7.setContactNumber("9415546297");
				customerDetails7.setDate(LocalDate.of(2020, 04, 21));
				customerDetails7.setPanNumber("ASWED099D");
				customerDetails7.setDOB("04/12/1978");
				customerDetails7.setCustomerFirstName("Rahul");
				customerDetails7.setCustomerLastName("Bajaj");
				customerDetails7.setAge("42");
				customerDetails7.setGender("Male");
				accountDetails7.setDate(customerDetails7.getDate());
				customer7Address.setStreet("101 Circular Rd, Bemloi");
				customer7Address.setState("Himachal Pradesh");
				customer7Address.setCity("Shimla");
				customer7Address.setZipCode("171001");
				customerDetails7.setAddress(customer7Address);
				accountDetails7.setCustomerDetails(customerDetails7);
				customerDetails7.setAddress(customer7Address);
				accountDetails7.setCustomerDetails(customerDetails7);

	
		
		
		
		
		daoService.insertAccountDetails(accountDetails1);
		daoService.insertAccountDetails(accountDetails2);
		daoService.insertAccountDetails(accountDetails3);
		daoService.insertAccountDetails(accountDetails4);
		daoService.insertAccountDetails(accountDetails5);
		daoService.insertAccountDetails(accountDetails6);
		daoService.insertAccountDetails(accountDetails7);
		
		// Every Check Number is Different and it's depend on cheque booklet of every individual account holder. 
		//Then I have make a check booklet of 5 account members and 2 cheque of each member for debit and credit.
		//only one cheque details->for withdrawing money using cheque
		
		ChequeDetails chequeDetails=new ChequeDetails();
		chequeDetails.setChequeNumber(652201);
		chequeDetails.setAccountNumber(1170001);
		chequeDetails.setBenificaryAccountNumber(1170001);
		chequeDetails.setIFSC("PUNB033954");
		chequeDetails.setAmount(1000);
		chequeDetails.setBankName("PECUNIA");
		chequeDetails.setIssueDate(LocalDate.of(2020, 04, 22));
		chequeDetails.setPayName("Self");  //SELF me Account Holder Withdrawing Money form his/her bank by own using cheque.
		chequeDetails.setTransactionType("Debit");// Debated money from by using cheque.
		chequeDetails.setCheckStatus("Unknown");
		try {
			debitService.debitCheque(chequeDetails);
		}
		catch (UserException e) {
			
			System.out.println(""+e);
		}
		
		
				ChequeDetails chequeDetails1=new ChequeDetails();
				chequeDetails1.setChequeNumber(652202);//we have to put different cheque number beacuse we use the previous one
				chequeDetails1.setAccountNumber(1170001);
				chequeDetails1.setBenificaryAccountNumber(1170002);
				chequeDetails1.setIFSC("PUNB033954");
				chequeDetails1.setAmount(1000);
				chequeDetails1.setBankName("PECUNIA");
				chequeDetails1.setIssueDate(LocalDate.of(2020, 04, 22));
				chequeDetails1.setPayName("Self");  //SELF means Account Holder Withdrawing Money form his/her bank by own using cheque.
				chequeDetails1.setTransactionType("Credit");// transaction money from one to another person.
				chequeDetails1.setCheckStatus("Unknown");
				try {
					creditService.creditCheque(chequeDetails1);
				}
				catch (UserException e) {
					
					System.out.println(""+e);
				}
		

	}

}
