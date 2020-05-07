import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Slip } from 'src/app/model/slip';
import { Transaction } from 'src/app/model/transaction';
import { TransactionService } from 'src/app/services/transaction.service';

@Component({
  selector: 'app-transaction-by-slip',
  templateUrl: './transaction-by-slip.component.html',
  styleUrls: ['./transaction-by-slip.component.scss']
})
export class TransactionBySlipComponent implements OnInit {

  
  transactionType=['Credit','Debit'];
  bankType=['PECUNIA'];
  transactionStatement:any;
  transactionErrorInfo:any;
  ngForm:FormGroup;
  val:boolean=false;
  transation:Transaction;
  constructor(private transaction:TransactionService) { }
 slip:Slip=new Slip();
  ngOnInit(): void {
  }

  doTransaction()
  {
    this.slip.status="Unknown";
    if(this.slip.transactionType=="Debit")
    {
      
      this.transactionStatement=this.transaction.insertSlip1(this.slip).subscribe(data=>{this.transactionStatement=data}
        ,error=>{this.transactionErrorInfo=error.error;
        });
    }
    else{
      this.transactionStatement=this.transaction.insertSlip(this.slip).subscribe(data=>{this.transactionStatement=data;this.val=true}
        ,error=>{this.transactionErrorInfo=error.error;this.val=false});
    }
    if(this.val==false)
    alert(this.transactionErrorInfo.toString);
    this.ngForm.reset();

    
  }

}
