
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { RouterModule } from '@angular/router';
import appRoutes from './routerConfig';
import { MatDialogModule } from '@angular/material/dialog';
import { LogoutComponent } from './components/logout/logout.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { BasicAuthHttpInterceptorService } from './services/basic-auth-http-interceptor.service';
import { ResetPasswordComponent } from './components/reset-password/reset-password.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoutComponent,
    AddEmployeeComponent,
    ResetPasswordComponent,
  
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    RouterModule.forRoot(appRoutes),
    MatDialogModule,
    HttpClientModule ],
  providers: [{provide:HTTP_INTERCEPTORS, useClass:BasicAuthHttpInterceptorService, multi:true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
