import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../student";
import {StudentService} from "../student.service";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  @Output('newStudent') onCreate = new EventEmitter<Student>()

  constructor(private _studentService:StudentService) { }
  student: Student| undefined;
  ngOnInit(): void {
  }

  createStudent(name:string, gender: string, point: string){
    this.student= {name: name, gender: parseInt(gender), point: parseInt(point)}
    this._studentService.save(this.student);
}
}
