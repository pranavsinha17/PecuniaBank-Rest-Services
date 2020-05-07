import { Component, OnInit } from '@angular/core';
import { Cheque } from 'src/app/model/cheque';
import { TransactionService } from 'src/app/services/transaction.service';
import { FormGroup } from '@angular/forms';
import { Transaction } from 'src/app/model/transaction';

@Component({
  selector: 'app-transaction-by-cheque',
  templateUrl: './transaction-by-cheque.component.html',
  styleUrls: ['./transaction-by-cheque.component.scss']
})
export class TransactionByChequeComponent implements OnInit {
  constructor(private transaction:TransactionService) { }
  cheque:Cheque=new Cheque();
  transactionStatement:any;
  transactionErrorInfo:any;
  ngForm:FormGroup;
  val:boolean=false;
  transation:Transaction;
  ngOnInit(): void {
  }
   transactionType=['Credit','Debit'];
   bankType=['PECUNIA','HDFC','SBI','ICIC','UBI'];
  doTransaction()
  {
    this.cheque.checkStatus="Unknown";
    if(this.cheque.transactionType=="Debit")
    {
      this.cheque.accountNumber=this.cheque.benificaryAccountNumber;
      
      this.transactionStatement=this.transaction.insertcheque(this.cheque).subscribe(data=>{this.transactionStatement=data}
        ,error=>{this.transactionErrorInfo=error.error;
        });
    }
    else{
      this.transactionStatement=this.transaction.insertcheque1(this.cheque).subscribe(data=>{this.transactionStatement=data;this.val=true}
        ,error=>{this.transactionErrorInfo=error.error;this.val=false});
    }
    if(this.val==false)
    alert(this.transactionErrorInfo.toString);
    this.ngForm.reset();

    
  }

}
