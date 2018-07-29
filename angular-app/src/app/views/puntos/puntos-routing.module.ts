import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PuntosCriticosComponent } from './puntos-criticos/puntos-criticos.component';
import { PuntosRecPublicoComponent } from './puntos-rec-publico/puntos-rec-publico.component';
import { PuntosRecUsuariosComponent } from './puntos-rec-usuarios/puntos-rec-usuarios.component';

const routes: Routes = [
    {
      path: 'criticos',
      component: PuntosCriticosComponent,
      data: {
        title: 'Puntos Criticos'
      }
    },
    {
      path: 'rec-publicos',
      component: PuntosRecPublicoComponent,
      data: {
        title: 'Puntos recolecion publicos'
      }
    },
    {
      path: 'rec-usuarios',
      component: PuntosRecUsuariosComponent,
      data: {
        title: 'Puntos recolecion usuarios'
      }
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PuntosRoutingModule { }
