import { Component, OnDestroy, OnInit, ViewChild } from "@angular/core";
import { DataTableDirective } from "../../../../../node_modules/angular-datatables";
import { Subject } from "../../../../../node_modules/rxjs";
import { TipsModel } from "../../../model/tips-model";
import { TipsService } from "../../../services/tips.service";
import { AlertModel, alertType } from "../../../model/alert-model";

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
  alertas: any = [];
  alert: AlertModel;

  @ViewChild(DataTableDirective) dtElement: DataTableDirective;
  dtTrigger: Subject<TipsModel> = new Subject();

  constructor(private tipsServices: TipsService) {
    this.tipsServices.contextoService.subscribe(val => {
      console.log(val);
      this.initContext(val);
    });
  }

  private initContext(data: Map<string, any>) {
    const accion = data.get('accion');
    if (accion === 'listar') {
      const evento = data.get('evento');
      this.resetdata();
      switch (evento) {
        case 'creado': {
          this.alert = new AlertModel('Registro creado con éxito', true, alertType.SUCCESS);
          break;
        }
        case 'modificado': {
          this.alert = new AlertModel('Registro modificado con éxito', true, alertType.SUCCESS);
          break;
        }
        case 'eliminado': {
          this.alert = new AlertModel('Registro eliminado con éxito', true, alertType.SUCCESS);
           break;
         }
      }
      this.alertas.push({
        type: this.alert.type,
        msg: this.alert.msg,
        timeout: 5000
      });
    }
  }

  ngOnInit() {
    this.tipsServices.getListTips().subscribe(data => {
      this.listData = data;
      this.dtTrigger.next();
    });
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }


  resetdata() {
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
    this.tipsServices.contextoService.next(this.context);
  }
  editElemt(data) {
    this.context = new Map<string, any>();
    this.context.set("accion", "modificar");
    this.context.set("data", data);
    this.tipsServices.contextoService.next(this.context);
  }
}
