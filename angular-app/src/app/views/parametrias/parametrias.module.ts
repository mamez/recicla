import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ParametriasRoutingModule } from './parametrias-routing.module';
import { PromocionesComponent } from './promociones/promociones.component';
import { TipoRevciclajeComponent } from './tipo-revciclaje/tipo-revciclaje.component';
import { TipsComponent } from './tips/tips.component';

@NgModule({
  imports: [
    CommonModule,
    ParametriasRoutingModule
  ],
  declarations: [PromocionesComponent, TipoRevciclajeComponent, TipsComponent]
})
export class ParametriasModule { }
