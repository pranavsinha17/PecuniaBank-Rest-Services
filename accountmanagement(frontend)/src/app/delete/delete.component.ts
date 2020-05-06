import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { AccountService } from '../Account.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  error={
    data:''
  }

  userAccount={
    accountHolderName:''
  }

  isDisabled=true;
  isPresent=false;
 
  constructor(private router:Router,private _deleteService:AccountService) { }

  ngOnInit(): void {
  }

  goHome()
  {
    this.router.navigate(['']);
  }

  find(value:any)
  {
    if(value.length>=10)
    {
      this._deleteService.findAccount(value).subscribe(
        result=>{
        this.getAccountByAccountNumber(value);
        this.error=result;
        console.log(this.error);
        if(result.data=='')
        {
          this.isDisabled=false; 
          this.isPresent=true; 
        }
        else
        {
          this.isDisabled=true;
          this.isPresent=false;
          this.userAccount.accountHolderName='';
        }
      });
    }
    else{
      this.isPresent=false;
    }
  }

  deleteAccount(accountNumber:any)
  {
    this._deleteService.deleteAccount(accountNumber)
    .subscribe(
      response=>{
        alert(response.data);
        if(response.data=="Account deleted Sucessfully")
        {
        this.goHome();
        }
        
      }
    );
  }

  getAccountByAccountNumber(value:any)
  {
    this._deleteService.findAccountByAccountNumber(value).subscribe(
      result=>{
        this.userAccount.accountHolderName=result.accountHolderName;
        console.log(this.userAccount)
        console.log(result);
      }
    )
  }
}
