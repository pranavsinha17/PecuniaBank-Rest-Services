package com.capgemini.main.service;

import com.capgemini.main.entity.Address;
import com.capgemini.main.entity.Admin;
import com.capgemini.main.entity.BranchDetails;
import com.capgemini.main.entity.EmployeeCredentials;
import com.capgemini.main.entity.EmployeeDetails;

public class AdminServiceImp implements AdminService{

	@Override
	public boolean checkCredentails(Admin admin) {
		// TODO Auto-generated method stub
		if(admin.Id.equals(Admin.getAdminid())&&admin.password.equals(Admin.getAdminpassword()))
			return true;
		return false;
	}

	@Override
	public String addBranch(BranchDetails branchDetails, Address address) {
		// TODO Auto-generated method stub
		branchDetails.setAddress(address);
		return "Branch Details Add sucessfuly";
	}

	@Override
	public String addEmployeeDetails(EmployeeDetails empDetails, Address address, EmployeeCredentials empCredentails) {
		// TODO Auto-generated method stub
		empDetails.setAddress(address);
		empCredentails.setEmployeeDetails(empDetails);
		return "Employee Details  Add sucessfuly";
	}

}
