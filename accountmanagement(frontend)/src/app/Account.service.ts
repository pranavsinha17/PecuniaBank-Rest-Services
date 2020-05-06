import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
import { UpdateAddress,UpdateMobileNumber,UpdateName } from './update';


@Injectable({
  providedIn: 'root'
})
export class AccountService {

  _url='http://localhost:8084/account';
  _getUrl='http://localhost:8084/accounts';
  _updateNameUrl='http://localhost:8084/updateName';
  _updateMobileUrl='http://localhost:8084/updateMobile';
  _updateAddressUrl='http://localhost:8084/updateAddress';
  _deleteAccountUrl='http://localhost:8084/account/';
  _findAccountUrl='http://localhost:8084/accounts/';
  _findAccountByNumberUrl='http://localhost:8084/account/';

  constructor(private _http:HttpClient) { }
   
  addAccount(user:User):Observable<any>{
    
    return this._http.post<any>(this._url,user);
  }
  getAccount():Observable<any>
  {
    return this._http.get<any>(this._getUrl);
  }
  updateName(updateName:UpdateName)
  {
    return this._http.post<any>(this._updateNameUrl,updateName);
  }
  updateMobile(updateMobileNumber:UpdateMobileNumber)
  {
    return this._http.post<any>(this._updateMobileUrl,updateMobileNumber)
  }
  updateAddress(updateAddress:UpdateAddress)
  {
    return this._http.post<any>(this._updateAddressUrl,updateAddress)
  }
  deleteAccount(deleteAccount:any)
  {
    return this._http.delete<any>(this._deleteAccountUrl+deleteAccount);
  }
  findAccount(accountNumber:any)
  {
    return this._http.get<any>(this._findAccountUrl+accountNumber);
  }
  findAccountByAccountNumber(acountNumber:any)
  {
    return this._http.get<any>(this._findAccountByNumberUrl+acountNumber);
  }
  
}
