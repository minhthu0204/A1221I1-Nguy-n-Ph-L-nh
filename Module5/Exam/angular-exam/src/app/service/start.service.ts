import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Start} from "../model/start";

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class StartService {

  constructor(private http: HttpClient) {

  }

  getAll(): Observable<Start[]> {
    return this.http.get<Start[]>(API_URL + '/starts');
  }
}