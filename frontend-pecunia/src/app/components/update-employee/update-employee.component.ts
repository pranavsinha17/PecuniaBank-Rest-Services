import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/model/address';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.scss']
})
export class UpdateEmployeeComponent implements OnInit {
  employeeId:string;
  street:string;
  city:string;
  state:string;
  zipcode:string;
  phone:string;
  address:Address;

  constructor(private service: EmployeeService) { }

  ngOnInit(): void {
  }

  updateEmployee()
  {
    const obj={
      mobileNumber:this.phone,
      address:{
        street: this.street,
     city: this.city,
     state:this.state,
     zipCode:this.zipcode
      }
    };

    this.service.updateData(obj,this.employeeId);
    
  }
}
