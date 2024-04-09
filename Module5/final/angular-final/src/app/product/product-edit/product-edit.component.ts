import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Category} from "../../model/category";
import {ProductService} from "../../service/product.service";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  productForm: FormGroup;


  categories: Category[] = [];

  id : number;

  constructor(
    private _formBuilder : FormBuilder,
    private productService: ProductService,
    private categoryService: CategoryService,
    private router: Router,
    private activatedRoute: ActivatedRoute,

  ) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });
  }

  ngOnInit(): void {
    this.getAllCategory();
  }

  getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.productForm = this._formBuilder.group({
        name: new FormControl(product.name, [Validators.required]),
        price: new FormControl(product.price, [Validators.required, Validators.min(150000)]),
        description: new FormControl(product.description, [Validators.required, Validators.minLength(10)]),
        category: new FormControl(product.category, [Validators.required])
      })
    });
  }

  updateProduct(id: number) {
    const product = this.productForm.value;
    if (this.productForm.valid) {
      this.productService.update(id, product).subscribe(() => {
        alert('Update Successfully');
        this.router.navigateByUrl('product/list');
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

  getAllCategory() {
    this.categoryService.getAll().subscribe(
      data => {
        this.categories = data;
      }
    )
  }

  get name() {
    return this.productForm.get('name');
  }
  get price() {
    return this.productForm.get('price');
  }
  get category() {
    return this.productForm.get('category');
  }
  get description() {
    return this.productForm.get('description');
  }


}
