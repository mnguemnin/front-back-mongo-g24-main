import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

export class Employee{
  constructor(
    public empId:string,
    public name:string,
    public designation:string,
    public salary:string,
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {
  private employeesService = environment.service + '/employees';
  constructor(
    private httpClient:HttpClient
  ) {
     }

     getEmployees()
  {
    console.log("test call");
    console.log(this.employeesService);
    return this.httpClient.get<Employee[]>(this.employeesService);
  }
delete(id) {
    return this.httpClient.delete(environment.service +`/delete/`+id);
  }
add(employee) {
    return this.httpClient.post(environment.service+`/add`,employee);
  }




}
