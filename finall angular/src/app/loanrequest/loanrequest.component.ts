import { Component} from '@angular/core';
import { Request } from '../request';
import { LoanService } from '../loan.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loanrequest',
  templateUrl: './loanrequest.component.html',
  styleUrls: ['./loanrequest.component.css']
})
export class LoanrequestComponent {

  request: Request = new Request();
  info: String;
  errorInfo: String;
  accountNumber1:string;
  account:Account;
  accountErrorInfo:string;
  val1:Boolean=false;
  val2:Boolean=false;
  accountNumber2:string;


  constructor(private loanService: LoanService, private route: Router) { }
  //Fuction to check account existance
  checkAccount(accountNumber1: string)
  {
    this.loanService.checkaccount(accountNumber1).
    subscribe(data=>{this.account=data;
      console.log(this.account);
      this.val1=true;
      this.accountNumber2=accountNumber1;
      this.val2=true;
      this.info = data;
       //auto fix account number in from.
       this.request.accountNumber=accountNumber1;

    this.accountErrorInfo=undefined;
   },error=>{
    this.info = undefined;
    this.accountErrorInfo = error.error;
    console.log(this.accountErrorInfo);
   });
}

//Function to process loan request
  loanRequest() {
    if(this.request.type=="Home")
    {
      this.request.roi=10.0;
    }
    else if(this.request.type=="Car")
    {
      this.request.roi=8.0;
    }
    else if(this.request.type=="Education")
    {
      this.request.roi=5.0;
    }
    else if(this.request.type=="Personal")
    {
      this.request.roi=12.0;
    }
    else if(this.request.type=="StartUp")
    {
      this.request.roi=9.0;
    }
    
    console.log('loan process');
    this.loanService.loanrequest(this.request).subscribe(data => {
      this.request = data;

      console.log(this.request);
      alert(this.request);
      this.info = data;

      this.errorInfo = undefined;
      },
      error => {
        this.info = undefined;
        this.errorInfo = error.error;
        console.log(this.errorInfo);
        alert(this.errorInfo);
      } );
  }

}
