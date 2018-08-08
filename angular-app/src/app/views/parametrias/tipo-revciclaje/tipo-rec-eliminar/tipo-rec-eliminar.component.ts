import { Component, OnInit, ViewChild } from '@angular/core';
import { TipoReciclajeModel } from '../../../../model/tipo-reciclaje-model';
import { TipoReciclajeService } from '../../../../services/tipo-reciclaje.service';

@Component({
  selector: 'app-tipo-rec-eliminar',
  templateUrl: './tipo-rec-eliminar.component.html',
  styles: []
})
export class TipoRecEliminarComponent implements OnInit {
  @ViewChild("modalEliminar") modal: any;
  model: TipoReciclajeModel = new TipoReciclajeModel();
  context: Map<string, any>;

  constructor(private tipoReciclajeService: TipoReciclajeService) {
    this.tipoReciclajeService.contextoService.subscribe(val => {
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

  ngOnInit() {
  }

  public elimar() {
    this.tipoReciclajeService.delete(this.model.id).subscribe(data => {
       this.closeModal(data);
    });
  }

  private closeModal(data: any) {
    this.modal.hide();
    this.context = new Map<string, any>();
    this.context.set('accion' , 'listar');
    this.context.set('evento' , 'eliminado');
    this.tipoReciclajeService.contextoService.next(this.context);
  }

}
