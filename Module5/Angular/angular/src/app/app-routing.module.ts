import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentListComponent} from "./student-list/student-list.component";
import {ReactiveFormComponent} from "./reactive-form/reactive-form.component";
import {DetailComponent} from "./detail/detail.component";


const routes: Routes = [
  {path:"home", component:StudentListComponent},
  {path:"create", component:ReactiveFormComponent},
  {path:"detail/:index", component: DetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
