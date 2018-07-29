import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Import Containers
import { DefaultLayoutComponent } from './containers';
import { LoguinComponent } from './loguin/loguin.component';


export const routes: Routes = [
  {
    path: 'loguin',
    component: LoguinComponent
  },
  {
    path: '',
    component: DefaultLayoutComponent,
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'usuarios',
        loadChildren: './views/usuarios/usuarios.module#UsuariosModule'
      },
      {
        path: 'parametria',
        loadChildren: './views/parametrias/parametrias.module#ParametriasModule'
      },
      {
        path: 'puntos',
        loadChildren: './views/puntos/puntos.module#PuntosModule'
      },
      {
        path: 'solicitud',
        loadChildren: './views/solicitudes/solicitudes.module#SolicitudesModule'
      }
    ]
  }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
