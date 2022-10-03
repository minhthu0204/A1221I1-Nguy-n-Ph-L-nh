import { Injectable } from '@angular/core';
import {Student} from "./student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private _student: Student[] = [
    {name: "Nguyen Van A", gender: 0, point: 100},
    {name: "Nguyen Van B", gender: 1, point: 80},
    {name: "Nguyen Van C", gender: 2, point: 50},
    {name: "Nguyen Van D", gender: 0, point: 0}
  ]

  constructor() { }


  get student(): Student[] {
    return this._student;
  }

  set student(value: Student[]) {
    this._student = value;
  }

  save(student:Student){
    this._student.unshift(student);
  }
}
