import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UpdatePassbookComponent } from './passbook/update-passbook/update-passbook.component';
import { AccountSummaryComponent } from './passbook/account-summary/account-summary.component';
import { PassBookService } from './pass-book.service';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { SearchPipePipe } from './search-pipe.pipe';
import { OrderByPipe } from './order-by.pipe';

@NgModule({
  declarations: [
    AppComponent,
    UpdatePassbookComponent,
    AccountSummaryComponent,
    SearchPipePipe,
    OrderByPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [PassBookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
