import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PuntosRoutingModule } from './puntos-routing.module';
import { PuntosCriticosComponent } from './puntos-criticos/puntos-criticos.component';
import { PuntosRecUsuariosComponent } from './puntos-rec-usuarios/puntos-rec-usuarios.component';
import { PuntosRecPublicoComponent } from './puntos-rec-publico/puntos-rec-publico.component';

@NgModule({
  imports: [
    CommonModule,
    PuntosRoutingModule
  ],
  declarations: [PuntosCriticosComponent, PuntosRecUsuariosComponent, PuntosRecPublicoComponent]
})
export class PuntosModule { }
