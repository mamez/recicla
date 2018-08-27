import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PromocionModel } from '../../../../model/promocion';
import { PromocionService } from '../../../../services/promocion.service';

@Component({
  selector: 'app-promocion-modificar',
  templateUrl: './promocion-modificar.component.html',
  styles: []
})
export class PromocionModificarComponent implements OnInit {

  public PromocionModificar: FormGroup;

  @ViewChild("modificarModal") modal: any;
  public model: PromocionModel = new PromocionModel();
  context: Map<string, any>;

  constructor(private formBuilder: FormBuilder, private promocionService: PromocionService) {
    this.promocionService.contextoService.subscribe(val => {
      console.log(12);
      this.initContext(val);
    });
   }
   private initContext(data: Map<string, any>) {
    const accion = data.get('accion');
    console.log('entro');
    switch (accion) {
      case 'modificar': {
        this.model = data.get("data");
        this.PromocionModificar.controls['titulo'].setValue(this.model.titulo);
        this.PromocionModificar.controls['descripcion'].setValue(this.model.descripcion);
        this.PromocionModificar.controls['factorPuntos'].setValue(this.model.factorPuntos);
        this.modal.show();
        break;
      }
    }
  }


  ngOnInit() {
    this.PromocionModificar = this.formBuilder.group({
      titulo: ['', [Validators.required]],
      descripcion: ['', [Validators.required]],
     factorPuntos: [ '', [ Validators.required, Validators.pattern('^[0-9]+$')]]
    });
  }

  public modificar(formValue: any) {
    this.model.titulo = formValue.titulo;
    this.model.descripcion = formValue.descripcion;
    this.model.factorPuntos = formValue.factorPuntos;
    this.promocionService.update(this.model)
      .subscribe(
        this.closeModal.bind(this)
      );
 }

 private closeModal(data: any) {
   this.modal.hide();
   this.context = new Map<string, any>();
   this.context.set('accion' , 'listar');
   this.context.set('evento' , 'modificado');
   this.promocionService.contextoService.next(this.context);
 }


}
