import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShareBetweenComponentsService {
  count:number=4;
  getCount()
  {
    return this.count;
  }
  setCount(count)
  {
    this.count=count;
  }
}
