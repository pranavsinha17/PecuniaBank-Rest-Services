import { Component, OnInit } from '@angular/core';
import { Ledger } from '../ledger';
import { LoanService } from '../loan.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ledgerbyaccount',
  templateUrl: './ledgerbyaccount.component.html',
  styleUrls: ['./ledgerbyaccount.component.css']
})
export class LedgerbyaccountComponent implements OnInit {

  ngOnInit(): void {
    
  }

  account:Account;
  accountErrorInfo:string;
  info:string;
  accountNumber1:string;
  loan:Ledger[]=[];
 
  val:Boolean=false;
  constructor(private loanService: LoanService, private route: Router) { }
  //Function to check account

  checkAccount(accountNumber1: string)
  {
    this.loanService.checkaccount(accountNumber1).
    subscribe(data=>{this.account=data;
      console.log(this.account);
  //To show paticular ledger Report
     this.val=true;
     this.loanService.loadLedgersAccount(accountNumber1).subscribe(data =>{this.loan=data;}
      ,error=>{this.accountErrorInfo=error.error});
    console.log(this.accountErrorInfo);
      this.info = data;

    this.accountErrorInfo=undefined;
   },error=>{
    this.info = undefined;
    this.accountErrorInfo = error.error;
    console.log(this.accountErrorInfo);
    alert(this.accountErrorInfo);
   });
   
   
   
}
}

