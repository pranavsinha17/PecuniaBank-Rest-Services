import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UpdatePassbookComponent } from './passbook/update-passbook/update-passbook.component';
import { AccountSummaryComponent } from './passbook/account-summary/account-summary.component';


const routes: Routes = [
  {path:'updatepassbook',component:UpdatePassbookComponent},
  {path:'accountsummary',component:AccountSummaryComponent},
  {path:'',redirectTo:'/updatepassbook',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
