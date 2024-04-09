import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../model/employee";


const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL + '/employee');
  }

  delete(id: number): Observable<Employee> {
    return this.http.delete<Employee>(API_URL + '/delete/' + id);
  }

  save(employee): Observable<Employee> {
    return this.http.post<Employee>(API_URL + '/employees', employee);
  }
}
