import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {EmployeeService} from "../service/employee.service";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  employeeForm: FormGroup = new FormGroup({
    name: new FormControl(),
    birthday: new FormControl(),
    cmnd: new FormControl(),
    gender: new FormControl(),
    email: new FormControl(),
    img_url: new FormControl(),
    username: new FormControl(),
    password: new FormControl()

  });

  submit() {
    const employee = this.employeeForm.value;
    employee.user = {
      username: employee.username,
      password: employee.password
    };
    this.employeeService.save(employee).subscribe(() => {
      alert('Tạo thành công');
      this.employeeForm.reset();
    }, e => console.log(e));
  }



  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
  }

}
