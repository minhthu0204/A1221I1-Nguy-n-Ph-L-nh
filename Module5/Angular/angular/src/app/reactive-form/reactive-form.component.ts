import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Student} from "../student";
import {StudentService} from "../student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent implements OnInit {

  rfStudent: FormGroup;


  constructor(private _formBuilder: FormBuilder,
              private _studentService: StudentService,
              private _router: Router) { }

  ngOnInit(): void {
    this.rfStudent = this._formBuilder.group({
      studentName :['Hoa', [Validators.required]],
      studentGender: [1],
      studentPoint: [90]
    })

  }

  onSubmit(){
    console.log(this.rfStudent);
    if(this.rfStudent.valid){
      this._studentService.save(this.rfStudent.value);
      this._router.navigateByUrl("/home")
    }
  }

}
