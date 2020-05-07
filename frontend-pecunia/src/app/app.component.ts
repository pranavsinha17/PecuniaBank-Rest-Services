import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
 
  constructor(public loginService:AuthenticationService){}
  name:string;
  
  ngOnInit(): boolean {
    this.name=this.loginService.profile();
    if(this.name==='admin')
    return true;
   return false;
    
  }

  

  title = 'PecuniaBank';

}

