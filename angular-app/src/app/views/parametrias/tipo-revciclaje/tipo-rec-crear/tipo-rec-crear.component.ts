import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '../../../../../../node_modules/@angular/forms';
import { TipoReciclajeModel } from '../../../../model/tipo-reciclaje-model';
import { TipoReciclajeService } from '../../../../services/tipo-reciclaje.service';

@Component({
  selector: 'app-tipo-rec-crear',
  templateUrl: './tipo-rec-crear.component.html',
  styles: []
})
export class TipoRecCrearComponent implements OnInit {
  public formularioTR: FormGroup;

  @ViewChild("modalCrear") modal: any;
  context: Map<string, any>;

  constructor(private formBuilder: FormBuilder, private tipoReciclajeService:  TipoReciclajeService) { }

  ngOnInit() {
    this.formularioTR = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      descripcion: ['', [Validators.required]],
      facPeso: ['', [Validators.required, Validators.pattern('^[0-9]+([,][0-9]+)?$')]],
      facPuntos: ['', [Validators.required, Validators.pattern('^[0-9]+$')]]
    });
  }

  public crear(formValue: any) {
    const tr: TipoReciclajeModel = new TipoReciclajeModel();
    tr.nombre = formValue.nombre;
    tr.descripcion = formValue.descripcion;
    tr.factorPeso = formValue.facPeso;
    tr.factorPuntos = formValue.facPuntos;
    this.tipoReciclajeService.save(tr).subscribe(this.tipsGuargadoOK.bind(this));
  }


  tipsGuargadoOK(data: any) {
    this.context = new Map<string, any>();
    this.context.set('accion' , 'listar');
    this.context.set('evento' , 'creado');
    this.tipoReciclajeService.contextoService.next(this.context);
    this.modal.hide();
  }

}
