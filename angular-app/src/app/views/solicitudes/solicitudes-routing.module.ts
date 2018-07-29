import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanjeComponent } from './canje/canje.component';
import { RecoleccionComponent } from './recoleccion/recoleccion.component';

const routes: Routes = [
  {
    path: 'canje',
    component: CanjeComponent,
    data: {
      title: 'Solicitud Canje'
    }
  },
  {
    path: 'recoleccion',
    component: RecoleccionComponent,
    data: {
      title: 'Solicitud Recoleccion'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SolicitudesRoutingModule { }
