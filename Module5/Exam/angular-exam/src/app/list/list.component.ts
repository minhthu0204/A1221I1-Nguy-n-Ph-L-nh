import { Component, OnInit } from '@angular/core';
import {Vehicle} from "../model/vehicle";
import {VehicleService} from "../service/vehicle.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {


  id: number;
  name: string;

  vehicles: Vehicle[] = [];

  constructor(private vehicleService: VehicleService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.vehicleService.getAll().subscribe(
      data => {
        this.vehicles = data;
      });
  }

  changeId(id: number, name: string) {

    this.id = id;
    this.name = name;

  }

  delete(id: number) {
    this.vehicleService.delete(id).subscribe(() => {
      this.getAll();
    }, error => {
      alert('Error');
    });
  }

}
