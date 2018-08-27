import { Component, OnInit, ViewChild } from '@angular/core';
import { PrPublicoModel } from '../../../../model/pr-publico-model';
import { PrpublicoService } from '../../../../services/prpublico.service';

@Component({
  selector: 'app-pr-eliminar',
  templateUrl: './pr-eliminar.component.html',
  styles: []
})
export class PrEliminarComponent implements OnInit {
  @ViewChild("modalEliminar") modal: any;
  model: PrPublicoModel = new PrPublicoModel();
  context: Map<string, any>;

  constructor(private prpublicoService: PrpublicoService) {
    this.prpublicoService.contextoService.subscribe(val => {
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

  elimarPunto() {
    this.prpublicoService.delete(this.model.id).subscribe(data => {
      this.closeModal(data);
   });
  }

  private closeModal(data: any) {
    this.modal.hide();
    this.context = new Map<string, any>();
    this.context.set('accion' , 'listar');
    this.context.set('evento' , 'eliminado');
    this.prpublicoService.contextoService.next(this.context);
  }

}
