import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {VehicleService} from "../service/vehicle.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Start} from "../model/start";
import {End} from "../model/end";
import {StartService} from "../service/start.service";
import {EndService} from "../service/end.service";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  vehicleForm: FormGroup;

  starts: Start[] = [];

  ends: End[] = [];

  id : number;

  constructor(
    private _formBuilder : FormBuilder,
    private vehicleService: VehicleService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private startService: StartService,
    private endService: EndService

  ) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getVehicle(this.id);
    });
  }

  ngOnInit(): void {
    this.getAllStart();
    this.getAllEnd();
  }


  private getVehicle(id: number) {
    return this.vehicleService.findById(id).subscribe(vehicle => {
      this.vehicleForm = this._formBuilder.group({
        // id: new FormControl(vehicle.id, [Validators.required]),
        // type:new FormControl(vehicle.type, [Validators.required]),
        // name: new FormControl(vehicle.name, [Validators.required]),
        // start: new FormControl(vehicle.start, [Validators.required]),
        // end: new FormControl(vehicle.end, [Validators.required]),
        // number: new FormControl(vehicle.number, [Validators.pattern(/^(090|093|097)\d{7}$/)]),
        // email :new FormControl(vehicle.id, [Validators.email]),
        // timeToStart: new FormControl(vehicle.id, [Validators.required]),
        // timeToArrive: new FormControl(vehicle.id, [Validators.required])

        id: new FormControl(vehicle.id, [Validators.required]),
        type:new FormControl(vehicle.type, [Validators.required]),
        name: new FormControl(vehicle.name, [Validators.required]),
        start: new FormControl(vehicle.start, [Validators.required]),
        end: new FormControl(vehicle.end, [Validators.required]),
        number: new FormControl(vehicle.number, [Validators.pattern(/^(090|093|097)\d{7}$/)]),
        email :new FormControl(vehicle.id, [Validators.email]),
        timeToStart: new FormControl(vehicle.id, [Validators.required]),
        timeToArrive: new FormControl(vehicle.id, [Validators.required])

      })
    });

  }

  updateVehicle(id: number) {
    const product = this.vehicleForm.value;
    if (this.vehicleForm.valid) {
    this.vehicleService.update(id, product).subscribe(() => {
      alert('Update Successfully');
      this.router.navigateByUrl('list');
    }, error => {
      alert('Loi');
    });
  }
  }

  compareObjects(o1: any, o2: any) {
    if (o1 === null || o2 === null) {
      return false;
    }
    return o1.id === o2.id;
  }

  private getAllStart() {
    this.startService.getAll().subscribe(
      data => {
        this.starts = data;
      }
    )
  }

  private getAllEnd() {
    this.endService.getAll().subscribe(
      data => {
        this.ends = data;
      }
    )
  }

  get name() {
    return this.vehicleForm.get('name');
  }
  get type() {
    return this.vehicleForm.get('type');
  }
  get start () {
    return this.vehicleForm.get('start');
  }
  get end() {
    return this.vehicleForm.get('end');
  }
  get number() {
    return this.vehicleForm.get('number');
  }
  get email() {
    return this.vehicleForm.get('email');
  }
  get timeToStart() {
    return this.vehicleForm.get('timeToStart');
  }
  get timeToArrive() {
    return this.vehicleForm.get('timeToArrive');
  }



}
