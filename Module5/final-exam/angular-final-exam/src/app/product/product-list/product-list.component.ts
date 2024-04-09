import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  id: number;
  name: string;

  products: Product[] = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.productService.getAll().subscribe(
      data => {
        this.products = data;
      });
  }

  changeId(id: number, name: string) {

      this.id = id;
      this.name = name;

  }

  delete(id: number) {
    this.productService.delete(id).subscribe(() => {
      this.getAll();
    }, error => {
      alert('Loi');
    });
  }
}
