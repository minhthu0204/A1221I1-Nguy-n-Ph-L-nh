import { Injectable } from '@angular/core';
import {Product} from "../model/product";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const api = `${environment.api_url}`;
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getAll() : Observable<Product[]> {
    return this.http.get<Product[]>(api);
  }

  saveProduct(product): Observable<Product> {
    return this.http.post<Product>(api,product);
  }

  findById(id: number) : Observable<Product> {
    return this.http.get<Product>(api + "/" + id);
  }

  updateProduct(id: number, product: Product) : Observable<Product> {
    return this.http.put<Product>(api + "/" + id , product);
  }

  deleteProduct(id: number) : Observable<Product>{
    return this.http.delete<Product>(api + "/" + id);
  }

}
