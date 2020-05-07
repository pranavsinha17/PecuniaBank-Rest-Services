import { Pipe, PipeTransform } from '@angular/core';
import { Transaction } from './transaction';

@Pipe({
  name: 'searchPipe'
})
export class SearchPipePipe implements PipeTransform {

  transform(transactions:Transaction[],searchTerm :string) {
    if(!transactions|| !searchTerm)
    {
    return transactions;
   }
   else
   return transactions.filter(transaction=>transaction.transactionType.toLowerCase().indexOf(searchTerm.toLowerCase())!=-1);
  }
}
