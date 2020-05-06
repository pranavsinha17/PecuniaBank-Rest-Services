import { Component, OnInit } from '@angular/core';
import { AccountService} from '../Account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  data=[];

  headers=['Account Number',
  'Account Holder Name',
  'Account Status',
  'Account Balance',
  'Account Interest',
  'Opening Date'
  ];

  keys=['accountNumber',
  'accountHolderName',
  'accountStatus',
  'accountBalance',
  'accountInterest',
  'openingDate'
  ];

  customerHeaders=['Customer Id',
  'First Name',
  'Last Name',
  'DOB',
  'Age',
  'Contact Number',
  'Gender',
  'Adhaar Number',
  'Account Type',
  ];

  customerKeys=['customerId',
  'customerFirstName',
  'customerLastName',
  'dob',
  'age',
  'contactNumber',
  'gender',
  'adhaarNumber',
  'accountType'
  ];

  addressHeaders=['Street',
  'City',
  'State',
  'Zipcode'
  ];

  addressKeys=['street',
  'city',
  'state',
  'zipCode'
  ];

  searchText;

  constructor(private router:Router,private _createService:AccountService) {
    
    this.getAccount();
    
  }

  ngOnInit(): void {
  }

  getAccount()
  {
      this._createService.getAccount().subscribe(
        response=>{
          for(let r of response)
          {
            this.data.push(r);
          }
        },
        error=>{console.error(error)}
      );
  }
  
  goHome()
  {
    this.router.navigate(['']);
  }

}
