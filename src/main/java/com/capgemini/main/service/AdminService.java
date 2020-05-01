package com.capgemini.main.service;

import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.Admin;
import com.capgemini.main.entity.BranchDetails;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.EmployeeDetails;

public interface AdminService {
public boolean checkCredentails(Admin admin);
public String addBranch(BranchDetails branchDetails,Address address);
//by default employeeCredentails set by bank for the new employee .
public String addEmployeeDetails(EmployeeDetails empDetails,Address address,EmployeeCredentials empCredentails);
}
