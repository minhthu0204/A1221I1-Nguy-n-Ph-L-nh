import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) {

  }
  getAll(): Observable<Category[]> {
    return this.http.get<Category[]>(API_URL + '/categories');
  }
}
