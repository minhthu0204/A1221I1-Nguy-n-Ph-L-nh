import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent implements OnInit {

  rfStudent: FormGroup;


  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.rfStudent = this._formBuilder.group({
      studentName :['Hoa', [Validators.required]],
      studentGender: [],
      studentPoint: []
    })

  }

}
