import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cheque } from '../model/cheque';
import { Slip } from '../model/slip';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  insertSlip1(slip:Slip) {
    return this.http.post("http://localhost:8082/SlipDebitDetails",slip,{responseType:"text"});
  }
  insertSlip(slip: Slip) {
    return this.http.post("http://localhost:8082/SlipCrediDetails",slip,{responseType:"text"});
  }
  

  
  constructor(private http: HttpClient) { }

  insertcheque( cheque:Cheque):Observable<any>{
   console.log(cheque)
    return this.http.post("http://localhost:8082/DebitChequeDetails",cheque,{responseType:"text"});
  }
  insertcheque1( cheque:Cheque):Observable<any>{
    console.log(cheque)
     return this.http.post("http://localhost:8082/CreditChequeDetails",cheque,{responseType:"text"});
   }

}
