import { Component, OnInit, OnDestroy } from '@angular/core';
import { PassBookService } from 'src/app/pass-book.service';
import { AccountDetails } from 'src/app/account-details';
import { BranchDetails } from 'src/app/branch-details';
import { CustomerDetails } from 'src/app/customer-details';
import { Address } from 'src/app/address';
import { PassbookUpdate } from 'src/app/passbook-update';
import { Transaction } from 'src/app/transaction';
import { PassBook } from 'src/app/pass-book';

@Component({
  selector: 'app-update-passbook',
  templateUrl: './update-passbook.component.html',
  styleUrls: ['./update-passbook.component.css']
})
export class UpdatePassbookComponent{
 
  accountDetails:AccountDetails=new AccountDetails();

  customerDetails:CustomerDetails=new CustomerDetails();

  address:Address=new Address();

  branchdetails:BranchDetails=new BranchDetails();
  
  passbook:PassbookUpdate=new PassbookUpdate();

  transactions:Transaction[]=[];
  transactions1:Transaction[]=[];
  accountNumber1:number;
  
  passbookUpdate:PassbookUpdate;

  val1:boolean=false;
  val2:boolean=false;

  accountErrorInfo:string;
  lastUpdateDate:Date;

  searchTerm:string;




  constructor(private passbookService:PassBookService)
  {

  }
 
  update(accountNumber1: number)
  {
    this.passbookService.loadAccountDetails(accountNumber1).
    subscribe(data=>{this.accountDetails=data;
    this.val1=true;
    this.accountErrorInfo=undefined;
   },error=>{
     this.val1=false;
     this.val2=false;
     this.accountErrorInfo=error.error;
   });
    
    this.passbookService.loadUpdatePassbookDetails(accountNumber1).
    subscribe(data=> 
    {
        this.passbookUpdate=data;
        console.log("pasbookDetails = "+this.passbookUpdate);
        this.lastUpdateDate=this.passbookUpdate.lastUpdate;
        this.passbookService.updatePassbookAccountTransactions(accountNumber1,this.lastUpdateDate)
        .subscribe(data=>
          {
            console.log(data);
            this.transactions=data;
            this.val1=true;
            this.val2=true;
            this.accountErrorInfo=undefined;
          },error =>{
            this.val2=false;
            this.accountErrorInfo=error.error;
          }
        );      
      });
  }
   showTransactions(accountNumber2:number)
   {
   this.passbookService.loadAccountTransactions(accountNumber2).subscribe(data=> 
     {this.transactions=data;
      console.log(this.transactions);
      this.val2=true;
      this.val1=false;
      this.accountErrorInfo=undefined;
     },error=>{
       this.val2=false;
       this.accountErrorInfo=error.error;
     }); 
    }
}