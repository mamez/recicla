import { Component, OnInit, OnDestroy, Input, Output, EventEmitter } from '@angular/core';
import { first } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { HttpClient } from '../../../../node_modules/@angular/common/http';

@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styles: []
})
export class DataTableComponent implements OnDestroy, OnInit {
  @Output()
  deleteRow: EventEmitter<any> = new EventEmitter<any>();

  @Output()
  editRow: EventEmitter<any> = new EventEmitter<any>();

  @Input()
  config: any = {};

  dtTrigger: Subject<any> = new Subject();
  listData: object = [];


  constructor(private http: HttpClient) {}

  ngOnInit() {
   this.http.get(this.config.url).subscribe(data => {
    this.listData = data;
    this.dtTrigger.next();
  });
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }

  deleteElemt(data: any): void {
    this.deleteRow.emit(data);
  }

  editElemt(data: any): void {
    this.editRow.emit(data);
  }

}
