import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-angular-pipes-component',
  templateUrl: './angular-pipes-component.component.html',
  styleUrls: ['./angular-pipes-component.component.css']
})
export class AngularPipesComponentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  dataStr: string ="Lĩnh bị bồ đá";
  dataNumber: number = 19.122002;
  dataMoney: number = 9;
  today: Date = new Date();

}
