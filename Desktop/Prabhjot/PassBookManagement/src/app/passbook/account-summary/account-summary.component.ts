import { Component, OnInit } from '@angular/core';
import { Accountsummary } from 'src/app/accountsummary';
import { PassBookService } from 'src/app/pass-book.service';
import { Address } from 'src/app/address';
import { BranchDetails } from 'src/app/branch-details';
import { CustomerDetails } from 'src/app/customer-details';
import { AccountDetails } from 'src/app/account-details';
import { Transaction } from 'src/app/transaction';
import { NgForm, FormGroup } from '@angular/forms';
import { isDefined } from '@angular/compiler/src/util';
import { UpdatePassbookComponent } from '../update-passbook/update-passbook.component';

@Component({
  selector: 'app-account-summary',
  templateUrl: './account-summary.component.html',
  styleUrls: ['./account-summary.component.css']
})
export class AccountSummaryComponent implements OnInit {


  ngOnInit(): void {
  }

  constructor(private passbookService:PassBookService){

  }

  form:FormGroup;

  accountDetails:AccountDetails=new AccountDetails();

  customerDetails:CustomerDetails=new CustomerDetails();

  address:Address=new Address();

  branchDetails:BranchDetails=new BranchDetails();

  accountSummaryData:Accountsummary=new Accountsummary();

  accountSummaryData1:Accountsummary;

  transactions:Transaction[]=[];

  accountNumber:number;
  startingDate:Date;
  endingDate:Date;

  val1:boolean=false;
  val2:boolean=false;

 
  
  accountErrorInfo:string;

 // minDate="01-01-2000";
  
  submit(accountSummaryData:Accountsummary)
  {

    this.accountNumber=accountSummaryData.accountNumber;
    this.startingDate=accountSummaryData.startingDate;
    this.endingDate=accountSummaryData.endingDate;

    
    this.passbookService.loadAccountDetails(this.accountNumber).
    subscribe(data=>{
      this.accountDetails=data;
      this.val1=true;
      this.accountErrorInfo=undefined;
   },error=>{
    this.val1=false;
    this.val2=false;
    this.accountErrorInfo=error.error;
  });
    

    this.passbookService.loadPassbookTransactionsByDateRange(this.accountNumber
   ,this.startingDate,this.endingDate).subscribe(data =>
       {
          console.log(data);
          this.transactions=data;
          this.val1=true;
          this.val2=true;
          this.accountErrorInfo=undefined;
       },error=>{
          this.val1=false;
          this.val2=false;
        this.accountErrorInfo=error.error;
      });

      this.form.reset();
  }

}
