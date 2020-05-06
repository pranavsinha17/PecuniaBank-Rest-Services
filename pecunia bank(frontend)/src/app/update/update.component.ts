import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AccountService} from '../Account.service';
import {UpdateName,UpdateAddress,UpdateMobileNumber } from '../update';
import { Address } from '../user';
import { SelectControlValueAccessor } from '@angular/forms';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  
  nameModel=new UpdateName(null,'','');
  mobileModel=new UpdateMobileNumber('',null);
  addressModel=new UpdateAddress(null,new Address('','','',''));
  error={
    data:''
  }

 userAccount={
    contactNumber:'',
    accountHolderName:'',
    address:{
      street:'',
      city:'',
      state:'',
      zipCode:''
    }
  }
  isDisabled=true;
  isDisabledContact=true;
  isDisabledAddress=true;
  showExisting=false;
  nameValue=false;
  contactValue=false;
  addressValue=false;

  constructor(private router:Router,private _updateService:AccountService) { }

  ngOnInit(): void {
  }
  
  goHome()
  {
    this.router.navigate(['']);
  }
  onSubmit()
  {
    if(this.nameValue)
    {
      this._updateService.updateName(this.nameModel).subscribe(
        (result:any)=>{console.log(result)
        alert(result.data);
        this.nameValue=false;
        this.contactValue=false;
        this.addressValue=false;
        this.showExisting=false;

        });
    }
    else if(this.contactValue)
    {
      this._updateService.updateMobile(this.mobileModel).subscribe(
        (result:any)=>{console.log(result)
        alert(result.data);
        this.nameValue=false;
        this.contactValue=false;
        this.addressValue=false;
        this.showExisting=false;
        
        });
    }
    else if(this.addressValue)
    {
      this._updateService.updateAddress(this.addressModel).subscribe(
        (result:any)=>{console.log(result)
          alert(result.data);
          this.nameValue=false;
        this.contactValue=false;
        this.addressValue=false;
        this.showExisting=false;
        
        });

    }
  }

  find(value:any)
  {
    if(value.length>=10)
    {
      this._updateService.findAccount(value).subscribe(
        result=>{
          this.getAccountByAccountNumber(value);
          this.error=result;
        console.log(this.error);
        if(result.data=='')
        {
          this.nameModel.accountNumber=value;
          this.mobileModel.accountNumber=value;
          this.addressModel.accountNumber=value;
          this.showExisting=true;
          this.isDisabled=false;  
        }
        else
        {
          this.isDisabled=true;
          this.userAccount.accountHolderName='';
          this.userAccount.contactNumber='';
          this.userAccount.address.street='';
          this.userAccount.address.city='';
          this.userAccount.address.state='';
          this.userAccount.address.zipCode='';
          this.showExisting=false;
        }
      });
    }
    else{
      this.showExisting=false;
    }
  }

  getAccountByAccountNumber(value:any)
  {
    this._updateService.findAccountByAccountNumber(value).subscribe(
      result=>{
        this.userAccount.accountHolderName=result.accountHolderName;
        this.userAccount.contactNumber=result.customerDetails.contactNumber;
        this.userAccount.address=result.customerDetails.address;
        console.log(this.userAccount)
        console.log(result);
      }
    )
  }

  getUpdatedView(value)
  {
    if(value=='Name')
    {
      this.nameValue=true;
      this.contactValue=false;
      this.addressValue=false;
    }
    else if(value=='Contact Number')
    {
      this.nameValue=false;
      this.contactValue=true;
      this.addressValue=false;
    }
    else if(value=='Address')
    {
      this.nameValue=false;
      this.contactValue=false;
      this.addressValue=true;
    }

  }

}
