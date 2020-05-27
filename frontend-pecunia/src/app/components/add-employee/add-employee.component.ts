import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeCredentials } from '../../model/employee-credentials';
import { EmployeeDetails } from '../../model/employee-details';
import { Address } from '../../model/address';
import { ShareBetweenComponentsService } from '../../services/share-between-components.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormGroup } from '@angular/forms';
import { EmployeeService } from 'src/app/services/employee.service';



@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.scss']
})
export class AddEmployeeComponent implements OnInit,OnDestroy {
  count:number;
   username:string;
   password:string;
  first_name:string;
  last_name:string;
  branchId:number;
  gender:string;
  adhar:string;
  pan:string;
  dob:string;
  phone:string;
  age:string='';
  street:string;
  city:string;
  state:string;
  zipcode:string;
  credentials:EmployeeCredentials;
  EmployeeDetails:EmployeeDetails;
  address:Address;
  contactForm: FormGroup;
  constructor(private router: Router,private sharer:ShareBetweenComponentsService,private service: EmployeeService) { 
    
  }
  ngOnDestroy(): void {
  }

  ngOnInit(): void {
    
  }
 
  addEmployee()
  {
    if(this.first_name==''||this.last_name==''||this.branchId==null||this.adhar==''||this.gender==''||this.pan==''||this.age==''||this.city==''||this.state==''||this.zipcode==''||this.phone==''||this.dob==''||this.street=='')
    {
      window.alert("Please Fill the Details");
    }
    else{
    let cnt=this.sharer.getCount();
    this.username=(116000+cnt).toString();
    cnt=cnt+1;
    this.password=(this.first_name).toLowerCase()+this.branchId;

    this.address={
      street: this.street,
      city: this.city,
      state:this.state,
      zipCode:this.zipcode
    }
    console.log(this.address);


    this.EmployeeDetails={
      employeeFirstName:this.first_name,
      employeeLastName:this.last_name,
      dob:this.dob,
      adharNumber:this.adhar,
      panNumber:this.pan,
      branchId:this.branchId,
      age:this.age,
      gender:this.gender,
      mobileNumber:this.phone,
      address:this.address

    }
    console.log(this.EmployeeDetails);
   
    this.credentials={
      employeeId:this.username,
      employeePassword:this.password,
      employeeDetails:this.EmployeeDetails
    }
    console.log(this.credentials);
    if(parseInt(this.age)>18)
    {
   this.service.putData(this.credentials);
    window.alert('Employee Added'+ 'Username: '+this.username + ' Password: '+this.password);
    this.sharer.setCount(cnt);
    this.router.navigateByUrl('/home');
  }
  else{
    window.alert("Age must be above 18");
  }
}
}
  
  getAge(value:any){

    this.age='';
    let currentYear: any = new Date().getFullYear(); //2020
    let userBirthYear: any = new Date(value).getFullYear();
    let age = currentYear - userBirthYear
    if(age>=0)
    {
      this.age = age.toString();
    }
  }

}
