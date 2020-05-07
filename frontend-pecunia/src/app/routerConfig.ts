import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AuthGaurdService } from './services/auth-guard.service';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { TransactionBySlipComponent } from './components/transaction-by-slip/transaction-by-slip.component';
import { TransactionByChequeComponent } from './components/transaction-by-cheque/transaction-by-cheque.component';



const appRoutes: Routes = [
  { path: 'login', 
    component: LoginComponent 
  }
,
{
    path:'home',
    component: HomeComponent,
    canActivate:[AuthGaurdService]
},
{ path: 'logout', component: LogoutComponent ,canActivate:[AuthGaurdService]},
{
    path:'add-employee',
    component: AddEmployeeComponent,
    canActivate:[AuthGaurdService]
},
{
  path:'transaction-by-slip',
  component: TransactionBySlipComponent,
  canActivate:[AuthGaurdService]
},
{
  path:'transaction-by-cheque',
  component: TransactionByChequeComponent,
  canActivate:[AuthGaurdService]
},

{
    path:'',redirectTo:'/home',pathMatch:'full',canActivate:[AuthGaurdService]
  }
  
];
export default appRoutes;