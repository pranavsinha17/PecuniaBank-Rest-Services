import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoanrequestComponent } from './loanrequest/loanrequest.component';
import { LoanLedgerComponent } from './loan-ledger/loan-ledger.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { LedgerbyaccountComponent } from './ledgerbyaccount/ledgerbyaccount.component';

@NgModule({
  declarations: [
    AppComponent,
    LoanrequestComponent,
    LoanLedgerComponent,
    HomeComponent,
    LedgerbyaccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
