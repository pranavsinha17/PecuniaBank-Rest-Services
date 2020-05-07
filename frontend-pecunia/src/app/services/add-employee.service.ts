import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddEmployeeService {

  constructor(private http:HttpClient) { }

  putData(credentials)
  {
    this.http.post('http://localhost:8082/addEmployee',credentials).subscribe((data)=>{
      console.log(data+'added');
    });
  }
}
