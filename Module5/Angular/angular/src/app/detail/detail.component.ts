import {Component, Input, OnInit} from '@angular/core';
import {Student} from "../student";
import {StudentService} from "../student.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  studentDetail: Student| undefined;

  constructor(private _studentService: StudentService,
              private _activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    let index = this._activatedRouter.snapshot.params['index'];
  }

}
