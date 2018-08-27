import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '../../../../../node_modules/@angular/forms';
import { UsuarioModel } from '../../../model/usuario-model';
import { UsuarioService } from '../../../services/usuario.service';

@Component({
  selector: 'app-modificar-usuario',
  templateUrl: './modificar-usuario.component.html',
  styles: []
})
export class ModificarUsuarioComponent implements OnInit {

  public formularioModificar: FormGroup;
  @ViewChild("modificarModal") modal: any;
  public model: UsuarioModel = new UsuarioModel();
  context: Map<string, any>;

  constructor(private formBuilder: FormBuilder, private usuarioService: UsuarioService) {
    this.usuarioService.contextoService.subscribe(val => {
      this.initContext(val);
    });
  }

  private initContext(data: Map<string, any>) {
    const accion = data.get('accion');
    switch (accion) {
      case 'modificar': {
        this.model = data.get("data");
        this.formularioModificar.controls['nombre'].setValue(this.model.nombre);
        this.formularioModificar.controls['apellidos'].setValue(this.model.apellidos);
        this.formularioModificar.controls['correo'].setValue(this.model.correo);
        this.formularioModificar.controls['password'].setValue(this.model.password);
        this.modal.show();
        break;
      }
    }
  }

  ngOnInit() {
    this.formularioModificar = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      apellidos: ['', [Validators.required]],
      correo: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }

  public modificar(formValue: any) {
     this.model.nombre = formValue.nombre;
     this.model.apellidos = formValue.apellidos;
     this.model.correo = formValue.correo;
     this.model.password = formValue.password;
     this.model.fechaModificacion = null;
     this.usuarioService.update(this.model)
       .subscribe(
         this.closeModal.bind(this)
       );
  }

  private closeModal(data: any) {
    this.modal.hide();
    this.context = new Map<string, any>();
    this.context.set('accion' , 'listar');
    this.context.set('evento' , 'modificado');
    this.usuarioService.contextoService.next(this.context);
  }


}
