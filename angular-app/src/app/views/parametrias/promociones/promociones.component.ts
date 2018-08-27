import { Component, OnInit, ViewChild, OnDestroy } from '@angular/core';
import { PromocionModel } from '../../../model/promocion';
import { AlertModel, alertType } from '../../../model/alert-model';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs';
import { PromocionService } from '../../../services/promocion.service';

@Component({
  selector: 'app-promociones',
  templateUrl: './promociones.component.html',
  styles: []
})
export class PromocionesComponent implements OnInit , OnDestroy {
  titulo = "Promociones";
  configuracion: any = {};
  listData: Array<PromocionModel>;
  context: Map<string, string>;
  alertas: any = [];
  alert: AlertModel;

  @ViewChild(DataTableDirective) dtElement: DataTableDirective;
  dtTrigger: Subject<PromocionModel> = new Subject();

  constructor(private promocionService: PromocionService) {
    this.promocionService.contextoService.subscribe(val => {
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
    this.promocionService.getList().subscribe(data => {
      this.listData = data._embedded.pomocion;
      this.dtTrigger.next();
    });
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }


  resetdata() {
    const mapdata = new Map<string, any>();
    this.promocionService.getList().subscribe(data => {
      this.listData = data._embedded.pomocion;
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
    this.promocionService.contextoService.next(this.context);
  }
  editElemt(data) {
    this.context = new Map<string, any>();
    this.context.set("accion", "modificar");
    this.context.set("data", data);
    this.promocionService.contextoService.next(this.context);
  }

}
