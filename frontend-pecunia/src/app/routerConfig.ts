import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AuthGaurdService } from './services/auth-guard.service';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { ResetPasswordComponent } from './components/reset-password/reset-password.component';



const appRoutes: Routes = [
  { path: 'login', 
    component: LoginComponent,
    children:[
      {path:'forget',component:ResetPasswordComponent}
    ] 
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
    path:'',redirectTo:'/home',pathMatch:'full',canActivate:[AuthGaurdService]
  }
  
];
export default appRoutes;