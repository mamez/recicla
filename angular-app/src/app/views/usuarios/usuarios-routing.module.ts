import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarUsuarioComponent } from './listar-usuario/listar-usuario.component';

const routes: Routes = [
{
  path: '',
  component: ListarUsuarioComponent,
  data: {
    title: 'Usuarios'
  },
  children: [
    {
      path: 'listar',
      component: ListarUsuarioComponent,
      data: {
        title: 'Listar'
      }
    }
  ]
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuariosRoutingModule { }
