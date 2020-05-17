import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ForgetPassword } from 'src/app/model/forget-password';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.scss']
})
export class ResetPasswordComponent implements OnInit {
   employeeId:string;
   employeePassword:string;
   confirmPassword:string;
   mobileNumber:string;
   forgetPassword:ForgetPassword;
   val1:boolean=false;
  constructor(private router:Router,private service:EmployeeService) { }

  ngOnInit(): void {
  }


  resetPassword()
  {
 if(this.employeePassword===this.confirmPassword && (this.employeeId!=null||this.employeePassword!=null|| this.mobileNumber!=null||this.confirmPassword!=null))
    {
       this.forgetPassword={
         employeeId:this.employeeId,
         mobileNumber:this.mobileNumber,
         employeePassword:this.employeePassword
       }
      this.service.resetData(this.forgetPassword,this.employeeId);

      this.router.navigateByUrl('/login')
      
    }
    else{
      if(this.employeePassword!==this.confirmPassword)
      window.alert("Password do not match");
      else if(this.employeeId==null||this.employeePassword==null|| this.mobileNumber==null||this.confirmPassword==null)
      window.alert("Enter the fields completely");
    }
  }
   
  }



