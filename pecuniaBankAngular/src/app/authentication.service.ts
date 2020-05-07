import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }
  
  authenticate(username, password) {
    if (username === "satyam" && password === "11608106") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }

  getuserName()
  {
    
   let name = sessionStorage.getItem('username')
   return name;

  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
