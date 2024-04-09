import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Vehicle} from "../model/vehicle";

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(API_URL + '/vehicles');
  }

  delete(id: number): Observable<Vehicle> {
    return this.http.delete<Vehicle>(API_URL + '/vehicles/' + id);
  }

  findById(id: number): Observable<Vehicle> {
    return this.http.get<Vehicle>( API_URL + '/vehicles/' + id);
  }


  update(id: number, vehicle: Vehicle): Observable<Vehicle> {
    return this.http.put<Vehicle>(API_URL + '/vehicles/' + id, vehicle);
  }
}
