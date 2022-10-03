import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularPipesComponentComponent } from './angular-pipes-component.component';

describe('AngularPipesComponentComponent', () => {
  let component: AngularPipesComponentComponent;
  let fixture: ComponentFixture<AngularPipesComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularPipesComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularPipesComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
