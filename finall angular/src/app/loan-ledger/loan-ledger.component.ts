import { Component, OnInit } from '@angular/core';
import { Ledger, Account } from '../ledger';
import { LoanService } from '../loan.service';

@Component({
  selector: 'app-loan-ledger',
  templateUrl: './loan-ledger.component.html',
  styleUrls: ['./loan-ledger.component.css']
})
export class LoanLedgerComponent implements OnInit {

  loan:Ledger[]=[];
  account:Account;
  info:string;
  errorInfo:any;
  

  constructor(private loanService: LoanService) { }
//To print all ledger data
  ngOnInit() {
    console.log("inside ngOninit loanLedger component");
    this.loanService.loadLedgers().subscribe(data => {
      this.loan=data;},error=>{this.errorInfo=error.error});
    console.log(this.errorInfo);
  
}
}