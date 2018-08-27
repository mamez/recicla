import { Component, OnInit, ViewChild, OnDestroy } from '@angular/core';
import { AlertModel, alertType } from '../../../model/alert-model';
import { PrPublicoModel } from '../../../model/pr-publico-model';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs';
import { PrpublicoService } from '../../../services/prpublico.service';

@Component({
  selector: 'app-puntos-rec-publico',
  templateUrl: './puntos-rec-publico.component.html',
  styles: []
})
export class PuntosRecPublicoComponent implements OnInit , OnDestroy {
  title = 'Lista de puntos de recoleccion publico';
  lat = 4.6567173;
  lng = -74.0572354;
  zoom = 14;


  order: string;
  configuracion: any = {};
  listData: Array<PrPublicoModel>;
  context: Map<string, string>;
  alertas: any = [];
  alert: AlertModel;

  @ViewChild(DataTableDirective) dtElement: DataTableDirective;
  dtTrigger: Subject<PrPublicoModel> = new Subject();

  constructor(private prpublicoService: PrpublicoService) {
    this.prpublicoService.contextoService.subscribe(val => {
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
    this.prpublicoService.getList().subscribe(data => {
      this.listData = data._embedded.puntosPublicos;
      this.dtTrigger.next();
    });
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }


  resetdata() {
    const mapdata = new Map<string, any>();
    this.prpublicoService.getList().subscribe(data => {
      this.listData = data._embedded.puntosPublicos;
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
    this.prpublicoService.contextoService.next(this.context);
  }



}
