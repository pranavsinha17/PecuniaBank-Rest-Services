import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TransactionComponent } from './transaction/transaction.component';
import { DepositSlipComponent } from './deposit-slip/deposit-slip.component';
import { WithdrawalSlipComponent } from './withdrawal-slip/withdrawal-slip.component';
import { WithdrawalChequeComponent } from './withdrawal-cheque/withdrawal-cheque.component';
import { DepositChequeComponent } from './deposit-cheque/deposit-cheque.component';
import { TransferChequeComponent } from './transfer-cheque/transfer-cheque.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthguardService } from './authguard.service';


const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent ,canActivate:[AuthguardService]},
  {path:'Transcation',component:TransactionComponent,canActivate:[AuthguardService]},
  {path:'DepositSlip',component:DepositSlipComponent,canActivate:[AuthguardService]},
  {path:'WithdrawalSlip',component:WithdrawalSlipComponent,canActivate:[AuthguardService]},
  {path:'WithdrawalCheque',component:WithdrawalChequeComponent,canActivate:[AuthguardService]},
  {path:'DepositCheque',component:DepositChequeComponent,canActivate:[AuthguardService]},
  {path:'TransferCheque',component:TransferChequeComponent,canActivate:[AuthguardService]},
  {path:'',redirectTo:'/login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
