export class Ledger {
  loanLedgerId: number;
  loanType:string;
  emiAmount: number;
  interestRate:number; 
  numberOfEMI:number;
  duration:number;
  status:string;
  startDate:Date;
  endDate:Date;
  loanRequestId:number;
  accountDetails:Account;
}
export class Account{
    accountNumber: string;
    accountHolderName:string;
    accountBalance:number;
    creditScore:number;
    accountInterest:number;
}
