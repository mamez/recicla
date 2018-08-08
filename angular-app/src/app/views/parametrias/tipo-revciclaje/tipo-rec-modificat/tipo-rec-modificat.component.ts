import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '../../../../../../node_modules/@angular/forms';
import { TipoReciclajeModel } from '../../../../model/tipo-reciclaje-model';
import { TipoReciclajeService } from '../../../../services/tipo-reciclaje.service';


@Component({
  selector: 'app-tipo-rec-modificat',
  templateUrl: './tipo-rec-modificat.component.html',
  styles: []
})
export class TipoRecModificatComponent implements OnInit {
  public trModificar: FormGroup;
  @ViewChild("modificarModal") modal: any;
  public model: TipoReciclajeModel = new TipoReciclajeModel();
  context: Map<string, any>;

  constructor(private formBuilder: FormBuilder, private tipoReciclajeService: TipoReciclajeService) {
    this.tipoReciclajeService.contextoService.subscribe(val => {
      this.initContext(val);
    });
  }

  private initContext(data: Map<string, any>) {
    const accion = data.get('accion');
    switch (accion) {
      case 'modificar': {
        this.model = data.get("data");
        this.trModificar.controls['nombre'].setValue(this.model.nombre);
        this.trModificar.controls['descripcion'].setValue(this.model.descripcion);
        this.trModificar.controls['facPeso'].setValue(this.model.factorPeso);
        this.trModificar.controls['facPuntos'].setValue(this.model.factorPuntos);
        this.modal.show();
        break;
      }
    }
  }

  ngOnInit() {
    this.trModificar = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      descripcion: ['', [Validators.required]],
      facPeso: ['', [Validators.required, Validators.pattern('^[0-9]+([,][0-9]+)?$')]],
      facPuntos: ['', [Validators.required, Validators.pattern('^[0-9]+$')]]
    });
  }

  public modificar(formValue: any) {
    this.model.nombre = formValue.nombre;
    this.model.descripcion = formValue.descripcion;
    this.model.factorPeso = formValue.facPeso;
    this.model.factorPuntos = formValue.facPuntos;
    this.tipoReciclajeService.update(this.model)
      .subscribe(
        this.closeModal.bind(this)
      );
 }

 private closeModal(data: any) {
   this.modal.hide();
   this.context = new Map<string, any>();
   this.context.set('accion' , 'listar');
   this.context.set('evento' , 'modificado');
   this.tipoReciclajeService.contextoService.next(this.context);
 }

}
