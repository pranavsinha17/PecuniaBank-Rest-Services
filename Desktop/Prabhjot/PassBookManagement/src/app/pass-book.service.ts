import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PassBookService {

  constructor(private http: HttpClient) { }

  loadAccountDetails(accountNumber:number):Observable<any>
  {
    let url="http://localhost:8080/account/"+accountNumber;
    return this.http.get(url);
  }

  loadAccountTransactions(accountNumber:number):Observable<any>
  {
    let url="http://localhost:8080/passbook/transactions/"+accountNumber;
    return this.http.get(url);
  }

  loadUpdatePassbookDetails(accountNumber:number):Observable<any>
  {
    let url="http://localhost:8080/updatepassbook/"+accountNumber;
    return this.http.get(url); 
  }

  updatePassbookAccountTransactions(accountNumber:number,lastUpdate:Date):Observable<any>
  {
    let url="http://localhost:8080/passbook/transactions/"+accountNumber+"/"+lastUpdate;
    console.log(this.http.get(url));
    return this.http.get(url);
  }

  loadPassbookTransactionsByDateRange(accountNumber:number,startingDate:Date,endingDate:Date):Observable<any>
  {   
	  let url = "http://localhost:8080/transactions/search/"+accountNumber+"/"+startingDate+"T00:00:00.000/"+endingDate+"T23:59:59.000";
    console.log(this.http.get(url));
    return this.http.get(url);
  }
}
