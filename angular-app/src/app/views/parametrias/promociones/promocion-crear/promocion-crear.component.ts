import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PromocionService } from '../../../../services/promocion.service';
import { PromocionModel } from '../../../../model/promocion';

@Component({
  selector: 'app-promocion-crear',
  templateUrl: './promocion-crear.component.html',
  styles: []
})
export class PromocionCrearComponent implements OnInit {
  public formularioPromocion: FormGroup;
  public nombreImagen: string;
  public uploadConfig = "/jobGreen/resourcess/images/upload/TIPS_MODEL";

  @ViewChild("crearPromocion") modal: any;
  context: Map<string, any>;

  constructor(private formBuilder: FormBuilder, private promocionService: PromocionService) {

   }

  ngOnInit() {
   this.formularioPromocion = this.formBuilder.group({
      titulo: ['', [Validators.required]],
      descripcion: ['', [Validators.required]],
     factorPuntos: [ '', [ Validators.required, Validators.pattern('^[0-9]+$')]]
    });
  }
  public crear(formValue: any) {
    const promocion: PromocionModel = new PromocionModel();
    promocion.titulo = formValue.titulo;
    promocion.descripcion = formValue.descripcion;
    promocion.factorPuntos = formValue.factorPuntos;
    promocion.imagen = this.nombreImagen;
    this.promocionService.save(promocion).subscribe(this.tipsGuargadoOK.bind(this));
  }

  refreshImages(nombreImagen: string) {
    if (nombreImagen !== "NOK") {
      this.nombreImagen = nombreImagen;
    }
  }

  tipsGuargadoOK(data: any) {
    this.context = new Map<string, any>();
    this.context.set('accion' , 'listar');
    this.context.set('evento' , 'creado');
    this.promocionService.contextoService.next(this.context);
    this.modal.hide();
  }

}

