package com.capgemini.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.main.Dao.DaoService;
import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.BranchDetails;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.EmployeeDetails;



@SpringBootApplication
public class Sprint2DemoApplication implements CommandLineRunner{

	@Autowired
	DaoService daoService;  //This is used to insert pre-existing Data.

	
	
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
				employee3.setEmployeeId("admin");//empNumber
				employee3.setEmployeePassword("admin");//Firstname + branchid
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
				
					
	}	
}
