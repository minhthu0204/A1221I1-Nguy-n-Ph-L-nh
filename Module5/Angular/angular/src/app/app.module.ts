import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AngularPipesComponentComponent } from './angular-pipes-component/angular-pipes-component.component';
import { DetailComponent } from './detail/detail.component';
import { CreateComponent } from './create/create.component';
import { ReactiveFormComponent } from './reactive-form/reactive-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import { StudentListComponent } from './student-list/student-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AngularPipesComponentComponent,
    DetailComponent,
    CreateComponent,
    ReactiveFormComponent,
    StudentListComponent
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }