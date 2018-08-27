export enum EstadoUsuario {
  ACTIVE,
  LOCKED ,
  LOCKED_TEMPORARY
}

export enum TipoUsuario {
  USER_ADMIN,
  USER_MOBILE
}

export class UsuarioModel {
 public id: number;
 public apellidos: string;
 public correo: string;
 public nombre: string;
 public password: string;
 public puntos: number;
 public tipoUsuario: TipoUsuario;
 public estadoUsuario: EstadoUsuario;
 public fechaModificacion: string;
}
