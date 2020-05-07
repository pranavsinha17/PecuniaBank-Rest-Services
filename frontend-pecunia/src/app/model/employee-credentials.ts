import { EmployeeDetails } from './employee-details';

export class EmployeeCredentials {
    constructor(  employeeId:string,
        employeePassword:string,employeeDetails:EmployeeDetails)
        {}
    employeeId:string;
    employeePassword:string;
    employeeDetails:EmployeeDetails;
}
