import { Pipe, PipeTransform } from '@angular/core';
import { Transaction } from './transaction';

@Pipe({
  name: 'orderBy'
})
export class OrderByPipe implements PipeTransform {

    transform(transactions:Transaction[], propertyName: string): any[] {
     if (propertyName)
       return transactions.sort((a: any, b: any) => a[propertyName].localeCompare(b[propertyName]));
     else
       return transactions;
   }
}
