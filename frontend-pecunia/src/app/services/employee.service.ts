import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
   
  accountError:string;
  constructor(private http:HttpClient) { }

  putData(credentials)
  {
     this.http.post('http://localhost:8082/addEmployee',credentials).pipe(catchError(this.handleError)).subscribe((data)=>{
      console.log(data+'added');
    });
  }

  resetData(data,username)
  {
    this.http.put(`http://localhost:8082/password-reset/${username}`,data).pipe( retry(1),
    catchError(this.handleError)
).subscribe((data)=>{
      console.log(data+'added');
    });
  }

  updateData(data,username)
  {
    this.http.put(`http://localhost:8082/employee/${username}`,data).pipe( retry(1),
    catchError(this.handleError)
).subscribe((data)=>{
      console.log(data+'added');
    });
  }
  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
        // client-side error
        errorMessage = `Error: ${error.error.message}`;
    } else {
        // server-side error
        if(error.status==200)
        error.error="Successful";
        errorMessage = `Error Code: ${error.status}\nMessage: ${error.error}`;
        
    }
    console.log(errorMessage);
    window.alert(errorMessage);
    return throwError(errorMessage);
}
}
