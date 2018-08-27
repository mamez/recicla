import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '../../../../../node_modules/@angular/forms';
import { AlertModel } from '../../../model/alert-model';
import { UsuarioService } from '../../../services/usuario.service';
import { UsuarioModel, EstadoUsuario, TipoUsuario } from '../../../model/usuario-model';

@Component({
  selector: 'app-crear-usuario',
  templateUrl: './crear-usuario.component.html',
  styles: []
})
export class CrearUsuarioComponent implements OnInit {
  public titulo = "Crear punto recoleccion publico";

  public forUsuarioCrear: FormGroup;

  alertas: any = [];
  alert: AlertModel;

  @ViewChild("modalCrear") modal: any;
  context: Map<string, any>;

  constructor(private formBuilder: FormBuilder,  private usuarioService: UsuarioService) {}

  ngOnInit() {
   this.iniciarFormulario();
  }

  private iniciarFormulario() {
    this.forUsuarioCrear = this.formBuilder.group({
      nombre: ["", [Validators.required]],
      apellidos: ["", [Validators.required]],
      correo: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }

  public crear(formValue: any) {
    const usuario: UsuarioModel = new UsuarioModel();
    usuario.nombre = formValue.nombre;
    usuario.apellidos = formValue.apellidos;
    usuario.correo = formValue.correo;
    usuario.password = formValue.correo;
    usuario.tipoUsuario = TipoUsuario.USER_ADMIN;
    usuario.estadoUsuario = EstadoUsuario.ACTIVE;
    usuario.puntos = 0;
    this.usuarioService.save(usuario).subscribe( data => {
      this.context = new Map<string, any>();
      this.context.set('accion' , 'listar');
      this.context.set('evento' , 'creado');
      this.usuarioService.contextoService.next(this.context);
      this.modal.hide();
    });
  }


}
