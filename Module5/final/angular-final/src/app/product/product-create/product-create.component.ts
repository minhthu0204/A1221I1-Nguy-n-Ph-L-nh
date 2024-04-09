import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Category} from "../../model/category";
import {ProductService} from "../../service/product.service";
import {CategoryService} from "../../service/category.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {


  productForm: FormGroup;


  categories: Category[] = [];


  constructor(
    private _formBuilder : FormBuilder,
    private productService: ProductService,
    private categoryService: CategoryService,
    private router: Router
  ) { }




  ngOnInit(): void {
    this.getAllCategory();
    this.productForm = this._formBuilder.group({
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required, Validators.min(150000)]),
      description: new FormControl('', [Validators.required, Validators.minLength(10)]),
      category: new FormControl('', [Validators.required])
    })
  }

  submit() {
    if (this.productForm.valid) {
      this.productService.saveProduct(this.productForm.value).subscribe(
        data => {
          console.log(data)
          this.router.navigateByUrl("/product/list");
        }
      )
    }
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
