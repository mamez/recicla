import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PuntosCriticosComponent } from './puntos-criticos/puntos-criticos.component';
import { PuntosRecPublicoComponent } from './puntos-rec-publico/puntos-rec-publico.component';
import { PuntosRecUsuariosComponent } from './puntos-rec-usuarios/puntos-rec-usuarios.component';
import { PrCrearComponent } from './puntos-rec-publico/pr-crear/pr-crear.component';
import { PrModificarComponent } from './puntos-rec-publico/pr-modificar/pr-modificar.component';

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
      path: 'rec-publicos/crear',
      component: PrCrearComponent,
      data: {
        title: 'Puntos recolecion crear'
      }
    },
    {
      path: 'rec-publicos/:id/modificar',
      component: PrModificarComponent,
      data: {
        title: 'Puntos recolecion crear'
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
