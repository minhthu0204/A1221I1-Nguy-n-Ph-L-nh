import { Component, OnInit } from '@angular/core';
import {Student} from "../student";
import {StudentService} from "../student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  student: Student | undefined;

  students: Student[]| undefined;


  constructor(private _studentService:StudentService,
              private _router: Router) { }

  ngOnInit(): void {
    this.students = this._studentService.student;
  }

  showDetail(index: number){
    this._router.navigate(['detail',index])
  }

  getNewStudent(value: Student){
    this._studentService.save(value)
  }

}
