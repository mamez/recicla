import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TipsComponent } from './tips/tips.component';
import { PromocionesComponent } from './promociones/promociones.component';
import { TipoRevciclajeComponent } from './tipo-revciclaje/tipo-revciclaje.component';

const routes: Routes = [
  {
    path: 'tips',
    component: TipsComponent,
    data: {
      title: 'tips'
    }
  },
  {
    path: 'promociones',
    component: PromocionesComponent,
    data: {
      title: 'promociones'
    }
  },
  {
    path: 'tipos-reciclaje',
    component: TipoRevciclajeComponent,
    data: {
      title: 'tipos-reciclaje'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ParametriasRoutingModule { }
