import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '../../../../../../node_modules/@angular/forms';
import { TipsModel } from '../../../../model/tips-model';
import { TipsService } from '../../../../services/tips.service';

@Component({
  selector: 'app-tips-modificar',
  templateUrl: './tips-modificar.component.html',
  styles: []
})
export class TipsModificarComponent implements OnInit {

  public formularioTips: FormGroup;
  @ViewChild("modificarModal") modal: any;
  public model: TipsModel = new TipsModel();
  context: Map<string, any>;

  constructor(private formBuilder: FormBuilder, private tipsService: TipsService) {
    this.tipsService.contextoService.subscribe(val => {
      this.initContext(val);
    });
  }

  private initContext(data: Map<string, any>) {
    const accion = data.get('accion');
    switch (accion) {
      case 'modificar': {
        this.model = data.get("data");
        this.formularioTips.controls['titulo'].setValue(this.model.titulo);
        this.formularioTips.controls['descripcion'].setValue(this.model.descripcion);
        this.modal.show();
        break;
      }
    }
  }

  ngOnInit() {
    this.formularioTips = this.formBuilder.group({
      titulo: ["", [Validators.required]],
      descripcion: ["", [Validators.required]]
    });
  }

  public modificar(formValue: any) {
     this.model.titulo = formValue.titulo;
     this.model.descripcion = formValue.descripcion;
     this.tipsService.updateTips(this.model)
       .subscribe(
         this.closeModal.bind(this)
       );
  }

  private closeModal(data: any) {
    this.modal.hide();
    this.context = new Map<string, any>();
    this.context.set('accion' , 'listar');
    this.context.set('evento' , 'modificado');
    this.tipsService.contextoService.next(this.context);
  }




}
