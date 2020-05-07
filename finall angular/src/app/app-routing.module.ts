import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoanrequestComponent } from './loanrequest/loanrequest.component';
import { LoanLedgerComponent } from './loan-ledger/loan-ledger.component';
import { HomeComponent } from './home/home.component';
import { LedgerbyaccountComponent } from './ledgerbyaccount/ledgerbyaccount.component';


const routes: Routes = [
  {
    path:'loanrequests',component:LoanrequestComponent
    
  },
  {
    path:'loanLedger',component:LoanLedgerComponent
  },
  {
    path:'Home',component:HomeComponent
  },
  {
    path:'ledgerbyaccount',component:LedgerbyaccountComponent
  },
  {
    path:'',redirectTo:'/loanrequests',pathMatch:'full'
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
