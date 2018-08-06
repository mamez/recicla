import {
  AfterViewInit,
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnDestroy,
  OnInit,
  Output,
  SimpleChanges,
  ViewChild
} from "@angular/core";
import { Subject } from "rxjs";
import { HttpClient } from "../../../../node_modules/@angular/common/http";
import { DataTableDirective } from "../../../../node_modules/angular-datatables";

@Component({
  selector: "app-data-table",
  templateUrl: "./data-table.component.html",
  styles: []
})
export class DataTableComponent
  implements OnChanges, OnDestroy, OnInit, AfterViewInit {
  @ViewChild(DataTableDirective) dtElement: DataTableDirective;

  @Output() deleteRow: EventEmitter<any> = new EventEmitter<any>();

  @Output() editRow: EventEmitter<any> = new EventEmitter<any>();

  @Input() config: any = {};

  dtTrigger: Subject<any> = new Subject();
  listData: object = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get(this.config.url).subscribe(data => {
      this.listData = data;
    });
    console.log("init1");
  }

  ngAfterViewInit(): void {
    this.dtTrigger.next();
    console.log("init2");
  }

  ngOnChanges(changes: SimpleChanges) {
    // tslint:disable-next-line:forin
    for (const propName in changes) {
      const change = changes[propName];
      const isReloat = change.currentValue.reload;
      if (isReloat) {
        this.rerender();
      }
    }
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

  rerender(): void {
    this.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
      // Destroy the table first
      dtInstance.destroy();
      // Call the dtTrigger to rerender again
      // this.dtTrigger.next();
    });
  }
}
