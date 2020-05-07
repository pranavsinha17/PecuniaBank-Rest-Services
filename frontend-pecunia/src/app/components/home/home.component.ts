import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  constructor() { 
  
  }

  ngOnInit(): void {
    
    
    let contains=["BANKING SOLUTIONS","FINANCING SOLUTIONS","SAVINGS ACCOUNT"];
    let define=["We at Pecunia believe in modern solutions to your banking systems","We provide loans at minimal ROI and with less paper work","Open accounts at a very good interest. We welcome you to our family"];
    var counter = 0;
var elem = document.getElementById("changeText");
var elem2=document.getElementById("def");
var inst = setInterval(change, 3000);
var ins2=setInterval(change,3000);

    function change() {
      elem.innerHTML = contains[counter];
      elem2.innerHTML=define[counter];
      counter++;
      if (counter >= contains.length) {
        counter = 0;
        // clearInterval(inst); // uncomment this if you want to stop refreshing after one cycle
      }
    }
  
  }

}
