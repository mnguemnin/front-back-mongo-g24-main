import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees:any;
  empId="";
  name="";
  designation="";
  salary=null;

  constructor( private httpClientService:HttpClientService) {

  }
  ngOnInit() {
  this.initEmployeeTable();
  }
  initEmployeeTable() {
    this.httpClientService.getEmployees().subscribe((response)=>{
     this.employees=response;
    }

    );
 }
handleSuccessfulResponse(response)
{
    this.employees=response;
}
add(){
let employee={
  empId:this.empId,
  name:this.name,
  designation:this.designation,
  salary:this.salary,

 }
 this.httpClientService.add(employee).subscribe((response) => {
 this.initEmployeeTable();
 this.empId="";
 this.name="";
 this.designation="";
 this.salary=null;
 });


}

delete(id){
this.httpClientService.delete(id).subscribe((response) => {
this.initEmployeeTable();
},
(error => {
            })
      );
}

}
