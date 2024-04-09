import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Start} from "../model/start";
import {environment} from "../../environments/environment";
import {End} from "../model/end";

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class EndService {

  constructor(private http: HttpClient) {

  }

  getAll(): Observable<End[]> {
    return this.http.get<End[]>(API_URL + '/ends');
  }
}
