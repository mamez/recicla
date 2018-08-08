import { Component, OnInit, ViewChild, OnDestroy } from '@angular/core';
import { TipoReciclajeModel } from '../../../model/tipo-reciclaje-model';
import { AlertModel, alertType } from '../../../model/alert-model';
import { DataTableDirective } from '../../../../../node_modules/angular-datatables';
import { Subject } from '../../../../../node_modules/rxjs';
import { TipoReciclajeService } from '../../../services/tipo-reciclaje.service';

@Component({
  selector: 'app-tipo-revciclaje',
  templateUrl: './tipo-revciclaje.component.html',
  styles: []
})
export class TipoRevciclajeComponent implements OnInit, OnDestroy {
  titulo = "Tipos Reciclajes";
  configuracion: any = {};
  listData: Array<TipoReciclajeModel>;
  context: Map<string, string>;
  alertas: any = [];
  alert: AlertModel;

  @ViewChild(DataTableDirective) dtElement: DataTableDirective;
  dtTrigger: Subject<TipoReciclajeModel> = new Subject();

  constructor(private tipoReciclajeService: TipoReciclajeService) {
    this.tipoReciclajeService.contextoService.subscribe(val => {
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
    this.tipoReciclajeService.getList().subscribe(data => {
      this.listData = data;
      this.dtTrigger.next();
    });
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }


  resetdata() {
    const mapdata = new Map<string, any>();
    this.tipoReciclajeService.getList().subscribe(data => {
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
    this.tipoReciclajeService.contextoService.next(this.context);
  }
  editElemt(data) {
    this.context = new Map<string, any>();
    this.context.set("accion", "modificar");
    this.context.set("data", data);
    this.tipoReciclajeService.contextoService.next(this.context);
  }

}
