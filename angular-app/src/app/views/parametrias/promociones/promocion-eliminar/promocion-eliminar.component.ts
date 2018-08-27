import { Component, OnInit, ViewChild } from '@angular/core';
import { PromocionModel } from '../../../../model/promocion';
import { PromocionService } from '../../../../services/promocion.service';

@Component({
  selector: 'app-promocion-eliminar',
  templateUrl: './promocion-eliminar.component.html',
  styles: []
})
export class PromocionEliminarComponent implements OnInit {
  @ViewChild("modalEliminar") modal: any;
  model: PromocionModel = new PromocionModel();
  context: Map<string, any>;

  constructor(private promocionService: PromocionService) {
    this.promocionService.contextoService.subscribe(val => {
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

  public elimar() {
    this.promocionService.delete(this.model.id).subscribe(data => {
       this.closeModal(data);
    });
  }

  private closeModal(data: any) {
    this.modal.hide();
    this.context = new Map<string, any>();
    this.context.set('accion' , 'listar');
    this.context.set('evento' , 'eliminado');
    this.promocionService.contextoService.next(this.context);
  }

}
