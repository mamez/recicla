import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuariosListarComponent } from './usuarios-listar/usuarios-listar.component';

const routes: Routes = [
{
  path: '',
  component: UsuariosListarComponent,
  data: {
    title: 'Usuarios'
  },
  children: [
    {
      path: 'listar',
      component: UsuariosListarComponent,
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
