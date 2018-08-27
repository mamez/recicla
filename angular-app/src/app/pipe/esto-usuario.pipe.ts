import { Pipe, PipeTransform } from '@angular/core';
import { EstadoUsuario } from '../model/usuario-model';

@Pipe({
  name: 'estoUsuario'
})
export class EstoUsuarioPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    console.log(value);
    if (value === 'ACTIVE') {
        return 'Activo';
    } else if (value === 'LOCKED') {
      return 'Bloqueado';
    } else if (value === 'LOCKED_TEMPORARY') {
      return 'Bloqueado Temporal';
    }
  }

}
