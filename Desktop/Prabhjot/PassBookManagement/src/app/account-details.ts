import { CustomerDetails } from './customer-details';
import { BranchDetails } from './branch-details';


export class AccountDetails {

    accountNumber:number;
    customerDetails:CustomerDetails;
    accountHolderName:string;
    accountStatus:string;
    accountBalance:any;
    creditScore:number;
    accountInterest:string;
    openingDate:Date;
    branchdetails:BranchDetails;
}
