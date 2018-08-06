import { Component, OnDestroy, OnInit, ViewChild } from "@angular/core";
import { DataTableDirective } from "../../../../../node_modules/angular-datatables";
import { Subject } from "../../../../../node_modules/rxjs";
import { TipsModel } from "../../../model/tips-model";
import { TipsService } from "../../../services/tips.service";

@Component({
  selector: "app-tips",
  templateUrl: "./tips.component.html",
  styles: []
})
export class TipsComponent implements OnInit, OnDestroy {
  titulo = "Tips";
  order: string;
  configuracion: any = {};
  listData: Array<TipsModel>;
  context: Map<string, string>;

  @ViewChild(DataTableDirective) dtElement: DataTableDirective;
  dtTrigger: Subject<TipsModel> = new Subject();

  constructor(private tipsServices: TipsService) {}

  ngOnInit() {
    const apiUrl = "jobGreen/tips";
    this.tipsServices.getListTips().subscribe(data => {
      this.listData = data;
      this.dtTrigger.next();
    });
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }

  estadoGuardado($event) {
    const mapdata = new Map<string, any>();
    this.tipsServices.getListTips().subscribe(data => {
      this.listData = data;
      this.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
        dtInstance.destroy();
        this.dtTrigger.next();
      });
    });
  }
  estadoEliminado($event) {
    const mapdata = new Map<string, any>();
    this.tipsServices.getListTips().subscribe(data => {
      this.listData = data;
      this.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
        dtInstance.destroy();
        this.dtTrigger.next();
      });
    });
  }

  deleteElemt(data) {
    this.context = new Map<string, any>();
    this.context.set("accion", "eliminar");
    this.context.set("data", data);
    this.tipsServices.popup.next(this.context);
  }
  editElemt(data) {
    this.context = new Map<string, any>();
    this.context.set("accion", "modificar");
    this.context.set("data", data);
    this.tipsServices.popup.next(this.context);
  }
}
