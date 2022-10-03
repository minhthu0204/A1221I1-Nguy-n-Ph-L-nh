import { Component } from '@angular/core';
import {Student} from "./student";
import {StudentService} from "./student.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular';

  // check: boolean = true;

  // student:Student[]=
  //   [
  //     {name:"Nguyễn Phú Lĩnh",gender: 1, point: 100 },
  //     {name: "Nguyễn Khánh Vi ", gender: 0, point:80},
  //     {name:"Nguyễn Thanh Phương",gender:1, point:40},
  //     {name:"Nguyễn Thị Minh Thư", gender:2, point: 60}
  //   ]


  // onToggle(){
  //   this.check = !this.check;
  // }

  students: Student[]| undefined;

  studentDetail : Student| undefined;

  constructor(private _studentService: StudentService) {
  }

  showDetail(item: Student){
    this.studentDetail = item;
  }

  getNewStudent(value: Student){

  }

  ngOnInit(): void{
    this.students = this._studentService.student;



  }
}
