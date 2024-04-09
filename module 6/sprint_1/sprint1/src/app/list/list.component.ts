import { Component, OnInit } from '@angular/core';
import {Employee} from "../model/employee";
import {EmployeeService} from "../service/employee.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  id: number;
  name: string;
  date : Date =new Date();

  employees : Employee[] = [];
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.employeeService.getAll().subscribe(
      data => {
        this.employees = data;
      }
    )
  }

  changeId(id: number, name: string) {

    this.id = id;
    this.name = name;

  }

  delete(id: number) {
    this.employeeService.delete(id).subscribe(() => {
      this.getAll();
    }, error => {
      alert("id không tìm thấy")
    });
  }

}
