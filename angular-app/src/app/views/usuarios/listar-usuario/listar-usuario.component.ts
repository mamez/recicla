import { Component, OnInit, ViewChild, OnDestroy } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { AlertModel, alertType } from '../../../model/alert-model';
import { UsuarioModel } from '../../../model/usuario-model';
import { DataTableDirective } from '../../../../../node_modules/angular-datatables';
import { Subject } from '../../../../../node_modules/rxjs';

@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styles: []
})
export class ListarUsuarioComponent implements OnInit , OnDestroy {
  title = 'usuarios';
  context: Map<string, string>;
  alertas: any = [];
  alert: AlertModel;
  listData: Array<UsuarioModel>;

  @ViewChild(DataTableDirective) dtElement: DataTableDirective;
  dtTrigger: Subject<UsuarioModel> = new Subject();

  constructor(private usuarioService: UsuarioService) {
    this.usuarioService.contextoService.subscribe(val => {
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
    this.usuarioService.getList().subscribe(data => {
      this.listData = data._embedded.usuarios;
      this.dtTrigger.next();
    });
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }

  resetdata() {
    const mapdata = new Map<string, any>();
    this.usuarioService.getList().subscribe(data => {
      this.listData = data._embedded.usuarios;
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
    this.usuarioService.contextoService.next(this.context);
  }

  editElemt(data) {
    this.context = new Map<string, any>();
    this.context.set("accion", "modificar");
    this.context.set("data", data);
    this.usuarioService.contextoService.next(this.context);
  }
}
