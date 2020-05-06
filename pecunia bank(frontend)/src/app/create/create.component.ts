import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';
import { Address } from '../user';
import { AccountService } from '../Account.service';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  userModel=new User('','','','','','','','','',null,new Address('','','',''),'118001',null);  
  
  data=[];
  dataPan=[];
  isPresent=false;
  isPanPresent=false;
  constructor(private router:Router,private _createService:AccountService) { }
  
  ngOnInit() {
  }

  

  onSubmit(){
    this._createService.addAccount(this.userModel)
    .subscribe((result:any)=>{
      alert(result.data);
      this.goHome()});
 
  }

   goHome(){
     
     this.router.navigate(['']);
   }

  getAge(value:any){

    this.userModel.age='';
    let currentYear: any = new Date().getFullYear(); //2020
    let userBirthYear: any = new Date(value).getFullYear();
    let age = currentYear - userBirthYear
    if(age>=0)
    {
      this.userModel.age = age.toString();
    }
  }
  checkAdhaar(value)
  {
    if(value.length==11)
    {
      
      this.isPresent=false;
    }
    else if(value.length==10)
    {
      this.data=[];
    }
    else if(value.length==12)
    {
      this.find();
      this.data.forEach((element,index,array)=>{
        if(element==value)
        {
          this.isPresent=true;
        }
      }) 
    }
    else
    {
      this.isPresent=false;

    }
  }
  checkPan(value)
  {
    if(value.length==9)
    {
      this.isPanPresent=false;
    }
    else if(value.length==8)
    {
      this.dataPan=[];
    }
    else if(value.length==10)
    {
      this.find();
      this.dataPan.forEach((element,index,array)=>{
        if(element==value)
        {
          this.isPanPresent=true;
        }
      })
    }
    else
    {
      this.isPanPresent=false;
    }

  }
  

  find()
  {
    this._createService.getAccount().subscribe(
      response=>{
        for(let r of response)
        {
          this.data.push(r.customerDetails.adhaarNumber);  
          this.dataPan.push(r.customerDetails.panNumber)  
        }
        
      });
  }
}