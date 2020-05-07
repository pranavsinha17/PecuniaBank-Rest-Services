import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Request } from './request';
import{ Account} from './ledger';

@Injectable({
  providedIn: 'root'
})
export class LoanService {

  loadLedgersAccount(accountNumber1: string):Observable<any> {
    return this.http.get("http://localhost:8084/viewLedger/"+accountNumber1);
  }

   constructor(private http:HttpClient) { }
   public  loadLedgers(): Observable<any>{
    return this.http.get("http://localhost:8084/viewLedgerData");
  }



  public loanrequest(request: Request): Observable<any> {
    return this.http.post('http://localhost:8084/loanRequest', request, {responseType: 'text'});
  }
  
  public checkaccount(accountNumber:string):Observable<any>
  {
    let url="http://localhost:8084/checkAccount/"+accountNumber;
    return this.http.get(url,{responseType: 'text'});
  }
}

