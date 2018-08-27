import { Pipe, PipeTransform } from '@angular/core';
import { TipoUsuario } from '../model/usuario-model';

@Pipe({
  name: 'tipoUsuario'
})
export class TipoUsuarioPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (value === 'USER_ADMIN') {
      return 'Administrador';
    } else {
      return 'App';
    }
  }

}
