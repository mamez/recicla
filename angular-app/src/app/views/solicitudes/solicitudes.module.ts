import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SolicitudesRoutingModule } from './solicitudes-routing.module';
import { CanjeComponent } from './canje/canje.component';
import { RecoleccionComponent } from './recoleccion/recoleccion.component';

@NgModule({
  imports: [
    CommonModule,
    SolicitudesRoutingModule
  ],
  declarations: [CanjeComponent, RecoleccionComponent]
})
export class SolicitudesModule { }
