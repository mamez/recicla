import { Component, OnInit, ViewChild } from '@angular/core';
import { UsuarioModel } from '../../../model/usuario-model';
import { UsuarioService } from '../../../services/usuario.service';

@Component({
  selector: 'app-eliminar-usuario',
  templateUrl: './eliminar-usuario.component.html',
  styles: []
})
export class EliminarUsuarioComponent implements OnInit {

  @ViewChild("modalEliminar") modal: any;
  model: UsuarioModel = new UsuarioModel();
  context: Map<string, any>;

  constructor(private usuarioService: UsuarioService) {
    this.usuarioService.contextoService.subscribe(val => {
      this.initContext(val);
    });
  }

  private initContext(data: Map<string, any>) {
    const accion = data.get('accion');
    switch (accion) {
      case 'eliminar': {
        this.model = data.get("data");
        this.modal.show();
        break;
      }
    }
  }


  ngOnInit() {}

  public elimarTips() {
    this.usuarioService.delete(this.model.id).subscribe(data => {
       this.closeModal(data);
    });
  }

  private closeModal(data: any) {
    this.modal.hide();
    this.context = new Map<string, any>();
    this.context.set('accion' , 'listar');
    this.context.set('evento' , 'eliminado');
    this.usuarioService.contextoService.next(this.context);
  }
}
