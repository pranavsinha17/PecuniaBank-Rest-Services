import { Address } from './address';

export class EmployeeDetails {
    constructor(branchId:number,
        employeeFirstName:string,
        employeeLastName:string,
        dob: string,
        age:string,
        gender:string,
        panNumber:string,
        adharNumber:string,
        mobileNumber:string,
        address:Address)
    {}
    branchId:number;
    employeeFirstName:string;
    employeeLastName:string;
    dob: string;
    age:string;
    gender:string;
    panNumber:string;
    adharNumber:string;
    mobileNumber:string;
    address:Address;
}
